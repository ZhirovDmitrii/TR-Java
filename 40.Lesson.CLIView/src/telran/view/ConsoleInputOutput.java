package telran.view;

import java.util.Scanner;

public class ConsoleInputOutput implements InputOutput{

	Scanner scanner = new Scanner(System.in); // read from console
	
	@Override
	public String inputString(String prompt) {
		outputLine(prompt + " or 'cancel' for exit.");
		
		String text = scanner.nextLine();	// for read from console
		
		return text.equalsIgnoreCase("cansel") ? null : text;
	}

	@Override
	public void output(Object obj) {
		System.out.println(obj);
	}

}
