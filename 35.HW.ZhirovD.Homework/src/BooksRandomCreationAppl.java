import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class BooksRandomCreationAppl {
	private static final Random gen = new Random();
	
	private static final String[] technologies = {
			"Computer Science",
	        "Software Development",
	        "Data Science",
	        "Artificial Intelligence",
	        "Web Development",
	        "Network Security",
	        "Database Management",
	        "Machine Learning",
	        "Robotics",
	        "Internet of Things (IoT)"
	};

	private static final int N_BOOKS = 10;
	private static final int DATE_PUBLISH_FROM = 1452;
	private static final int DATE_PUBLISH_TO = 2023;
	private static int counter = 1;
	
//	==================== MAIN ====================

	public static void main(String[] args) {
		List<Book> list = getRandomBooks();

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.txt"))) {
			oos.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	==================== METHODS ====================

	// Generate random book and add in List
	private static List<Book> getRandomBooks() {
		return Stream.generate(() -> getRandomBook()).distinct().limit(N_BOOKS).toList();
	}

	// Create one random book
	private static Book getRandomBook() {
		Book b = getRandomCommonBook();

		return getRandomNumber(1, 100) <= 50 ? getRandomLiteratureBook(b) : getRandomTechnicalBook(b);
	}

	private static Book getRandomTechnicalBook(Book b) {
		String technology = getRandomTechnology(technologies);
		
		return new TechnicalBook(b.isbn, b.author, b.cover, b.pages, b.publishDate, b.title, technology);
	}

	// Get random technologies
	private static String getRandomTechnology(String[] array) {
		int index = getRandomNumber(0, array.length - 1);
		
		return array[index];
	}

	// Generate random Literature Book
	private static Book getRandomLiteratureBook(Book b) {
		Genre genre = getGenre(getRandomNumber(1, 4));
		
		return new LiteratureBook(b.isbn, b.author, b.cover, b.pages, b.publishDate, b.title, genre);
	}

	// Generate random genre
	private static Genre getGenre(int randomNumber) {
		Genre genre = null;
		switch (randomNumber) {
		case 1:
			genre = Genre.DETECTIVE;
			break;
		case 2:
			genre = Genre.FANTASY;
			break;
		case 3:
			genre = Genre.HISTORY;
			break;
		case 4:
			genre = Genre.NOVEL;
		}
		return genre;
	}

	// Generate random Book with fields
	private static Book getRandomCommonBook() {
		long isbn = counter++;
		String author = "author" + getRandomNumber(1, 10);
		CoverType cover = getRandomNumber(1, 10) <= 5 ? CoverType.SOLID : CoverType.SOFT;
		int pages = getRandomNumber(100, 1000);
		LocalDate publishDate = getRandomPublishDate(DATE_PUBLISH_FROM, DATE_PUBLISH_TO);
		String title = "title" + getRandomNumber(1, 100);

		return new Book(isbn, author, cover, pages, publishDate, title);
	}

	// Generate random date
	private static LocalDate getRandomPublishDate(int datePublishFrom, int datePublishTo) {
		Year year = getRandomYear();
		Month month = getRandomMonth();
		int day = getRandomNumber(1, month.length(year.isLeap()));

		return LocalDate.of(year.getValue(), month.getValue(), day);
	}

	// Generate random year
	private static Year getRandomYear() {
		int numberYear = getRandomNumber(DATE_PUBLISH_FROM, DATE_PUBLISH_TO);

		return Year.of(numberYear);
	}

	// Generate random month
	private static Month getRandomMonth() {
		int numberMonth = getRandomNumber(1, 12);

		return Month.of(numberMonth);
	}

	// Generate random number
	private static int getRandomNumber(int min, int max) {
		return gen.ints(min, max + 1).findAny().getAsInt();
	}
}
