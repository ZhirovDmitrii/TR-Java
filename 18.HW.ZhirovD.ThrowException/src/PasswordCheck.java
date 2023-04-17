
public class PasswordCheck {

	public static final String WRONG_LENGTH_MESSAGE = "Wrong length!";
	public static final String NO_SPEC_SYMBOL_MESSAGE = "No speial symbol!";
	public static final String NO_DIGIT_MESSAGE = "No digit!";
	public static final String NO_UPPER_CASE_MESSAGE = "No upper case!";
	public static final String NO_LOWER_CASE_MESSAGE = "No lower case!";
	public static final String WRONG_SYMBOL_MESSAGE = "Wrong symbol!";
	static final String[] MESSAGES = { NO_UPPER_CASE_MESSAGE, NO_LOWER_CASE_MESSAGE, NO_DIGIT_MESSAGE,
			NO_SPEC_SYMBOL_MESSAGE };

	static final int UPPER_CASE_INDEX = 0;
	static final int LOWER_CASE_INDEX = 1;
	static final int DIGIT_INDEX = 2;
	static final int SPEC_SYMB_INDEX = 3;
	private static final int N_FLAGS = 4;
	static boolean[] flags;

	public static void check(String password) throws IllegalPasswordException {

		flags = new boolean[N_FLAGS]; // 4

		// check null
		if (password == null)
			throw new IllegalArgumentException("null");
		// check length
		if (password.length() < 8)
			throw new IllegalPasswordException(new String[] { WRONG_LENGTH_MESSAGE });

		// check digit, special symbol, upper and lower cases
		for (char c : password.toCharArray()) {
			if(Character.isWhitespace(c))
				throw new IllegalPasswordException(new String[] {WRONG_SYMBOL_MESSAGE});
			
			if(Character.isUpperCase(c))
				flags[UPPER_CASE_INDEX] = true;
			else if(Character.isLowerCase(c))
				flags[LOWER_CASE_INDEX] = true;
			else if(Character.isDigit(c))
				flags[DIGIT_INDEX] = true;
			else
				flags[SPEC_SYMB_INDEX] = true;
		}
		
		int countErrors = getCountErrors();
		if(countErrors != 0)
			throw new IllegalPasswordException(getMessages(countErrors));
	}

	private static String[] getMessages(int countErrors) {
		String[] res = new String[countErrors];
		int ind = 0;
		for(int i = 0; i < flags.length; i++) {
			if(!flags[i])
				res[ind++] = MESSAGES[i];
		}
		return res;
	}

	private static int getCountErrors() {
		int count = 0;
		for(boolean flag: flags) {
			if(!flag)	// false
				count++;
		}
		return count;
	}
}