
public class MySingleton {
	public static final MySingleton INSTANCE = new MySingleton();
	
	private MySingleton() {
		System.out.println("Object created");
	}
	
	public void display() {
		System.out.println("I am singletone");
	}
}
