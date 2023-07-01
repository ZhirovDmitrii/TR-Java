package telran.library.model;

public enum BooksReturnCode {
	// Sprint 1
	OK, 
	READER_EXISTS,
	BOOK_ITEM_EXISTS, 
	NO_BOOK_ITEM, 
	PICK_PERIOD_GREATER_MAX, 
	PICK_PERIOD_LESS_MIN,
	
	// Sprint 2
	NO_READER,
	READER_READS_IT,
	NO_BOOK_EXEMPLARS
}
