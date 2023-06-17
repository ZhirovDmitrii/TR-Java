package telran.library.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import telran.library.dto.RemovedBookData;
import telran.library.entities.Book;
import telran.library.entities.PickRecord;
import telran.library.entities.Reader;
import telran.library.utils.Persistable;

@SuppressWarnings("serial")
public class LibraryMaps extends AbstractLibrary implements Persistable {
	// Sprint 1
	HashMap<Long, Book> books = new HashMap<>();
	HashMap<Integer, Reader> readers = new HashMap<>();

	// Sprint 2
	TreeMap<LocalDate, List<PickRecord>> records = new TreeMap<>();
	HashMap<Long, List<PickRecord>> bookRecords = new HashMap<>();
	HashMap<Integer, List<PickRecord>> readerRecords = new HashMap<>();
	HashMap<String, List<Book>> authorBooks = new HashMap<>();
//	===================================================

//	===== Sprint 1 =====
	@Override
	public BooksReturnCode addBookItem(Book book) {
		if (book.getPickPeriod() > getMaxPickPeriod()) {
			return BooksReturnCode.PICK_PERIOD_GREATER_MAX;
		}
		if (book.getPickPeriod() < getMinPickPeriod()) {
			return BooksReturnCode.PICK_PERIOD_LESS_MIN;
		}

		// Sprint 2
		BooksReturnCode res = books.putIfAbsent(book.getIsbn(), book) == null ? BooksReturnCode.OK
				: BooksReturnCode.BOOK_ITEM_EXISTS;
		if (res == BooksReturnCode.OK) {
			addToMap(authorBooks, book.getAuthor(), book);
		}

		return res;
	}

	@Override
	public BooksReturnCode addReader(Reader reader) {
		return readers.putIfAbsent(reader.getReaderId(), reader) == null ? BooksReturnCode.OK
				: BooksReturnCode.READER_EXISTS;
	}

	@Override
	public BooksReturnCode addBookExemplars(long isbn, int amount) {
		Book book = books.get(isbn);
		if (book == null) {
			return BooksReturnCode.NO_BOOK_ITEM;
		}

		book.setAmount(amount + book.getAmount());

		return BooksReturnCode.OK;
	}

	@Override
	public Reader getReader(int readerId) {
		return readers.get(readerId);
	}

	@Override
	public Book getBook(long isbn) {
		return books.get(isbn);
	}

	@Override
	public void save(String fileName) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(this);
		} catch (Exception e) {
			System.out.println("Error in method save " + e.getMessage());
		}

	}

	public static ILibrary restoreFromFile(String fileName) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			return (LibraryMaps) in.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		} catch (IOException e) {
			System.out.println("Error reading from file: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error restoring object from file: " + e.getMessage());
		}

		// if error - return empty library
		return new LibraryMaps();
	}

