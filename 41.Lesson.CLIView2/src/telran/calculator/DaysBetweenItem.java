package telran.calculator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import telran.view.InputOutput;
import telran.view.Item;

public class DaysBetweenItem implements Item{

	InputOutput inOut;
	String format;
	
	
	
	public DaysBetweenItem(InputOutput inOut, String format) {
		super();
		this.inOut = inOut;
		this.format = format;
	}

	@Override
	public String displayedName() {
		return "Days between item";
	}

	@Override
	public void perform() {
		LocalDate date01 = inOut.inputDate("Enter first date in format " + format, format);
		if(date01 == null)
			return;
		
		LocalDate date02 = inOut.inputDate("Enter second date in format " + format, format);
		if(date02 == null)
			return;
		
		inOut.outputLine(ChronoUnit.DAYS.between(date01, date02));
	}

}
