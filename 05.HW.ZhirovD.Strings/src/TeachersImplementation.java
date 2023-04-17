
public class TeachersImplementation {
	public static boolean isPalindrome(String str)
	{
		if (str == null || str.isBlank())
			return false;

		if (str.length() == 1)
			return true;

		str = str.toLowerCase().replaceAll(" ", "");
		
		char[] chars = str.toCharArray();
		for (int i = 0, j = chars.length - 1; i < j; i++, j--) 
		{
			if (chars[i] != chars[j])
				return false;
		}
		return true;
	}
	
	public static boolean isReverse(String str1, String str2)
	{
		if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty())
			return false;

		int size1 = str1.length();
		int size2 = str2.length();
		if (size1 != size2)
			return false;

		for (int i = 0, j = size1 - 1; i < size1; i++, j--)
		{
			if (str1.charAt(i) != str2.charAt(j))
				return false;
		}
		return true;
	}
	
	public static void printSubStringReverse(String str, int start, int end)
	{
		if (str == null || str.isEmpty() || start < 0 || start > str.length() - 1 || end < 1 
				|| end >= str.length() || start >= end)
		{
			System.out.println("Wrong parametr");
			return;
		}
			
		for (int i = end; i >= start; i--)
		{
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}
	
	public static void printStringInColumn(String str)
	{
		if (str == null || str.isEmpty())
			return;

		for (int i = 0; i < str.length(); i++)
		{
			System.out.println(str.charAt(i));
		}
	}
	
	public static int countChar(String str, char c)
	{
		if(str == null || str.isEmpty())
			return 0;
		
		char[] chars = str.toCharArray();
		int count = 0;
		for (int i=0; i<chars.length; i++)
		{
			if (c == chars[i])
				count++;
		}
		return count;

	}
	
	public static String reverse(String str)
	{
		char[] array = str.toCharArray();
		for(int i=0, j=array.length-1; i<j; i++, j--)
		{
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		return new String(array);
	}
	
	public static boolean isReverse2(String str1, String str2)
	{
		if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty())
			return false;

		int size1 = str1.length();
		int size2 = str2.length();
		if (size1 != size2)
			return false;

//		if(str1.equals(reverse(str2)))
//			return true;
//		return false;
//		return str1.equals(reverse(str2)) ? true : false;
		return str1.equals(reverse(str2));
	}
	
	public static void validPassword(String password)
	{
//		1. Length 8 or more symbols
//	    2. Contains one or more uppercase letter
//	    3. Contains one or more lowercase letter
//	    4. Contains one or more digit
//	    5. Contains one or more special symbols from set ("~","!","-","_")
		boolean[] checked = new boolean[5];

		if (password == null || password.isBlank())
		{
			System.out.println("password is null or empty");
			return;
		}
		if (password.length() >= 8)
		{
			checked[0] = true;
		}
		
//		if(password.length() < 8)
//		{
//			System.out.println("Wrong length");
//			return;
//		}
		
		for (int i = 0; i < password.length(); i++)
		{
			char ch = password.charAt(i);
			if (Character.isUpperCase(ch))
				checked[1] = true;
			else if (Character.isLowerCase(ch))
				checked[2] = true;
			else if (Character.isDigit(ch))
				checked[3] = true;
			else if (ch == '~' || ch == '-' || ch == '_' || ch == '!')
				checked[4] = true;
		}
		
		boolean isValid = true;
		if (!checked[0])
		{
			System.out.println(password + " Wrong length!");
			isValid = false;
		}
		if (!checked[1])
		{
			System.out.println(password + " Wrong uppercase");
			isValid = false;
		}
		if (!checked[2])
		{
			System.out.println(password + " Wrong lowercase");
			isValid = false;
		}
		if (!checked[3])
		{
			System.out.println(password + " Wrong digit");
			isValid = false;
		}
		if (!checked[4])
		{
			System.out.println(password + " Wrong spec symbol");
			isValid = false;
		}
		if (isValid)
			System.out.println(password + " Password is valid");

	}
}