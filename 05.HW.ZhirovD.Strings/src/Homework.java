
public class Homework {

	public static void main(String[] args) {
		// Task 1
		System.out.println("Task 1.");
		System.out.println(Utils.isPalindrome("madaM"));
		System.out.println(Utils.isPalindrome("mister"));
		System.out.println();

		// Task 2
		System.out.println("Task 2.");
		System.out.println(Utils.isReverse("Dima", "Amid"));
		System.out.println(Utils.isReverse("Dima", "Mida"));
		System.out.println();

		// Task 3
		System.out.println("Task 3.");
		Utils.printSubStringReverse("stop", 0, 4);
		System.out.println("\n");

		// Task 4
		System.out.println("Task 4.");
		Utils.printStringInColumn("Tel-Ran");
		System.out.println();

		// Task 5
		System.out.println("Task 5.");
		System.out.println(Utils.countChar("chance", 'c'));
		System.out.println();

		// Task 6
		System.out.println("Task 6. - Check the JUnit tests class");
	}

	public static void validPassword(String password) {

		if (password != null) {
			if (password.length() < 8) {
				System.out.println("Your password is not correct!");
				return;
			}

			boolean uppSymbolCheck = false;
			boolean lowSymbolCheck = false;
			boolean digitSymbolCheck = false;
			boolean specialSymbolCheck = false;
			boolean flag = true;

			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)))
					uppSymbolCheck = true;
				else if (Character.isLowerCase(password.charAt(i)))
					lowSymbolCheck = true;
				else if (Character.isDigit(password.charAt(i)))
					digitSymbolCheck = true;
				else if (password.charAt(i) == '~' || password.charAt(i) == '!' || password.charAt(i) == '-'
						|| password.charAt(i) == '_')
					specialSymbolCheck = true;
				else {
					flag = false;
					break;
				}
			}
			
			if (uppSymbolCheck && lowSymbolCheck && digitSymbolCheck && specialSymbolCheck && flag)
				System.out.println("Your password is correct!");
			else
				System.out.println("Your password is not correct!");
		}
	}
}