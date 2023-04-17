package repeat;

public class HomeworkAppl {

	// 1
	public static boolean isPalindrome(String str) {
		String res = "";
		for (int i = str.length() - 1; i >= 0; i--)
			res += str.charAt(i);
		return str.equalsIgnoreCase(res);
	}

	// 2
	public static boolean isReverse(String str1, String str2) {
		String res = "";
		for(int i = str2.length() - 1; i >= 0; i--)
			res += str2.charAt(i);
		return str1.equals(res);
	}

	// 3
	public static void printSubStringReverse(String str, int start, int end) {
		char[] c = str.toCharArray();
		String res = "";
		for(int i = end; i >= start; i--) {
			res += c[i];
		}
		System.out.println(res);
	}

	// 4
	public static void ptintStringInColumn(String str) {
		for(int i = 0; i < str.length(); i++)
			System.out.println(str.charAt(i));
	}

	// 5
	public static int countChar(String str, char c) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c)
				count++;
		}
		return count;
	}
	
	// 6
	public static void validPassword(String password) {
		if(password == null || password.isBlank() || password.isEmpty()) {
			System.out.println("WTF?");
			return;
		}
		
		if(password.length() <  8) {
			System.out.println(password + " - is not valid!");
			return;
		}
		
		boolean upperCase = false;
		boolean lowerCase = false;
		boolean isDigit = false;
		boolean specSymb = false;
		boolean flag = false;
		
		char[] c = password.toCharArray();
		
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(c[i])) {
				upperCase = true;
			}
			else if(Character.isLowerCase(c[i])) {
				lowerCase = true;
			}
			else if(Character.isDigit(c[i])) {
				isDigit = true;
			}
			else if(c[i] == '~' || c[i] == '!' || c[i] == '-' || c[i] == '_') {
				specSymb = true;
			}
		}
		
		if(upperCase && lowerCase && isDigit && specSymb)
			flag = true;
		
		if(flag)
			System.out.println(password + " - is valid!");
		else {
			System.out.println(password + " - is not valid");
			return;
		}
		
	}

}
