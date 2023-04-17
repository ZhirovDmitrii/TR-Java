package stringPack;

import java.util.Iterator;

public class MyString implements Iterable<Character>{
	private StringBuilder str;

	public MyString(String str) {
		super();
		this.str = new StringBuilder(str);
	}

	public StringBuilder getStr() {
		return str;
	}

	public void setStr(StringBuilder str) {
		this.str = str;
	}

	public int size() {
		return str.length();
	}

	@Override
	public Iterator<Character> iterator() {
		return new MyStringIterator(str);
	}

	public void remove(Character c) {
		str.deleteCharAt(str.toString().indexOf(c));
		
	}
	
}