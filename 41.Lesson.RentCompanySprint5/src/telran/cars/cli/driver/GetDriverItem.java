package telran.cars.cli.driver;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetDriverItem extends RentCompanyItem{

	public GetDriverItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Get driver data";
	}

	@Override
	public void perform() {
		Long licenseId = getLicenseIdIfExists();
		if(licenseId == null)
			return;
		
		inOut.outputLine(company.getDriver(licenseId));
	}

}
