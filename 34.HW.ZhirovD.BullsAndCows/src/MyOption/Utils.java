package MyOption;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

	/// Create random numbers needed length from 1 to 9
	public static int[] generateNumber(int maxNumber, int numberLength) {
		// create array from 1 to 9 and add in our list
		List<Integer> digits = new ArrayList<>();
		for (int i = 1; i <= maxNumber; i++) {
			digits.add(i);
		}
		Collections.shuffle(digits); // shuffle our digits

		// create array with needed length and add shuffled digits to array
		int[] randomNumber = new int[numberLength];
		for (int i = 0; i < numberLength; i++) {
			randomNumber[i] = digits.get(i); // add shuffled digits to array
		}
		return randomNumber;
	}

	/// Parse String to Integer
	public static int[] parseNumber(int numberLength, String number) {
		int[] res = new int[numberLength];
		for (int i = 0; i < numberLength; i++) {
			res[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
		}

		return res;
	}

	/// Check contains digit in array
	public static boolean containsDigitsInNumber(int i, int[] generateNumber) {
		for (int n : generateNumber) {
			if (n == i)
				return true;
		}
		return false;
	}

	/// Print game information
	@SuppressWarnings("unused")
	public static void displayMoves(PrintWriter pWriter, List<String> list) {
		for (String l : list) {
			pWriter.print(list);
		}
		pWriter.println();
		pWriter.flush();

		list.clear();
	}

	/// Saving game information after won
	@SuppressWarnings("unused")
	public static void saveGameInformation(List<String> list, int count) {
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm_ss");
		LocalDateTime ldt = LocalDateTime.now();
		String format = ldt.format(dt);
		String fileName = format + "_" + count;
		
		try(PrintWriter writer = new PrintWriter(fileName)){
			for(String l: list) {
				writer.println(list);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}