
public class StringExpression {
	public static boolean isTrue(String string) {
		return string.matches("[tT]rue");
	}

	public static boolean isNumber(String str) {
		return str.matches("\\d+");
	}

	public static boolean isThreeDigitsNumber(String str) {
		return str.matches("\\d{3}");
	}

	public static boolean isPositiveNumberLessThan300(String str)// 0-9 || 10-99 || 100-299
	{
//		return str.matches("[12]?\\d?\\d");
		return str.matches("([12]\\d{2})|([1-9]?\\d)");
	}

	public static boolean isWord(String str) {
//		return str.matches("[A-Za-z][a-z]*-?[a-z]+");
		return str.matches("([A-Za-z][a-z]*-[a-z]+)|([A-Za-z][a-z]*)");
	}

	public static boolean isIsraelMobilePhone(String str) {
		return str.matches("(\\+972|\\(\\+972\\)|0)-?5(-?\\d){8}");
	}
}