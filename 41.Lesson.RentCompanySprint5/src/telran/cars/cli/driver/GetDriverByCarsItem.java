package telran.cars.cli.driver;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.dto.Driver;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetDriverByCarsItem extends RentCompanyItem{

	public GetDriverByCarsItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Get drivers data by cars";
	}

	@Override
	public void perform() {
		String regNumber = getRegNumberIfExist();
		if(regNumber == null)
			return;
		
		List<Driver> list = company.getDriversByCar(regNumber);
		if(list.isEmpty()) {
			inOut.outputLine("Car is was not rented by this driver");
			return;
		}
		
		list.forEach(inOut::outputLine);
	}

}
