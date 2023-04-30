
public class MySingleton2 {
	private static MySingleton2 instance;
	
	private MySingleton2() {
		System.out.println("Object created");
	}
	
	public static MySingleton2 getInstance() {
		if(instance == null)
			instance = new MySingleton2();
		return instance;
	}
	
	public void display() {
		System.out.println("I am singletone");
	}
}
