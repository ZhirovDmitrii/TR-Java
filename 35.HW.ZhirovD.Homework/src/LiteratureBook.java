import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class LiteratureBook extends Book implements Serializable{
	Genre genre;

	public LiteratureBook(long isbn, String author, CoverType cover, int pages, LocalDate publishDate,
			String title, Genre genre) {
		super(isbn, author, cover, pages, publishDate, title);
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "LiteratureBook [genre=" + genre + "]" + super.toString();
	}
}