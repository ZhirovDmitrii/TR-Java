package telran.calculator;

import telran.view.*;

public class CalculatorAppl {

	public static void main(String[] args) {
		InputOutput inOut = new ConsoleInputOutput();
		Item[] items = {
				new CalculatorItem(inOut),
				new ExitItem()
		};
		
		
		Menu menu = new Menu(items, inOut);
		menu.runMenu();
	}

}
