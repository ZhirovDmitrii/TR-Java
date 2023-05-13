
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

public class DateOperations {

	/**
	 * @param dates
	 * @return sorted array of strings in the ascending order of the appropriate
	 *         dates
	 */
	public static String[] sortStringDates(String[] dates) {
		Arrays.sort(dates, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				DateTimeFormatter dtf01 = getFormat(o1);
				LocalDate ld01 = LocalDate.parse(o1, dtf01);
				
				DateTimeFormatter dtf02 = getFormat(o2);
				LocalDate ld02 = LocalDate.parse(o2, dtf02);
				
				return ld01.compareTo(ld02);
			}
		});

		return dates;
	}

	protected static DateTimeFormatter getFormat(String str) {
		return str.contains("-") ? DateTimeFormatter.ISO_DATE : DateTimeFormatter.ofPattern("dd/MM/yyyy");
	}

	/**
	 * @param birthDate
	 * @param currentDate
	 * @return full age in the years relatively the given current date if
	 *         currentDate is null the LocalDate.now() is applied
	 */
	public static Integer getAge(String birthDate, String currentDate) {
		// Option 1
//		DateTimeFormatter dtf01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		DateTimeFormatter dtf02 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ldCD;
		LocalDate ldBD;
//		try {
//			ldCD = currentDate == null ? LocalDate.now() : LocalDate.parse(currentDate, dtf01);
//		} catch (DateTimeParseException e) {
//			ldCD = currentDate == null ? LocalDate.now() : LocalDate.parse(currentDate, dtf02);
//		}
//
//		try {
//			ldBD = LocalDate.parse(birthDate, dtf01);
//		} catch (DateTimeParseException e) {
//			ldBD = LocalDate.parse(birthDate, dtf02);
//		}

		// Option 2
		DateTimeFormatter dtf = new DateTimeFormatterBuilder().appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();
		ldCD = currentDate == null ? LocalDate.now() : LocalDate.parse(currentDate, dtf);
		ldBD = LocalDate.parse(birthDate, dtf);
		return Period.between(ldBD, ldCD).getYears();
	}

	/**
	 * @param zoneSubstring print current time in format HH:MM (hours:minutes) for
	 *                      all time zones containing zoneSubstring one printed line
	 *                      should contain full zone name and time in the above
	 *                      format
	 */
	public static void printCurrentTime(String string) {
		Set<String> zones = ZoneId.getAvailableZoneIds();
		for (String zone : zones) {
			if (zone.contains(string)) {
				ZoneId zi = ZoneId.of(zone);
				LocalTime t = LocalTime.now(zi);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
				String res = dtf.format(t);
				System.out.println(zone + " - " + res);
			}
		}
	}

}
