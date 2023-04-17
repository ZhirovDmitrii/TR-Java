
class Newspaper extends MassMedia implements IPrintable{
	private int issueNumber;
    private int numberOfPages;
    private int circulation;
    
    public Newspaper(String name, int issueNumber, int numberOfPages, int circulation) {
        super(name);
        this.issueNumber = issueNumber;
        this.numberOfPages = numberOfPages;
        this.circulation = circulation;
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
				"issue number: " + issueNumber +
				"number of pages: " + numberOfPages + 
				"circulation: " + circulation);
	}
}