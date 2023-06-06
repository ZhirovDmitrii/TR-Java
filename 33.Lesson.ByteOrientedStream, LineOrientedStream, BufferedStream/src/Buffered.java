import java.io.*;

public class Buffered {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader, 10_000);
		
		//good code
//		while(true) {
//			System.out.println("Enter numbers separated by space or exit");
//			String line = in.readLine();
//			
//			if(line.equalsIgnoreCase("exit"))
//				break;
//			if(line.isBlank()) {
//				System.out.println("Wrong data");
//				continue;
//			}
//			
//			String[] numbers = line.trim().split("\\D+");
//			System.out.println("Sum = " + Arrays.stream(numbers)
//			.filter(s -> !s.isEmpty())
//			.mapToInt(Integer::parseInt)
//			.sum());
//		}
		
		Writer writer = new FileWriter("res.txt");
		BufferedWriter out = new BufferedWriter(writer);
		
		out.write("Hello world and goodbye");	// text in buffer, file is empty now
		out.flush();	// opt 1 - and text in file
//		out.close();	// opt 2 - after close() text in file (before - in buffer)
		
	}

}
