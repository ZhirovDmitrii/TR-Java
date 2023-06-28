package telran.calculator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import telran.view.InputOutput;
import telran.view.Item;

public class DateAfterBeforeItem implements Item {
	InputOutput inOut;
	String format;
	List<String> list = new ArrayList<>();

	public DateAfterBeforeItem(InputOutput inOut, String format) {
		super();
		this.inOut = inOut;
		this.format = format;
		this.list.add("before");
		this.list.add("after");
	}

	@Override
	public String displayedName() {
		return "Date after or before item";
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void perform() {
		LocalDate date = inOut.inputDate("Enter date in format " + format, format);
		if (date == null)
			return;

		Long days = inOut.inputLong("Enter the number of days");
		if (days == null)
			return;

		String beforeAfter = inOut.inputString("Enter 'before' or 'after' days", list);
		if (beforeAfter == null)
			return;
		
		inOut.outputLine(list.equals("before") ? date.plusDays(days) : date.minusDays(days));
	}
}
