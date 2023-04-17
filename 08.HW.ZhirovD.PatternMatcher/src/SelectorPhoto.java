import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectorPhoto {
	
	public static String[] selectPictures(String[] pictures, String regex) {
		// Exceptions
		if (pictures == null || pictures.length == 0)
			return null;

		String res = new String();
		Pattern pattern = Pattern.compile(regex);

		for (int i = 0; i < pictures.length; i++) {
			Matcher matcher = pattern.matcher(pictures[i]);
			if (matcher.find())
				res += pictures[i] + ", ";
		}
//		System.out.println(res + "\n");
		return res.split(",\\s");
	}
}
