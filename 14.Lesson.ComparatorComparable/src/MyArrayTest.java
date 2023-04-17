
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyArrayTest {

	// Fields for tests
	IArray<Integer> numbers;
	IArray<String> strings;
	MyArray<Integer> other;
	
	Integer[] arNumbers = { 10, 7, 11, -2, 13, 10, 2000 };
	String[] arStrings = { "abc", "lmn", "qwerty", "abc" };
//	====================================================

	@BeforeEach
	void setUp() throws Exception {
		numbers = new MyArray<Integer>(); // 16
		// fill array
		for (int i = 0; i < arNumbers.length; i++) {
			numbers.add(arNumbers[i]);
		}

		// =======

		strings = new MyArray<String>(1);
		// fill array
		for (int i = 0; i < arStrings.length; i++) {
			strings.add(arStrings[i]);
		}
		
		// =======
		
		other = new MyArray<>();
		other.add(100);
		other.add(200);
	}
//	====================================================

	@Test
	void testAddGetSize() {
		int sizeNumbers = numbers.size(); // 7
		int sizeStrings = strings.size(); // 4

		// check true
		assertEquals(arNumbers.length, sizeNumbers);
		assertEquals(arStrings.length, sizeStrings);
		// Not assertArrayEquals because our MyArray - is Object!!!

		// check that all elements from array == elements from MyArray
		for (int i = 0; i < sizeNumbers; i++) {
			assertEquals(numbers.get(i), arNumbers[i]);
		}

		for (int i = 0; i < sizeStrings; i++) {
			assertEquals(strings.get(i), arStrings[i]);
		}
	}

	@Test
	void testIndexOf() {
		assertEquals(0, numbers.indexOf(10));
		assertEquals(6, numbers.indexOf(2000));
		assertEquals(-1, numbers.indexOf(100));

		assertEquals(0, strings.indexOf("abc"));
		assertEquals(-1, strings.indexOf("abcd"));
	}

	@Test
	void testRemoveAtIndex() {
		Integer[] actual = { 10, 7, -2, 13, 10, 2000 }; // remove at index 2

		assertNull(numbers.remove(100));

		assertEquals(11, numbers.remove(2));
		assertEquals(numbers.size(), actual.length);
		for (int i = 0; i < actual.length; i++) {
			assertEquals(numbers.get(i), actual[i]);
		}
	}

	@Test
	void testRemoveObject() {
		Integer[] actual = { 10, 7, -2, 13, 10, 2000 }; // remove at index 2

		assertTrue(numbers.remove((Integer) 11));

		assertEquals(numbers.size(), actual.length);

		for (int i = 0; i < actual.length; i++) {
			assertEquals(numbers.get(i), actual[i]);
		}
	}

	@Test
	void addByIndex() {
		String[] actual = { "abc", "lmn", "dima", "qwerty", "abc" }; // add 2 index

		assertTrue(strings.add(2, "dima"));

		for (int i = 0; i < actual.length; i++) {
			assertEquals(strings.get(i), actual[i]);
		}

//		assertFalse(strings.add(2, 1));	// but 1 - it's integer, not string!
	}

	@Test
	void testContains() {
		assertTrue(strings.contains("qwerty"));
		assertFalse(strings.contains("dima"));

		assertTrue(numbers.contains(10));
		assertFalse(numbers.contains(-1));
	}

	@Test
	void testLastIndexOf() {
		assertEquals(5, numbers.lastIndexOf(10));
		assertEquals(-1, numbers.lastIndexOf(-1));
		assertNotEquals(5, numbers.lastIndexOf(13));

		assertEquals(2, strings.lastIndexOf("qwerty"));
		assertEquals(-1, strings.lastIndexOf(null));
	}

	@Test
	void testToArray() {
		assertArrayEquals(arNumbers, numbers.toArray());
		assertArrayEquals(arStrings, strings.toArray());
	}

	@Test
	void testSet() {
		assertTrue(strings.set("dima", 2));

		assertTrue(numbers.set(200, 6));
	}

	@Test
	void testAddAll() {
		Integer[] arExpected = { 10, 7, 11, -2, 13, 10, 2000, 100, 200};

		numbers.addAll(other);
		assertArrayEquals(arExpected, numbers.toArray());
	}
	
	@Test
	void testRemoveAll()
	{
		Integer[] arNumbers = {7, 11, -2, 13, 2000};
		assertTrue(numbers.removeAll(10));
		assertFalse(numbers.removeAll(1000));
		assertArrayEquals(numbers.toArray(), arNumbers);
		
		String[] arString = {"lmn", "qwerty"};
		assertTrue(strings.removeAll("abc"));
		assertFalse(strings.removeAll("ABC"));
		assertArrayEquals(strings.toArray(), arString);
	}
	
	@Test
	void addAllAtIndexTest()
	{
		Integer[] arExpected = {10, 7, 11, 100, 200, -2, 13, 10, 2000};
		numbers.addAll(3, other);
		assertArrayEquals(arExpected, numbers.toArray());
	}
	
//	=========================================================
	
	@Test
	void testSort()
	{
		numbers.sort(new ReverseNumberComporator());
		System.out.println(Arrays.toString(numbers.toArray()));
		
		strings.sort(new SimpleStringComporator());
		System.out.println(Arrays.toString(strings.toArray()));
		
		strings.sort(new LengthStringComporator());
		System.out.println(Arrays.toString(strings.toArray()));
	}
}