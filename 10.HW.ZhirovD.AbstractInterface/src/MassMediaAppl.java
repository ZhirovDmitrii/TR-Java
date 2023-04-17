
public class MassMediaAppl {

	public static void main(String[] args) {
		MassMedia[] massMediaArray = { 
				new Newspaper("Newspaper1", 1, 10, 1000000),
				new Newspaper("Newspaper2", 2, 12, 2000000), new Journal("Journal1", 1, 30, 3000000, false),
				new Journal("Journal2", 2, 24, 4000000, true), new NewsPortal("newsportal1.co.il", "http://", 5000000),
				new NewsPortal("newsportal2.co.il", "https://", 6000000),
				new WebSite("website1.co.il", "http://", "Dmitrii Zhirov", 7_291_000),
				new WebSite("website1.com", "http://", "Dmitrii Zhirov", 8_291_000),
				new WebSite("website1.org", "http://", "Dmitrii Zhirov", 9_291_000),
				new WebSite("website1.ru", "http://", "Dmitrii Zhirov", 10_291_000) };

		for (int i = 0; i < massMediaArray.length; i++) {
			System.out.println(massMediaArray[i].getName() + " - rating: " + massMediaArray[i].getRating());
		}
		System.out.println();

		// A
		displayPrintable(massMediaArray);
		System.out.println();

		// B
		IPrintable[] printable = getPrintableElements(massMediaArray);
		for (int i = 0; i < printable.length; i++) {
			printable[i].print();
		}
		System.out.println();

		// C
		displayMassMediaRatingMoreThen(massMediaArray, 5);

	}

	// A
	private static void displayPrintable(MassMedia[] ar) {
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] instanceof IPrintable)
				((IPrintable) ar[i]).print();
		}
	}

	// B
	private static IPrintable[] getPrintableElements(MassMedia[] ar) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] instanceof IPrintable)
				count++;
		}

		IPrintable[] res = new IPrintable[count];
		
		count = 0;
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] instanceof IPrintable) {
				res[count] = (IPrintable) ar[i];
				count++;
			}
		}
		
		return res;
	}

	// C
	public static void displayMassMediaRatingMoreThen(MassMedia[] ar, int thresholdRating) {
		for (int i = 0; i < ar.length; i++) {
			if (ar[i].getRating() > thresholdRating)
				System.out.println(ar[i].getName() + " - rating: " + ar[i].getRating());
		}
	}
}