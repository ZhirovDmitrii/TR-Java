package telran.library.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import telran.library.entities.*;


public interface ILibrary extends Serializable{
	// Sprint1 function
	BooksReturnCode addBookItem(Book book);
	BooksReturnCode addReader(Reader reader);
	BooksReturnCode addBookExemplars(long isbn, int amount);	// adds a given amount of exemplars
	
	Reader getReader(int readerId);
	Book getBook(long isbn);
	
	// Sprint2 function
	BooksReturnCode pickBook(long isbn, int readerId, LocalDate pickDate);
	List<Book> getBooksPickedByReader(int readerId);
	List<Reader> getReadersPickedBook(long isbn);
	List<Book> getBooksAutor(String authorName);
	List<PickRecord> getPickRecordsAtDates(LocalDate from, LocalDate to);
}
