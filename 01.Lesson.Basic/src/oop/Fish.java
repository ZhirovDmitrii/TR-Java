package oop;

public class Fish extends Animal {
	private boolean reproduction;

	public boolean isReproduction() {
		return reproduction;
	}

	public void setReproduction(boolean reproduction) {
		this.reproduction = reproduction;
	}

	public Fish(String name, int age, boolean reproduction) {
		super(name, age);
		this.reproduction = reproduction;
	}

	@Override
	public String toString() {
		String str = reproduction ? "eggs" : "whitebaits";

		return "Fish [reproduction=" + str + "]" + super.toString();
	}

	@Override
	public void voice()
	{
		System.out.println("Bulk bulk");
	}
	
	public void voiceFish()
	{
		System.out.println("Bulk bulk");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (reproduction ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Fish))
			return false;
		Fish other = (Fish) obj;
		if (reproduction != other.reproduction)
			return false;
		return true;
	}
	
	
}