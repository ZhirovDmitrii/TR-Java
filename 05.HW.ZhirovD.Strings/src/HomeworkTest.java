import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class HomeworkTests {

	@Test
	void testValidPassword() {
		//fail("Not yet implemented");
		System.out.println("Task 6.");
		Homework.validPassword("Aa12345~!-_");
		Homework.validPassword("Aa1234!");
		Homework.validPassword("AA12345!");
		Homework.validPassword("aabcdef!");
		Homework.validPassword("1234567!");
		Homework.validPassword("Aa12345%");
		Homework.validPassword("Aa12345!%");
		Homework.validPassword("Aa12345%!");
		System.out.println();
		
		assertTrue(Utils.isPalindrome("madam"));
		
		assertTrue(Utils.isReverse("Dima", "Amid"));

		Utils.printSubStringReverse("stop", 0, 4);
		System.out.println("\n");
		
		System.out.println("Task 4.");
		Utils.printStringInColumn("Tel-Ran");
		System.out.println();
		
		System.out.println("Task 5.");
		System.out.println(Utils.countChar("777 is bad number, but 666 is good!", 'o'));
		
	}

}