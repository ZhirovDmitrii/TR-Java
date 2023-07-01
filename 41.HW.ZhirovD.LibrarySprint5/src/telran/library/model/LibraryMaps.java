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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import telran.library.entities.Book;
import telran.library.entities.PickRecord;
import telran.library.entities.Reader;
import telran.library.entities.ReaderDelay;
import telran.library.entities.RemovedBookData;
import telran.library.utils.Persistable;

@SuppressWarnings("serial")
public class LibraryMaps extends AbstractLibrary implements Persistable {
	// Sprint 4
	private static final LocalDate dateFrom = LocalDate.of(2000, 1, 1);

	// Sprint 1
	HashMap<Long, Book> books = new HashMap<>(); // keeps a map of books inside
	HashMap<Integer, Reader> readers = new HashMap<>(); // keeps a map of readers inside

	// Sprint 2
	TreeMap<LocalDate, List<PickRecord>> records = new TreeMap<>(); // keeps a map of books in use
	HashMap<Long, List<PickRecord>> bookRecords = new HashMap<>(); // keeps a map of books that readers have taken
	HashMap<Integer, List<PickRecord>> readerRecords = new HashMap<>(); // keeps a map of readers who have taken the
																		// book
	HashMap<String, List<Book>> authorBooks = new HashMap<>(); // keeps a map of authors with their books
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
		if (bookInUse(isbn, readerId)) {
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
		return list.stream().filter(b -> b.getAmount() > b.getAmountInUse()).toList();
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
		if (book == null || book.getAmount() < 0) {
			return null;
		}

		if (book.getAmountInUse() > 0) {
			book.setAmount(-1);
			return new RemovedBookData(book, null);
		} else {
			List<PickRecord> removeRecords = actualBookRemove(isbn);
			return new RemovedBookData(book, removeRecords);
		}
	}

	private List<PickRecord> actualBookRemove(long isbn) {
		Book book = getBook(isbn);
		authorBooks.get(book.getAuthor()).remove(book);
		books.remove(isbn);

		List<PickRecord> recordsForRemove = bookRecords.getOrDefault(isbn, new ArrayList<>());
		recordsForRemove.forEach(this::removeRecordsFromMaps);

		return recordsForRemove;
	}

	private void removeRecordsFromMaps(PickRecord record) {
		long isbn = record.getIsbn();
		bookRecords.remove(isbn);

		LocalDate pickDate = record.getPickDate();
		records.get(pickDate).remove(record);

		int readerId = record.getReaderId();
		readerRecords.get(readerId).remove(record);
	}

	@Override
	public List<RemovedBookData> removeAuthor(String author) {
		List<Book> list = authorBooks.getOrDefault(author, new ArrayList<>());
		List<RemovedBookData> res = new ArrayList<>();
		list.forEach(b -> res.add(removeBook(b.getIsbn())));
		return res;
	}

	@Override
	public RemovedBookData returnBook(long isbn, int readerId, LocalDate returnDate) {
		List<PickRecord> recordsList = readerRecords.get(readerId);
		if (recordsList == null) {
			return null;
		}

		PickRecord record = recordsList.stream().filter(r -> r.getIsbn() == isbn && r.getReturnDate() == null)
				.findFirst().orElse(null);
		if (record == null) {
			return null;
		}

		Book book = getBook(isbn);
		updateRecord(returnDate, record, book);
		return updateBook(isbn, book);
	}

	private void updateRecord(LocalDate returnDate, PickRecord record, Book book) {
		record.setReturnDate(returnDate);
		int actualDays = (int) ChronoUnit.DAYS.between(record.getPickDate(), returnDate);
		int delay = actualDays - book.getPickPeriod();

		if (delay > 0) {
			record.setDelayDays(delay);
		}

	}

	private RemovedBookData updateBook(long isbn, Book book) {
		book.setAmountInUse(book.getAmountInUse() - 1);
		if (book.getAmount() < 0 && book.getAmountInUse() == 0)
			return new RemovedBookData(book, actualBookRemove(isbn));
		else
			return new RemovedBookData(book, null);
	}

//	===== Sprint 4 =====

