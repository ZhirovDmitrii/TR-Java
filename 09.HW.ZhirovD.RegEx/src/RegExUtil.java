import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUtil {
	private static final String DELIMETER = ";";

	public static String[] regexPatternMatchStream(String regexp, String string)
	{
		Matcher matcher = Pattern.compile(regexp).matcher(string);
		
		StringBuilder res = new StringBuilder();
        
        while (matcher.find()) {
            res.append(matcher.group()).append(DELIMETER);
        }
        return res.toString().split(DELIMETER);
	}
}
