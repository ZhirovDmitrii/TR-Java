package abstracts;

public class Fish extends Pet implements ISwimable {
	public String color;

	public Fish(String name, int age, char gender, String color) {
		super(name, age, gender);
		this.color = color;
	}

	public void voice() {
		System.out.println("Bulk bulk");
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub

	}
}