package repeat;

public class Newspaper extends MassMedia implements IPrintable{
	private int issueNumber;
	private int numberOfPages;
	private int circulation;

	public Newspaper(String name, int issueNumber, int numberOfPages, int circulation) {
		super(name);
		this.issueNumber = issueNumber;
		this.numberOfPages = numberOfPages;
		this.circulation = circulation;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public int getCirculation() {
		return circulation;
	}

	@Override
	public String toString() {
		return super.toString() + "\t ISSUE NUMBER: " + issueNumber + "\t NUMBER OF PAGES: " + numberOfPages + "\t CIRCULATION: "
				+ circulation;
	}

	@Override
	public int getRating() {
		if(circulation >= 9291000)
			return 10;
		else
			return circulation * 10 / 9291000;
	}

	@Override
	public void print() {
		System.out.println(super.getName() + "	ISSUE NUMBER: " + getIssueNumber() + "	NUMBER OF PAGES: " + getNumberOfPages() + "	CIRCULATION: "
				+ getCirculation());
	}

}
