package telran.cars.cli.statist;

import java.time.LocalDate;
import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetMostPopularModelsItem extends RentCompanyItem{

	private static final int MIN_AGE = 21;
	private static final int MAX_AGE = 70;
	
	public GetMostPopularModelsItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Get most popular models";
	}

	@Override
	public void perform() {
		LocalDate fromDate = inOut.inputDate("Enter date from using format " + format, format);
		if(fromDate == null)
			return;
		
		LocalDate toDate = inOut.inputDate("Enter date to using format " + format, format);
		if(toDate == null)
			return;
		
//		=====
		
		Integer fromAge = inOut.inputInteger(String.format("Enter age from in range [%d-%d]", MIN_AGE, MAX_AGE), MIN_AGE, MAX_AGE);
		if (fromAge == null)
			return;
		
		Integer toAge = inOut.inputInteger(String.format("Enter age to in range [%d-%d]", MIN_AGE, MAX_AGE), MIN_AGE, MAX_AGE);;
		if (toAge == null)
			return;
		
//		=====
		
		List<String> list = company.getMostPopularCarModels(fromDate, toDate, fromAge, toAge);
		if(list.isEmpty()) {
			inOut.outputLine("No popular models");
			return;
		}
		
		list.forEach(inOut::outputLine);
	}

}
