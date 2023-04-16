package oop;

public class Dog extends Animal{
	private String breed;	// field

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age, String breed) {
		super(name, age);
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Dog [breed=" + breed + ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public void voice()
	{
		System.out.println("Gav gav");
	}
	
	public void voiceDog()
	{
		System.out.println("Gav gav");
	}
}

