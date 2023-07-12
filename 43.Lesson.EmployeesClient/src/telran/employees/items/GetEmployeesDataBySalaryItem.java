package telran.employees.items;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class GetEmployeesDataBySalaryItem extends EmplyeesItem{

	public GetEmployeesDataBySalaryItem(InputOutput inOut, IEmployees empl) {
		super(inOut, empl);
	}

	@Override
	public String displayedName() {
		return "Get employees data by salary";
	}

	@Override
	public void perform() {
		Integer salaryFrom = inOut.inputInteger(String.format("Enter salary from [%d-%d]", MIN_SALARY, MAX_SALARY), MIN_SALARY, MAX_SALARY);
		if(salaryFrom == null)
			return;
		
		Integer salaryTo = inOut.inputInteger(String.format("Enter salary to [%d-%d]", MIN_SALARY, MAX_SALARY), MIN_SALARY, MAX_SALARY);
		if(salaryTo == null)
			return;
		
		if (salaryTo < salaryFrom)
		{
			inOut.outputLine("salary to can't be less than salary from");
			return;
		}
		
		empl.getEmployeesDataBySalary(salaryFrom, salaryTo).forEach(inOut::outputLine);
	}

}
