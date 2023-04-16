import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherAppl {
	public static void main(String[] args) {
		String str = "Dont`t Trouble trouble untill troublE troubles you";
		String regex = "[Tt]rouble\\w*";
		System.out.println(str.matches(regex));	// false

		Pattern pattern = Pattern.compile(regex);
		System.out.println(pattern.flags());	// 0
		System.out.println(pattern.pattern());	//[Tt]rouble\w*

		pattern = Pattern.compile("trouble\\w*", Pattern.CASE_INSENSITIVE);	// off case
		System.out.println(pattern.flags());	// 2
		System.out.println(pattern.pattern());	// trouble\w*

		Matcher matcher = pattern.matcher(str);

//		find methods
		System.out.println(matcher.matches());		// false - check full compliance
		System.out.println(matcher.lookingAt());	// false - check string start with a word
		System.out.println(matcher.find());			// true - check if a word is in the text
		System.out.println(matcher.find(10));		// true - ... start from 10 index

//		index methods
		System.out.println(matcher.start());	// return start index
		System.out.println(matcher.end());		// return end index

		System.out.println("**************");
		matcher.reset();						// reset all checker on start
		while (matcher.find()) {
			System.out.println(matcher.start());
			System.out.println(matcher.end());
			System.out.println(matcher.group());	// return word
		}

		System.out.println("**************");
		matcher.reset("All my troubles seemd so far away");
		while (matcher.find()) {
			System.out.println(matcher.start());
			System.out.println(matcher.end());
			System.out.println(matcher.group());
		}
	}
}