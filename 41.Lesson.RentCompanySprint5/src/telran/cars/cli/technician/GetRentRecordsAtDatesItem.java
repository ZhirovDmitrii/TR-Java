package telran.cars.cli.technician;

import java.time.LocalDate;
import java.util.List;

import telran.cars.cli.RentCompanyItem;
import telran.cars.dto.RentRecord;
import telran.cars.model.IRentCompany;
import telran.view.InputOutput;

public class GetRentRecordsAtDatesItem extends RentCompanyItem{

	public GetRentRecordsAtDatesItem(InputOutput inOut, IRentCompany company) {
		super(inOut, company);
	}

	@Override
	public String displayedName() {
		return "Get rent records at dates";
	}

	@Override
	public void perform() {
		LocalDate fromDate = inOut.inputDate("Enter date from using format " + format, format);
		if(fromDate == null)
			return;
		
		LocalDate toDate = inOut.inputDate("Enter date to using format " + format, format);
		if(toDate == null)
			return;
		
		List<RentRecord> list = company.getRentRecordsAtDates(fromDate, toDate);
		if(list.isEmpty()) {
			inOut.outputLine("No records");
			return;
		}
		
		list.forEach(inOut::outputLine);
	}

}
