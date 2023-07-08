package telran.employees;

import telran.employees.service.EmployeesTcpProxy;
import telran.employees.service.IEmployees;
import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

public class EmployeesClientAppl {
	private static final String HOST = "localhost";
	private static final int PORT = 3000;
	static InputOutput inOut;
	static IEmployees service;
	
	public static void main(String[] args) throws Exception {
		inOut = new ConsoleInputOutput();
		service = new EmployeesTcpProxy(HOST, PORT);
		Item[] items = {
				
		};
		
		Menu menu = new Menu(items, inOut);
		menu.runMenu();
	}
}
