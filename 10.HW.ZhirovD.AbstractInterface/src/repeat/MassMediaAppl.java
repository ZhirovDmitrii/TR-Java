package repeat;

public class MassMediaAppl {
	public static void main(String[] args) {
		MassMedia[] massMediaArray = { 
				new Newspaper("Newspaper1", 1, 10, 1000000),
				new Newspaper("Newspaper2", 2, 12, 2000000), new Journal("Journal1", 1, 30, 3000000, false),
				new Journal("Journal2", 2, 24, 4000000, true), new NewsPortal("newsportal1.co.il", "http://", 5000000),
				new NewsPortal("newsportal2.co.il", "https://", 6000000),
				new WebSite("website1.co.il", "http://", 7_291_000, "Dmitrii Zhirov"),
				new WebSite("website1.com", "http://", 8_291_000, "Dmitrii Zhirov"),
				new WebSite("website1.org", "http://", 9_291_000, "Dmitrii Zhirov"),
				new WebSite("website1.ru", "http://", 10_291_000, "Dmitrii Zhirov") };
		
		// A
		displayPrintable(massMediaArray);
		System.out.println();
		
		//B
		IPrintable[] printable = getPrintableElements(massMediaArray);
		for (int i = 0; i < printable.length; i++)
			printable[i].print();
		System.out.println();
		
		// C
		displayMassMediaMoreTher(massMediaArray, 5);
	}
	
	private static void displayPrintable(MassMedia[] ar) {
		for(int i = 0; i < ar.length; i++) {
			if(ar[i] instanceof IPrintable)
				((IPrintable)ar[i]).print();
		}
	}
	
	private static IPrintable[] getPrintableElements(MassMedia[] ar) {
		int count = 0;
		
		for(int i = 0; i < ar.length; i++)
			if(ar[i] instanceof IPrintable)
				count++;
		
		IPrintable[] arr = new IPrintable[count];
		count = 0;
		for(int i = 0; i < ar.length; i++)
			if(ar[i] instanceof IPrintable) {
				arr[count] = (IPrintable)ar[i];
				count++;
			}
		
		return arr;
	}
	
	
	private static void displayMassMediaMoreTher(MassMedia[] ar, int theresholdRating) {
		for(int i = 0; i < ar.length; i++) {
			if(ar[i].getRating() >= theresholdRating)
				System.out.println(ar[i].getName() +  "	Rating: " + ar[i].getRating());
		}
	}
}
