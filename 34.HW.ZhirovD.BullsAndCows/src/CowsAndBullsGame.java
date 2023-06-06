import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CowsAndBullsGame {
	private static final String FILE_NAME_PATTERN = "yyyy-MM-dd_HH_mm";
	static private Integer bullsCows[] = {0,0};	// {bulls, cows}
	static private List<Move> moves = new ArrayList<>();
	static private int count = 0;
	static private CowsAndBulls game;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		while(startGame()) {
			
		}
	}

	private static boolean startGame() throws IOException {
		game = new CowsAndBulls();
		game.getRandomNumber();
		count = 0;
		moves.clear();
		
		runGame();
		
		System.out.println("Do you want to start new game? Y/N");
		String responce = reader.readLine();
		return responce.equalsIgnoreCase("Y");
	}

	private static void runGame() throws IOException {
		while(true) {
			System.out.println("Enter guess number (4 unrepeated digits) from 1 to 9");
			String line = reader.readLine();
			count++;
			bullsCows = game.gameStatistic(line);
			
			Move move = new Move(bullsCows, line);
			moves.add(move);
			moves.forEach(System.out::println);
			
			if(bullsCows[0] == 4) {
				finishGame();
				return;
			}
		}
		
	}

	private static void finishGame() throws IOException {
		System.out.println("You WIN!!! \nNumber of attempts: " + count + "\nMoves: " + moves);
		String fileName = null;
		try {
			fileName = getGameFileName();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try (PrintWriter writer = new PrintWriter(fileName)){
			moves.forEach(writer::println);
			System.out.println("Game result are saved to the file " + fileName);
		} catch (Exception e) {
			System.out.println("File with game history can't be created " + e.getMessage());
		}
	}

	private static String getGameFileName() throws IOException {
		System.out.println("Enter path to save file or Enter to save the file in current directory");
		String path = reader.readLine();
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(FILE_NAME_PATTERN);
		
		String fileName = ldt.format(dtf) + "_" + count;
		
		return path.isBlank() ? fileName : path + File.separator + fileName;
	}
	
}
