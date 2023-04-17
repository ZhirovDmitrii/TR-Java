
public abstract class MassMedia {
	protected String name;
	
	public MassMedia(String name) {
		this.name = name;
	}

	public abstract int getRating();

	public String getName() {
		return name;
	}
}
