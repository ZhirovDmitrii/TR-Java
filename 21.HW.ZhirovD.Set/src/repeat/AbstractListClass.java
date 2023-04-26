package repeat;

import java.util.HashSet;
import java.util.function.Predicate;

public class AbstractListClass extends AbstractSuperClass{

	@Override
	public void removeRepeated() {
		HashSet<Integer> res = new HashSet<>();
		
		collection.removeIf(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return !res.add(t);
			}
		});
	}

}
