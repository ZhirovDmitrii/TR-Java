
public class StringExpression {

	public static Boolean isProgrammingName(String string) {
		// TODO Auto-generated method stub
		return string.matches("[A-Za-z_]+\\d*");
	}

	public static Boolean isPositiveNumberLess1000(String string) {
		// TODO Auto-generated method stub
							// 0 1-9 10-99 100-999
		return string.matches("0|[1-9]\\d?\\d?");
	}

	public static Boolean isPositiveNumberLessEquals255(String string) {
		// TODO Auto-generated method stub
							//	0-9		10-99	100-199		200-255
		return string.matches("\\d|[1-9]\\d|1\\d{2}|2[0-5][0-5]");
	}

	public static Boolean isIPv4(String string) {
		// TODO Auto-generated method stub
		return string.matches("((\\d|[1-9]\\d|1\\d{2}|2[0-5][0-5])\\.){3}"
				+ "(\\d|[1-9]\\d|1\\d{2}|2[0-5][0-5])");
	}

	public static Boolean isEmailCoIlMailRu(String string) {
		// TODO Auto-generated method stub
		return string.matches("[^\\s,]+@[A-Za-z\\d]+\\.(co\\.il|mail\\.ru)");
	}

	public static Boolean isArithmeticExpression(String string) {
		// TODO Auto-generated method stub
		return string.matches("\\s*\\d+(\\s*[*/+-]\\s*\\d+)*\\s*");
	}

	public static Boolean checkCreditCardNumber(String string) {
		// TODO Auto-generated method stub
		return string.matches("\\d{8,16}");
	}

	public static Boolean checkDateFormatEU(String string) {
		// TODO Auto-generated method stub
							// 01-09 10-19 20-29 30-31 .	0-9		10-12 .	year
		return string.matches("(0[1-9]|1\\d|2\\d|3[0-1])\\.(0[1-9]|1[0-2])\\.\\d{4}");
	}

	public static Boolean checkDateFormatUS(String string) {
		// TODO Auto-generated method stub
							// year	  - 01-09	10-12	-	01-09 10-19 20-29 30-31
		return string.matches("\\d{4}\\-(0[1-9]|1[0-2])\\-(0[1-9]|1\\d|2\\d|3[0-1])");
	}

	public static Boolean isNumber(String string) {
		// TODO Auto-generated method stub
		return string.matches("-?(0|[1-9]\\d*)(\\.\\d+)?");
	}

	
}