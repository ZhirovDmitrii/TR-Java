package telran.calculator;

import java.time.LocalDate;

import telran.view.InputOutput;
import telran.view.Item;

public class DateAfterBeforeItem implements Item {
	InputOutput inOut;
	String format;

	public DateAfterBeforeItem(InputOutput inOut, String format) {
		super();
		this.inOut = inOut;
		this.format = format;
	}

	@Override
	public String displayedName() {
		return "Date after or before item";
	}

	@Override
	public void perform() {
		LocalDate date = inOut.inputDate("Enter date in format " + format, format);
		if (date == null)
			return;

		Long days = inOut.inputLong("Enter the number of days");
		if (days == null)
			return;

		String beforeAfter = inOut.inputString("Enter 'before' or 'after' days");
		if (beforeAfter == null)
			return;
		
		inOut.outputLine(beforeAfter.contains("before") ? date.minusDays(days) : date.plusDays(days).toString());
	}
}
