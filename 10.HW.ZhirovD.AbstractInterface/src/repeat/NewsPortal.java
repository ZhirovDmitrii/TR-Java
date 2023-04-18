package repeat;

public class NewsPortal extends MassMedia{
	private String url;
	private int numberOfUsers;
	
	public NewsPortal(String name, String url, int numberOfUsers) {
		super(name);
		this.url = url;
		this.numberOfUsers = numberOfUsers;
	}

	public String getUrl() {
		return url;
	}

	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	@Override
	public String toString() {
		return super.toString() + "	URL: " + url + "	NUMBER OF USERS: " + numberOfUsers;
	}

	@Override
	public int getRating() {
		if(numberOfUsers >= 9291000)
			return 10;
		else
			return numberOfUsers * 10 / 9291000;
	}
	
	
}
