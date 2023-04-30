
public enum LengthUnit {
	MM(1), CM(10), IN(25.4), FT(304.08), M(1000);

	private double value;

	private LengthUnit(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

//	==== HW =====
	public double between(Length l1, Length l2) {
		double res1 = l1.getNumber() * l1.getUnit().getValue();
		double res2 = l2.getNumber() * l2.getUnit().getValue();
		return (res2 - res1) / value;
	}
}
