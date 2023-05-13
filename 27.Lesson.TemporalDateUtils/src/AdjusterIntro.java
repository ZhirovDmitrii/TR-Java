import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class AdjusterIntro {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println(date.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.println(date.with(TemporalAdjusters.firstDayOfYear()));
		System.out.println(date.with(TemporalAdjusters.firstDayOfNextYear()));
		System.out.println(date.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY)));
	
		TemporalAdjuster lastDayYear = TemporalAdjusters.lastDayOfYear();
		LocalDate lastDay = date.with(lastDayYear);	// parse to LocalDate for work with Period
		Period until = date.until(lastDay);
		System.out.printf("Until New Year left %d years %d months %d days\n", until.getYears(), until.getMonths(), until.getMonths());
		System.out.println(ChronoUnit.DAYS.between(date, lastDay));
	
		System.out.println(date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
		System.out.println(date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)));
	
		// if looking for a date on the same day of the week, it will return today's date
		System.out.println(date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)));
		System.out.println(date.with(TemporalAdjusters.previousOrSame(DayOfWeek.FRIDAY)));

		System.out.println(date.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY)));
		System.out.println(date.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY)));
		System.out.println(date.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.MONDAY)));
		System.out.println();
		
		System.out.println(date.with(new NoneLeapYears(10)));
	}
}
