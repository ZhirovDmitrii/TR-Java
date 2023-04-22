
import java.util.*;
import java.util.function.Predicate;

public class NumberBoxLinkedList extends AbstractSuperClass {
	public NumberBoxLinkedList() {
		collection = new LinkedList<>();
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