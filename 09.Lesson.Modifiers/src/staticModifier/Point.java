package staticModifier;

public class Point {
	//fields
	public int x;
	public int y;
	//constant "fields"
	public static double pi = 3.14;
	public static int count = 0;

	// constructor
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		count++;
	}

	// method - just counter
	public Point() {
		count++;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]" + getString(x);
	}

	public static void print(String str) {

		System.out.println(str);
		System.out.println(count);
//		System.out.println(x); - error
//		toString(); - error
//		static int res = 0; - error
	}

	public static String getString(Integer str) {
		return str.toString();
	}
}