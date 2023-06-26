package telran.library.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.library.entities.Book;
import telran.library.entities.Reader;
import telran.library.entities.ReaderDelay;
import telran.library.model.ILibrary;
import telran.library.model.LibraryMaps;

class LibraryMapsStatisticTest {
	ILibrary lib = new LibraryMaps();
	
	int[] booksIsbn = {0,0,1,2,3};
	int[] readersId = {0,1,1,2,3};
	String[] authors = {"a1","a2", "a3", "a3"};
	
	LocalDate[] dates = { LocalDate.of(2000, 1, 1),
			LocalDate.of(1999, 2, 2),
			LocalDate.of(1980, 3, 3),
			LocalDate.of(1970, 4, 4)
	};
	
	int[] expDelay = {19, 10, 8, 7};
	
	@BeforeEach
	void setUp() throws Exception{
		createAndAddBooks();
		createAndAddReaders();
		
		pickBooks();
	}

	private void pickBooks() {
		for(int i =0; i < booksIsbn.length; i++) {
			lib.pickBook(booksIsbn[i], readersId[i], LocalDate.now());
		}
		
	}

	private void createAndAddReaders() {
		for(int i = 0; i < dates.length; i++) {
			lib.addReader(new Reader(i, "name", "phone", dates[i]));
		}
		
	}

	private void createAndAddBooks() {
		for(int i = 0; i < authors.length; i++) {
			lib.addBookItem(new Book(i, "title", authors[i], 100, 10+i));
		}
		
	}
	
	private void returnBooks()
	{
		for (int i = 0; i < booksIsbn.length; i++)
		{
			lib.returnBook(booksIsbn[i], readersId[i], LocalDate.now().plusDays(20));
		}
	}
	
	@Test
	public void testGetReadersDelayingBooks() {
		List<ReaderDelay> readerDelays = lib.getReadersDelayingBooks(LocalDate.now().plusDays(20));
		testReaderDelays(expDelay, readerDelays);
		returnBooks();
		
		// after returning no delaying books
		readerDelays = lib.getReadersDelayingBooks(LocalDate.now().plusDays(20));
		assertTrue(readerDelays.isEmpty());
	}
	
	private void testReaderDelays(int[] ed, List<ReaderDelay> rd)
	{
		for (int i=0; i<ed.length; i++)
		{
			assertEquals(ed[i], rd.get(i).getDelay());
		}
	}
	
	@Test
	public void testGetMostPopularBooks()
	{
		List<Book> popularBooks50_70 = lib.getMostPopularBooks(LocalDate.now(),
				LocalDate.now().plusDays(20 + 1), 50, 70);
		List<Book> popularBooks15_25 = lib.getMostPopularBooks(LocalDate.now(),
				LocalDate.now().plusDays(20 + 1), 15, 25);
		
		assertEquals(1, popularBooks15_25.size());
		assertEquals(0, popularBooks15_25.get(0).getIsbn());
		
		assertEquals(1, popularBooks50_70.size());
		assertTrue(popularBooks50_70.contains(lib.getBook(3)));
	}
	
	@Test
	public void testGetMostPopularAuthors()
	{
		List<String> popularAuthors = lib.getMostPopularAuthors();
		
		// most popular author is authors[2]
		assertEquals(2, popularAuthors.size());
		assertEquals(authors[0], popularAuthors.get(0));
	}
	
	@Test
	public void testGetMostActiveReaders()
	{
		List<Reader> activeReaders = lib.getMostActiveReaders(LocalDate.now(), LocalDate.now().plusDays(20 + 1));
		
		// most active reader is readers 0
		assertEquals(1, activeReaders.size());
		assertEquals(1, activeReaders.get(0).getReaderId());
	}

}
