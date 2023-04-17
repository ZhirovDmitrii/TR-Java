package stringPack;

public class MyStringAppl {

	public static void main(String[] args) {
		MyString myStr = new MyString("Two beer, or not only two beer");

		for (Character c : myStr) {
			System.out.print(c);
		}

//		for(Character c: myStr) {
//			if(c=='o')
//				myStr.remove(c);
//		}
//	}

		MyStringIterator iter = (MyStringIterator) myStr.iterator();
		while(iter.hasNext()) {
			if(iter.next() == 'o')
				iter.remove();
		}
		System.out.println();
		
		for (Character c : myStr) {
			System.out.print(c);
		}
	
	}
}