
public class Journal extends MassMedia implements IPrintable{
	public int issueNumber;
	public int numberOfPages;
	public int circulation;
	public boolean glossy;
	
	public Journal(String name, int issueNumber, int numberOfPages, int circulation, boolean glossy) {
		super(name);
		this.issueNumber = issueNumber;
		this.numberOfPages = numberOfPages;
		this.circulation = circulation;
		this.glossy = glossy;
	}
	
	@Override
    public int getRating() {
        if (circulation >= 9291000) {
            return 10;
        } else {
            return circulation * 10 / 9291000;
        }
    }

	@Override
	public void print() {
		System.out.println("Newspaper: " + name +
				", issue number: " + issueNumber +
				", number of pages: " + numberOfPages + 
				", circulation: " + circulation + 
				"glossy: " + glossy);
	}
}