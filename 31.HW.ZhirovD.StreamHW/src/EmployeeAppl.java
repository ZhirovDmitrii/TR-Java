import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeAppl {
	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>(
				Arrays.asList(
						new Employee(23454, "Dima", "TR", 8124), 
						new Employee(13432, "Marina", "RH", 7101),
						new Employee(12323, "Iliya", "SR", 10053), 
						new Employee(15345, "Sasha", "BU", 5569),
						new Employee(23454, "Dmitrii", "TR", 9562)));
		
		System.out.println("Task 1");
		displayBiggestCompanies(emp);
		System.out.println();
		
		System.out.println("Task 2");
		displayCompaniesAboveAvgSalary(emp);
		System.out.println();
		
		System.out.println("Task 3");
		int interval = 100;
		displayEmployeesBySalaryIntervals(emp, interval);
		System.out.println();
		
		System.out.println("Task 4");
		String text = "lmn, vf ab a lmn: ab lmn";
		displayWordCounts(text);
		
	}
	
	// Displays out only company names with the most amount of employees
	static void displayBiggestCompanies(List<Employee> employees) {
		Map<String, Long> mp = employees.stream()
				.collect(Collectors.groupingBy(Employee::getCompany,
						Collectors.counting()));
		
		// find max salary
		long maxEmployeesCount = mp.values().stream().max(Comparator.comparingLong(Long::valueOf)).orElse(0L);
		
		//print company name
		mp.entrySet().stream()
		.filter(e -> e.getValue() == maxEmployeesCount)
		.forEach(k -> System.out.println(k.getKey()));
	}
	
	// Displays out only company names with average salary greater or equal the overall average salary
	static void displayCompaniesAboveAvgSalary(List<Employee> employees) {
		double avgSalary = employees.stream()
				.collect(Collectors.averagingDouble(e -> e.getSalary()));
//		System.out.println("Avg salary all companies: " + avgSalary);
		
		Map<String, Double> mp = employees.stream()
				.collect(Collectors.groupingBy(e -> e.company, 
						Collectors.averagingDouble(e -> e.getSalary())));
		
		mp.entrySet().stream()
		.filter(e -> e.getValue() >= avgSalary)
		.forEach(k -> System.out.println(k.getKey()));
	}
	
	/*
	 * Generates a map, where the key is the salary interval, 
	 * and the value is a list of employees in the salary range. 
	 * Set the step yourself, for example 1000. 
	 * And displays the result as
	 * [10000-11000) [employees]
	 * [11000-12000) [employees]
	 * [12000-13000) [employees]
	 */
	static void displayEmployeesBySalaryIntervals(List<Employee> employees, int interval) {
		Map<String, List<Employee>> salaryIntervals = employees.stream()
				.collect(Collectors.groupingBy(e -> {
					int lower = (e.getSalary() / interval) * interval;
					int upper = lower + interval;
					return String.format("[%d-%d)", lower, upper);
				}));
		
		salaryIntervals.forEach((range, empList) -> System.out.println(range + " " + empList));
	}

	/*
	 * Will print to the console how many times this or that word occurs in a line in sorted order by the number of occurrences, 
	 * and if several lines have the same occurrence, then alphabetically
	 * 
	 * String text = "lmn, vf ab a lmn: ab lmn"; - at the entrance.
	 * At the exit
	 * lmn -> 3
	 * ab -> 2
	 * a -> 1
	 * vf -> 1
	 */
	static void displayWordCounts(String text) {
		String[] words = text.split("\\W+");
		
		// counting how many times the word occurs
		Map<String, Long> mp = Arrays.stream(words)
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		
		// sort
		mp.entrySet().stream()
		.sorted((s1,s2) -> s1.getValue() == s2.getValue() ?
				s1.getKey().compareTo(s2.getKey()) :
					Long.compare(s2.getValue(), s1.getValue()))
		.forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
	}
}
