package staticModifier;

public class Point1 extends Point {
	public int z;

	public Point1(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	@Override
	public String toString() {
		return "Point1 [z=" + z + "]";
	}

//	@Override
//	public static String getString(Integer str)
//	{
//		return str.toString();
//	}
}
