package telran.library.dto;

import java.util.List;

import telran.library.entities.Book;
import telran.library.entities.PickRecord;

public class RemovedBookData {
	private Book book;
	private List<PickRecord> records;
	
	public RemovedBookData() {
		// TODO Auto-generated constructor stub
	}

	public RemovedBookData(Book book, List<PickRecord> records) {
		super();
		this.book = book;
		this.records = records;
	}

	public Book getBook() {
		return book;
	}

	public List<PickRecord> getRecords() {
		return records;
	}

	@Override
	public String toString() {
		return "RemovedBookData [book=" + book + ", records=" + records + "]";
	}
}
