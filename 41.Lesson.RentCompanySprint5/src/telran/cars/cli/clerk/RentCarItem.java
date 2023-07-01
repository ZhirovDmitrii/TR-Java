package telran.cars.cli.clerk;

import java.time.LocalDate;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class RentCarItem extends RentCompanyItem{
	
	private static final Integer MIN = 1;
	private static final Integer MAX = 28;

	public RentCarItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Rent car";
	}

	@Override
	public void perform() {
		String regNumber = getRegNumberIfExist();
		if(regNumber == null)
			return;
		
		if(company.getCar(regNumber).inUse()) {
			inOut.outputLine("This car is in use");
			return;
		}
		
		Long licenseId = getLicenseIdIfExists();
		if(licenseId == null)
			return;
		
		LocalDate dateOfRent = inOut.inputDate("Enter rent date in format " + format, format); // format in write in RentCompanyItem
		if(dateOfRent == null)
			return;
		
		Integer rentDays = inOut.inputInteger(String.format("Enter rent days from range [%d-%d]", MIN, MAX), MIN, MAX);
		if(rentDays == null)
			return;
		
		inOut.outputLine(company.rentCar(regNumber, licenseId, dateOfRent, rentDays));
	}

}
