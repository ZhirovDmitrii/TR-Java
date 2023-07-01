package telran.cars.cli.driver;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.dto.Car;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetCarsByDriverItem extends RentCompanyItem{

	public GetCarsByDriverItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Get cars data by drivers";
	}

	@Override
	public void perform() {
		Long licenseId = getLicenseIdIfExists();
		if(licenseId == null)
			return;
		
		List<Car> list = company.getCarsByDriver(licenseId);
		if(list.isEmpty()) {
			inOut.outputLine("Driver did not rent this car");
			return;
		}
		
		list.forEach(inOut::outputLine);
	}

}
