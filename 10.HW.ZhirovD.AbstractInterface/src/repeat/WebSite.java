package repeat;

public class WebSite extends NewsPortal{
	private String author;

	public WebSite(String name, String url, int numberOfUsers, String author) {
		super(name, url, numberOfUsers);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return super.toString() + "	AUTHOR: " + author;
	}
	
	

}
