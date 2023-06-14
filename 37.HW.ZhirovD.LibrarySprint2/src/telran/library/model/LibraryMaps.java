package telran.library.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
		if(book.getPickPeriod() > getMaxPickPeriod()) {
			return BooksReturnCode.PICK_PERIOD_GREATER_MAX;
		}
		if(book.getPickPeriod() < getMinPickPeriod()) {
			return BooksReturnCode.PICK_PERIOD_LESS_MIN;
		}
		
		return books.putIfAbsent(book.getIsbn(), book) == null ? BooksReturnCode.OK : BooksReturnCode.BOOK_ITEM_EXISTS;
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
		Reader reader = getReader(readerId);
		Book book = getBook(isbn);
		
		if(reader == null) {
			return BooksReturnCode.NO_READER;
		}
		if(book == null || book.getAmount() == 0) {
			return BooksReturnCode.NO_BOOK_EXEMPLARS;
		}
		if(readerReadsBook(readerId, isbn)) {
			return BooksReturnCode.READER_READS_IT;
		}

		PickRecord record = new PickRecord(isbn, readerId, pickDate);
		addToRecordsMap(bookRecords, isbn, record);
		addToRecordsMap(readerRecords, readerId, record);
		addToRecordsMap(records, pickDate, record);
		
		return BooksReturnCode.OK;
	}
	
	
	private boolean readerReadsBook(int readerId, long isbn) {
		List<PickRecord> list = readerRecords.getOrDefault(readerId, new ArrayList<>());
		return list.stream().anyMatch(l -> l.getIsbn() == isbn);
	}

	@SuppressWarnings("unused")
	private <T> void addToRecordsMap(Map<T, List<PickRecord>> recordsMap, T key, PickRecord record) {
		List<PickRecord> list = recordsMap.getOrDefault(key, new ArrayList<>());
		list.add(record);
		recordsMap.put(key, list);
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
		return list.stream().distinct().toList();
	}

	@Override
	public List<PickRecord> getPickRecordsAtDates(LocalDate from, LocalDate to) {
		if(from.isAfter(to)) {
			LocalDate temp = from;
			from = to;
			to = temp;
		}
		
		Collection<List<PickRecord>> col = records.subMap(from, to).values();
		return col.stream().flatMap(l -> l.stream()).toList();
	}

}
