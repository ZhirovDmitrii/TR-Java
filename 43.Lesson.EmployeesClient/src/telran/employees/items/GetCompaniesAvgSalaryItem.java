package telran.employees.items;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class GetCompaniesAvgSalaryItem extends EmplyeesItem{

	public GetCompaniesAvgSalaryItem(InputOutput inOut, IEmployees empl) {
		super(inOut, empl);
	}

	@Override
	public String displayedName() {
		return "Get companies avg salary";
	}

	@Override
	public void perform() {
		inOut.outputLine(empl.getCompaniesAvgSalary());
	}

}
