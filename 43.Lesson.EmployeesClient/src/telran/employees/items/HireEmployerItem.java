package telran.employees.items;

import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class HireEmployerItem extends EmplyeesItem {

	public HireEmployerItem(InputOutput inOut, IEmployees empl) {
		super(inOut, empl);
	}

	@Override
	public String displayedName() {
		return "Hire employer";
	}

	@Override
	public void perform() {
		Integer id = getNotExistingId();
		if(id == null)
			return;
		
		String name = inOut.inputString("Enter name");
		if(name == null)
			return;
		
		String companyName = inOut.inputString("Enter company name");
		if(companyName == null)
			return;
		
		Integer salary = inOut.inputInteger(String.format("Enter salary [%d-%d]", MIN_SALARY, MAX_SALARY), MIN_SALARY, MAX_SALARY);
		if(salary == null)
			return;
		
		if(empl.hireEmployee(new Employee(id, name, companyName, salary)))
			inOut.outputLine("Employer has been hired");
	}

}
