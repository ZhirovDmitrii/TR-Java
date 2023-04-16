import java.util.Arrays;

public class ArgsAppl {

	public static void main(String[] args) { // 0 - operand1, 1 - operand2, 2-operator
//		System.out.println(Arrays.toString(args));
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);

		System.out.println(calculator(x, y, args[2]));
	}

	public static double calculator(double x, double y, String op) {
		switch (op) {
		case "add":
			return x + y;
		case "sub":
			return x - y;
		case "mul":
			return x * y;
		case "div":
			return x / y;
		default:
			System.out.println("Wrong operator");
			return Double.NaN;
		}
	}
}