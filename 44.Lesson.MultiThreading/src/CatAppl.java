
public class CatAppl {

	private static final int N_PRINTS = 5;

	public static void main(String[] args) {
		Cat c1 = new Cat("Snow", 'm', N_PRINTS);
		Cat c2 = new Cat("Bogdana", 'f', N_PRINTS);
		Cat c3 = new Cat("Boss", 'm', N_PRINTS);
		Cat c4 = new Cat("White", 'f', N_PRINTS);

		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);
		Thread t4 = new Thread(c4);

		Thread[] cats = { t1, t2, t3, t4 };
		for(Thread t: cats)
			t.start();
	}

}
