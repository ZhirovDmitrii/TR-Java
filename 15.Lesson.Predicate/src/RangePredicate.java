import java.util.function.Predicate;

public class RangePredicate implements Predicate<Integer>{
	int min;		// or Integer
	Integer max;	// or int
	
	public RangePredicate(int min, Integer max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean test(Integer t) {
		return t >= min && t <= max;
	}

}
