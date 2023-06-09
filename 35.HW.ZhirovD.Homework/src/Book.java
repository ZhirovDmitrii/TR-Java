import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Book implements Serializable{	
	long isbn;
	String author;
	CoverType cover;
	int pages;
	LocalDate publishDate;
	String title;
	
	public Book(long isbn, String author, CoverType cover, int pages, LocalDate publishDate, String title) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.cover = cover;
		this.pages = pages;
		this.publishDate = publishDate;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + ", cover=" + cover + ", pages=" + pages + ", publishDate="
				+ publishDate + ", title=" + title + "]";
	}
}
