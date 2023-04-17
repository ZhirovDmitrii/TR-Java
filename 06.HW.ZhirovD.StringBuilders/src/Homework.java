
public class Homework {
//	 	The method should return true if string is palindrome and false if is not. Case insensitive
	// my option
	public static boolean isPalindrome(String str) {
		if (str == null || str.isBlank())
			return false;

		if (str.length() == 1)
			return true;

		return str.equals(new StringBuilder(str).reverse().toString()) ? true : false;
	}
	
	// teachers options
	public static boolean isPalindrome1(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		if (str.length() == 1)
			return true;

		str = str.trim().toLowerCase().replace(" ", "");
		StringBuilder temp = new StringBuilder(str).reverse();
		return str.equals(temp.toString());
	}

	public static boolean isReverse(String str1, String str2) {
		if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty())
			return false;

		int size1 = str1.length();
		int size2 = str2.length();
		if (size1 != size2)
			return false;

		return str1.equals(new StringBuilder(str2).reverse().toString());
	}

	public static String reverse(String str) {
		StringBuilder temp = new StringBuilder(str);
		return temp.reverse().toString();
	}
}