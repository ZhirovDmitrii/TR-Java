package driver;

public interface PrinterDriver {
	void say();

	default void drive() {
		System.out.println("I drive a printer");
	}

	static void greeting() {
		System.out.println("Print with lexmark!");
	}
}
