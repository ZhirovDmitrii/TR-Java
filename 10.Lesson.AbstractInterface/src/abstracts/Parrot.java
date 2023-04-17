package abstracts;

public class Parrot extends Pet implements IFlyable, IRunable, IBoxable {
	public boolean talk;

	public Parrot(String name, int age, char gender, boolean talk) {
		super(name, age, gender);
		this.talk = talk;
	}

	public void voice() {
		if (talk)
			System.out.println("Gav bulk mau hello");
		else
			System.out.println("prosto orut");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub

	}
}
