import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramTest {

String word = "electricity";
	
	@Test
	void testTrue()
	{
		assertTrue(Anagram.isAnagram(word, "city"));
		assertTrue(Anagram.isAnagram(word, "tric"));
		assertTrue(Anagram.isAnagram(word, "tet"));
		assertTrue(Anagram.isAnagram(word, "electric"));
	}

	@Test
	void testFalse()
	{
		assertFalse(Anagram.isAnagram(word, "select"));
		assertFalse(Anagram.isAnagram(word, "ellect"));
		assertFalse(Anagram.isAnagram(word, "tel e"));
		assertFalse(Anagram.isAnagram(word, "teeel"));
	}

}
