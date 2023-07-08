
import telran.view.ConsoleInputOutput;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

public class CalculatorTestAppl {
	static InputOutput inOutput;
	static CalculatorClient calcClient;
	
	public static void main(String[] args) throws Exception {
		inOutput = new ConsoleInputOutput();
		calcClient = new CalculatorClient("localhost", 2000);
		Item[] items = {
			new CalculatorItem(inOutput, calcClient),
			new CloseExitItem(inOutput, calcClient)
		};
		
		Menu menu = new Menu(items, inOutput);
		menu.runMenu();
	}

}
