
public class ArrayUtils {
	// Print array
	public static void printArray(int[] arr) {
		if (arr == null)
			return;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	// Print array reverse
	public static void printArrayReverse(int[] arr) {
		if (arr == null)
			return;

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	// Print array strings
	public static void printArrayStrings(String[] strs) {
		if (strs == null)
			return;
		for (int i = 0; i >= strs.length; i++) {
			System.out.print(strs[i] + " ");
		}
		System.out.println();
	}

	// Print array strings reverse
	public static void printArrayStringsReverse(String[] strs) {
		if (strs == null)
			return;
		for (int i = strs.length - 1; i >= 0; i--) {
			System.out.print(strs[i] + " ");
		}
		System.out.println();
	}

	// Print odds index
	public static void printOddsIndex(int[] arr) {
		if (arr == null)
			return;
		for (int i = 1; i < arr.length; i += 2) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	// Print evens index
	public static void printEvensIndex(int[] arr) {
		if (arr == null)
			return;
		for (int i = 0; i < arr.length; i += 2) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	// Fill array random numbers
	public static void fillArray(int[] arr, int min, int max) {
		if (arr == null || min > max)
			return;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * ((max - min) + 1)) + min;
		}
	}

	// Clone array
	public static int[] cloneArray(int[] arr) {
		if (arr == null)
			return null;

		int[] res = new int[arr.length]; // create empty array
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}

		return res;
	}

	// Check sorted array
	public static int isSortedArray(int[] arr) {
		if (arr == null) {
			System.out.println("Array is null");
			return 0;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i + 1])
				return 0;
		}
		return 1;
	}

	// Swap element (for sort)
	public static void swap(int[] arr, int i, int j) {
		if (arr == null)
			return;

		int buf = arr[i];
		arr[i] = arr[j];
		arr[j] = buf;
	}

	// Bubble sort
	public static void bubbleSort(int[] arr) {
		if (arr == null)
			return;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}

	// Bubble sort - reverse
	public static void bubbleSortReverse(int[] arr) {
		if (arr == null)
			return;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] < arr[j + 1])
					swap(arr, j, j + 1);
			}
		}

	}

	// Bubble sort - odd first
	public static void bubbleSortOddFirst(int[] arr) {
		if (arr == null)
			return;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] % 2 == 0)
					swap(arr, j, j + 1);
			}
		}
	}

	// Bubble sort - even first
	public static void bubbleSortEvenFirst(int[] arr) {
		if (arr == null)
			return;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] % 2 != 0)
					swap(arr, j, j + 1);
			}
		}
	}

	// Bubble sort in range
	public static void bubbleSortInRange(int[] arr, int start, int finish) {
		if (arr == null)
			return;
		else if (start < 0 || finish >= arr.length || start > finish) {
			System.out.println("Wrong range\n");
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = start; j <= finish - i - 1; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}

	// Select sort
	public static void selectSort(int[] arr) {
		if (arr == null)
			return;

		int min_i, min_e;

		for (int i = 0; i < arr.length - 1; i++) {
			min_i = i;
			min_e = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min_e) {
					min_e = arr[j];
					min_i = j;
				}
			}
			if (i != min_i)
				swap(arr, i, min_i);
		}
	}

	// SelectSort - reverse
	public static void selectSortReverse(int[] arr) {
		if (arr == null)
			return;

		int min_i, min_e;
		for (int i = 0; i < arr.length - 1; i++) {
			min_e = arr[i];
			min_i = i;

			for (int j = 1 + i; j < arr.length; j++) {
				if (arr[j] > min_e) {
					min_e = arr[j];
					min_i = j;
				}
			}
			if (i != min_i)
				swap(arr, i, min_i);
		}
	}

	// Select sort - odd first
	public static void selectSortOddFirst(int[] arr) {
		if (arr == null)
			return;

		int min_i;
		for (int i = 0; i < arr.length - 1; i++) {
			min_i = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] % 2 != 0) {
					min_i = j;
				}
			}
			if (i != min_i)
				swap(arr, i, min_i);
		}
	}

	// Select sort - even first
	public static void selectSortEvenFirst(int[] arr) {
		if (arr == null)
			return;

		int min_i;
		for (int i = 0; i < arr.length - 1; i++) {
			min_i = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] % 2 == 0) {
					min_i = j;
				}
			}
			if (i != min_i)
				swap(arr, i, min_i);
		}
	}

	// Select sort in range
	public static void selectSortInRange(int[] arr, int start, int finish) {
		if (arr == null)
			return;
		else if (start < 0 || finish >= arr.length || start > finish) {
			System.out.println("Wrong range\n");
			return;
		}

		int min_i, min_e;

		for (int i = start; i < arr.length - 1; i++) {
			min_e = arr[i];
			min_i = i;

			for (int j = i + 1; j <= finish; j++) {
				if (arr[j] < min_e) {
					min_e = arr[j];
					min_i = j;
				}
			}
			if (i != min_i)
				swap(arr, i, min_i);
		}
	}

	// Take a sorted array and insert an element into it
	public static void insertPosition(int[] arr01, int[] arr02, int value) {
		if (arr01 == null && arr02 == null)
			return;
		int myIndex = 0;
		for (int i = 0; i < arr01.length; i++) {

			if (value <= arr01[i]) {
				myIndex = i;
				break;
			} else {
				myIndex = i + 1;
			}
		}
		arr02[myIndex] = value;

		for (int i = 0; i < arr02.length; i++) {
			if (i < myIndex) {
				arr02[i] = arr01[i];
			} else if (i > myIndex) {
				arr02[i] = arr01[i - 1];
			}
		}
	}

	// Reverse first positive and last negative elements
	public static void firstPosLastNegReverse(int[] arr) {
		if (arr == null)
			return;

		int buf01 = 0, buf02 = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				buf01 = i;
				break;
			}
		}
		for (int j = arr.length - 1; j >= 0; j--) {
			if (arr[j] < 0) {
				buf02 = j;
				break;
			}
		}
		swap(arr, buf01, buf02);
	}

	// Finds average and prints all numbers greater than the average in the array
	public static void moreThanAverage(int[] arr) {
		int avg = (int) ArrayMathUtils.average(arr);
		System.out.println(avg);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > avg) {
				System.out.print(arr[i] + " ");
			}

		}

	}
}