	@Override
	// list of readers ordered by total delay on current date (they have not
	// returned yet)
	public List<ReaderDelay> getReadersDelayingBooks(LocalDate currentDate) {
		List<PickRecord> list = getPickRecordsAtDates(dateFrom, currentDate);

		Map<Reader, Integer> map = list.stream().filter(pr -> pr.getReturnDate() == null)
				.map(pr -> getReaderDelay(pr, currentDate)).filter(rd -> rd.getDelay() > 0)
				.collect(Collectors.groupingBy(rd -> rd.getReader(), Collectors.summingInt(rd -> rd.getDelay())));

		return getList(map);
	}

	private ReaderDelay getReaderDelay(PickRecord record, LocalDate currentDate) {
		int delay = (int) (ChronoUnit.DAYS.between(record.getPickDate(), currentDate)
				- getBook(record.getIsbn()).getPickPeriod());
		return new ReaderDelay(getReader(record.getReaderId()), delay);
	}

	private List<ReaderDelay> getList(Map<Reader, Integer> readers) {
		List<ReaderDelay> res = new ArrayList<>();
		readers.forEach((k, v) -> res.add(new ReaderDelay(k, v)));
		res.sort((rd1, rd2) -> Integer.compare(rd2.getDelay(), rd1.getDelay()));
		return res;
	}

	@Override
	// list of readers ordered by total delay of all returned books(they returned
	// but with a delay)
	public List<ReaderDelay> getReadersDelayedBooks() {
		Map<Reader, Integer> readersTotalDelay = records.values().stream().flatMap(List::stream)
				.filter(r -> r.getReturnDate() != null && r.getDelayDays() > 0)
				.map(r -> new ReaderDelay(getReader(r.getReaderId()), r.getDelayDays()))
				.collect(Collectors.groupingBy(rd -> rd.getReader(), Collectors.summingInt(rd -> rd.getDelay())));

		return getList(readersTotalDelay);
	}

	@Override
	public List<Book> getMostPopularBooks(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge) {
		List<PickRecord> list = getPickRecordsAtDates(fromDate, toDate);

		Map<Long, Long> map = list.stream().filter(pr -> isProperAge(pr, fromAge, toAge))
				.collect(Collectors.groupingBy(pr -> pr.getIsbn(), Collectors.counting()));

		long max = Collections.max(map.values());

		List<Book> titles = new ArrayList<>();
		map.forEach((k, v) -> {
			if (v == max) {
				titles.add(getBook(k));
			}
		});

		return titles;
	}

	private boolean isProperAge(PickRecord pr, int fromAge, int toAge) {
		Reader reader = getReader(pr.getReaderId());
		int birthDate = (int) ChronoUnit.YEARS.between(reader.getBirthDate(), pr.getPickDate());

		return birthDate >= fromAge && birthDate < toAge;
	}

	@Override
	public List<String> getMostPopularAuthors() {
		Map<String, Long> map = records.values().stream().flatMap(List::stream)
				.collect(Collectors.groupingBy(r -> getBook(r.getIsbn()).getAuthor(), Collectors.counting()));

		long max = Collections.max(map.values());

		List<String> authors = new ArrayList<>();
		map.forEach((k, v) -> {
			if (v == max) {
				authors.add(k);
			}
		});

		return authors;
	}

	@Override
	public List<Reader> getMostActiveReaders(LocalDate fromDate, LocalDate toDate) {
		List<PickRecord> list = getPickRecordsAtDates(fromDate, toDate);

		Map<Integer, Long> map = list.stream()
				.collect(Collectors.groupingBy(pr -> pr.getReaderId(), Collectors.counting()));

		long max = Collections.max(map.values());

		List<Reader> readers = new ArrayList<>();
		map.forEach((k, v) -> {
			if (v == max) {
				readers.add(getReader(k));
			}
		});

		return readers;
	}

}
