package telran.employees.service;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;

public class EmployeesMaps implements IEmployees{
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
	
	// TODO

	@Override
	public boolean hireEmployee(Employee empl) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fireEmpployee(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployeeData(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeesDataBySalary(int salaryFrom, int salaryTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanySalary> getCompaniesAvgSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanySalary> getCompaniesGreaterAvgSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAverageSalary() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
