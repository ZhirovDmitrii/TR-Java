package staticModifier;

public class PointAppl {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(1, 1);	// count = 1
		Point p1 = new Point(2, 2);	// count = 2

		System.out.println(p.x);	// 1
		System.out.println(p1.x);	// 2
		System.out.println(p.pi);	// 3.14 - const
		System.out.println(p1.pi);	// 3.14 - const
		System.out.println(Point.pi);	// !!! 3.14 - const !!!

		System.out.println(Integer.MAX_VALUE);

		Point p2 = new Point();
		System.out.println(Point.count);	// count 3

		p2.print("Hello");
		Point.print("Hello");
	}

}