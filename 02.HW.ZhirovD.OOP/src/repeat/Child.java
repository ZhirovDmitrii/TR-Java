package repeat;

import java.util.Objects;

public class Child extends Person{
	private String kinderGarten;

	public Child(String name, int age, boolean married, String kinderGarten) {
		super(name, age, married);
		this.kinderGarten = kinderGarten;
	}

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
		result = prime * result + Objects.hash(kinderGarten);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Child other = (Child) obj;
		return Objects.equals(kinderGarten, other.kinderGarten);
	}

	@Override
	public String toString() {
		return "Child [kinderGarten=" + kinderGarten + "]";
	}
}
