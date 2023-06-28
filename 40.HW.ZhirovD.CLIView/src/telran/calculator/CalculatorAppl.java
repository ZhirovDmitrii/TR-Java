package telran.calculator;

import telran.view.*;

public class CalculatorAppl {

	public static void main(String[] args) {
		String format = "dd.MM.yyyy";
		InputOutput inOut = new ConsoleInputOutput();
		Item[] items = {
				new CalculatorItem(inOut),
				new DateAfterBeforeItem(inOut, format),
				new DaysBetweenItem(inOut, format),
				new ExitItem()
		};
		
		
		Menu menu = new Menu(items, inOut);
		menu.runMenu();
	}

}
