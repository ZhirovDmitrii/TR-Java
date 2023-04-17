package repeat;

public class HomeworkAppl {

	// 1
	public static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str).reverse();
		return str.equalsIgnoreCase(sb.toString());
	}

	// 2
	public static boolean isReverse(String str1, String str2) {
		StringBuilder sb = new StringBuilder(str2).reverse();
		return str1.equals(sb.toString());
	}

	// 3
	public static void printSubStringReverse(String str, int start, int end) {
		StringBuilder sb = new StringBuilder(str);
		System.out.println(sb.reverse().substring(start, end));
	}
	
	// 4
	public static int countSubString(String str, String subStr) {
		return str.split(subStr, -1).length - 1;
	}
	
	// 5
	public static boolean isEmailValid(String email) {
		if(email.isBlank() || email.isEmpty() || email == null)
			return false;
		
		if(email.length() > 50) {
			System.out.println(email + " - is not valid");
			return false;
		}
		
		boolean atSymbol = false;
		boolean dotSymbol = false;
		boolean specSymbol = false;
		boolean flag = false;

		for(int i = 0; i < email.length(); i++) {
			if(email.charAt(i) == '@' && email.indexOf('@') != 0 && email.lastIndexOf('@') == email.indexOf('@') && email.indexOf('@') != email.length() - 1)
				atSymbol = true;
			else if(email.charAt(i) == '.' && email.indexOf('.') > email.indexOf('@') + 1 && email.indexOf('.') < email.length() - 2)
				dotSymbol = true;
			else if((email.charAt(i) == '-' || email.charAt(i) == '_' || email.charAt(i) == '!') && 
					(email.indexOf('!') < email.indexOf('@') || email.indexOf('-') < email.indexOf('@') || email.indexOf('_') < email.indexOf('@')))
				specSymbol = true;
		}
		
		if(atSymbol && dotSymbol && specSymbol)
			flag = true;
		
		if(flag) {
			System.out.println(email + " - is valid!");
			return true;
		}
		else {
			System.out.println(email + " - is not valid!");
			return false;
		}
	}

}
