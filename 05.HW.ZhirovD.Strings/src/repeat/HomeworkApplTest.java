package repeat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HomeworkApplTest {

	@Test
	void testIspalindrome() {
		assertTrue(HomeworkAppl.isPalindrome("MadAm"));
		assertFalse(HomeworkAppl.isPalindrome("madom"));
	}

	@Test
	void testIsReverse() {
		assertTrue(HomeworkAppl.isReverse("Dima", "amiD") );
		assertFalse(HomeworkAppl.isReverse("Dima", "Amid"));
	}

	@Test
	void testPrintSubStringReverse() {
		HomeworkAppl.printSubStringReverse("Hello", 1, 4);
	}

	@Test
	void testPtintStringInColumn() {
		HomeworkAppl.ptintStringInColumn("Hello");
	}

	@Test
	void testCountChar() {
		assertEquals(2, HomeworkAppl.countChar("Hello", 'l'));
		assertNotEquals(2, HomeworkAppl.countChar("Hello", 'e'));
	}
	
	@Test
	void testValidPassword() {
		HomeworkAppl.validPassword("Aa12345~");	// valid
		HomeworkAppl.validPassword("Aa1234~");	// length < 8
		HomeworkAppl.validPassword("aa12345~"); // no upper case
		HomeworkAppl.validPassword("AA12345~"); // no lower case
		HomeworkAppl.validPassword("Aaqwert~"); // no digit
		HomeworkAppl.validPassword("Aa123456"); // no special symbol
	}

}
