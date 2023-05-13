
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.Stack;
import java.util.TimeZone;

public class DateOperations {

	/**
	 * @param dates
	 * @return sorted array of strings in the ascending order of the appropriate
	 *         dates
	 */
	public static String[] sortStringDates(String[] dates) {
		
		
		return null;
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
		DateTimeFormatter dtf = new DateTimeFormatterBuilder()
				.appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
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
		// Option 1 (from google)
//		String[] zones = TimeZone.getAvailableIDs();
//		for(String zone: zones) {
//			if(zone.contains(string)) {
//				TimeZone tz = TimeZone.getTimeZone(zone);
//				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//				sdf.setTimeZone(tz);
//				Date d = new Date();
//				System.out.println(zone + " - " + sdf.format(d));
//			}
//		}

		// Option 2
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
