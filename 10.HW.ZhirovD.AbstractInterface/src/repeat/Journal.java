package repeat;

public class Journal extends Newspaper{
	private boolean glossy;

	public Journal(String name, int issueNumber, int numberOfPages, int circulation, boolean glossy) {
		super(name, issueNumber, numberOfPages, circulation);
		this.glossy = glossy;
	}

	@Override
	public String toString() {
		return super.toString() + "\t GLOSSY: " + glossy;
	}
	
	public boolean isGlossy() {
		return glossy;
	}

	@Override
	public void print() {
		System.out.println(super.getName() + "	ISSUE NUMBER: " + getIssueNumber() + "	NUMBER OF PAGES: " + getNumberOfPages() + "	CIRCULATION: "
				+ getCirculation() + "	GlOSSY: " + isGlossy());
	}

}
