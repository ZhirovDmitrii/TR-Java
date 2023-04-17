package finalModifier;

public class FinalAppl {
	final int y = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unused")
		final int x = 10;
//		x = 20;

		Worker w = new Worker();
		w.work();
//		WhiteWorker ww = new WhiteWorker();
//		ww.work();
	}

}