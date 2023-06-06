import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CowsAndBulls {
	List<Character> randomNumber = new ArrayList<>(); // for add all moves

	public List<Character> getRandomNumber() {
		return randomNumber;
	}

	// TASK 1, TASK 2
	// Every new game - create new random number
	public CowsAndBulls() {
		new Random().ints(1, 10).distinct().limit(4).mapToObj(n -> (char) n).forEach(randomNumber::add);
		System.out.println(randomNumber);
	}

	public Integer[] gameStatistic(String line) {
		Integer bulls = 0, cows = 0;
		
		char[] guess = line.toCharArray();	// user enter
		int limit = guess.length < 4 ?
				guess.length : 4;
		
		for(int i = 0; i < limit; i++) {
			int ind = randomNumber.indexOf(guess[i]); // get index by user digit
			if(ind >= 0) {
				if(ind == i) {
					bulls++;
				} else {
					cows++;
				}
			}
		}
		
		return new Integer[] {bulls, cows};
	}

}
