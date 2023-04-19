
public class Utils {
	// Print reverse number
	public static void printReverseNumber(int number) {
		int reverssResult = reverseNumber(number);
		System.out.println(reverssResult);
		return;
	}

	// Return reverse number
	public static int reverseNumber(int number) {
		int reverse = 0;

		if (number % 10 == 0)
			return -1;
		else if (number <= 0)
			return -1;

		while (number > 0) {
			reverse = (reverse * 10) + (number % 10);
			number /= 10;
		}

		return reverse;
	}
}