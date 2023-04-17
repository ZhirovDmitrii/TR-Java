package repeat;

public class HomeworkAppl1 {
	public static void main(String[] args) {
		String[] array = { "byte", "short", "int", "long", "double", "float", "char" };
		
		if(args.length == 0)
			args = array;
		
		for(int i = 0; i < args.length; i++)
			minMax(args[i]);
	}

	private static String minMax (String array) {
		switch (array) {
		case "byte":
			System.out.println(Byte.TYPE + "\tMin: " + Byte.MIN_VALUE + "\tMax: " + Byte.MAX_VALUE);
			break;
		case "short":
			System.out.println(Short.TYPE + "\tMin: " + Short.MIN_VALUE + "\tMax: " + Short.MAX_VALUE);
			break;
		case "int":
			System.out.println(Integer.TYPE + "\tMin: " + Integer.MIN_VALUE + "\tMax: " + Integer.MAX_VALUE);
			break;
		case "long":
			System.out.println(Long.TYPE + "\tMin: " + Long.MIN_VALUE + "\tMax: " + Long.MAX_VALUE);
			break;
		case "double":
			System.out.println(Double.TYPE + "\tMin: " + Double.MIN_VALUE + "\tMax: " + Double.MAX_VALUE);
			break;
		case "float":
			System.out.println(Float.TYPE + "\tMin: " + Float.MIN_VALUE + "\tMax: " + Float.MAX_VALUE);
			break;
		case "char":
			System.out.println(Character.TYPE + "\tMin: " + (int)Character.MIN_VALUE + "\t\tMax: " + (int)Character.MAX_VALUE);
			break;
		default:
			System.out.println(array + " - is worng type");
			return null;
		}
		return array;
	}
}
