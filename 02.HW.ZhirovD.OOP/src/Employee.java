
public class Employee extends Person {

	// Fields
	private String company;
	private int salaryPerDay = 34;

	// Constructor
	public Employee(String name, int age, boolean married, String company, int salaryPerDay) {
		super(name, age, married);
		this.company = company;
		this.salaryPerDay = salaryPerDay;
	}

	// Getters and setters
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalaryPerDay() {
		return salaryPerDay;
	}

	public void setSalaryPerDay(int salaryPerDay) {
		if (salaryPerDay > this.salaryPerDay)
			this.salaryPerDay = salaryPerDay;
	}

	// hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + salaryPerDay;
		return result;
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (salaryPerDay != other.salaryPerDay)
			return false;
		return true;
	}

	// Method
	public int computeSalary(int countDays) {
		return countDays * salaryPerDay;
	}

	// toString
	@Override
	public String toString() {
		return "Employee [company=" + company + ", salaryPerDay=" + salaryPerDay + ", toString()=" + super.toString()
				+ "]";
	}
}