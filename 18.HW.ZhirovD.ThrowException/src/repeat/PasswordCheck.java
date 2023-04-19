package repeat;

public class PasswordCheck {
	public static final String WRONG_LENGTH_MESSAGE = "Wrong length!";
	public static final String NO_SPEC_SYMBOL_MESSAGE = "No special symbol!";
	public static final String NO_DIGIT_MESSAGE = "No digit!";
	public static final String NO_UPPER_CASE_MESSAGE = "No upper case!";
	public static final String NO_LOWER_CASE_MESSAGE = "No lower case!";
	public static final String WRONG_SYMBOL_MESSAGE = "Wrong symbol!";

	public static String[] MESSAGES = { NO_UPPER_CASE_MESSAGE, NO_LOWER_CASE_MESSAGE, NO_DIGIT_MESSAGE,
			NO_SPEC_SYMBOL_MESSAGE };

	static final int UPPER_CASE_INDEX = 0;
	static final int LOWER_CASE_INDEX = 1;
	static final int DIGIT_INDEX = 2;
	static final int SPEC_SYMB_INDEX = 3;

	private static final int N_FLAGS = 4; // upper, lower, digit and symbol
	static boolean[] flags;

//	============================================================================

	public static void check(String string) {
		flags = new boolean[N_FLAGS];
		// check null
		if (string == null)
			throw new IllegalArgumentException("null");
		// check length
		if (string.length() < 8)
			throw new IllegalPasswordException(new String[] { WRONG_LENGTH_MESSAGE });

		for (char c : string.toCharArray()) {
			// check whitespace
			if (Character.isWhitespace(c))
				throw new IllegalPasswordException(new String[] { WRONG_SYMBOL_MESSAGE });

			// check digit
			if (Character.isDigit(c))
				flags[DIGIT_INDEX] = true;
			// check upper case
			else if (Character.isUpperCase(c))
				flags[UPPER_CASE_INDEX] = true;
			// check lower case
			else if (Character.isLowerCase(c))
				flags[LOWER_CASE_INDEX] = true;
			// check special symbol
			else
				flags[SPEC_SYMB_INDEX] = true;
		}

		// how many errors
		int countErrors = getCountErrors();
		if (countErrors != 0)
			throw new IllegalPasswordException(getMessages(countErrors));
	}

	// ====== METHODS =====
	private static String[] getMessages(int countErrors) {
		String[] messages = new String[countErrors];
		int index = 0;
		for (int i = 0; i < flags.length; i++) {
			if (!flags[i])
				messages[index++] = MESSAGES[i];
		}
		return messages;
	}

	private static int getCountErrors() {
		int count = 0;
		for (boolean b : flags) {
			if (!b) // false
				count++;
		}
		return count;
	}
}
