package telran.employees;

import telran.employees.items.CloseAndExitItem;
import telran.employees.items.FireEmployerItem;
import telran.employees.items.GetAvgSalariesItem;
import telran.employees.items.GetCompaniesAvgSalaryItem;
import telran.employees.items.GetCompaniesGreaterAvgSalaryItem;
import telran.employees.items.GetEmployeesDataBySalaryItem;
import telran.employees.items.GetEmployerDataItem;
import telran.employees.items.HireEmployerItem;
import telran.employees.service.EmployeesTcpProxy;
import telran.employees.service.IEmployees;
import telran.view.ConsoleInputOutput;
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
		Item[] items = { new HireEmployerItem(inOut, service), 
				new FireEmployerItem(inOut, service), 
				new GetEmployerDataItem(inOut, service),
				new GetEmployeesDataBySalaryItem(inOut, service),
				new GetCompaniesAvgSalaryItem(inOut, service),
				new GetCompaniesGreaterAvgSalaryItem(inOut, service),
				new GetAvgSalariesItem(inOut, service),
				new CloseAndExitItem(inOut, service) };

		Menu menu = new Menu(items, inOut);
		menu.runMenu();
	}
}
