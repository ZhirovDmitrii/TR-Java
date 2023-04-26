package repeat;

import java.util.TreeSet;

public class NumberBoxTreeSet extends AbstractSetClass{
	public NumberBoxTreeSet() {
		collection = new TreeSet<>();
	}
	
	@Override
	public void removeInRange(int min, int max) {
		if(min > max) {
			int[] res = swap(min,max);
			min = res[0];
			max = res[1];
		}
		((TreeSet<Integer>)collection).subSet(min, max).clear();
	}

	private int[] swap(int min, int max) {
		return new int[] {max,min};
	}
}
