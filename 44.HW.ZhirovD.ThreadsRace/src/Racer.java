import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Racer implements Runnable {
	private static final int MIN_SLEEP_TIME = 2;
	private static final int MAX_SLEEP_TIME = 5;
	
	private int sleepTime;
	private AtomicInteger winner;

	private int threadsNumber;
	private int nRuns;

	public Racer(int threadsNumber, int nRuns, AtomicInteger winner) {
		super();
		this.threadsNumber = threadsNumber;
		this.nRuns = nRuns;
		this.winner = winner;
	}

	@Override
	public void run() {
		for (int i = 0; i < nRuns; i++) {
			System.out.println("Thread " + threadsNumber + ": iteration " + (i + 1));

			try {
				sleepTime = getRandomNumber();
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(winner.compareAndSet(-1, threadsNumber)) {
			return;
		}

	}

	private int getRandomNumber() {
		return new Random().nextInt(MAX_SLEEP_TIME - MIN_SLEEP_TIME + 1) + MIN_SLEEP_TIME;
	}
}
