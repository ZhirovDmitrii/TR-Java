package repeat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringExpressionTests
{

	@Test
	void testProgrammingName()
	{
		assertTrue(StringExpression.isProgrammingName("abc"));
		assertTrue(StringExpression.isProgrammingName("a"));
		assertTrue(StringExpression.isProgrammingName("a1d"));
		assertTrue(StringExpression.isProgrammingName("a_c"));
		assertTrue(StringExpression.isProgrammingName("aBc"));
		assertTrue(StringExpression.isProgrammingName("Abc"));
		assertTrue(StringExpression.isProgrammingName("_"));
		assertTrue(StringExpression.isProgrammingName("__"));
		
		assertFalse(StringExpression.isProgrammingName(" abc"));
		assertFalse(StringExpression.isProgrammingName("a c"));
		assertFalse(StringExpression.isProgrammingName("ab#c"));
		assertFalse(StringExpression.isProgrammingName("ab+c"));
		assertFalse(StringExpression.isProgrammingName("ab&c"));
		assertFalse(StringExpression.isProgrammingName("1abc"));
	}
	
	@Test
	void testIsPositiveNumberLess1000()
	{
		assertTrue(StringExpression.isPositiveNumberLess1000("1"));
		assertTrue(StringExpression.isPositiveNumberLess1000("11"));
		assertTrue(StringExpression.isPositiveNumberLess1000("111"));
		assertTrue(StringExpression.isPositiveNumberLess1000("999"));
		assertTrue(StringExpression.isPositiveNumberLess1000("0"));
		
		assertFalse(StringExpression.isPositiveNumberLess1000("1000"));
		assertFalse(StringExpression.isPositiveNumberLess1000("-1"));
		assertFalse(StringExpression.isPositiveNumberLess1000("10a"));
		assertFalse(StringExpression.isPositiveNumberLess1000("10-00"));
		assertFalse(StringExpression.isPositiveNumberLess1000("10.00"));
		assertFalse(StringExpression.isPositiveNumberLess1000("10,00"));
		assertFalse(StringExpression.isPositiveNumberLess1000("01"));
	}

	@Test
	void testPositiveNumberLessEquals255()
	{
		assertTrue(StringExpression.isPositiveNumberLessEquals255("1"));
		assertTrue(StringExpression.isPositiveNumberLessEquals255("11"));
		assertTrue(StringExpression.isPositiveNumberLessEquals255("111"));
		assertTrue(StringExpression.isPositiveNumberLessEquals255("255"));
		assertTrue(StringExpression.isPositiveNumberLessEquals255("0"));
		
		assertFalse(StringExpression.isPositiveNumberLessEquals255("256"));
		assertFalse(StringExpression.isPositiveNumberLessEquals255("-16"));
		assertFalse(StringExpression.isPositiveNumberLessEquals255("25.2"));
	}
	
	@Test
	void testIsIPv4()
	{
		assertTrue(StringExpression.isIPv4("1.2.3.4"));
		assertTrue(StringExpression.isIPv4("255.0.13.40"));
		assertTrue(StringExpression.isIPv4("0.0.0.0"));
		assertTrue(StringExpression.isIPv4("255.255.255.255"));

		assertFalse(StringExpression.isIPv4("256.255.255.255"));
		assertFalse(StringExpression.isIPv4("-2.255.255.255"));
		assertFalse(StringExpression.isIPv4("255.255.255.255."));
		assertFalse(StringExpression.isIPv4("255.255.255"));
		assertFalse(StringExpression.isIPv4(".56.255.255.255"));
	}

	@Test
	void emailAddressTest()
	{
		// there must be @
		// before @ maybe any symbols except whitespace and comma
		// after @ may be any letters or digits or dashes
		// email address should ended either .co.il or .mail.ru
		assertTrue(StringExpression.isEmailCoIlMailRu("t%u@12.co.il"));
		assertTrue(StringExpression.isEmailCoIlMailRu("t#u@t.mail.ru"));
		assertTrue(StringExpression.isEmailCoIlMailRu("12_5-6*@y.co.il"));

		assertFalse(StringExpression.isEmailCoIlMailRu("t,u@12.co.il"));// , - disallowed
		assertFalse(StringExpression.isEmailCoIlMailRu("t u@12.co.il"));// space disallowed
		assertFalse(StringExpression.isEmailCoIlMailRu("ttu@1#2.co.il"));// after @ the symbol # disallowed
		assertFalse(StringExpression.isEmailCoIlMailRu("ttu@12.mail1ru"));// neither .co.il nor mail.ru
		assertFalse(StringExpression.isEmailCoIlMailRu("ttu@12co.il"));// neither .co.il nor mail.ru
		assertFalse(StringExpression.isEmailCoIlMailRu("ttu12.co.il"));// no @
		assertFalse(StringExpression.isEmailCoIlMailRu("ttu@1_2.co.il"));// after @ the symbol _ disallowed
	}

	@Test
	void arithmeticExpressionTest()
	{
		// operands (positive integer numbers), operators either with space or no space between
		// Arithmetic operations + * / -
		assertTrue(StringExpression.isArithmeticExpression("2+3 /7"));
		assertTrue(StringExpression.isArithmeticExpression("2"));
		assertTrue(StringExpression.isArithmeticExpression("2*3 /7"));
		assertTrue(StringExpression.isArithmeticExpression(" 2 + 3 / 7"));
		
		assertFalse(StringExpression.isArithmeticExpression("*3 /7"));
		assertFalse(StringExpression.isArithmeticExpression("2..5 +8/2"));// ..
		assertFalse(StringExpression.isArithmeticExpression("2*5 +8#2"));// # isn't code operation
	}
	
	@Test
	void testCheckCreditCardNumber()
	{
		assertTrue(StringExpression.checkCreditCardNumber("12345678"));
		assertTrue(StringExpression.checkCreditCardNumber("1234567890"));
		assertTrue(StringExpression.checkCreditCardNumber("1234567887654321"));

		assertFalse(StringExpression.checkCreditCardNumber("12345678876543210"));
		assertFalse(StringExpression.checkCreditCardNumber("1234567"));
		assertFalse(StringExpression.checkCreditCardNumber("123456780A"));
	}

	@Test
	void testCheckDateFormatEU()
	{
		assertTrue(StringExpression.checkDateFormatEU("25.01.2020"));
		assertTrue(StringExpression.checkDateFormatEU("05.11.2018"));

		assertFalse(StringExpression.checkDateFormatEU("32.12.2020"));
		assertFalse(StringExpression.checkDateFormatEU("12.15.2020"));
		assertFalse(StringExpression.checkDateFormatEU("12/12/2020"));
		assertFalse(StringExpression.checkDateFormatEU("2020.12.15"));
		assertFalse(StringExpression.checkDateFormatEU("2020-12-15"));
		assertFalse(StringExpression.checkDateFormatEU("5.11.2018"));
	}

	@Test
	void testCheckDateFormatUS()
	{
		assertTrue(StringExpression.checkDateFormatUS("2020-12-15"));
		assertTrue(StringExpression.checkDateFormatUS("2020-05-21"));

		assertFalse(StringExpression.checkDateFormatUS("2020-05-32"));
		assertFalse(StringExpression.checkDateFormatUS("2020-15-30"));
		assertFalse(StringExpression.checkDateFormatUS("2020-121-30"));
	}

	
	@Test//**
	void testIsNumber()
	{
		assertTrue(StringExpression.isNumber("0"));
		assertTrue(StringExpression.isNumber("-0"));
		assertTrue(StringExpression.isNumber("1"));
		assertTrue(StringExpression.isNumber("11"));
		assertTrue(StringExpression.isNumber("1111"));
		assertTrue(StringExpression.isNumber("11111111111"));
		assertTrue(StringExpression.isNumber("-1"));
		assertTrue(StringExpression.isNumber("-11"));
		assertTrue(StringExpression.isNumber("-1111"));
		assertTrue(StringExpression.isNumber("-11111111111"));
		assertTrue(StringExpression.isNumber("0.1"));
		assertTrue(StringExpression.isNumber("-0.1"));
		assertTrue(StringExpression.isNumber("1.1"));
		assertTrue(StringExpression.isNumber("-1.1"));
		assertTrue(StringExpression.isNumber("1011.1"));
		assertTrue(StringExpression.isNumber("1111111.1111"));
		
		assertFalse(StringExpression.isNumber("1111111,1111"));
		assertFalse(StringExpression.isNumber("011"));
		assertFalse(StringExpression.isNumber("-011.1111"));
		assertFalse(StringExpression.isNumber("11..1111"));
		assertFalse(StringExpression.isNumber("-11.11.11"));
		assertFalse(StringExpression.isNumber("aaa"));
		assertFalse(StringExpression.isNumber("$1111"));
		assertFalse(StringExpression.isNumber("11 11"));
		assertFalse(StringExpression.isNumber("1111."));
		assertFalse(StringExpression.isNumber("1111-"));
		assertFalse(StringExpression.isNumber("-111-1"));
		assertFalse(StringExpression.isNumber("-.1111"));
	}


}