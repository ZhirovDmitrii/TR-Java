package telran.library.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.library.entities.Book;
import telran.library.entities.Reader;
import telran.library.model.LibraryMaps;

class LibraryMapsTest {
	private static final long ISBN = 11111;
	private static final String TITLE = "Title";
	private static final String AUTHOR = "It's me";
	private static final int AMOUNT = 100;	
	private static final int AMOUNT_IN_USE = 40;
	private static final int PICK_PERIOD = 15;
	private static final int PICK_PERIOD_GREATER = 31;
	private static final int PICK_PERIOD_LESS = 2;
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
		lib.addBookExemplars(ISBN, AMOUNT);
		lib.addBookItem(book);
		lib.addReader(reader);
		lib.save(FILE_NAME);
	}

	@BeforeEach
	void setUp() throws Exception {
		lib = (LibraryMaps) LibraryMaps.restoreFromFile(FILE_NAME);
	}

	@Test
	void testGets() {
		Book actualBook = lib.getBook(ISBN);
		assertEquals(book, actualBook);
		Reader actualReader = lib.getReader(READER_ID);
		assertEquals(reader, actualReader);
	}

}
