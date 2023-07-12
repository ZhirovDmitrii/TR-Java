package telran.employees.items;

import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class EmplyeesItem implements Item {
	protected InputOutput inOut;
	protected IEmployees empl;
	
	protected final int MIN_SALARY = 6000;
	protected final int MAX_SALARY = 60_000;
	
	public EmplyeesItem(InputOutput inOut, IEmployees empl) {
		super();
		this.inOut = inOut;
		this.empl = empl;
	}
	
	Integer getNotExistingId() {
		Integer id = inOut.inputInteger("Enter new unique identifier");
		if(id == null)
			return null;
		
		if(empl.getEmployeeData(id) != null) {
			inOut.outputLine("Employee already exist");
			return null;
		}
		
		return id;
	}
	
	Integer getExistingId() {
		Integer id = inOut.inputInteger("Enter new unique identifier");
		if(id == null)
			return null;
		
		Employee e = empl.getEmployeeData(id);
		if(e == null) {
			inOut.outputLine("Employee with the entered ID not found");
			return null;
		}
		
		return id;
	}
	
}