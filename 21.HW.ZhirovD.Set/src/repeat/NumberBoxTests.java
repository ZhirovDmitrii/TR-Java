package repeat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class NumberBoxTests {
	Integer array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	Integer noDividedBy3[] = { 1, 2, 4, 5, 7, 8, 10 };
	Integer noInRange8_11[] = { 1, 2, 3, 4, 5, 6, 7 };
	
	INumberBox numbersBox;

	@Before
	public void setUp() throws Exception {
//		numbersBox = new NumberBoxArrayList();
		numbersBox = new NumberBoxLinkedList();
//		numbersBox = new NumberBoxHashSet();
//		numbersBox = new NumberBoxTreeSet();
		for (int number : array) {
			numbersBox.addNumber(number);
		}
	}

	@Test
	public void addContainsSizeTest() {
		runTest(array);
	}

	@Test
	public void removeDividedByTest() {
		numbersBox.removeDividedBy(3);
		runTest(noDividedBy3);
	}

	@Test
	public void removeInRangeTest() {
		numbersBox.removeInRange(8, 11);
		runTest(noInRange8_11);
	}

	@Test
	public void removeRepeatedTest() {
		runTest(array);
		numbersBox.addNumber(1);
		numbersBox.addNumber(5);
		numbersBox.addNumber(10);
		numbersBox.removeRepeated();
		runTest(array);
	}

	private void runTest(Integer[] array) {
		assertEquals(array.length, numbersBox.size());
		for (int number : array)
			assertTrue(numbersBox.containsNumber(number));
	}
}
