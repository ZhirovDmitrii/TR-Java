package telran.employees.items;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class GetAvgSalariesItem extends EmplyeesItem {

	public GetAvgSalariesItem(InputOutput inOut, IEmployees empl) {
		super(inOut, empl);
	}

	@Override
	public String displayedName() {
		return "Get avg salary";
	}

	@Override
	public void perform() {
		inOut.outputLine(empl.getAverageSalary());
	}

}
