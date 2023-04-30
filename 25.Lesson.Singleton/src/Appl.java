
public class Appl {

	public static void main(String[] args) {
		MySingleton obj1 = MySingleton.INSTANCE;
		MySingleton obj2 = MySingleton.INSTANCE;
		
		obj1.display();
		System.out.println(obj1 == obj2);// true

		MySingleton2 obj3 = MySingleton2.getInstance();
		MySingleton2 obj4 = MySingleton2.getInstance();
		obj3.display();
		System.out.println(obj3 == obj4);// true
	}

}
