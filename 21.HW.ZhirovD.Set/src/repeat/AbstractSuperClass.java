package repeat;

import java.util.Collection;
import java.util.function.Predicate;

public abstract class AbstractSuperClass implements INumberBox {
	Collection<Integer> collection;

	@Override
	public void addNumber(int number) {
		collection.add(number);
	}

	@Override
	public void removeNumber(int number) {
		collection.remove((Integer)number);

	}

	@Override
	public boolean containsNumber(int number) {
		return collection.contains(number);
	}

	@Override
	public void removeDividedBy(int number) {
		collection.removeIf(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t % number == 0;
			}
		});
	}

	@Override
	public int size() {
		return collection.size();
	}

	@Override
	public void removeInRange(int fromInclusive, int toExclusive) {
		collection.removeIf(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t >= fromInclusive && t < toExclusive;
			}
		});
	}

}
