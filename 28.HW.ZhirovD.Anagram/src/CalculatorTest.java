import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testWrongExpressions()
	{
		assertNull(Calculator.computeExpression("10+10/"));
		assertNull(Calculator.computeExpression("+10/10"));
		assertNull(Calculator.computeExpression("10$10"));
		assertNull(Calculator.computeExpression("10  10"));
	}
	
	@Test
	void testRigthExpressions()
	{
		assertEquals(10, Calculator.computeExpression("10+10-10"));
		assertEquals(100, Calculator.computeExpression("10*10"));
		assertEquals(10, Calculator.computeExpression("  10    +10    -10"));
		assertEquals(10, Calculator.computeExpression("10"));
	}

}
