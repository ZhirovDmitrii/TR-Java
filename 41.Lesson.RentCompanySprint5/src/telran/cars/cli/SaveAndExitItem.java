package telran.cars.cli;

import telran.cars.model.IRentCompany;
import telran.cars.utils.Persistable;
import telran.view.InputOutput;

public class SaveAndExitItem extends RentCompanyItem{
	String fileName;

	public SaveAndExitItem(InputOutput inOut, IRentCompany company, String fileName) {
		super(inOut, company);
		this.fileName = fileName;
	}

	@Override
	public String displayedName() {
		return "Save and exit";
	}

	@Override
	public void perform() {
		((Persistable)company).save(fileName);
	}
	
	public boolean isExit() {
		return true;
	}
}
