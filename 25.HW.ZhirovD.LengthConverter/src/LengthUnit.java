
public enum LengthUnit {
	MM(1), CM(10), IN(25.4), FT(304.08), M(1000);
	
	private double value;

	private LengthUnit(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}
	
	public double between(Length l1, Length l2) {
		// HW
	}
}
