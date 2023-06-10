package telran.library.model;

import java.io.Serializable;

import telran.library.entities.*;


public interface ILibrary extends Serializable{
	// Sprint1 function
	BooksReturnCode addBookItem(Book book);
	BooksReturnCode addReader(Reader reader);
	BooksReturnCode addBookExemplars(long isbn, int amount);	// adds a given amount of exemplars
	
	Reader getReader(int readerId);
	Book getBook(long isbn);
	
}
