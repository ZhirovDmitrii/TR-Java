
public enum WeightUnits {
	GR(1), KG(1000), TN(1_000_000), LBS(453.592);
	
	double gramAmount;
	
	private WeightUnits(double gramAmount) {
		this.gramAmount = gramAmount;
	}
	
	public double convert(WeightUnits other) {
		return gramAmount / other.gramAmount;
	}
	
	public double convert(WeightUnits other, double amount) {
		return gramAmount / other.gramAmount * amount;
	}
	
	public static double convert(double amount, WeightUnits first, WeightUnits second) {
		return first.gramAmount / second.gramAmount * amount;
	}
	
	public double getGramAmount() {
		return gramAmount;
	}
}
