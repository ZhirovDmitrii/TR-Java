package telran.library.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.library.entities.Book;
import telran.library.entities.Reader;
import telran.library.model.BooksReturnCode;
import telran.library.model.LibraryMaps;

class LibraryMapsTest {
	private static final long ISBN = 11111;
	private static final String TITLE = "Title";
	private static final String AUTHOR = "It's me";
	private static final int AMOUNT = 1;	
	private static final int PICK_PERIOD = 15;
	private static final String FILE_NAME = "library.txt";
	
	private static final int READER_ID = 12345;
	private static final String NAME = "Dima";
	private static final String PHONE = "1234567890";
	private static final LocalDate BIRTH_DATE = LocalDate.of(1994, 06, 24);
	
	static Book book = new Book(ISBN, TITLE, AUTHOR, AMOUNT, PICK_PERIOD);
	static Reader reader = new Reader(READER_ID, NAME, PHONE, BIRTH_DATE);
	
	static LibraryMaps lib;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {     
		lib = new LibraryMaps();
		lib.addBookItem(book);
		lib.addReader(reader);
		lib.addBookExemplars(ISBN, AMOUNT);
		lib.save(FILE_NAME);
	}

	@BeforeEach
	void setUp() throws Exception {
		lib = (LibraryMaps) LibraryMaps.restoreFromFile(FILE_NAME);
	}

	@Test
	void testGets() {
		Book actualBook = lib.getBook(ISBN);
		Reader actualReader = lib.getReader(READER_ID);
		assertEquals(reader, actualReader);
	}
	
	@Test
	void testAddBook() {
		Book newBook = new Book(ISBN, TITLE, AUTHOR, AMOUNT, PICK_PERIOD);
		assertEquals(BooksReturnCode.BOOK_ITEM_EXISTS, lib.addBookItem(newBook));
		
		newBook = new Book(ISBN+1, TITLE, AUTHOR, AMOUNT, PICK_PERIOD);
		assertEquals(BooksReturnCode.OK, lib.addBookItem(newBook));
		
		newBook = new Book(ISBN+1, TITLE, AUTHOR, AMOUNT, 2);
		assertEquals(BooksReturnCode.PICK_PERIOD_LESS_MIN, lib.addBookItem(newBook));
		
		newBook = new Book(ISBN+1, TITLE, AUTHOR, AMOUNT, 31);
		assertEquals(BooksReturnCode.PICK_PERIOD_GREATER_MAX, lib.addBookItem(newBook));
	}
	
	@Test
	void testAddReader() {
		Reader newReader = new Reader(READER_ID, NAME, PHONE, BIRTH_DATE);
		assertEquals(BooksReturnCode.READER_EXISTS, lib.addReader(newReader));
		
		newReader = new Reader(READER_ID+1, NAME, PHONE, BIRTH_DATE);
		assertEquals(BooksReturnCode.OK, lib.addReader(newReader));
	}
	
	@Test
	void testAddBookExemplars() {
		BooksReturnCode res = lib.addBookExemplars(ISBN, AMOUNT);
		assertEquals(BooksReturnCode.OK, res);
		
		res = lib.addBookExemplars(ISBN+50, AMOUNT);
		assertEquals(BooksReturnCode.NO_BOOK_ITEM, res);
	}

}
