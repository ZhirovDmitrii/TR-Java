package repeat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class INumberBoxTest {
	int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int[] noNumber = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int[] noDividedBy2 = { 1, 3, 5, 7, 9 };
	int[] noInRange3_6 = { 1, 2, 6, 7, 8, 9, 10 };

	INumberBox numberBox;

	@BeforeEach
	void setUp() throws Exception {
//		numberBox = new NumberBoxArrayList();
//		numberBox = new NumberBoxLinkedList();
//		numberBox = new NumberBoxHashSet();
		numberBox = new NumberBoxTreeSet();
		for (int number : array)
			numberBox.addNumber(number);
	}

	@Test
	void testContainsNumber() {
		for (int number : array)
			assertTrue(numberBox.containsNumber(number));
	}
	
	@Test
	void testRemoveNumber() {
		numberBox.removeNumber(10);
		for(int number: noNumber)
			assertTrue(numberBox.containsNumber(number));
	}

	@Test
	void testRemoveRepeated() {
		numberBox.addNumber(1);
		numberBox.addNumber(2);
		numberBox.addNumber(5);
		numberBox.removeRepeated();
		assertEquals(array.length, numberBox.size());
		for (int number : array)
			numberBox.containsNumber(number);
	}

	@Test
	void testRemoveDividedBy() {
		numberBox.removeDividedBy(2);
		assertEquals(noDividedBy2.length, numberBox.size());
		for (int number : noDividedBy2)
			numberBox.containsNumber(number);
	}

	@Test
	void testSize() {
		assertTrue(numberBox.size() == array.length);
	}

	@Test
	void testRemoveInRange() {
		numberBox.removeInRange(3, 6);
		assertEquals(noInRange3_6.length, numberBox.size());
		for (int number : noInRange3_6)
			numberBox.containsNumber(number);
	}

}
