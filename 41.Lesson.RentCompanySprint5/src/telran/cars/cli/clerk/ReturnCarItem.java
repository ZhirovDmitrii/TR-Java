package telran.cars.cli.clerk;

import java.time.LocalDate;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class ReturnCarItem extends RentCompanyItem{

	public ReturnCarItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Return car from rent";
	}

	@Override
	public void perform() {
		String regNumber = getRegNumberIfExist();
		if (regNumber == null)
			return;
		
		Long licenseId = getLicenseIdIfExists();
		if (licenseId == null)
			return;
		
		LocalDate dateOfReturn = inOut.inputDate("Enter return date in format " + format, format);
		if(dateOfReturn == null)
			return;
		
		Integer damages = inOut.inputInteger("Enter percent of damages", 0, 100);
		if(damages == null)
			return;
		
		Integer tankPercent = inOut.inputInteger("Enter tank percent", 0, 100);
		if(tankPercent == null)
			return;
		
		inOut.outputLine(company.returnCar(regNumber, licenseId, dateOfReturn, damages, tankPercent));
	}

}
