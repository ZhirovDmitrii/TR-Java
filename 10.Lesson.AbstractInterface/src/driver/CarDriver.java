package driver;

public interface CarDriver {
	void say();

	default void drive() {
		System.out.println("I drive a car");
	}

	static void greeting() {
		System.out.println("Good morning!");
	}
}