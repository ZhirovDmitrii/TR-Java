package telran.cars.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.utils.Persistable;

@SuppressWarnings("serial")
public class RentCompanyEmbedded extends AbstractRentCompany implements Persistable
{
	HashMap<String, Car> cars = new HashMap<>();
	HashMap<Long, Driver> drivers = new HashMap<>();
	HashMap<String, Model> models = new HashMap<>();

	@Override
	public CarsReturnCode addCar(Car car)
	{
		if(!models.containsKey(car.getModelName()))
			return CarsReturnCode.NO_MODEL;
		return cars.putIfAbsent(car.getRegNumber(), car) == null ? CarsReturnCode.OK: CarsReturnCode.CAR_EXISTS;
	}

	@Override
	public CarsReturnCode addDriver(Driver driver)
	{
		return drivers.putIfAbsent(driver.getLicenseId(), driver) == null ? CarsReturnCode.OK : CarsReturnCode.DRIVER_EXISTS;
	}

	@Override
	public CarsReturnCode addModel(Model model)
	{
		return models.putIfAbsent(model.getModelName(), model) == null ? CarsReturnCode.OK : CarsReturnCode.MODEL_EXISTS;
	}

	@Override
	public Car getCar(String regNumber)
	{
		return cars.get(regNumber);
	}

	@Override
	public Model getModel(String modelName)
	{
		return models.get(modelName);
	}

	@Override
	public Driver getDriver(long licenseId)
	{
		return drivers.get(licenseId);
	}

	@Override
	public void save(String fileName)
	{
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			out.writeObject(this);
		} catch (Exception e)
		{
			System.out.println("Error in method save " + e.getMessage());
		}
	}
	
	public static RentCompanyEmbedded restoreFromFile(String fileName)
	{
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)))
		{
			return (RentCompanyEmbedded) in.readObject();
		} catch (Exception e)
		{
			return new RentCompanyEmbedded();
		}
	}

}
