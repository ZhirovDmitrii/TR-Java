
public class StringsUtils {
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
		// for case insensitive
		String str1Low = str1.toLowerCase();
		String str2Low = str2.toLowerCase();

		// reverse str2
		char[] array = str2Low.toCharArray();
		String str2Reverse = "";

		for (int i = array.length - 1; i >= 0; i--)
			str2Reverse += array[i];

		// check and return result
		return str1Low.equals(str2Reverse);
	}

//	The method should print a substring of the passed string in reverse
	public static void printSubStringReverse(String str, int start, int end) {
		String res = "";
		String sub = str.substring(start, end);

		char[] array = sub.toCharArray();
		for (int i = array.length - 1; i >= 0; i--)
			res += array[i];

		System.out.println(res);
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
	
//	The method returns the sum of all numbers in the string
	public static int getCharsSum(String str, String delim) {
		// exception
		if (str == null || delim == null || str.isBlank())
			return 0;

		String[] array = str.split(delim);
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			if (isDigitChars(array[i]) && !array[i].isEmpty()) {
				int num = Integer.parseInt(array[i]);
				sum += num;
			}
		}
		return sum;
	}
	
//	The method to check if a character in a string is a digit
	public static boolean isDigitChars(String string) {
		char[] array = string.toCharArray();

		for (int i = 0; i < array.length; i++) {
			if (!(Character.isDigit(array[i])))
				return false;
		}
		return true;
	}
	
//	Select sort
	public static void selectSort(String[] strings) {
		if (strings == null || strings.length == 0 || strings.length == 1)
			return;
		for (int i = 0; i < strings.length; i++) {
			selectSort(i, strings);
		}
	}

	// Select sort
	private static void selectSort(int index, String[] strings) {
		String min = strings[index];
		int indexMin = index;
		for (int i = index; i < strings.length - 1; i++) {
			if (min.compareTo(strings[i + 1]) > 0) {
				min = strings[i + 1];
				indexMin = i + 1;
			}
		}

		swap(strings, index, indexMin);
	}

//	The method swap element (for sort)
	public static void swap(String[] strings, int i, int j) {
		String temp = strings[i];
		strings[i] = strings[j];
		strings[j] = temp;
	}
//	The method to check if a words is anagram from string origin
	public static boolean isAnagram(String origin, String anagram) {
		byte[] codes = new byte[128]; // [0][0][0][1][0][0][1][0][][2][][].....
		char[] symbols = origin.toCharArray();

//		step 1: iterate origin, count symbols
		for (int i = 0; i < symbols.length; i++) {
			int symbol = symbols[i]; // n 'E'
			codes[symbol]++;
		}

//		for(int i = 0; i < origin.length(); i++) {
//			int symbol = origin.charAt(i); // [][][][][][] private final char[]
//			codes[symbol]++;
//		}

		// step 2: iterate anagram and check if there are enough values in codes array
		symbols = anagram.toCharArray();
		for (int i = 0; i < symbols.length; i++) {
			int symbol = symbols[i];
			if (codes[symbol] == 0)
				return false;
			else
				codes[symbol]--;
		}

		return true;
	}
}