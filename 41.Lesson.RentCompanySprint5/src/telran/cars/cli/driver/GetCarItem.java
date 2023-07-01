package telran.cars.cli.driver;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetCarItem extends RentCompanyItem{

	public GetCarItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Get car data";
	}

	@Override
	public void perform() {
		String regNumber = getRegNumberIfExist();
		if(regNumber == null)
			return;
		
		inOut.outputLine(company.getCar(regNumber));
	}
	
}
