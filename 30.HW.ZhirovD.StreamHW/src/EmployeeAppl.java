import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class EmployeeAppl {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>(
				Arrays.asList(
						new Employee(23454, "Dima", "TR", 8124), 
						new Employee(13432, "Marina", "RH", 7000),
						new Employee(12323, "Iliya", "SR", 6000), 
						new Employee(15345, "Sasha", "BU", 5000),
						new Employee(23454, "Dmitrii", "TR", 9562)));
		displayAverageMinMaxSalary(emp);
		System.out.println("\n");
		
		displayAverageSalary(emp, "TR");
		System.out.println();
		
		displayEmployeesAvgSalary(emp);
		
	}

	public static void displayAverageMinMaxSalary(List<Employee> employees) {
		IntSummaryStatistics stat = employees.stream().mapToInt(n -> n.salary).summaryStatistics();
		System.out.printf("Avg salary = %.2f, Min salary = %d, Max salary = %d", stat.getAverage(), stat.getMin(), stat.getMax());
	}

	public static void displayAverageSalary(List<Employee> employees, String company) {
		System.out.println(employees.stream().filter(s -> s.company.equals(company)).mapToInt(n -> n.salary).average());
	}

	public static void displayEmployeesAvgSalary(List<Employee> employees) {
		double avgSalary = employees.stream().mapToDouble(n -> n.salary).average().getAsDouble();
		System.out.println("Avg salary is: " + avgSalary);
		
		employees.stream().filter(n -> n.salary > avgSalary).map(c -> new NewEmployee(c.name, c.salary)).forEach(System.out::println);
	}
}
