package telran.cars.cli.manager;

import telran.cars.cli.RentCompanyItem;
import telran.cars.dto.Model;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class AddModelItem extends RentCompanyItem{
	private static final int MIN_TANK = 35;
	private static final int MAX_TANK = 100;
	private static final int MIN_PRICE = 50;
	private static final int MAX_PRICE = 1000;
	
	
	public AddModelItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Add car model";
	}

	@Override
	public void perform() {
		String modelName = inOut.inputString("Enter model name");
		if(modelName == null)
			return;
		
		Integer gasTank = inOut.inputInteger(String.format("Enter gas tank volumr from range [%d-%d]", MIN_TANK, MAX_TANK),
				MIN_TANK, MAX_TANK);
		if(gasTank == null)
			return;
		
		String companyName = inOut.inputString("Enter company name");
		if(companyName == null)
			return;
		
		String country = inOut.inputString("Enter country");
		if(country == null)
			return;
		
		Integer priceDay = inOut.inputInteger(String.format("Enter price day from range [%d-%d]", MIN_PRICE, MAX_PRICE), MIN_PRICE, MAX_PRICE);
		if(priceDay == null)
			return;
		
		
		Model model = new Model(modelName, gasTank, companyName, country, priceDay);
		inOut.output(company.addModel(model));
	}
	
}
