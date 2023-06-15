package telran.cars.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import telran.cars.dto.Car;
import telran.cars.dto.CarsReturnCode;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.dto.RemovedCarData;
import telran.cars.dto.RentRecord;
import telran.cars.dto.State;
import telran.cars.utils.Persistable;

@SuppressWarnings("serial")
public class RentCompanyEmbedded extends AbstractRentCompany implements Persistable {
	private static final int REMOVE_THRESHOLD = 60;
	private static final int BAD_THRESHOLD = 30;
	private static final int GOOD_THRESHOLD = 10;

	// ===== Sprint 1 fields =====
	HashMap<String, Car> cars = new HashMap<>();
	HashMap<Long, Driver> drivers = new HashMap<>();
	HashMap<String, Model> models = new HashMap<>();

//	===== Sprint 2 fields =====
	TreeMap<LocalDate, List<RentRecord>> records = new TreeMap<>();
	HashMap<String, List<RentRecord>> carRecords = new HashMap<>(); // regNumber - key
	HashMap<Long, List<RentRecord>> driverRecords = new HashMap<>(); // licenseId - key
	HashMap<String, List<Car>> modelCars = new HashMap<>(); // modelName - key

//	===== Sprint 1 =====
	@Override
	public CarsReturnCode addCar(Car car) {
		// Sprint 1
		if (!models.containsKey(car.getModelName()))
			return CarsReturnCode.NO_MODEL;

		boolean res = cars.putIfAbsent(car.getRegNumber(), car) == null;
		if (!res) {
			return CarsReturnCode.CAR_EXISTS;
		}

		// Sprint 2
		addToModelCars(car);

		return CarsReturnCode.OK;
	}

	// Sprint 2
	private void addToModelCars(Car car) {
		String modelName = car.getModelName(); // get model name

		List<Car> list = modelCars.getOrDefault(modelName, new ArrayList<>()); // check if car with this model name
																				// exist, OR return empty list for added
																				// this model
		list.add(car); // and add to list

		modelCars.putIfAbsent(modelName, list); // if model not exist - put this car in new model, or add in old model
	}

	@Override
	public CarsReturnCode addDriver(Driver driver) {
		return drivers.putIfAbsent(driver.getLicenseId(), driver) == null ? CarsReturnCode.OK
				: CarsReturnCode.DRIVER_EXISTS;
	}

	@Override
	public CarsReturnCode addModel(Model model) {
		return models.putIfAbsent(model.getModelName(), model) == null ? CarsReturnCode.OK
				: CarsReturnCode.MODEL_EXISTS;
	}

	@Override
	public Car getCar(String regNumber) {
		return cars.get(regNumber);
	}

	@Override
	public Model getModel(String modelName) {
		return models.get(modelName);
	}

	@Override
	public Driver getDriver(long licenseId) {
		return drivers.get(licenseId);
	}

	@Override
	public void save(String fileName) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(this);
		} catch (Exception e) {
			System.out.println("Error in method save " + e.getMessage());
		}
	}

	public static RentCompanyEmbedded restoreFromFile(String fileName) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			return (RentCompanyEmbedded) in.readObject();
		} catch (Exception e) {
			return new RentCompanyEmbedded();
		}
	}

//	===== Sprint 2 =====

	@Override
	public CarsReturnCode rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
		Car car = getCar(regNumber);
		if (car == null) {
			return CarsReturnCode.NO_CAR;
		}
		if (car.isFlRemoved()) {
			return CarsReturnCode.CAR_REMOVED;
		}
		if (car.inUse()) {
			return CarsReturnCode.CAR_IN_USE;
		}

		if (!drivers.containsKey(licenseId)) {
			return CarsReturnCode.NO_DRIVER;
		}

		RentRecord record = new RentRecord(regNumber, licenseId, rentDate, rentDays);
		addToCarRecords(record);
		addToDriverRecords(record);
		addToRecord(record);

		car.setUse(true);

		return CarsReturnCode.OK;
	}

	private void addToRecord(RentRecord record) {
		LocalDate date = record.getRentDate();
		List<RentRecord> list = records.getOrDefault(date, new ArrayList<>());
		list.add(record);

		records.putIfAbsent(date, list);
	}

	private void addToDriverRecords(RentRecord record) {
		long licenseId = record.getLicenseId();
		List<RentRecord> list = driverRecords.getOrDefault(licenseId, new ArrayList<>());
		list.add(record);

		driverRecords.putIfAbsent(licenseId, list);
	}

	private void addToCarRecords(RentRecord record) {
		String regNumber = record.getRegNumber();
		List<RentRecord> list = carRecords.getOrDefault(regNumber, new ArrayList<>());
		list.add(record);

		carRecords.putIfAbsent(regNumber, list);

	}

	@Override
	public List<Car> getCarsByDriver(long licenseId) {
		List<RentRecord> list = driverRecords.getOrDefault(licenseId, new ArrayList<>());
		return list.stream().map(rr -> getCar(rr.getRegNumber())).distinct().toList();
	}

	@Override
	public List<Driver> getDriversByCar(String regNumber) {
		List<RentRecord> list = carRecords.getOrDefault(regNumber, new ArrayList<>());
		return list.stream().map(rr -> getDriver(rr.getLicenseId())).distinct().toList();
	}

	@Override
	public List<Car> getCarsByModel(String modelName) {
		List<Car> list = modelCars.getOrDefault(modelName, new ArrayList<>());
		return list.stream().filter(c -> !c.inUse() && !c.isFlRemoved()).toList();
	}

	@Override
	public List<RentRecord> getRentRecordsAtDates(LocalDate fromDate, LocalDate toDate) {
		// 1.1.2000 -> {rr1, rr2, rr3}
		// 2.1.2000 -> {rr1}
		// 5.1.2000 -> {rr1, rr2}
		// all lists need convert to 1 list with dates
		Collection<List<RentRecord>> col = records.subMap(fromDate, toDate).values();
		return col.stream().flatMap(l -> l.stream()).toList(); // collection {}{}{}{}{} -> {}
	}

