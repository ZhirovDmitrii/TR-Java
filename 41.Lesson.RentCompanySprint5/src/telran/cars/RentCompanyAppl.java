package telran.cars;

import telran.cars.cli.SaveAndExitItem;
import telran.cars.cli.clerk.AddDriverItem;
import telran.cars.cli.clerk.GetCarsByModelItem;
import telran.cars.cli.clerk.RentCarItem;
import telran.cars.cli.clerk.ReturnCarItem;
import telran.cars.cli.driver.GetCarItem;
import telran.cars.cli.driver.GetCarsByDriverItem;
import telran.cars.cli.driver.GetDriverItem;
import telran.cars.cli.manager.AddCarItem;
import telran.cars.cli.manager.AddModelItem;
import telran.cars.cli.manager.RemoveCarItem;
import telran.cars.cli.manager.RemoveModelItem;
import telran.cars.cli.statist.GetMostActiveDriversItem;
import telran.cars.cli.statist.GetMostPopularModelsItem;
import telran.cars.cli.statist.GetMostProfitableModelsItem;
import telran.cars.cli.technician.GetRentRecordsAtDatesItem;
import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;
import telran.view.ConsoleInputOutput;
import telran.view.ExitItem;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;
import telran.view.SubMenuItem;

public class RentCompanyAppl {
	private static final String COMPANY_FILE = "company.data";
	
	static IRentCompany company;
	static InputOutput inOut = new ConsoleInputOutput();
	
	public static void main(String[] args) {
		company = RentCompanyEmbedded.restoreFromFile(COMPANY_FILE);
		
		Menu menu = new Menu(getMainMenuItems(), inOut);
		menu.runMenu();
	}

	private static Item[] getMainMenuItems() {
		Item[] res = {
				new SubMenuItem("Manager", inOut, getManagerMenuItems()),
				new SubMenuItem("Clerk", inOut, getClerkMenuItems()),
				new SubMenuItem("Driver", inOut, getDriverMenuItems()),
				new SubMenuItem("Statist", inOut, getStatistMenuItems()),
				new SubMenuItem("Technician", inOut, getTechniciankMenuItems()),
				new SaveAndExitItem(inOut, company, COMPANY_FILE),
				new ExitItem()
		};
		
		return res;
	}

	private static Item[] getTechniciankMenuItems() {
		Item[] res = {
				new GetRentRecordsAtDatesItem(inOut, company),
				new ExitItem()
		};
		
		return res;
	}

	private static Item[] getStatistMenuItems() {
		Item[] res = {
				new GetMostActiveDriversItem(inOut, company),
				new GetMostPopularModelsItem(inOut, company),
				new GetMostProfitableModelsItem(inOut, company),
				new ExitItem()
		};
		
		return res;
	}

	private static Item[] getDriverMenuItems() {
		Item[] res = {
				new GetCarItem(inOut, company),
				new GetDriverItem(inOut, company),
				new GetCarsByDriverItem(inOut, company),
				new GetDriverItem(inOut, company),
				new ExitItem()
		};
		
		return res;
	}

	private static Item[] getClerkMenuItems() {
		Item[] res = {
			new AddDriverItem(inOut, company),
			new GetCarsByModelItem(inOut, company),
			new RentCarItem(inOut, company),
			new ReturnCarItem(inOut, company),
			new ExitItem()
		};
		
		return res;
	}

	private static Item[] getManagerMenuItems() {
		Item[] res = {
				new AddModelItem(inOut, company),
				new AddCarItem(inOut, company),
				new RemoveCarItem(inOut, company),
				new RemoveModelItem(inOut, company),
				new ExitItem()
		};
		
		return res;
	}

}
