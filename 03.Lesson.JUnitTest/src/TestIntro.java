
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class TestIntro {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before all");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After all");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before each");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After each");
	}

	@Test
	@Disabled
	void testEquals() {
//		fail("Not yet implemented");
		System.out.println("Test equals");
		
		assertEquals(4, 2+2);
		assertEquals("Hello world", "Hello " + "world");
		assertNotEquals(5, 2+2);
		assertNotEquals("Hello world", "Hello" + "world");
	}
	
	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	void testBoolean()
	{
		System.out.println("Test boolean");
		
//		assertTrue(2+2==4);
		assertFalse(2+2==5);
	}

	@Test
	void testNull()
	{
		System.out.println("Test null");
		assertNull(null);
		assertNotNull("");
	}
	
	@Test
	void testSame()
	{
		System.out.println("Test same");
		
		String str = new String("Hello");
		String str1 = new String("Hello");
		String str2 = str;
		
		assertEquals(str, str1);
		assertEquals(str, str2);
		
//		assertSame(str, str1);		// Will error
		assertNotSame(str, str1);	// check link
		assertSame(str, str2);		// check link
	}
}