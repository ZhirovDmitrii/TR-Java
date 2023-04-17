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
	void testCountSubString() {
		assertEquals(2, HomeworkAppl.countSubString("HeHello", "He"));
	}
	
	@Test
	void testEmailValidation() {
		HomeworkAppl.isEmailValid("sdf-2@mail.ru"); 	// ok
		HomeworkAppl.isEmailValid("sdf-2mail.ru");		// no at
		HomeworkAppl.isEmailValid("sdf-2@mailru");		// no dot
		HomeworkAppl.isEmailValid("sdf-2@mailru.");		// dot in the end word
		HomeworkAppl.isEmailValid("@sdf-2@mail.ru");	// start with at
		HomeworkAppl.isEmailValid("sdf-2@ma@il.ru");	// 2 at
		HomeworkAppl.isEmailValid("sdf-2@mail.co.il");	// ok
		HomeworkAppl.isEmailValid("sdf2@mail.ru");		// no special symbol
			
		
	}

}
