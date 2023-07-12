package telran.employees.items;

import java.io.Closeable;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class CloseAndExitItem extends EmplyeesItem {

	public CloseAndExitItem(InputOutput inOut, IEmployees empl) {
		super(inOut, empl);
	}

	@Override
	public String displayedName() {
		return "Close/Exit";
	}

	@Override
	public void perform() {
		try {
			((Closeable)empl).close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}
