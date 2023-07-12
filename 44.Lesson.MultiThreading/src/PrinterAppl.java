
public class PrinterAppl {
	private static final int N_PRINTS = 100;

	public static void main(String[] args) {
		Printer p1 = new Printer('a', N_PRINTS);
		Printer p2 = new Printer('o', N_PRINTS);
		
		// 1 thread
//		p1.run();
//		p2.run();
		
		p1.start();
		p2.start();
	}

}
