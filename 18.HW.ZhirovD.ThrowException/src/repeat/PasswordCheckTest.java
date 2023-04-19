package repeat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PasswordCheckTest
{
	@Test
	void rightPassword() throws IllegalPasswordException
	{
		PasswordCheck.check("12%AbcD7u");
		PasswordCheck.check("12*AbcD7u");
	}

	@Test
	void testWrongLength()
	{
		String[] expected = {PasswordCheck.WRONG_LENGTH_MESSAGE};
		try
		{
			PasswordCheck.check("12%Abc");
			fail("no exception");
		} catch (IllegalPasswordException e)
		{
			assertArrayEquals(expected, e.getMessages());
		}
	}

	@Test
	void testNoSpecSymbol()
	{
		String[] expected = {PasswordCheck.NO_SPEC_SYMBOL_MESSAGE};
		try
		{
			PasswordCheck.check("12Abc345");
			fail("no exception");
		} catch (IllegalPasswordException e)
		{
			assertArrayEquals(expected, e.getMessages());
		}
	}

	@Test
	void testNoDigit()
	{
		String[] expected = {PasswordCheck.NO_DIGIT_MESSAGE};
		try
		{
			PasswordCheck.check("Abc*Ut**");
			fail("no exception");
		} catch (IllegalPasswordException e)
		{
			assertArrayEquals(expected, e.getMessages());
		}
	}

	@Test
	void testNoUpperCase()
	{
		String[] expected = {PasswordCheck.NO_UPPER_CASE_MESSAGE};
		try
		{
			PasswordCheck.check("12abc$345");
			fail("no exception");
		} catch (IllegalPasswordException e)
		{
			assertArrayEquals(expected, e.getMessages());
		}
	}

	@Test
	void testNoLowerCase()
	{
		String[] expected = {PasswordCheck.NO_LOWER_CASE_MESSAGE};
		try
		{
			PasswordCheck.check("12ABC$345");
			fail("no exception");
		} catch (IllegalPasswordException e)
		{
			assertArrayEquals(expected, e.getMessages());
		}
	}

	@Test
	void testWrongSymbol()
	{
		String[] expected = {PasswordCheck.WRONG_SYMBOL_MESSAGE};
		try
		{
			PasswordCheck.check("12ABC$3 45");
			fail("no exception");
		} catch (IllegalPasswordException e)
		{
			assertArrayEquals(expected, e.getMessages());
		}
	}

	@Test
	void testAllTogether()
	{
		String[] expected = 
			{
		        PasswordCheck.NO_LOWER_CASE_MESSAGE, 
		        PasswordCheck.NO_DIGIT_MESSAGE,
		        PasswordCheck.NO_SPEC_SYMBOL_MESSAGE
		    };
		try
		{
			PasswordCheck.check("AAAAAAAAAAA");
			fail("no exception");
		} catch (IllegalPasswordException e)
		{
			assertArrayEquals(expected, e.getMessages());
		}
	}
}