import java.io.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

public class PrintWriterVsPrintStream {

	public static void main(String[] args) {
		testPrintWriter();
		testPrintStream();
	
	}

	private static void testPrintStream() {
		try {
			PrintStream writer = new PrintStream("file");
			LocalTime start = LocalTime.now();
			
			IntStream.range(0, 1_000_000).forEach(i -> writer.println("hello"));
			printResult("PrintStream", start, LocalTime.now());
			writer.close();
			} catch (FileNotFoundException e) {
			}
	}

	private static void testPrintWriter() {
		try {
		PrintWriter writer = new PrintWriter("file");
		LocalTime start = LocalTime.now();
		
		IntStream.range(0, 1_000_000).forEach(i -> writer.println("hello"));
		printResult("PrintWriter", start, LocalTime.now());
		writer.close();
		} catch (FileNotFoundException e) {
		}
	}

	private static void printResult(String string, LocalTime start, LocalTime now) {
		System.out.printf("Runnig time for %s is %d\n", string, ChronoUnit.MILLIS.between(start, now));
	}

}
