
public class MathUtils {
	// Count digits
	public static int countDigits(int number) {
		int count = 0;

		if (number > 0) {
			for (; number != 0; number /= 10)
				count++;
		} else
			return -1;
		return count;
	}

	// Count even digits
	public static int countEvenDigits(int number) {
		int count = 0;

		if (number > 0) {
			for (; number != 0; number /= 10) {
				if (number % 2 == 0)
					count++;
			}
		} else
			return -1;

		return count;
	}

	// Count odd digits
	public static int countOddDigits(int number) {
		int count = 0;

		if (number > 0) {
			for (; number != 0; number /= 10) {
				if (number % 2 != 0)
					count++;
			}
		} else
			return -1;

		return count;
	}

	// Factorial
	public static int factorial(int number) {
		int result = 1;

		if (number <= 0)
			return -1;
		else if (number == 0)
			return 1;

		for (; number > 0; number--) {
			result *= number;
		}

		return result;
	}

	// Number in power
	public static int numberToThePower(int number, int power) {
		int result = 1;

		if (power == 0)
			return 1;
		else if (power < 0)
			return -1;

		for (; power > 0; power--) {
			result *= number;
		}

		return result;
	}

	// Sum digits in number
	public static int sumDigits(int number) {
		int sum = 0;

		for (; number != 0; number /= 10) {
			sum += number % 10;
		}

		return sum;
	}

	// Sum odd digits in number
	public static int sumOddDigits(int number) {
		int sum = 0;

		if (number < 0)
			return -1;

		for (; number != 0; number /= 10) {
			if (number % 2 == 1)
				sum += number % 10;
		}

		return sum;
	}

	// Sum even digits in number
	public static int sumEvenDigits(int number) {
		int sum = 0;

		if (number < 0)
			return -1;

		for (; number != 0; number /= 10) {
			if (number % 2 == 0)
				sum += number % 10;
		}

		return sum;
	}
}