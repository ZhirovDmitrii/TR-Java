package telran.cars.model;

import java.io.Serializable;

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
}
