import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateOperationsTest {

	String[] dates = {"2000-12-01", "10/12/2000", "1970-08-12", "2010-10-05"};
	String[] expectedDates = {"1970-08-12", "2000-12-01", "10/12/2000", "2010-10-05"};

	@Test
	void datesSortTest()
	{
		String[] actual = DateOperations.sortStringDates(dates);
		assertArrayEquals(expectedDates, actual);
	}

	@Test
	void ageTest()
	{
		String birthDate = "12/04/1961";
		String currentDate = "11/11/2018";
		assertEquals(57, DateOperations.getAge(birthDate, currentDate));
		birthDate = "1961-12-12";
		currentDate = "2018-11-11";
		assertEquals(56, DateOperations.getAge(birthDate, currentDate));
		assertEquals(61, DateOperations.getAge(birthDate, null));
	}

	@Test
	void printCurrentTimeForZonesTest()
	{
		DateOperations.printCurrentTime("America");
		// <zone name containing America> - HH:MM
		// ...........
	}
}
