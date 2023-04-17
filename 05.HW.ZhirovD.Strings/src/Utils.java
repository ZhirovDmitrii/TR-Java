
public class Utils {
// 	The method should return true if string is palindrome and false if is not. Case insensitive
	public static boolean isPalindrome(String str) {
		String text = str.toLowerCase(); // for case insensitive
		char[] letters = text.toCharArray(); // split the given string into characters
		int forward = 0; // for check from start our array letters
		int backward = letters.length - 1; // for check from end our array letters

		while (backward > forward) {
			if (letters[forward++] != letters[backward--]) // check and move to check next symbols
				return false;
		}
		return true;
	}

//	The method takes 2 strings and returns true if the second string is the reverse of the first
	public static boolean isReverse(String str1, String str2) {
		// reverse str2
		char[] array = str2.toCharArray();
		String str2Reverse = "";

		for (int i = array.length - 1; i >= 0; i--)
			str2Reverse += array[i];

		// check and return result
		return str1.equalsIgnoreCase(str2Reverse);
	}

//	The method should print a substring of the passed string in reverse
	public static void printSubStringReverse(String str, int start, int end) {
		String sub = str.substring(start, end);

		char[] array = sub.toCharArray();
		for (int i = array.length - 1; i >= 0; i--)
			System.out.print(array[i]);

	}

//	The method should output the string to the console character by character in a column. one character per line
	public static void printStringInColumn(String str) {
		char[] array = str.toCharArray();
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}

//	The method should return how many times a character occurs in a String str
	public static int countChar(String str, char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
		}
		return count;
	}
}