package telran.cars.test;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.cars.dto.Car;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;

class RentCompanyEmbeddedStatisticTest {

	IRentCompany company = new RentCompanyEmbedded(); // create company
	int[] pricesDay = { 100, 100, 100, 100, 1000 };
	int[] birthYears = { 2000, 1995, 1950, 1948 };

	LocalDate fromDate = LocalDate.of(1900, 1, 1);
	LocalDate toDate = LocalDate.of(2500, 1, 1);
	LocalDate rentDate = LocalDate.of(2020, 1, 1);
	
	int rentDays = 5;

	@BeforeEach
	void setUp() throws Exception {
		createAndAddModels();
		createAndAddCars();
		createAndAddDrivers();

		rentsReturns();
	}

	private void rentsReturns() {
		int[] licinses = { 0, 0, 1, 1, 2, 2, 3, 3, 0 }; // number drivers
		String[] regNumbers = {"car0", "car1", "car0", "car1", "car2", "car3", "car2", "car3", "car4"};

		for(int i = 0; i < licinses.length; i++) { // rehNumbers can use too
			company.rentCar(regNumbers[i], licinses[i], rentDate, rentDays);
			company.returnCar(regNumbers[i], licinses[i], rentDate.plusDays(rentDays), 0, 100);
			rentDate = rentDate.plusDays(rentDays+1);
		}
	}

	private void createAndAddDrivers() {
		for (int i = 0; i < birthYears.length; i++) {
			company.addDriver(new Driver(i, "name", birthYears[i], "phone"));
		}
	}

	private void createAndAddCars() {
		for (int i = 0; i < pricesDay.length; i++) {
			company.addCar(new Car("car" + i, "color", "model" + i));
		}
	}

	private void createAndAddModels() {
		for (int i = 0; i < pricesDay.length; i++) {
			company.addModel(new Model("model" + i, 50, "company", "country", pricesDay[i]));
		}
	}

	@Test
	void testGetMostPopularCarMOdels() {
		int ageYoungFrom = rentDate.getYear() - birthYears[0];
		int ageYoungTo = rentDate.getYear() - birthYears[1] + 1;
		
		int ageOldFrom = rentDate.getYear() - birthYears[2];
		int ageOldTo = rentDate.getYear() - birthYears[3] + 1;
		
		List<String> res = company.getMostPopularCarMOdels(fromDate, toDate, ageYoungFrom, ageYoungTo);
		assertEquals(2, res.size());
		assertTrue(res.contains("model0"));
		assertTrue(res.contains("model1"));
		
		res = company.getMostPopularCarMOdels(fromDate, toDate, ageOldFrom, ageOldTo);
		assertEquals(2, res.size());
		assertTrue(res.contains("model2"));
		assertTrue(res.contains("model3"));
	}

	@Test
	void testGetMostProfitableCarModels() {
		List<String> res = company.getMostProfitableCarModels(fromDate, toDate);
		assertEquals(1, res.size());
		assertTrue(res.contains("model4"));
	}

	@Test
	void testGetMostActiveDriver() {
		List<Driver> res = company.getMostActiveDriver();
		assertEquals(1, res.size());
		assertEquals(0, res.get(0).getLicenseId());
	}

}
