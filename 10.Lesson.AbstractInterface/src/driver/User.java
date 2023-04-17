package driver;

public class User implements CarDriver, PrinterDriver {

	@Override
	public void say() {
		System.out.println("I`m user");
	}

	@Override
	public void drive() {
		CarDriver.super.drive();
		PrinterDriver.super.drive();
	}

}