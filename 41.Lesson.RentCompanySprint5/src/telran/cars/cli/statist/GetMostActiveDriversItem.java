package telran.cars.cli.statist;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.dto.Driver;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetMostActiveDriversItem extends RentCompanyItem{

	public GetMostActiveDriversItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Get most active drivers";
	}

	@Override
	public void perform() {
		List<Driver> list = company.getMostActiveDriver();
		if(list.isEmpty()) {
			inOut.outputLine("No drivers");
			return;
		}
		
		list.forEach(inOut::outputLine);
	}

}
