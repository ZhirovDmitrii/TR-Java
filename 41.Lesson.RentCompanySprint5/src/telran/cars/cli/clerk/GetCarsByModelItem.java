package telran.cars.cli.clerk;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.dto.Car;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetCarsByModelItem extends RentCompanyItem {

	public GetCarsByModelItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Get cars by model";
	}

	@Override
	public void perform() {
		List<String> models = company.getModelNames();
		String modelname = inOut.inputString("Enter model name from " + models, models);
		if(modelname == null)
			return;
		
		// =====
		
		List<Car> cars = company.getCarsByModel(modelname);
		if(cars.isEmpty()) {
			inOut.outputLine("No car by this model");
			return;
		}
		
		cars.forEach(inOut::outputLine);
	}

}
