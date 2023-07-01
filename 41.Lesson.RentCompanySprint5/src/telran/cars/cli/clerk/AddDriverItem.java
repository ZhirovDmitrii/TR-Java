package telran.cars.cli.clerk;

import telran.cars.cli.RentCompanyItem;
import telran.cars.dto.Driver;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class AddDriverItem extends RentCompanyItem{

	private static final Integer MIN_YEAR = 1950;
	private static final Integer MAX_YEAR = 2000;

	public AddDriverItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Add driver";
	}

	@Override
	public void perform() {
		Long licenseId = getLicenseIdIfNotExists();
		if(licenseId == null)
			return;
		
		String name = inOut.inputString("Enter driver name");
		if(name == null)
			return;
		
		Integer birthDate = inOut.inputInteger(String.format("Enter birth year from range [%d-%d]", MIN_YEAR, MAX_YEAR), MIN_YEAR, MAX_YEAR);
		if(birthDate == null)
			return;
		
		String phone = inOut.inputString("Enter phone number");
		if(phone == null)
			return;
		
		
		Driver driver = new Driver(licenseId, name, birthDate, phone);
		inOut.outputLine(company.addDriver(driver ));
	}

}
