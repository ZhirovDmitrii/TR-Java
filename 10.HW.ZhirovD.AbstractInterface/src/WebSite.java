
public class WebSite extends MassMedia {
	public String url;
	public String author;
	public int numberOfUsers;

	public WebSite(String name, String url, String author, int numberOfUsers) {
		super(name);
		this.url = url;
		this.author = author;
		this.numberOfUsers = numberOfUsers;
	}

	@Override
	public int getRating() {
		double ratio = (double) numberOfUsers / 9291000;
		if (ratio >= 1) {
			return 10;
		} else {
			return (int) Math.round(ratio * 10);
		}
	}
}
