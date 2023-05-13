import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

public class QueryIntro {

	public static void main(String[] args) {
		TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
		
		System.out.printf("LocalDate precision is - %s\n", LocalDate.now().query(query));
		System.out.printf("LocalDateTime precision is - %s\n", LocalDateTime.now().query(query));
		System.out.printf("LocalTime precision is - %s\n", LocalTime.now().query(query));
		System.out.printf("Year precision is - %s\n", Year.now().query(query));
		System.out.printf("YearMonth precision is - %s\n", YearMonth.now().query(query));
		System.out.printf("Instant precision is - %s\n", Instant.now().query(query));
		
		System.out.println(LocalDate.now().query(new IsWeekendDay()));
		System.out.println(LocalDate.now().plus(1, ChronoUnit.DAYS).query(new IsWeekendDay()));
	}

}
