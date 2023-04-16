package oop;

public class Cat extends Animal {
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Cat(String name, int age, String color) {
		super(name, age);
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cat [color=" + color + "]" + super.toString();
	}
	
	@Override
	public void voice()
	{
		System.out.println("Mau mau");
	}
	
	public void voiceCat()
	{
		System.out.println("Mau mau");
	}
}
