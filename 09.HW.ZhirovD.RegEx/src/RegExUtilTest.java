import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegExTest {

//	Build regular expressions to extract all integer numbers from sentence
	@Test
	void testTaskA()
	{
		String[] expected = { "3", "25", "888" };
		String regexp = "\\d+";
		String[] actual = RegExUtil.regexPatternMatchStream(regexp,
			"Today during 3 hours we studied 25 tutorial chapters and built 888 expressions");
		assertArrayEquals(expected, actual);
	}

//	Build regular expressions to extract price in dollars from sentence
	@Test
	void testTaskB()
	{
		String[] expected = { "$0.5", "$550,000" };
		String regexp = "\\$(\\d,?)+([.]?\\d+)?";
		String[] actual = RegExUtil.regexPatternMatchStream(regexp, 
				"Pen costs $0.5 , but house costs $550,000");
		assertArrayEquals(expected, actual);
	}

//	Write regular expressions to find the full name (first and last name) of all persons with
//	first name Jacob in sentence
	@Test
	void testTaskC()
	{
		String[] expected = { "Jacob Cohen" };
		String regexp = "Jacob\\s+[A-Z][a-z]*";
		String[] actual = RegExUtil.regexPatternMatchStream(regexp,
				"Abraham  Smith, Jacob Cohen, Peter Jacobson, Meir Jacob");
		assertArrayEquals(expected, actual);
	}

//	Write regular expression to find the full name (first and last name) of all persons with 
//	last name Jacob (exactly!) or Cohen in the same sentence
	@Test
	void testTaskD()
	{
		String[] expected = { "Jacob Cohen", "Meir Jacob" };
		String regexp = "[A-Z][a-z]*\\s+(Jacob|Cohen)\\b";
		String[] actual = RegExUtil.regexPatternMatchStream(regexp,
				"Abraham Smith, Jacob Cohen, Peter Jacobson, Meir Jacob");
		assertArrayEquals(expected, actual);
	}

//	**** 
//	Using a back-reference (like \1) write a regular expression that will
//	match a person's name only if that person's last name begins from his own first name
//	(Ivan Ivanov, Meyer Meyerson, etc.) in sentence
	@Test
	public void testTaskE()
	{
		String[] expected = { "Ivan Ivanov", "Oskar Oskarson", "Peter Peterson" };
		String regexp = "(\\w+)\\s+\\1\\w*";
		String[] actual = RegExUtil.regexPatternMatchStream(regexp,
				"Rachel Simpson, Ivan Ivanov, Oskar Oskarson, Meyer Peterson, Peter Peterson");
		assertArrayEquals(expected, actual);
	}


}