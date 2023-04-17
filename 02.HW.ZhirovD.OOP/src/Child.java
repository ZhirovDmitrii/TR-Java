
public class Child extends Person{
	
	// Field
	private String kinderGarten;

	// Constructor
	public Child(String name, int age, boolean married, String kinderGarten) {
		super(name, age, married);
		this.kinderGarten = kinderGarten;
	}

	// Getters and setters
	public String getKinderGarten() {
		return kinderGarten;
	}

	public void setKinderGarten(String kinderGarten) {
		this.kinderGarten = kinderGarten;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((kinderGarten == null) ? 0 : kinderGarten.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Child))
			return false;
		Child other = (Child) obj;
		if (kinderGarten == null) {
			if (other.kinderGarten != null)
				return false;
		} else if (!kinderGarten.equals(other.kinderGarten))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Child [kinderGarten=" + kinderGarten + "]" + super.toString();
	}
}