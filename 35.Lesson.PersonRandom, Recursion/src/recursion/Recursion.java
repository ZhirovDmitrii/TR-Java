package recursion;

public class Recursion {

	public static void main(String[] args) {
		method(3); // 1. non recursion call
		
		System.out.println(nonRecursionFactorial(5));
		System.out.println(recursionFactorial(0));
		
		int[] array = {1,2,3,4,5,6,8,9,10};
		System.out.println(nonRecBinarySearch(array, 0));
		System.out.println(nonRecBinarySearch(array, 2));
		System.out.println(recBinarySearch(array, 0));
		System.out.println(recBinarySearch(array, 2));
		
	}

	public static void method(int x) {
		if (x > 5)
			return; // 2. non recursion return
		method(x + 1);// 3. recursion return to be nearby to non recursion return
	}

	public static int nonRecursionFactorial(int x) {
		int res = 1;
		for (int i = 1; i <= x; i++)
			res *= i;
		return res;
	}

	public static int recursionFactorial(int x) {
		return x == 0 ? 1 : x * nonRecursionFactorial(x - 1);
	}
	
	public static int nonRecBinarySearch(int[] array, int x) {
		int left = 0;
		int right = array.length -1;
		int middle;
		
		while(left <= right) {
			middle = (left + right) / 2;
			if(array[middle] == x)
				return middle;
			else if(x > array[middle])
				left = middle +1;
			else
				right = middle - 1;
		}
		return -1;
	}
	
	public static int recBinarySearchWork(int[] array, int x, int left, int right) {
		if(left > right)
			return -1;
		
		int middle = (left + right) / 2;
		
		if(array[middle] == x)
			return middle;
		else if(x > array[middle])
			left = middle +1;
		else
			right = middle - 1;
		
		return recBinarySearchWork(array, x, left, right);
	}
	
	public static int recBinarySearch(int[] array, int x) {
		return recBinarySearchWork(array, x, 0, array.length-1);
	}
}
