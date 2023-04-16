import java.util.Arrays;

public class StringsAppl {

	public static void main(String[] args) {
		// private final char[] value; - inside String

		// create string option 1
		String str = "Hello";

		// create string option 2
		String str1 = new String();

		// create string option 3
		String str2 = new String("world");

		// create string option 4
//		String str3 = new String(new char[] {'h', 'e', 'l', 'l', 'o'});
		char[] res = { 'h', 'e', 'l', 'l', 'o' };
//		char[] res = new char[] {'h', 'e', 'l', 'l', 'o'};
		String str3 = new String(res);

		// =====//
		// work with character elements
		String str4 = new String(res, 2, 2); // 'l' 'l' - res(argument), 2(second index), 2(two characters use (l and l))
		System.out.println(str4);

		System.out.println(str3.length()); // = 5

			// toString()
		char[] chars = str3.toCharArray(); // split the string into characters
		System.out.println(Arrays.toString(chars)); // print array

			// isEmpty()
		System.out.println(str1.isEmpty()); // true
		System.out.println(str3.isEmpty()); // false

			// isBlank()
		System.out.println(str1.isBlank()); // true (check only space and if is empty array)
		System.out.println(str3.isBlank()); // false

		String str5 = "		";
		System.out.println(str5.isBlank()); // true (only space)
		System.out.println(str5.isEmpty()); // false (not empty)

			// concat()
		System.out.println(str + str2); // Helloworld
		System.out.println(str.concat(str2)); // Helloworld

				// if it is NULL - concat will show EXCEPTION
		System.out.println(str + null); // Hellonull
//		System.out.println(str.concat(null));	// EXCEPTION

			// join()
		System.out.println(String.join(" ", str, str1, str2, str3, str4, str5));

		// STRING COMPARISON
		str = "Hello";
		str1 = "Hello";
		str2 = "hello";
		str3 = "HELLO";
		str4 = "Hello world";
		str5 = "I work";

			// equals()
		System.out.println(str.equals(str1)); // true
		System.out.println(str.equals(str2)); // false

			// equalsIsIgnoreCase()
		System.out.println(str.equalsIgnoreCase(str1)); // true
		System.out.println(str.equalsIgnoreCase(str2)); // true

			// compareTo() - return int
		System.out.println(str.compareTo(str1)); // if the strings are equal - return 0
		System.out.println(str.compareTo(str2)); // if first string < second string - return -32 (H - h)
		System.out.println(str2.compareTo(str)); // if first string > second string - return +32 (h - H)

		System.out.println(str.compareToIgnoreCase(str1)); // return 0
		System.out.println(str.compareToIgnoreCase(str2)); // return 0
		System.out.println(str2.compareToIgnoreCase(str)); // return 0

		System.out.println(str.compareTo(str4)); // return -6

			// regionMatches() / toffset()
		System.out.println(str4.regionMatches(true, 5, str5, 1, 4)); // true (" wor" equals with " wor")
		System.out.println(str4.regionMatches(5, str5, 1, 4)); // true

			// charAt()
		System.out.println(str4.charAt(0)); // H

			// indexOf() - return index of the searched element
		System.out.println(str4.indexOf('l')); // return 2
		System.out.println(str4.indexOf('l', 3)); // return 3 - start finding from 3 symbol(index)

			// lastIndexOf() - search from the end
		System.out.println(str4.lastIndexOf('l')); // return 9
		System.out.println(str4.lastIndexOf('l', 3)); // return 3 - start finding from 3 symbol(index)

			// startWith()
		System.out.println(str4.startsWith("Hell")); // true

			// endWith()
		System.out.println(str4.endsWith("Hello")); // false

			// getChars()
		char[] destination = new char[4]; // create new char array
		str4.getChars(2, 6, destination, 0); // use getChars()
		System.out.println(Arrays.toString(destination)); // print array

			// substring()
		System.out.println(str4.substring(4)); // print from 4 symbol to end
		System.out.println(str4.substring(4, 6)); // print 4 and 5 symbols

			// toUpperCase() / toLowerCase()
		System.out.println(str4.toUpperCase()); // all symbols up register
		System.out.println(str4.toLowerCase()); // all symbols low register

			// repeat()
		System.out.println(str4.repeat(3)); // repeat this string 3 times

			// trim()
		System.out.println("   hello       ");
		System.out.println("   hello       ".trim()); // delete all spaces

			// split()
		str = "Two beer or not two beer";
		String[] words = str.split(" ");
		System.out.println(Arrays.toString(words));

		// =====//
		// "1 2 3aa 4 5 6 7" - find sum all this digits
		System.out.println(getCharsSum("1 2 3 45 6", " "));
		System.out.println(getCharsSum("1-2-3-45-6", "-"));
		System.out.println(getCharsSum("1 2a  3 aaa 45 6", " "));
	}

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

	private static boolean isDigitChars(String string) {
		char[] array = string.toCharArray();

		for (int i = 0; i < array.length; i++) {
			if (!(Character.isDigit(array[i])))
				return false;
		}
		return true;
	}

}