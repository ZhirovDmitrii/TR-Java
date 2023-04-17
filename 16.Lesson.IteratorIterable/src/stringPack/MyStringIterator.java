package stringPack;

import java.util.Iterator;

public class MyStringIterator implements Iterator<Character> {

	private StringBuilder str;
	private int size;
	private int current;
	
	public MyStringIterator(StringBuilder str) {
		this.str = str;
		size = str.length();
		current = 0;
	}

	@Override
	public boolean hasNext() {
		return current < size;
	}

	@Override
	public Character next() {
//		Character current = str.charAt(current);
//		current++;
//		return current;
		return str.charAt(current++);
	}
	
	@Override
	public void remove() {
		str.deleteCharAt(--current);
		size--;
	}

}