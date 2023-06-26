package telran.library.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import telran.library.entities.*;


public interface ILibrary extends Serializable{
	// Sprint1 functions
	BooksReturnCode addBookItem(Book book);
	BooksReturnCode addReader(Reader reader);
	BooksReturnCode addBookExemplars(long isbn, int amount);	// adds a given amount of exemplars
	
	Reader getReader(int readerId);
	Book getBook(long isbn);
	
	// Sprint2 functions
	BooksReturnCode pickBook(long isbn, int readerId, LocalDate pickDate);
	List<Book> getBooksPickedByReader(int readerId);
	List<Reader> getReadersPickedBook(long isbn);
	List<Book> getBooksAutor(String authorName);
	List<PickRecord> getPickRecordsAtDates(LocalDate from, LocalDate to);

	// Sprint 3 functions
	RemovedBookData removeBook(long isbn);
	List<RemovedBookData> removeAuthor(String author);
	RemovedBookData returnBook(long isbn, int readerId, LocalDate returnDate);
	
	// Sprint 4 functions
	List<ReaderDelay> getReadersDelayingBooks(LocalDate currentDate);
	List<ReaderDelay> getReadersDelayedBooks();
	List<Book> getMostPopularBooks(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge);
	List<String> getMostPopularAuthors();
	List<Reader> getMostActiveReaders(LocalDate fromDate, LocalDate toDate);
}