//	===== Sprint 2 =====

	@Override
	public BooksReturnCode pickBook(long isbn, int readerId, LocalDate pickDate) {
		Book book = getBook(isbn);
		if (book == null || book.getAmount() < 0) {
			return BooksReturnCode.NO_BOOK_ITEM;
		}
		if (book.getAmount() == book.getAmountInUse()) {
			return BooksReturnCode.NO_BOOK_EXEMPLARS;
		}
		if (!readers.containsKey(readerId)) {
			return BooksReturnCode.NO_READER;
		}
		if (bookInUse(isbn, readerId) == true) {
			return BooksReturnCode.READER_READS_IT;
		}

		PickRecord record = new PickRecord(isbn, readerId, pickDate);
		addToMap(bookRecords, record.getIsbn(), record);
		addToMap(readerRecords, record.getReaderId(), record);
		addToMap(records, record.getPickDate(), record);

		book.setAmountInUse(book.getAmountInUse() + 1);

		return BooksReturnCode.OK;
	}

	private boolean bookInUse(long isbn, int readerId) {
		List<PickRecord> pickRecords = readerRecords.get(readerId);
		if (pickRecords != null
				&& pickRecords.stream().anyMatch(r -> r.getIsbn() == isbn && r.getReturnDate() == null)) {
			return true;
		}
		return false;
	}

	private <K, V> void addToMap(Map<K, List<V>> map, K key, V value) {
		map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
	}

	@Override
	public List<Book> getBooksPickedByReader(int readerId) {
		List<PickRecord> list = readerRecords.getOrDefault(readerId, new ArrayList<>());
		return list.stream().map(pr -> getBook(pr.getIsbn())).distinct().toList();
	}

	@Override
	public List<Reader> getReadersPickedBook(long isbn) {
		List<PickRecord> list = bookRecords.getOrDefault(isbn, new ArrayList<>());
		return list.stream().map(pr -> getReader(pr.getReaderId())).distinct().toList();
	}

	@Override
	public List<Book> getBooksAutor(String authorName) {
		List<Book> list = authorBooks.getOrDefault(authorName, new ArrayList<>());
		return list.stream().filter(l -> l.getAmount() > l.getAmountInUse()).toList();
	}

	@Override
	public List<PickRecord> getPickRecordsAtDates(LocalDate from, LocalDate to) {
		if (from.isAfter(to)) {
			LocalDate temp = from;
			from = to;
			to = temp;
		}

		Collection<List<PickRecord>> col = records.subMap(from, to).values();
		return col == null ? new ArrayList<>() : col.stream().flatMap(List::stream).toList();
	}

//	===== Sprint 3 =====

	@Override
	public RemovedBookData removeBook(long isbn) {
		Book book = getBook(isbn);
		if(book == null) {
			return null;
		}
		
		if(!bookRecords.containsKey(isbn)) {
			book.setAmountInUse(-1) ;
			return new RemovedBookData(book, null);
		}

		return actualBookRemove(book);
	}

	private RemovedBookData actualBookRemove(Book book) {
		long isbn = book.getIsbn();
		
		// delete all information from archive
		List<PickRecord> list = bookRecords.get(isbn);
		bookRecords.remove(isbn);	// delete all information about book from this map
		books.remove(isbn);	// delete all book by isbn
		
		removeFromReaderRecords(list);
		removeFromRecords(list);
		removeFromAuthorBooks(book);
		
		return new RemovedBookData(book, list);
	}

	private void removeFromAuthorBooks(Book book) {
		authorBooks.get(book.getAuthor()).remove(book);
	}

	private void removeFromRecords(List<PickRecord> list) {
		list.forEach(rr -> records.get(rr.getPickDate()).remove(rr));
	}

	private void removeFromReaderRecords(List<PickRecord> list) {
		list.forEach(rr -> readerRecords.get(rr.getReaderId()).remove(rr));
	}

	@Override
	public List<RemovedBookData> removeAuthor(String author) {
		List<Book> list = authorBooks.get(author);
		if(list != null) {
			return list.stream().map(b -> removeBook(b.getIsbn())).toList();
		}
		return new ArrayList<>();
	}

	@Override
	public RemovedBookData returnBook(long isbn, int readerId, LocalDate returnDate) {
		PickRecord record = readerRecords.get(readerId).stream()
				.filter(pr -> pr.getIsbn() == isbn 
						&& pr.getPickDate() == null) // don't return from use
				.findFirst().orElse(null);
		
		// if reader don't get a book, OR get, but returned
		if(record == null) {
			return null;
		}
		
		// calculate the delay in days
		getDelay(record);
		
		// overwrite return date
		record.setReturnDate(returnDate);
		
		// update information about book
		Book book = getBook(isbn);
		book.setAmountInUse(book.getAmountInUse() - 1);
		
		List<PickRecord> list = new ArrayList<>();
		list.add(record);
		
		return new RemovedBookData(book, list);
	}
	
	private int getDelay(PickRecord record) {
		int realDays = (int) ChronoUnit.DAYS.between(record.getPickDate(), record.getReturnDate());
		record.setDelayDays(realDays);
		return record.getDelayDays();
	}

}
