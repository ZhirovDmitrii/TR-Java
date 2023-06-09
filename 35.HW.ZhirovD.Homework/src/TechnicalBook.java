import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class TechnicalBook extends Book implements Serializable{
	String technology;

	public TechnicalBook(long isbn, String author, CoverType cover, int pages, LocalDate publishDate, String title,
			String technology) {
		super(isbn, author, cover, pages, publishDate, title);
		this.technology = technology;
	}

	@Override
	public String toString() {
		return "TechnicalBook [technology=" + technology + "]" + super.toString();
	}
}