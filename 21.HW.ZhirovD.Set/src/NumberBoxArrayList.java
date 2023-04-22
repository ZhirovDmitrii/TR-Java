
import java.util.*;
import java.util.function.Predicate;

public class NumberBoxArrayList extends AbstractSuperClass {
	public NumberBoxArrayList() {
		collection = new ArrayList<>();
	}

	@Override
	public void removeRepeated() {
		HashSet<Integer> helper = new HashSet<>();

		collection.removeIf(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return !helper.add(t);
			}
		});
	}
}