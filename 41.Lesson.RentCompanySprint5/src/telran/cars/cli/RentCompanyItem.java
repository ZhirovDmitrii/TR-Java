package telran.cars.cli;

import telran.cars.model.IRentCompany;
import telran.view.InputOutput;
import telran.view.Item;

public abstract class RentCompanyItem implements Item{
	protected  InputOutput inOut;
	protected IRentCompany company;
	protected String format = "dd.MM.yyyy";
	
	public RentCompanyItem(InputOutput inOut, IRentCompany company) {
		super();
		this.inOut = inOut;
		this.company = company;
	}
	

	public String getRegNumberIfNotExist() {
		String regNumber = inOut.inputString("Enter new registration number");
		if(regNumber == null)
			return null;
		
		if(company.getCar(regNumber) != null) {
			inOut.output("Car is already exists");
			return null;
		}
		
		return regNumber;
	}
	
	public Long getLicenseIdIfNotExists() {
		Long licenseId = inOut.inputLong("Enter license ID");
		if(licenseId == null)
			return null;
		
		if(company.getDriver(licenseId) != null) {
			inOut.outputLine("Driver is already exists");
			return null;
		}
		
		return licenseId;
	}
	
	public String getRegNumberIfExist() {
		String regNumber = inOut.inputString("Enter new registration number");
		if(regNumber == null)
			return null;
		
		if(company.getCar(regNumber) == null) {
			inOut.output("Car is not exists");
			return null;
		}
		
		return regNumber;
	}
	
	public Long getLicenseIdIfExists() {
		Long licenseId = inOut.inputLong("Enter license ID");
		if(licenseId == null)
			return null;
		
		if(company.getDriver(licenseId) == null) {
			inOut.outputLine("Driver is not exists");
			return null;
		}
		
		return licenseId;
	}
}
