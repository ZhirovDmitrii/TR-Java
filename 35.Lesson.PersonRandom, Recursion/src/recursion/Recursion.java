package recursion;

public class Recursion {

	public static void main(String[] args) {
		method(3); // 1. non recursion call
		
		System.out.println(nonRecursionFactorial(5));
		System.out.println(recursionFactorial(5));
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
		return x == 1 ? 1 : x * nonRecursionFactorial(x - 1);
	}
}
