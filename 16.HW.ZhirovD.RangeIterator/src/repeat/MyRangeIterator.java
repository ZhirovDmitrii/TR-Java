package repeat;

import java.util.Iterator;

public class MyRangeIterator implements Iterator<Integer>{
	private int min;
	private int max;

	public MyRangeIterator(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean hasNext() {
		return min < max;
	}

	@Override
	public Integer next() {
		return min++;
	}
	
	
}
