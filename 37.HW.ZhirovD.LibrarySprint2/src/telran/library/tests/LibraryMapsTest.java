package telran.library.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.library.entities.Book;
import telran.library.entities.PickRecord;
import telran.library.entities.Reader;
import telran.library.model.BooksReturnCode;
import telran.library.model.ILibrary;
import telran.library.model.LibraryMaps;

class LibraryMapsTest {
//	===== Sprint 1 fields =====
	private static final long ISBN = 123;
	private static final String TITLE = "Java for Dummies";
	private static final int PICK_PERIOD = 30;
	private static final int PICK_PERIOD_LESS_MIN = 2;
	private static final int PICK_PERIOD_GREATER_MAX = 40;
	private static final int AMOUNT = 500;
	private static final String AUTHOR = "Dummy";
	private static final String PHONE = "1234567";
	private static final int READER_ID = 123;
	private static final LocalDate BIRTH_DATE = LocalDate.ofYearDay(1980, 100);
	private static final String NAME = "Vasya";
	
	static Book book = new Book(ISBN, TITLE, AUTHOR, AMOUNT, PICK_PERIOD);
	static Reader reader = new Reader(READER_ID, NAME, PHONE, BIRTH_DATE);
	static ILibrary lib;
	
//	===== Sprint 2 fields =====
	private static final int YEAR = 2018;
	private static final LocalDate RENT_DATE = LocalDate.of(YEAR, 12, 7);
	private static final int READER_ID2 = 124;

	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
//		Sprint 1
		lib = new LibraryMaps();
		lib.addReader(reader);
		lib.addBookItem(book);
		
//		Sprint 2
		lib.pickBook(ISBN, READER_ID, RENT_DATE);
		((LibraryMaps) lib).save("library.txt");
	}

	@BeforeEach
	void setUp() throws Exception
	{
		lib = LibraryMaps.restoreFromFile("test.book");
	}

//	Sprint 1
	
	@Test
	void testAddBookItem()
	{
		assertEquals(BooksReturnCode.BOOK_ITEM_EXISTS, lib.addBookItem(book));
		Book book2=new Book(ISBN-1, "title", "author", 10, PICK_PERIOD_LESS_MIN);
		
		assertEquals(BooksReturnCode.PICK_PERIOD_LESS_MIN, lib.addBookItem(book2));
		
		book2=new Book(ISBN-1, "title", "author", 10, PICK_PERIOD_GREATER_MAX);
		assertEquals(BooksReturnCode.PICK_PERIOD_GREATER_MAX, lib.addBookItem(book2));
		
		book2=new Book(ISBN-1, "title", "author", 10, 20);
		assertEquals(BooksReturnCode.OK, lib.addBookItem(book2));
	}

	@Test
	void testAddReader()
	{
		Reader reader2=new Reader(READER_ID-1, "name", "phone", BIRTH_DATE);
		assertEquals(BooksReturnCode.READER_EXISTS, lib.addReader(reader));
		
		assertEquals(BooksReturnCode.OK, lib.addReader(reader2));
	}

	@Test
	void testAddBookExemplars()
	{
		int amount=10;
		assertEquals(BooksReturnCode.NO_BOOK_ITEM, lib.addBookExemplars(ISBN-1,amount));
		
		assertEquals(BooksReturnCode.OK, lib.addBookExemplars(ISBN,amount));
		
		assertEquals(AMOUNT+amount, lib.getBook(ISBN).getAmount());
	}

	@Test
	void testGetReader()
	{
		Reader actualReader = lib.getReader(READER_ID);
		assertEquals(reader, actualReader);
	}

	@Test
	void testGetBookItem()
	{
		Book actualBook = lib.getBook(ISBN);
		assertEquals(book, actualBook);
	}
	
//	Sprint 2
	
	@Test
	public void pickBookTest()
	{
		assertEquals(BooksReturnCode.READER_READS_IT, lib.pickBook(ISBN, READER_ID, RENT_DATE));
		
		Reader reader2 = new Reader(READER_ID2, "Vasya", "1234567", BIRTH_DATE);
		lib.addReader(reader2);
		assertEquals(BooksReturnCode.NO_BOOK_ITEM, lib.pickBook(ISBN + 100, READER_ID2, RENT_DATE));
		
		assertEquals(BooksReturnCode.NO_READER, lib.pickBook(ISBN, READER_ID2 + 100, RENT_DATE));
		
		assertEquals(BooksReturnCode.OK, lib.pickBook(ISBN, READER_ID2, RENT_DATE));
		
		Book book2 = new Book(ISBN + 100, "title", "author", 1, 5);
		lib.addBookItem(book2);
		assertEquals(BooksReturnCode.OK, lib.pickBook(ISBN + 100, READER_ID, RENT_DATE));
		
		assertEquals(BooksReturnCode.NO_BOOK_EXEMPLARS, lib.pickBook(ISBN + 100, READER_ID2, RENT_DATE));
	}

	@Test
	public void getReaderBooks()
	{
		Reader reader2 = new Reader(READER_ID2, "Vasya", "1234567", BIRTH_DATE);
		lib.addReader(reader2);
		
		// No readers with READER_ID1+100
		assertTrue(lib.getBooksPickedByReader(READER_ID + 1000).isEmpty());
		
		// Reader with READER_ID2 exists but with no picked books
		assertTrue(lib.getBooksPickedByReader(READER_ID2).isEmpty());
		
		List<Book> books = lib.getBooksPickedByReader(READER_ID);
		assertEquals(1, books.size());
		assertEquals(book, books.get(0));
	}

	@Test
	public void getReadersBookTest()
	{
		// No book item with isbn=ISBN1+100;
		assertTrue(lib.getReadersPickedBook(ISBN + 100).isEmpty());
		lib.addBookItem(new Book(ISBN + 100, "title", "author", 1, 5));
		
		// Book item with isbn=ISBN1+100 exists but it hasn't been peeked
		assertTrue(lib.getReadersPickedBook(ISBN + 100).isEmpty());
		
		List<Reader> readers = lib.getReadersPickedBook(ISBN);
		assertEquals(1, readers.size());
		
		assertEquals(reader, readers.get(0));
	}

	@Test
	public void getAuthorBooksTest()
	{
		// No author unknown
		assertTrue(lib.getBooksAutor("unknown").isEmpty());
		
		// should be OK
		List<Book> books = lib.getBooksAutor(AUTHOR);
		assertEquals(1, books.size());
		
		assertEquals(book, books.get(0));
	}

	@Test
	public void getRecordsAtDates()
	{
		List<PickRecord> records = lib.getPickRecordsAtDates(RENT_DATE, RENT_DATE.plusDays(1));
		PickRecord expected = new PickRecord(ISBN, READER_ID, RENT_DATE);
		assertEquals(1, records.size());
		
		assertEquals(expected, records.get(0));
	}
}
