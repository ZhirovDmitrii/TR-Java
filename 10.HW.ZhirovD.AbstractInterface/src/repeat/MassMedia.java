package repeat;

public abstract class MassMedia {
	private String name;
	
	public MassMedia(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "NAME:	" + name;
	}

	public abstract int getRating();
}
