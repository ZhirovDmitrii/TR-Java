package abstracts;

public abstract class Pet extends Animal {
	public char gender;

	public Pet(String name, int age, char gender) {
		super(name, age);
		this.gender = gender;
	}

//	public abstract void voice();
}
