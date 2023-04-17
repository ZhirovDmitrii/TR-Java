import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PersonTest {
	Person Moshe = new Person (1, "Moshe");
	Person person = new Person ();
	
	@Test
	@Disabled
	void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	void testPerson() {
//		fail("Not yet implemented");
		person.setId(1);
		person.setName("Moshe");
		assertEquals(Moshe, person);
		assertTrue(Moshe.equals(person));
		
		person.setId(0);
		assertNotEquals(Moshe, person);
		assertFalse(Moshe.equals(person));
	}

	@Test
	void testGetId() {
//		fail("Not yet implemented");
		assertNotNull(Moshe.getId());
		assertNull(person.getId());
	}

	@Test
	void testGetName() {
//		fail("Not yet implemented");
		assertNotNull(Moshe.getName());
		assertNull(person.getName());
		
		assertEquals("Moshe", Moshe.getName());
		assertEquals(1, Moshe.getId());
	}

	@Test
	void testSetName() {
//		fail("Not yet implemented");
		person.setId(1);
		person.setName("Moshe");
		assertEquals(Moshe, person);
		assertTrue(Moshe.equals(person));
	}

	@Test
	void testEqualsObject() {
//		fail("Not yet implemented");
		Person Dima = new Person (1, "Dima");
		Person Dmitrii = new Person (1, "Dima");
		assertEquals(Dima, Dmitrii);
		
		assertNotEquals(Moshe, person);
	}

	@Test
	@Disabled
	void testToString() {
//		fail("Not yet implemented");
	}

}