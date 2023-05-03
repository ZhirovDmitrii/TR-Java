import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateTimeIntro {
	public static void main(String[] args) {
//		Class LocalDate - save a date (not a time), and safe static methods
		
		LocalDate date = LocalDate.now();	// create actual date
		System.out.println(date);
		
		LocalDate date01 = LocalDate.of(2000, 10, 10);	// another option
		System.out.println(date01);
		
		LocalDate date02 = LocalDate.of(2000, Month.FEBRUARY, 10);	// another option
		System.out.println(date02);
		
		LocalDate date03 = LocalDate.parse("2000-12-29");	// another option
		System.out.println(date03);
		
		LocalDate date04 = LocalDate.ofYearDay(2020, 300);	// another option (300 is a day by year - 10.26)
		System.out.println(date04);
		
		System.out.println(date01.getDayOfYear()); 	// what a day in year
		System.out.println(date01.getDayOfWeek()); 	// what day in week
		
		date04 = date.withYear(1980);	// give me the same date as in date, but 1980
		System.out.println(date04);
		System.out.println(date04.getDayOfWeek()); // 1980-05-03 is a Saturday
	
		System.out.println(date04.plusYears(10).plusWeeks(2).plusDays(10).plusMonths(1));
		System.out.println(date04); 	// 1980 - because date - IMUTABLE!!!!!!!!!!!!
		System.out.println(date04.minusDays(1).minusMonths(1).minusWeeks(1).minusYears(1));
		
		// easy option - use class Period
		System.out.println(date04.plus(Period.of(1, 1, 1)));
		System.out.println(date04.minus(Period.of(1, 1, 1)));
		
		// plus a big period - centuries, decade (10 days), millennia (1000 years)
		System.out.println(date.plus(1, ChronoUnit.CENTURIES));
		System.out.println(date.minus(1, ChronoUnit.MILLENNIA));
	
		// check period between
		System.out.println(ChronoUnit.DECADES.between(date03, date04));
		System.out.println(ChronoUnit.DAYS.between(date, LocalDate.of(2022, Month.SEPTEMBER, 15)));
	
		// check date before/after
		System.out.println(date.isAfter(date04));	// date stay after date04 - TRUE
		System.out.println(date.isBefore(date04));	// date stay before date04 - FALSE
	
		// take era
		System.out.println(date.getEra());	// CE - current era
		System.out.println(LocalDate.of(-10, 10, 10).getEra());	// BCE - before current era
		// System.out.println(ChronoUnit.MINUTES.between(date, LocalDate.of(2022, Month.SEPTEMBER, 15))); -  exception. Not work with time
		
		System.out.println();
		
//		Class LocalTime - for work with time
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
	
		LocalTime time01 = LocalTime.of(10, 10);
		System.out.println(time01);
		
		LocalTime time02 = LocalTime.parse("10:10:10.10");
		System.out.println(time02);
		
		LocalTime time03 = LocalTime.ofSecondOfDay(1000);	// get a time in 1000 sec - 16 min 40 sec
		System.out.println(time03);
	
		LocalTime time04 = LocalTime.ofNanoOfDay(1010000000000L);	// nanosec
		System.out.println(time04);
		
		// not use ChronoUnit class!!! 
		// USE Duration class!!!
		System.out.println(time.plus(Duration.ofMinutes(10)));	// +10 min to current time
		System.out.println(time.minus(Duration.ofSeconds(10000)));	// - 10_000 sec from current time
		System.out.println(time.plus(1, ChronoUnit.HALF_DAYS));	// + 12 hour
		
		System.out.println();
		
//		LocalDateTime class - for save date and time
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		// use LocalDate and LocatTime in LocalDateTime
		LocalDateTime ldt01 = LocalDateTime.of(date04, time04);
		System.out.println(ldt01);
		
		System.out.println();
		
//		Formatter
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, dd/MMM/yyyy hh:mm:ss a");
//		yy yyyy - years
//		MM MMM MMMM - (MM - 01,02) (MMM - APR, JUN) (MMMM - full name: SEPTEMBER, OCTOBER)
//		dd - day
//		E ee eeee - weekdays(E - mon, tue, sun) (ee - number weekdays: 01,02) (eeee - full name weekdays)
//		hh HH a- (hh - 12 hour format) (HH - 24 hour format) ()a - AP/PM)
//		mm - minutes
//		ss - sec
//		and more ...
		System.out.println(ldt.format(dtf));
		
		dtf = DateTimeFormatter.ofPattern("E, dd/MMM/yyyy hh:mm:ss a", Locale.JAPAN);
		System.out.println(ldt.format(dtf));
		
		// if in Locale don't see needed format
		dtf = DateTimeFormatter.ofPattern("E, dd/MMM/yyyy hh:mm:ss a", Locale.forLanguageTag("he"));
		System.out.println(ldt.format(dtf));
		
		dtf = DateTimeFormatter.ofPattern("E, dd/MMM/yyyy hh:mm:ss a", Locale.ENGLISH);
		LocalDateTime res = LocalDateTime.parse("Wed, 03/May/2023 08:32:06 PM", dtf);
		System.out.println(res);
		
		System.out.println();
		
//		ZoneTime
		
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		
		// opt 1
		ZonedDateTime zdt01 = ZonedDateTime.now(ZoneId.of("GMT-4"));
		System.out.println(zdt01);
		
		// opt 2
		zdt01 = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
		System.out.println(zdt01);
		
		System.out.println();
		
//		=========================
//		OffsetDateTime class
		
		OffsetDateTime odt = OffsetDateTime.of(res, ZoneOffset.of("-08:00"));
		System.out.println(odt);
//		=========================
		
		// print all zones
		for(String str: ZoneId.getAvailableZoneIds())
			System.out.println(str);
		
		ZonedDateTime almatyTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Almaty"));
		ZonedDateTime nyTime = almatyTime.withZoneSameInstant(ZoneId.of("America/New_York"));
		System.out.println(almatyTime);
		System.out.println(nyTime);
	}
}
