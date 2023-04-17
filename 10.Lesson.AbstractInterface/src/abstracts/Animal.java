package abstracts;

public abstract class Animal {
	public String name;
	public int age;
	
	public Animal(String name, int age)
	{
		super();
		this.name = name;
		this.age = age;
	}
	
	public abstract void voice();
	
	public void method()
	{
		System.out.println("method");
	}
}