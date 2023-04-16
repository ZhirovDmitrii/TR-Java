
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class CalculatorTest {

	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void testSum() {
//		fail("Not yet implemented");
		assertEquals(2, Calculator.sum(1, 1));
		assertNotEquals(3, Calculator.sum(1, 1));
		
		assertTrue(Calculator.sum(1, 1) == 2);
		assertFalse(Calculator.sum(1, 1) == 3);
	}

	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void testDiv() {
//		fail("Not yet implemented");
		assertEquals(1, Calculator.div(2, 2));
		assertNotEquals(2, Calculator.div(2, 2));
		
		assertTrue(Calculator.div(2, 2) == 1);
		assertFalse(Calculator.div(2, 2) == 2);
	}

	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void testMul() {
//		fail("Not yet implemented");
		assertEquals(4, Calculator.mul(2, 2));
		assertNotEquals(5, Calculator.mul(2, 2));
		
		assertTrue(Calculator.mul(2, 2) == 4);
		assertFalse(Calculator.mul(2, 2) == 5);
	}

	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void testSub() {
//		fail("Not yet implemented");
		assertEquals(1, Calculator.sub(2, 1));
		assertNotEquals(3, Calculator.sub(2, 1));
		
		assertTrue(Calculator.sub(2, 1) == 1);
		assertFalse(Calculator.sub(2, 1) == 3);
	}

	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void testIsEven() {
//		fail("Not yet implemented");
		assertEquals(true, Calculator.isEven(2));
		assertEquals(false, Calculator.isEven(1));
		assertNotEquals(false, Calculator.isEven(2));
		assertNotEquals(true, Calculator.isEven(1));
	}

}