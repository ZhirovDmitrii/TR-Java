
public class Calculator {
	public static int sum(int x, int y) {
		return x + y;
	}

	public static int div(int x, int y) {
		return x / y;
	}

	public static int mul(int x, int y) {
		return x * y;
	}

	public static int sub(int x, int y) {
		return x - y;
	}

	public static Integer computeExpression(String string) {
		if (!isArithmeticExpression(string))
			return null;

		string = string.trim();

		String[] operands = getOperands(string);	// digits
		String[] operators = getOperators(string);	// symbols (+-*/)
		Integer res = Integer.parseInt(operands[0]);// number (parse from string to Integer
		
		for (int i = 1; i < operands.length; i++) {
			res = computeOne(res, operands[i], operators[i]);
		}
		return res;
	}

	private static boolean isArithmeticExpression(String string) {
		return string.matches("\\s*\\d+(\\s*[*+/-]\\s*\\d+)*\\s*");
	}

	private static Integer computeOne(Integer res, String operand, String operator) {
		Integer number = Integer.parseInt(operand);
		switch (operator) {
		case "+":
			return sum(res, number);
		case "-":
			return sub(res, number);
		case "*":
			return mul(res, number);
		case "/":
			return div(res, number);
		default:
			return res;
		}
	}

	private static String[] getOperators(String string)
	{
		return string.split("[\\s\\d]+");
	}

	private static String[] getOperands(String string) {
		return string.split("\\D+");
	}

}