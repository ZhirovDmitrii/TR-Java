package telran.cars.cli.manager;

import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class RemoveModelItem extends RentCompanyItem{

	public RemoveModelItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Remove car model";
	}

	@Override
	public void perform() {
		List<String> models = company.getModelNames();
		
		String modelName = inOut.inputString("Enter model name from " + models, models);
		if(modelName == null)
			return;
		
		company.removeCarsOfModel(modelName).forEach(inOut::outputLine);
	}

}