//	===== Sprint 3 =====

	@Override
	public RemovedCarData removeCar(String regNumber) {
		Car car = getCar(regNumber);
		if (car == null) {
			return null;
		}
		car.setFlRemoved(true); // flag - if i want remove car this flag just for information
		return car.inUse() ? new RemovedCarData(car, null) : actualCarRemove(car);
	}

	private RemovedCarData actualCarRemove(Car car) {
		String regNumber = car.getRegNumber();

		// delete all information from archive
		List<RentRecord> list = carRecords.get(regNumber);
		carRecords.remove(regNumber); // delete from all maps

		// and delete car
		cars.remove(regNumber);

		removeFromDriverRecords(list);
		removeFromRecords(list);
		removeFromModelCars(car);

		return new RemovedCarData(car, list);
	}

	private void removeFromModelCars(Car car) {
		modelCars.get(car.getModelName()).remove(car);
	}

	private void removeFromRecords(List<RentRecord> list) {
		list.forEach(rr -> records.get(rr.getRentDate()).remove(rr));
	}

	private void removeFromDriverRecords(List<RentRecord> list) {
		list.forEach(rr -> driverRecords.get(rr.getLicenseId()).remove(rr)); // all records by driver who get this
																				// removedCar
		// list -> rr{id=1, regN = 1}, rr{id=2, regN=1}, rr{id=3, regN=1}
		// {id=1, car=5}, {id=1, car=1}, {id=1, car=20}
		// remove -> {id=1, car=5}, {id=1, car=20}
	}

	@Override
	public List<RemovedCarData> removeCarsOfModel(String modelName) {
		List<Car> list = modelCars.get(modelName);
		if (list != null) {
//			models.remove(modelName);
			return list.stream().map(c -> removeCar(c.getRegNumber())).toList();
		}

		return new ArrayList<>();
	}

	@Override
	public RemovedCarData returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages,
			int tankPercent) {
		RentRecord record = driverRecords.get(licenseId).stream()
				.filter(rr -> rr.getRegNumber().equals(regNumber) 
						&& rr.getRentDate() == null) // don't return from use
				.findFirst().orElse(null);

		// if this driver don't get a car or get, BUT return
		if (record == null) {
			return null;
		}

		// update record
		updateRecord(record, returnDate, damages, tankPercent);

		// now update information our car
		Car car = getCar(regNumber);
		updateCar(car, damages);

		return car.isFlRemoved() == true || damages > REMOVE_THRESHOLD ? actualCarRemove(car)
				: new RemovedCarData(car, null);
	}

	private void updateCar(Car car, int damages) {
		car.setUse(false);
		if(damages >= BAD_THRESHOLD) {
			car.setState(State.BAD);
		}
		else if(damages >= GOOD_THRESHOLD) {
			car.setState(State.GOOD);
		}
	}

	private void updateRecord(RentRecord record, LocalDate returnDate, int damages, int tankPercent) {
		record.setDamages(damages);
		record.setReturnDate(returnDate);
		record.setTankPercent(tankPercent);
		
		// double cost = priceDay * rentDays + delay(delayDays * delayPercent) + costTank
		double cost = computeCost(getRentPrice(record.getRegNumber()), 
				record.getRentDays(), 
				getDelay(record), 
				tankPercent, 
				getTankVolum(record.getRegNumber()));
		
		record.setCost(cost);
	}

	private int getTankVolum(String regNumber) {
		String modelName = cars.get(regNumber).getModelName();
		return models.get(modelName).getGasTank();
	}

	private int getDelay(RentRecord record) {
		long realDays = ChronoUnit.DAYS.between(record.getRentDate(), record.getReturnDate());
		int delta = (int) (realDays - record.getRentDays());
		return delta < 0 ? 0 : delta;
	}

	private int getRentPrice(String regNumber) {
		String modelName = cars.get(regNumber).getModelName();
		return models.get(modelName).getPriceDay();
	}
}
