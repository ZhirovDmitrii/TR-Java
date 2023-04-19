package repeat;

import java.util.Iterator;

public class Range implements Iterable<Integer>{
	int min;
	int max;
	
	public Range(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new MyRangeIterator(min, max);
	}	
}
