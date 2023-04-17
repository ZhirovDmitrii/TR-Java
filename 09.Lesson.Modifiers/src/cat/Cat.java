package cat;

public class Cat {
	public String name;
	private int age;
	protected double weight;
	boolean trained;

	public void print() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(weight);
		System.out.println(trained);
	}
}
