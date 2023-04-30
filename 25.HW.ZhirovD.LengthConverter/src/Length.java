
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
	
	public String toString() {
		// HW
	}
	
	public Length plus(Length length) {
		// HW
	}
	
	public Length minus(Length length) {
		// HW
	}
	
	public Length convert(LengthUnit unit) {
		// HW
	}
	
	public boolean Equals(Object obj) {
		// HW
	}
}
