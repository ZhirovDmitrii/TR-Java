package telran.cars.cli.manager;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class RemoveCarItem extends RentCompanyItem{

	public RemoveCarItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Remove car";
	}

	@Override
	public void perform() {
		String regNumber = getRegNumberIfExist();
		if(regNumber == null)
			return;
		
		inOut.outputLine(company.removeCar(regNumber));
	}

}
