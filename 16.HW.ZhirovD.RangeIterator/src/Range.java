import java.util.Iterator;

public class Range implements Iterable<Integer>{
	int min;
	int max;
	
	public Range(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new RangeIterator();
	}
	
	private class RangeIterator implements Iterator<Integer> {
		private int current = min;

		@Override
		public boolean hasNext() {
			return current <= max;
		}

		@Override
		public Integer next() {
			return current++;
		}
		
		
	}
}