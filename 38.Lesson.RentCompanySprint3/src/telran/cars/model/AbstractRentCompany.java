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
}
