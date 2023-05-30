import java.io.*;
import java.util.Arrays;

public class Buffered {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader, 10_000);
		
		while(true) {
			System.out.println("Enter numbers separated by space or exit");
			String line = in.readLine();
			
			if(line.equalsIgnoreCase("exit"))
				break;
			if(line.isBlank()) {
				System.out.println("Wrong data");
				continue;
			}
			
			String[] numbers = line.trim().split("\\D+");
			System.out.println("Sum = " + Arrays.stream(numbers)
			.filter(s -> !s.isEmpty())
			.mapToInt(Integer::parseInt)
			.sum());
		}

		
	}

}
