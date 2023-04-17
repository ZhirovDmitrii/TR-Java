
public class NewsPortal extends MassMedia{
	public String url;
	public int numberOfUsers;
	
	public NewsPortal(String name, String url, int numberOfUsers) {
		super(name);
		this.url = url;
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
