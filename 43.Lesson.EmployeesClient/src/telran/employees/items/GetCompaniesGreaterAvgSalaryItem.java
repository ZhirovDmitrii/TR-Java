package telran.employees.items;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class GetCompaniesGreaterAvgSalaryItem extends EmplyeesItem{

	public GetCompaniesGreaterAvgSalaryItem(InputOutput inOut, IEmployees empl) {
		super(inOut, empl);
	}

	@Override
	public String displayedName() {
		return "Get companies greater avg salary";
	}

	@Override
	public void perform() {
		inOut.outputLine(empl.getCompaniesGreaterAvgSalary());
	}

}
