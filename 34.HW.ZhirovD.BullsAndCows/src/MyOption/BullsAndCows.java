package MyOption;

import java.util.ArrayList;
import java.util.List;

public class BullsAndCows {
	private static final int NUMBER_LENGTH = 4;
	private static final int MAX_NUMBER = 9;
	
	public int[] generatedNumber;
	private List<String> moves;
	
	// Constructor
	public BullsAndCows() {
		// TASK 1
		generatedNumber = Utils.generateNumber(MAX_NUMBER, NUMBER_LENGTH);	
		moves = new ArrayList<>();	// create list for saving our moves
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		BullsAndCows game = new BullsAndCows();
		PlayToGame playGame = new PlayToGame();
		playGame.play(NUMBER_LENGTH, game.generatedNumber, game.moves);
	}
}