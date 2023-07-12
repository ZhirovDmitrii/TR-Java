package telran.employees.items;

import telran.employees.service.IEmployees;
import telran.view.InputOutput;

public class FireEmployerItem extends EmplyeesItem{

	public FireEmployerItem(InputOutput inOut, IEmployees empl) {
		super(inOut, empl);
	}

	@Override
	public String displayedName() {
		return "Fire employer";
	}

	@Override
	public void perform() {
		Integer id = getExistingId();
		if(id == null)
			return;
		
		if(empl.fireEmpployee(id))
			inOut.outputLine("Emloyer has been fire");
	}

}
