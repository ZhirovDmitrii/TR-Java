import java.util.function.Predicate;

public class StringLengthPredicate implements Predicate<String>{

	@Override
	public boolean test(String t) {
		return t.length() >= 3;
 	}
	
}
