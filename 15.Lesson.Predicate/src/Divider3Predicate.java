import java.util.function.Predicate;

public class Divider3Predicate implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		return t % 3 == 0;
	}
	
}