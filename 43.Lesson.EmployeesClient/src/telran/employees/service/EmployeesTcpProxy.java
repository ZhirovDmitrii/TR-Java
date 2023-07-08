package telran.employees.service;

import java.util.List;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;
import telran.net.TcpClientJava;

public class EmployeesTcpProxy extends TcpClientJava implements IEmployees{
	
	public EmployeesTcpProxy(String hostName, int port) throws Exception {
		super(hostName, port);
	}
//	============================================
	
	@Override
	public boolean hireEmployee(Employee empl) {
		return sendReuest("hireEmployee", empl);
	}

	@Override
	public boolean fireEmpployee(int id) {
		return sendReuest("fireEmpployee", id);
	}

	@Override
	public Employee getEmployeeData(int id) {
		return sendReuest("getEmployeeData", id);
	}

	@Override
	public List<Employee> getEmployeesDataBySalary(int salaryFrom, int salaryTo) {
		Integer[] data = {salaryFrom, salaryTo};
		return sendReuest("getEmployeesDataBySalary", data);
	}

	@Override
	public List<CompanySalary> getCompaniesAvgSalary() {
		return sendReuest("getCompaniesAvgSalary", null);
	}

	@Override
	public List<CompanySalary> getCompaniesGreaterAvgSalary() {
		return sendReuest("getCompaniesGreaterAvgSalary", null);
	}

	@Override
	public int getAverageSalary() {
		return sendReuest("getAverageSalary", null);
	}
	
}
