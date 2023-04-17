import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {
	Integer[] array = {1,2,3,4,4,4,1,20};
	List<Integer> list;

//	======================================================
	
	@BeforeEach
	void setUp() throws Exception {
		list = new ArrayList<>(Arrays.asList(array));
//		list = new LinkedList<>(Arrays.asList(array));	// OK, but not good
	}

//	======================================================
	
	@Test
	void testRemoveNumber() {
//		list.remove(2); FAIL, because '2' this is INDEX, NOT ELEMENT
		
		// Option 1
//		list.remove((Integer)2);		// cast for remove by element
		// Option 2
		((Collection<Integer>)list).remove(2);	// cast by collection
		assertFalse(list.contains(2));
	}
	
	@Test
	void testRemoveAll() {
		list.removeAll(Arrays.asList(1,20,5,6));	// 5 and 6 our array don't have, but it's OK - just ignore
		
		assertFalse(list.contains(1));
		assertFalse(list.contains(20));
	}
	
	@Test
	void testRetainAll() {
		list.retainAll(Arrays.asList(1,4,5,6));
		
		assertTrue(list.contains(1));
		assertTrue(list.contains(4));
		assertFalse(list.contains(20));
	}
	
	@Test
	void testNotSupported() {
		List<Integer> temp = Arrays.asList(1,2,3);	// immutable
		assertEquals(3, temp.size());
		assertTrue(temp.contains(1));
		assertEquals(temp.get(0), 1);
//		temp.add(20);	// false
	}
	
	@Test
	void testSubList() {
		List<Integer> temp = list.subList(1, 4);
		temp.remove((Integer)3);
		assertFalse(list.contains(3));
		
		@SuppressWarnings("unused")
		ArrayList<Integer> second = new ArrayList<>(list.subList(0, 3));
	}
	
	@Test
	void testAdd() {
		assertTrue(list.add(100));
		
		list.add(0, 100);
		assertEquals(100, list.get(0));
	}
	
	@Test
	void testClear() {
		assertFalse(list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	@Test
	void testToArray() {
		Object[] temp = list.toArray();
		assertArrayEquals(temp, array);
		
		@SuppressWarnings("unused")
		Integer[] temp1 = list.toArray(new Integer[0]);
	}

}