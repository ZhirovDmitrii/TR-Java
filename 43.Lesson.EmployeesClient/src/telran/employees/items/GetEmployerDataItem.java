package telran.employees.items;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class GetEmployerDataItem extends EmplyeesItem {

	public GetEmployerDataItem(InputOutput inOut, IEmployees empl) {
		super(inOut, empl);
	}

	@Override
	public String displayedName() {
		return "Get employer data";
	}

	@Override
	public void perform() {
		Integer id = getExistingId();
		if(id == null)
			return;
		
		inOut.outputLine(empl.getEmployeeData(id));
	}

}
