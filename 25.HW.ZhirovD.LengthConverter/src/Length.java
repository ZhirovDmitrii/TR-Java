
public class Length {
	private double number;
	private LengthUnit unit;

	public Length(double number, LengthUnit unit) {
		super();
		this.number = number;
		this.unit = unit;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public LengthUnit getUnit() {
		return unit;
	}

	public void setUnit(LengthUnit unit) {
		this.unit = unit;
	}

//	===== HW =====
	public String toString() {
		return (int) number + unit.name();
	}

	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		Length l = (Length) obj;	// cast an obj to a new type
		//	take number and value by unit and calculate
		double tNum = getNumber() * getUnit().getValue();
		//	repeat operation, but with obj
	    double oNum = l.getNumber() * l.getUnit().getValue();
	    
	    return Double.compare(tNum, oNum) == 0;	// if == 0 - is TRUE
	}
	
//	public Length plus(Length length) {
//		// HW
//	}
	
//	public Length minus(Length length) {
//		// HW
//	}

	public Length convert(LengthUnit otherUnit) {
		double num = getNumber() * getUnit().getValue() / otherUnit.getValue();
		return new Length(num, otherUnit);
	}
	
}
