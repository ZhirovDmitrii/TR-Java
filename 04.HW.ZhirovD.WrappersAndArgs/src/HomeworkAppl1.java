
public class HomeworkAppl1 {

	public static void main(String[] args) {
		String[] array = { "byte", "short", "int", "double", "float", "long", "char" };

		if (args.length == 0) {
			args = array;
			
			for (int i = 0; i < array.length; i++) {
				printMinMaxTypes(array[i]);
			}
		} else {
			for (int i = 0; i < args.length; i++) {
				printMinMaxTypes(args[i]);
			}
		}
	}

	public static void printMinMaxTypes(String operator) {
		switch (operator) {
		case "byte":
			System.out.println("Byte\t" + Byte.MIN_VALUE + "\t" + Byte.MAX_VALUE);
			break;
		case "short":
			System.out.println("Short\t" + Short.MIN_VALUE + "\t" + Short.MAX_VALUE);
			break;
		case "int":
			System.out.println("Integer\t" + Integer.MIN_VALUE + "\t" + Integer.MAX_VALUE);
			break;
		case "double":
			System.out.println("Double\t" + Double.MIN_VALUE + "\t" + Double.MAX_VALUE);
			break;
		case "float":
			System.out.println("Float\t" + Float.MIN_VALUE + "\t" + Float.MIN_VALUE);
			break;
		case "long":
			System.out.println("Long\t" + Long.MIN_VALUE + "\t" + Long.MAX_VALUE);
			break;
		case "char":
			System.out.println("Character\t" + (int) Character.MIN_VALUE + "\t" + (int) Character.MAX_VALUE);
			break;
		default:
			System.out.println(operator + " Wrong type");
		}
	}
}