
public class CountSubInStringCount {
	public static void main(String[] args) {

	}

	// my option
	public static int countSubString1(String str, String subStr) {
		int count = 0;
		int fromIndex = 0;

		while ((fromIndex = str.indexOf(subStr, fromIndex)) != -1) {
			count++;
			fromIndex++;
		}

		return count;
	}

	// teachers option 1
	public static int countSubString2(String str, String subStr) // helhelhel hel
	{
		if (str == null || subStr == null || str.isEmpty() || subStr.isEmpty() || str.length() < subStr.length())
			return 0;

		int count = 0;
		int indx = 0;
		indx = str.indexOf(subStr, indx);
		while (indx >= 0) {
			count++;
			indx = str.indexOf(subStr, indx + subStr.length());
		}
		return count;
	}

	// teacher option 2
	public static int countSubString3(String str, String subStr) {
		if (str == null || subStr == null || str.isBlank() || subStr.isBlank() || str.length() < subStr.length())
			return 0;

		String tmp = str.replace(subStr, "");
		return (str.length() - tmp.length()) / subStr.length();// o -> hell len 9
	}

}