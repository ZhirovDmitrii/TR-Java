package telran.cars.model;

@SuppressWarnings("serial")
public abstract class AbstractRentCompany implements IRentCompany{
	protected int finePercent = 15;
	protected int gasPrice = 10;

	public int getGasPrice() {
		return getGasPrice();
	}
	
	public void setGasPrice(int price) {
		this.gasPrice = price;
	}
	
	public int getFinePercent() {
		return finePercent;
	}
	
	public void setFinePercent(int finePercent) {
		this.finePercent = finePercent;
	}
	
	// Sprint 3
	protected double computeCost(int rentPrice, int rentDays, int delay, int tankPercent, int tankVolum) {
		double cost = rentPrice * rentDays;
		
		if(delay > 0) {
			cost += delay * (rentPrice * (1 + (double)finePercent / 100));
		}
		if(tankPercent < 100)
			cost += tankVolum * ((double)(100 - tankPercent) / 100) * gasPrice;
		
		return cost;
	}
}
