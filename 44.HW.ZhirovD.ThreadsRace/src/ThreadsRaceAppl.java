import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadsRaceAppl {

	public static void main(String[] args) {	
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			
//			===== USER ENTER =====
			System.out.println("Enter number of iterations: ");
			int nRuns = Integer.parseInt(reader.readLine());
			
			System.out.println("Enter number of threads: ");
			int threadsNumber = Integer.parseInt(reader.readLine());
			
//			===== CREATE RACERS AND THREADS =====
			Racer[] racers = new Racer[threadsNumber];
			Thread[] threads = new Thread[threadsNumber];
			AtomicInteger winner = new AtomicInteger(-1);
			
			for(int i = 0; i < threadsNumber; i++) {
				racers[i] = new Racer(i + 1, nRuns, winner);
				threads[i] = new Thread(racers[i]);
				threads[i].start();
			}
			
//			===== WAIT FOR ALL THREADS FINISH =====
			for (Thread t: threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
			
			int winnerThread = winner.get();
			System.out.println("Thread #" + winnerThread + " is winner! \nGame Over");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
