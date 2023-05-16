import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calculator {

//	Write a map based calculator application, where you will have an operator as a key, and a functional interface as a 
//	value, where you will pass the corresponding arithmetic operation. Take the Calculator from the lesson 8 as a basis.

	static Map<String,BinaryOperator<Integer>> mapOperations;
		static {
			mapOperations = new HashMap<>();
			// for me
//			mapOperations.put("+", new BinaryOperator<Integer>() {
//
//				@Override
//				public Integer apply(Integer t, Integer u) {
//					return t+u;
//				}
//				
//			});
			mapOperations.put("+", (t,u) -> t+u);
			mapOperations.put("*", (t,u) -> t*u);
			mapOperations.put("-", (t,u) -> t-u);
			mapOperations.put("/", (t,u) -> t/u);
		}

	public static Object computeExpression(String string) {
		if (!isArithmeticExpression(string))
			return null;
		
		string = string.trim();
		
		String[] operands = getOperands(string);	// digits
		String[] operators = getOperators(string);	// symbols (+-*/)
		Integer res = Integer.parseInt(operands[0]);// number (parse from string to Integer)
		
		for (int i = 1; i < operands.length; i++)
		{
			res = computeOne(res, Integer.parseInt(operands[i]), operators[i]);
		}

		return res;
	}
	
	private static Integer computeOne(Integer res, Integer operand, String operator) {
//		Integer number = Integer.parseInt(operand);
//		switch (operator) {
//		case "+":
//			return sum(res, number);
//		case "-":
//			return sub(res, number);
//		case "*":
//			return mul(res, number);
//		case "/":
//			return div(res, number);
//		default:
//			return res;
//		}
		return mapOperations.getOrDefault(operator, (t,u) -> null).apply(res, operand);
	}

	private static boolean isArithmeticExpression(String string) {
		return string.matches("\\s*\\d+(\\s*[*+/-]\\s*\\d+)*\\s*");
	}

	private static String[] getOperators(String string) {
		return string.split("[\\s\\d]+");
	}

	private static String[] getOperands(String string) {
		return string.split("\\D+");
	}

}
