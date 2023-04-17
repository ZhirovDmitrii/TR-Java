package repeat;

public class StringExpression {

	public static Boolean isProgrammingName(String string) {
		return string.matches("([A-Za-z_]+\\d*)+");
	}

	public static Boolean isPositiveNumberLess1000(String string) {
		return string.matches("0|[1-9](\\d{1,2})?");
	}

	public static Boolean isPositiveNumberLessEquals255(String string) {
		return string.matches("0|[1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5]");
	}

	public static Boolean isIPv4(String string) {
		return string.matches("((0|[1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(0|[1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])");
	}

	public static Boolean isEmailCoIlMailRu(String string) {
		return string.matches("[^\\s,]+@[A-Za-z0-9-]+\\.(co\\.il|mail\\.ru)");
	}

	public static Boolean isArithmeticExpression(String string) {
		return string.matches("\\s?\\d+(\\s?[*/+-]\\s?\\d+)*");
	}

	public static Boolean checkCreditCardNumber(String string) {
		return string.matches("\\d{8,16}");
	}

	public static Boolean checkDateFormatEU(String string) {
		return string.matches("([0-2]\\d|3[01])\\.(0[1-9]|1[0-2])\\.\\d{4}");
	}

	public static Boolean checkDateFormatUS(String string) {
		return string.matches("\\d{4}-(0[1-9]|1[0-2])-([0-2]\\d|3[01])");
	}

	public static Boolean isNumber(String string) {
		return string.matches("-?(0(\\.\\d+)?|[1-9]\\d*(\\.\\d+)?)");
	}

}
