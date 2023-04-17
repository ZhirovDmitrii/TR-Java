package repeat;

import java.util.Objects;

public class Employee extends Person{
	private String company;
	private int salaryperDay;
	private static final int COUNT_DAYS = 22;
	
	public Employee(String name, int age, boolean married, String company, int salaryperDay) {
		super(name, age, married);
		this.company = company;
		this.salaryperDay = salaryperDay;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getSalaryperDay() {
		return salaryperDay;
	}
	public void setSalaryperDay(int salaryperDay) {
		this.salaryperDay = salaryperDay;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(company, salaryperDay);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(company, other.company) && salaryperDay == other.salaryperDay;
	}
	@Override
	public String toString() {
		return "Employee [company=" + company + ", salaryperDay=" + salaryperDay + "]";
	}
	
//	===== METHOD =====
	
	public int computeSalary(int countDays) {
		return salaryperDay * COUNT_DAYS;
	}
}
