import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WeigthUnitsTest
{

	@Test
	void testConvert()
	{
		assertEquals(1000, WeightUnits.TN.convert(WeightUnits.KG), 0.1);
		assertEquals(0.001, WeightUnits.KG.convert(WeightUnits.TN), 0.001);
	}
	
	@Test
	void testGetGramAmount()
	{
		assertEquals(453.592, WeightUnits.LBS.getGramAmount(), 0.001);
	}
	
	@Test
	void testConvertAmount()
	{
		assertEquals(15000, WeightUnits.TN.convert(WeightUnits.KG, 15), 0.1);
		assertEquals(1, WeightUnits.KG.convert(WeightUnits.TN, 1000), 0.001);
	}
	
	@Test
	void testStaticConvertAmount()
	{
		assertEquals(15000, WeightUnits.convert(15, WeightUnits.TN, WeightUnits.KG), 0.1);
		assertEquals(1, WeightUnits.convert(1000, WeightUnits.KG, WeightUnits.TN), 0.001);
	}

}