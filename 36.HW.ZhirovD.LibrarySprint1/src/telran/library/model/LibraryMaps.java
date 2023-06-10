package telran.library.model;

import java.util.HashMap;

import telran.library.entities.Book;
import telran.library.entities.Reader;
import telran.library.utils.Persistable;

@SuppressWarnings("serial")
public class LibraryMaps extends AbstractLibrary implements Persistable{
	HashMap<Long, Book> books;
	HashMap<Integer, Reader> readers; // readerId, Reader

	@Override
	public BooksReturnCode addBookItem(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BooksReturnCode addReader(Reader reader) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BooksReturnCode addBookExemplars(long isbn, int amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getReader(int readerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBook(long isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(String fileName) {
		// TODO Auto-generated method stub
		
	}
	
	public static ILibrary restoreFromFile(String fileName) {
		
		return null;
	}
}
