
public class EmailValidation {

	public static boolean isEmailValid(String email) {
		if (email == null || email.isBlank())
			return false;

		int index = email.indexOf('@');
		if (index < 1 || index != email.lastIndexOf('@'))// .jh@k.co.com //4 length = 8
		{
			return false;
		}
		if (email.indexOf('.', index) == -1 || email.indexOf('.', index) == index + 1) {
			return false;
		}
		if (email.lastIndexOf('.') > email.length() - 3) {
			return false;
		}
		if (email.indexOf(".") == 0)
			return false;

		for (int i = 0; i < email.length(); i++) {
			char c = email.charAt(i);
			if (!(c == '@' || c == '_' || c == '.' || c == '-' || Character.isDigit(c) || Character.isAlphabetic(c)))
				return false;
		}
		return true;
	}

}