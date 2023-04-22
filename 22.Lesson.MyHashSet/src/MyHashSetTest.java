import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyHashSetTest {
	MyHashSet<Integer> hs;
	List<Integer> actual = new ArrayList<>(Arrays.asList(2,3,5,7,11,13,17,19));
	List<Integer> temp = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
	List<Integer> temp01 = new ArrayList<>(Arrays.asList(2,3,5));
	
	@BeforeEach
	void setUp() throws Exception
	{
		hs = new MyHashSet<>();
		for(Integer num: actual)
		{
			hs.add(num);
		}
	}
//	============================================
	
	@Test
	void testContains()
	{
		for(Integer num: actual)
		{
			assertTrue(hs.contains(num));
		}
		
		assertFalse(hs.contains(1));
	}

	@Test
	void testToArray()
	{
		Object[] res =hs.toArray();
		assertEquals(res.length, actual.size());
		for(Object num: res){
			assertTrue(actual.contains(num));
		}
	}

	@Test
	void testAdd()
	{
		assertEquals(hs.size(), actual.size());
		assertFalse(hs.add(2));	// we have 2
		assertEquals(hs.size(), actual.size());
		assertTrue(hs.add(1));
		assertEquals(hs.size(), actual.size()+1);
		assertTrue(hs.contains(1));
	}

	@Test
	void testRemove()
	{
		assertFalse(hs.remove(9));
		assertEquals(hs.size(), actual.size());
		assertTrue(hs.remove(5));
		assertEquals(hs.size(), actual.size()-1);
		assertFalse(hs.contains(5));
	}

	@Test
	void testAddAll()
	{
		assertTrue(hs.addAll(temp));
		assertEquals(11, hs.size());
		assertTrue(hs.contains(1));
	}
	
	@Test
	void testRetainAll()
	{
		assertTrue(hs.retainAll(temp));
		assertEquals(3, hs.size());
		assertTrue(hs.contains(2));
		assertFalse(hs.contains(13));
	}

	@Test
	void testRemoveAll()
	{
		assertTrue(hs.removeAll(temp));
		assertEquals(5, hs.size());
		assertTrue(hs.contains(13));
		assertFalse(hs.contains(2));
	}
	
	@Test
	void testContainsAll()
	{
		assertFalse(hs.containsAll(temp));
		assertTrue(hs.containsAll(temp01));
	}
	
	@Test
	void testClear()
	{
		assertFalse(hs.isEmpty());
		hs.clear();
		assertTrue(hs.isEmpty());
	}
}
