package abstracts;

public class Dog extends Pet implements IBoxable, IRunable, ISwimable {
	public String breed;

	public Dog(String name, int age, char gender, String breed) {
		super(name, age, gender);
		this.breed = breed;
	}

	public void voice() {
		System.out.println("Gav gav");
	}

	@Override
	public double size(double height, double length, double width) {
		return height * length;
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

//	public abstract void run();
}