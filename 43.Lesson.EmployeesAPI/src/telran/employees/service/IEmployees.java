package telran.employees.service;

import java.util.List;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;

public interface IEmployees {
	boolean hireEmployee(Employee empl);
	boolean fireEmpployee(int id);
	Employee getEmployeeData(int id);

	List<Employee> getEmployeesDataBySalary(int salaryFrom, int salaryTo);
	List<CompanySalary> getCompaniesAvgSalary();
	List<CompanySalary> getCompaniesGreaterAvgSalary();
	int getAverageSalary();
}
