import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.*;

public class PlayToGame {
	private static String fileName;
	
	public static void play(int numberLength, int[] generateNumber, List<String> list) {
		Reader reader = new InputStreamReader(System.in); // for read from console
		Writer writer = new PrintWriter(System.out); // for writing

		boolean endGame = false;
		int count = 0;

		try (BufferedReader bReader = new BufferedReader(reader); 
				PrintWriter pWriter = new PrintWriter(writer)) {

			while (!endGame) {
				String guessNumber = bReader.readLine(); // read number from console

				// TASK 6
				if (guessNumber.length() != numberLength || 
						guessNumber.contains("0") || 
						!guessNumber.matches("[1-9]+"))
					continue;

				// parse String to integer
				int[] parseGuessNumber = Utils.parseNumber(numberLength, guessNumber);

				// Checking the guess number with the generate number
				int bulls = 0, cows = 0;
				for (int i = 0; i < numberLength; i++) {
					if (parseGuessNumber[i] == generateNumber[i]) {
						bulls++;
					} else if (Utils.containsDigitsInNumber(parseGuessNumber[i], generateNumber)) {
						cows++;
					}
				}
			
				count++;

				// Print information about the game
				// TASK 3
				list.add(guessNumber + " (" + cows + " cows, " + bulls + " bulls)");
				// TASK 5
				Utils.displayMoves(pWriter, list);

				// VICTORY
				// TASK 4
				if (bulls == numberLength) {
					pWriter.println("You Win!!!\n");
					pWriter.flush();				
					endGame = true;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TASK 7
		Utils.saveGameInformation(list, count);
	}
}
