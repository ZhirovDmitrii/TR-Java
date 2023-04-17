import java.util.Arrays;

public class WrapperIntro {

	public static void main(String[] args) {
		// byte -> Byte
		// short -> Short
		// int -> Integer +
		// long -> Long
		// float -> Float
		// double -> Double +
		// boolean -> Boolean +
		// char -> Character +
		
		int x = 10;					// 4 byte
		System.out.println(x + 10);
		
		Integer y = 10;				// 8 byte (this is link)
		System.out.println(y + 10);
		
		int z = y; // unpacking
		Integer q = x;	// packing
		System.out.println(z);
		System.out.println(q);
		
		@SuppressWarnings("removal")
		Integer a = new Integer(100);	// duplicated
		System.out.println(a);
		
		// parse (string -> number)
		String str1 = "2";
		String str2 = "10";
		System.out.println(str1 + str2); // 210 - concat
		
		Integer i = Integer.parseInt(str1);
		Integer j = Integer.parseInt(str2);
		System.out.println(i + j);	// 12
		
		// i = Integer.parseInt("hello"); // WRONG
		i = Integer.parseInt("-12");
		System.out.println(i);
		
		Double d = Double.parseDouble("-112.12");
		System.out.println(d);
		
		Boolean b = Boolean.parseBoolean("true");
		System.out.println(b);
		b = Boolean.parseBoolean("1");
		System.out.println(b);
		b = Boolean.parseBoolean("TRUE");
		System.out.println(b);
		
		System.out.println(i.toString());
		System.out.println(Integer.toBinaryString(i));
		
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		System.out.println(Byte.BYTES);
		System.out.println(Float.SIZE);	// bit
		
		Short s = 10; // auto package
		Short s1 = 8;
		Short s2 = 10;
		System.out.println(s - s1);	// unpacking
		System.out.println(s.equals(s2));	// true
	
		int res = 10;
		printNumber(i);
		printNumberWrapper(res);
		
		@SuppressWarnings("unused")
		int[] array = {1, 2, 3, 4, 5};
		// printArray(array);	// WRONG - Integer can't use int
	
		// Char wrapper
		Character ch ='A';
		Character ch1 = 100;	// ascii
		System.out.println(ch);
		System.out.println(ch1);
		System.out.println(Character.isUpperCase(ch));
		System.out.println(Character.isUpperCase(ch1));
		System.out.println(Character.isDigit(ch));
	}
	

	public static void printNumber(int x)
	{
		System.out.println("x = " + x);
	}
	
	public static void printNumberWrapper(Integer x)
	{
		System.out.println("x = " + x);
	}
	
	public static void printArray(Integer[] array)
	{
		System.out.println(Arrays.toString(array));
	}
	
}