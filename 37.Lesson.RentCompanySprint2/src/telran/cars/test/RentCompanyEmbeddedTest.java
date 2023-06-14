package telran.cars.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.dto.RentRecord;
import telran.cars.model.RentCompanyEmbedded;

class RentCompanyEmbeddedTest {
	private static final String MODEL_NAME = "BMW X5";
	private static final int GAS_TANK = 85;
	private static final int PRICE_DAY = 1000;
	private static final String COMPANY = "BMW";
	private static final String COUNTRY = "Germany";
	private static final String REG_NUMBER = "123";
	private static final long LICENSE_ID = 123;
	
	private static final String FILE_NAME = "company.data";
	
	static Car car = new Car(REG_NUMBER, "color", MODEL_NAME);
	static Model model = new Model(MODEL_NAME, GAS_TANK, COMPANY, COUNTRY, PRICE_DAY);
	static Driver driver = new Driver(LICENSE_ID, "name", 2000, "222333222214875");
	
//	Sprint2
	private static final int RENT_DAYS = 5;
	private static final int YEAR = 2018;
	private static final int MONTH = 12;
	private static final int DAY = 2;
	private static final LocalDate RENT_DATE = LocalDate.of(YEAR, MONTH, DAY);

	
	static RentCompanyEmbedded company;

	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		company = new RentCompanyEmbedded();
		company.addModel(model);
		company.addCar(car);
		company.addDriver(driver);
		company.rentCar(REG_NUMBER, LICENSE_ID, RENT_DATE, RENT_DAYS);
		company.save(FILE_NAME);
	}

	@BeforeEach
	void setUp() throws Exception
	{
		company = RentCompanyEmbedded.restoreFromFile(FILE_NAME);
	}

	@Test
	public void testGets()
	{
		Model actualModel = company.getModel(MODEL_NAME);
		assertEquals(model, actualModel);
		Car actualCar = company.getCar(REG_NUMBER);
		assertEquals(car, actualCar);
		Driver actualDriver = company.getDriver(LICENSE_ID);
		assertEquals(driver, actualDriver);
	}

	@Test
	public void testAddCar()
	{
		// fact of real adding is tested in testGets
		// this test for testing return codes
		Car newCar = new Car(REG_NUMBER, "red", MODEL_NAME);
		assertEquals(CarsReturnCode.CAR_EXISTS, company.addCar(newCar));
		newCar = new Car(REG_NUMBER + 111, "red", MODEL_NAME + "***");
		assertEquals(CarsReturnCode.NO_MODEL, company.addCar(newCar));
		newCar = new Car(REG_NUMBER + 111, "red", MODEL_NAME);
		assertEquals(CarsReturnCode.OK, company.addCar(newCar));
	}

	@Test
	public void testAddModel()
	{
		assertEquals(CarsReturnCode.MODEL_EXISTS, company.addModel(model));
		Model newModel = new Model(MODEL_NAME + "***", 50, "company", "country", 500);
		assertEquals(CarsReturnCode.OK, company.addModel(newModel));
	}

	@Test
	public void testDriver()
	{
		assertEquals(CarsReturnCode.DRIVER_EXISTS, company.addDriver(driver));
		Driver newDriver = new Driver(LICENSE_ID + 10, "name", 1980, "12345");
		assertEquals(CarsReturnCode.OK, company.addDriver(newDriver));
	}
	
	public void rentCarTest()
	{
		assertEquals(CarsReturnCode.NO_CAR, company.rentCar(REG_NUMBER+"111", LICENSE_ID, RENT_DATE, RENT_DAYS));
		assertEquals(CarsReturnCode.CAR_IN_USE, company.rentCar(REG_NUMBER, LICENSE_ID, RENT_DATE, RENT_DAYS));
		
		Car car1 = new Car(REG_NUMBER+1, "red", MODEL_NAME);
		company.addCar(car1);
		
		assertEquals(CarsReturnCode.NO_DRIVER, company.rentCar(REG_NUMBER+1, LICENSE_ID+1, RENT_DATE, RENT_DAYS));
		car1.setFlRemoved(true);
		assertEquals(CarsReturnCode.CAR_REMOVED, company.rentCar(REG_NUMBER+1, LICENSE_ID, RENT_DATE,	RENT_DAYS));
	}

	
	@Test
	public void getRentRecordsTest()
	{
		RentRecord expected = new RentRecord(REG_NUMBER, LICENSE_ID, RENT_DATE, RENT_DAYS);
		List<RentRecord> records = company.getRentRecordsAtDates(RENT_DATE, RENT_DATE.plusDays(RENT_DAYS));
		assertEquals(1, records.size());
		assertEquals(expected, records.get(0));
		records = company.getRentRecordsAtDates(RENT_DATE.minusDays(1), RENT_DATE);
		assertTrue(records.isEmpty());

	}

	@Test
	public void getCarsDriverTest()
	{
		List<Car> cars = company.getCarsByDriver(LICENSE_ID);
		assertEquals(1, cars.size());		
		assertEquals(car, cars.get(0));
		cars = company.getCarsByDriver(LICENSE_ID + 100);
		assertTrue(cars.isEmpty());
	}

	@Test
	public void getDriversCarTest()
	{
		List<Driver> drivers = company.getDriversByCar(REG_NUMBER);
		assertEquals(1, drivers.size());
		assertEquals(driver, drivers.get(0));
		drivers = company.getDriversByCar(REG_NUMBER + "111");
	}

	@Test
	public void getModelCars()
	{
		List<Car> cars = company.getCarsByModel(MODEL_NAME);
		assertTrue(cars.isEmpty());// car1 is in use
		Car car2 = new Car(REG_NUMBER + "111", "green", MODEL_NAME);
		company.addCar(car2);
		cars = company.getCarsByModel(MODEL_NAME);
		assertEquals(1, cars.size());
		assertEquals(car2, cars.get(0));
		cars = company.getCarsByModel(MODEL_NAME + "YYY");
		assertTrue(cars.isEmpty());// model doesn't exist
	}

}
