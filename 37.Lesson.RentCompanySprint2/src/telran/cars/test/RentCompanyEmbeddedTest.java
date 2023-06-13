package telran.cars.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
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
	static Driver driver = new Driver(LICENSE_ID, "name", GAS_TANK, "222333222214875");
	
	static RentCompanyEmbedded company;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {	
		company = new RentCompanyEmbedded();
		company.addModel(model);
		company.addCar(car);
		company.addDriver(driver);
		company.save(FILE_NAME);
	}


	@BeforeEach
	void setUp() throws Exception {
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
	
	@Test
	public void testRentCar() {	
		assertEquals(CarsReturnCode.NO_CAR, company.rentCar(REG_NUMBER + "1", LICENSE_ID, LocalDate.now(), 5));
		
		assertEquals(CarsReturnCode.NO_DRIVER, company.rentCar(REG_NUMBER, LICENSE_ID + 1, LocalDate.now(), 5));
	
		// not now. don't have functional 
//		car.setFlRemoved(true);
//		assertEquals(CarsReturnCode.CAR_REMOVED, company.rentCar(REG_NUMBER, LICENSE_ID, LocalDate.now(), 5));
//		car.setFlRemoved(false);
		
		assertEquals(CarsReturnCode.OK, company.rentCar(REG_NUMBER, LICENSE_ID, LocalDate.now(), 5));
	
		assertEquals(CarsReturnCode.CAR_IN_USE, company.rentCar(REG_NUMBER, LICENSE_ID, LocalDate.now(), 5));
	}

}
