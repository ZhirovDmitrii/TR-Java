package telran.cars.cli.manager;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.dto.Car;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class AddCarItem extends RentCompanyItem{

	public AddCarItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Add car";
	}

	@Override
	public void perform() {
		String regNumber = getRegNumberIfNotExist();
		if(regNumber == null)
			return;
		
		String color = inOut.inputString("Enter color");
		if(color == null)
			return;
		
		List<String> models = company.getModelNames();
		String modelName = inOut.inputString("Enter model from " + models, models);
		if(modelName == null)
			return;
		
		Car car = new Car(regNumber, color, modelName);
		inOut.output(company.addCar(car));
	}

}
