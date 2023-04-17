import java.util.Arrays;

public class Varargs
{

	public static void main(String[] args)
	{
		test(new int[0]);
		testVararg();
		testVararg(1);
		testVararg(1,2,3,4,5,6,7,8,9);
		testVararg(new int[] {1,2,3,4});
		
		int[] array = new int[] {1,2,3,4};
		testVararg(array);
		
		testVararg1(1,2);
		testVararg1(1,2,3);
		testVararg1(1,2,3,4,5,6,7,8,9);
		testVararg1(1,2, new int[] {1,2,3,4});
	}
	
	public static void test(int[] ar)
	{
		System.out.println("test");
	}
	
	public static void testVararg(int ...num)
	{
		System.out.println("test vararg");
		System.out.println(num.length);
		System.out.println(Arrays.toString(num));
	}
	
	public static void testVararg1(int x, int y, int ...num)
	{
		System.out.println("test vararg1");
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println(num.length);
		System.out.println(Arrays.toString(num));
	}
	
//	CRUD - create read update delete

}