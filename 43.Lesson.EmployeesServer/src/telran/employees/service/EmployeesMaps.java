package telran.employees.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;

public class EmployeesMaps implements IEmployees {
	HashMap<Integer, Employee> emplyees = new HashMap<>(); // id, employee
	HashMap<String, List<Employee>> companies = new HashMap<>(); // companyName, list employees
	TreeMap<Integer, List<Employee>> salaries = new TreeMap<>(); // salary, list employees

	public EmployeesMaps() {
	}

	public EmployeesMaps(HashMap<Integer, Employee> emplyees, HashMap<String, List<Employee>> companies,
			TreeMap<Integer, List<Employee>> salaries) {
		super();
		this.emplyees = emplyees;
		this.companies = companies;
		this.salaries = salaries;
	}

	@Override
	public boolean hireEmployee(Employee empl) {
		boolean res = emplyees.putIfAbsent(empl.getId(), empl) == null;
		if(res) {
			addCompanies(empl);
			addSalaries(empl);
		}
		return res;
	}

	private void addSalaries(Employee empl) {
		int salary = empl.getSalary();
		List<Employee> emplList = salaries.getOrDefault(salary, new ArrayList<>());
		emplList.add(empl);
		salaries.putIfAbsent(salary, emplList);
	}

	private void addCompanies(Employee empl) {
		String companyName = empl.getCompanyName();
		List<Employee> emplList = companies.getOrDefault(companyName, new ArrayList<>());
		emplList.add(empl);
		companies.putIfAbsent(companyName, emplList);
	}

	@Override
	public boolean fireEmpployee(int id) {
		Employee empl = emplyees.remove(id);
		if(empl != null) {
			removeCompany(empl);
			removeSalary(empl);
		}
		return empl != null;
	}

	private void removeSalary(Employee empl) {
		int salary = empl.getSalary();
		List<Employee> emplList = salaries.get(salary);
		emplList.remove(empl);
		
		if(emplList.isEmpty())
			salaries.remove(salary);
	}

	private void removeCompany(Employee empl) {
		String companyName = empl.getCompanyName();
		List<Employee> emplList = companies.get(companyName);
		emplList.remove(empl);
		
		if(emplList.isEmpty())
			companies.remove(companyName);		
	}

	@Override
	public Employee getEmployeeData(int id) {
		return emplyees.get(id);
	}

	@Override
	public List<Employee> getEmployeesDataBySalary(int salaryFrom, int salaryTo) {
		return salaries.subMap(salaryFrom, salaryTo).values().stream().flatMap(List::stream).collect(Collectors.toList());
	}

	@Override
	public List<CompanySalary> getCompaniesAvgSalary() {
		return companies.entrySet().stream().map(e -> {
			double avgSalary = e.getValue().stream()
					.collect(Collectors.averagingInt(empl -> empl.getSalary()));
			return new CompanySalary(e.getKey(), avgSalary);
		}).collect(Collectors.toList());
	}

	@Override
	public List<CompanySalary> getCompaniesGreaterAvgSalary() {
		double avgSalary = getAverageSalary();
		List<CompanySalary> res = getCompaniesAvgSalary();
		return res.stream().filter(c -> c.getAvgSalary() > avgSalary).collect(Collectors.toList());
	}

	@Override
	public int getAverageSalary() {
		double avg = emplyees.values().stream().collect(Collectors.averagingDouble(e -> e.getSalary()));
		return (int) avg;
	}

}
