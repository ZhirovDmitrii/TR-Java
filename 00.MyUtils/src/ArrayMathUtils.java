
public class ArrayMathUtils {
	// Sum elements array
	public static int sumElements(int[] arr) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	// Sum even index elements
	public static int sumEvenIndexElements(int[] arr) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		int sum = 0;

		int i;
		for (i = 0; i < arr.length; i += 2) {
			sum += arr[i];
		}
		return sum;
	}

	// Sum odd index elements
	public static int sumOddIndexElements(int[] arr) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		int sum = 0;

		int i;
		for (i = 1; i < arr.length; i += 2) {
			sum += arr[i];
		}
		return sum;
	}

	// Sum even elements array
	public static int sumEvenElements(int[] arr) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0)
				sum += arr[i];
		}

		return sum;
	}

	// Sum odd elements array
	public static int sumOddElements(int[] arr) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0)
				sum += arr[i];
		}

		return sum;
	}

	// Sum first and last positive positions
	public static void sumFirstLastPos(int[] arr) {
		if (arr == null)
			return;

		int firstNum = -1, lastNum = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				firstNum = arr[i];
				break;
			}
		}
		for (int j = arr.length - 1; j >= 0; j--) {
			if (arr[j] > 0) {
				lastNum = arr[j];
				break;
			}
		}
		// if we did not meet positive numbers in the array
		if (firstNum != -1)
			System.out.println("Sum = " + (firstNum + lastNum));
	}

	// Average
	public static float average(int[] arr) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		float sum = 0;
		float average = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		average = sum / arr.length;

		return average;
	}

	// Search a value in array
	public static int binarySearch(int[] arr, int value) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		int left = 0;
		int right = arr.length - 1;
		int count = 0;

		while (left <= right) {
			int middle = (left + right) / 2;

			count++;

			if (arr[middle] == value) {
				System.out.println("Count binary = " + count);
				return 1;
			} else if (arr[middle] < value)
				left = middle + 1;
			else if (arr[middle] > value)
				right = middle - 1;
		}
		return 0;
	}

	// Search a value in array and return index
	public static int binarySearchIndex(int[] arr, int number) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int middle = (left + right) / 2;

			if (arr[middle] == number)
				return middle;
			else if (arr[middle] < number)
				left = middle + 1;
			else if (arr[middle] > number)
				right = middle - 1;
		}
		return -1;
	}

	// Search max index
	public static int searchMaxIndex(int[] arr) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[max] < arr[i])
				max = i;
		}
		return max;
	}

	// Search min index
	public static int searchMinIndex(int[] arr) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		int min = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[min] > arr[i])
				min = i;
		}
		return min;
	}

	// Search max element
	public static int searchMaxElement(int[] arr) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}

	// Search min element
	public static int searchMinElement(int[] arr) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}

		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i])
				min = arr[i];
		}
		return min;
	}

	// Search min element in range
	public static int searchMinElementInRange(int[] arr, int startIndex, int finishIndex) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		} else if (startIndex < 0 || finishIndex >= arr.length || startIndex > finishIndex) {
			System.out.println("Wrong range\n");
			return 0;
		}

		int min = arr[startIndex];
		for (int i = startIndex + 1; i <= finishIndex; i++) {
			if (min > arr[i])
				min = arr[i];
		}
		return min;
	}

	// Search max element in range
	public static int searchMaxElementInRange(int[] arr, int startIndex, int finishIndex) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		} else if (startIndex < 0 || finishIndex >= arr.length || startIndex > finishIndex) {
			System.out.println("Wrong range\n");
			return 0;
		}

		int max = arr[startIndex];
		for (int i = startIndex + 1; i <= finishIndex; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}
}