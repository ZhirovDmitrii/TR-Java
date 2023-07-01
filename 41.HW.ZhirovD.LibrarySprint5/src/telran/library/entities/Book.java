package telran.library.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Book implements Serializable{
	private long isbn;
	private String title;
	private String author;
	private int amount;	// book item may contain amount of the exemplars
	private int amountInUse;// how many readers are keeping the book
	private int pickPeriod;	// the number of days for keeping a book
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(long isbn, String title, String author, int amount, int pickPeriod) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.amount = amount;
		this.pickPeriod = pickPeriod;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmountInUse() {
		return amountInUse;
	}

	public void setAmountInUse(int amountInUse) {
		this.amountInUse = amountInUse;
	}

	public int getPickPeriod() {
		return pickPeriod;
	}

	public void setPickPeriod(int pickPeriod) {
		this.pickPeriod = pickPeriod;
	}

	public long getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (isbn ^ (isbn >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn != other.isbn)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", amount=" + amount
				+ ", amountInUse=" + amountInUse + ", pickPeriod=" + pickPeriod + "]";
	}

}
