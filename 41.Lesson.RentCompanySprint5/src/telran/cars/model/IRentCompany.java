package telran.cars.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import telran.cars.dto.*;

public interface IRentCompany extends Serializable{
	// Sprint 1
	int getGasPrice();
	void setGasPrice(int price);
	int getFinePercent();
	void setFinePercent(int finePercent);
	
	CarsReturnCode addCar(Car car);
	CarsReturnCode addDriver(Driver driver);
	CarsReturnCode addModel(Model model);
	
	Car getCar(String regNumber);
	Model getModel(String modelName);
	Driver getDriver(long licenseId);
	
	// Sprint 2
	CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays);
	List<Car> getCarsByDriver(long licenseId);		// list cars with was rented by driver with this licenseId
	List<Driver> getDriversByCar(String regNumber);	// list drivers which rented car with this regNumber
	List<Car> getCarsByModel(String modelName);		// list cars of model with this modelName
	List<RentRecord> getRentRecordsAtDates(LocalDate fromDate, LocalDate toDate);	// list records, which was rented of period from date to date
	
	// Sprint 3
	RemovedCarData removeCar(String regNumber);
	List<RemovedCarData> removeCarsOfModel(String modelName);
	RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages, int tankPercent);
	// RemovedCarData = {car: Car, List<RentRecord>: null}

	// Sprint 4
	List<String> getMostPopularCarModels(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge);
	List<String> getMostProfitableCarModels(LocalDate fromDate, LocalDate toDate);
	List<Driver> getMostActiveDriver();
	
	// Sprint 5
	List<String> getModelNames();
}
