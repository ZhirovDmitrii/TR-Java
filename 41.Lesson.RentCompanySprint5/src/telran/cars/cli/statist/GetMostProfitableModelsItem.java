package telran.cars.cli.statist;

import java.time.LocalDate;
import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetMostProfitableModelsItem extends RentCompanyItem{

	public GetMostProfitableModelsItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Get most profitableModelsItem";
	}

	@Override
	public void perform() {
		LocalDate fromDate = inOut.inputDate("Enter date from using format " + format, format);
		if(fromDate == null)
			return;
		
		LocalDate toDate = inOut.inputDate("Enter date to using format " + format, format);
		if(toDate == null)
			return;
		
		List<String> models = company.getMostProfitableCarModels(fromDate, toDate);
		if (models.isEmpty()) {
			inOut.outputLine("No models");
			return;
		}
		
		
		models.forEach(inOut::outputLine);
	}

}
