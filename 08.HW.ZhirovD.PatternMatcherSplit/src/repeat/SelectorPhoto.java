package repeat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectorPhoto {

	public static String[] selectPictures(String[] pictures, String regex) {
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile(regex);
		
		for(int i = 0; i < pictures.length; i++) {
			Matcher matcher = pattern.matcher(pictures[i]);
			while(matcher.find()) {
				sb.append(pictures[i] + ", ");
			}
		}
		return sb.toString().split(",\\s");
	}

}
