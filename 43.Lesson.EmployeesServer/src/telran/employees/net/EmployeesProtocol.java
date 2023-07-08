package telran.employees.net;

import java.io.Serializable;
import java.util.List;

import telran.employees.dto.CompanySalary;
import telran.employees.dto.Employee;
import telran.employees.service.IEmployees;
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TcpResponse;
import telran.net.server.ProtocolJava;

public class EmployeesProtocol implements ProtocolJava {
	IEmployees service;

	public EmployeesProtocol(IEmployees service) {
		super();
		this.service = service;
	}

	@Override
	public ResponseJava getResponseJava(RequestJava request) {
		switch (request.requestType) {
		case "hireEmployee":
			return hireEmployee(request.requestData);
		case "fireEmpployee":
			return fireEmpployee(request.requestData);
		case "getEmployeeData":
			return getEmployeeData(request.requestData);
		case "getEmployeesDataBySalary":
			return getEmployeesDataBySalary(request.requestData);
		case "getCompaniesAvgSalary":
			return getCompaniesAvgSalary(request.requestData);
		case "getCompaniesGreaterAvgSalary":
			return getCompaniesGreaterAvgSalary(request.requestData);
		case "getAverageSalary":
			return getAverageSalary(request.requestData);
		default:
			return new ResponseJava(TcpResponse.UNKNOWN, null);
		}
	}

	private ResponseJava getAverageSalary(Serializable requestData) {
		try {
			Integer res = service.getAverageSalary();
			return new ResponseJava(TcpResponse.OK, res);
		} catch (Exception e) {
			return wrongRequest(e);
		}
	}

	private ResponseJava getCompaniesGreaterAvgSalary(Serializable requestData) {
		try {
			List<CompanySalary> res = service.getCompaniesGreaterAvgSalary();
			return new ResponseJava(TcpResponse.OK, (Serializable) res);
		} catch (Exception e) {
			return wrongRequest(e);
		}
	}

	private ResponseJava getCompaniesAvgSalary(Serializable requestData) {
		try {
			Integer[] data = (Integer[]) requestData;
			List<Employee> res = service.getEmployeesDataBySalary(data[0], data[1]);
			return new ResponseJava(TcpResponse.OK, (Serializable) res);
		} catch (Exception e) {
			return wrongRequest(e);
		}
	}

	private ResponseJava getEmployeesDataBySalary(Serializable requestData) {
		try {
			List<CompanySalary> res = service.getCompaniesAvgSalary();
			return new ResponseJava(TcpResponse.OK, (Serializable) res);
		} catch (Exception e) {
			return wrongRequest(e);
		}
	}

	private ResponseJava getEmployeeData(Serializable requestData) {
		try {
			Integer data = (Integer) requestData;
			Employee res = service.getEmployeeData(data);
			return new ResponseJava(TcpResponse.OK, res);
		} catch (Exception e) {
			return wrongRequest(e);
		}
	}

	private ResponseJava fireEmpployee(Serializable requestData) {
		try {
			Integer data = (Integer) requestData;
			boolean res = service.fireEmpployee(data);
			return new ResponseJava(TcpResponse.OK, res);
		} catch (Exception e) {
			return wrongRequest(e);
		}
	}

	private ResponseJava hireEmployee(Serializable requestData) {
		try {
			boolean res = service.hireEmployee((Employee) requestData);

			return new ResponseJava(TcpResponse.OK, res);
		} catch (Exception e) {
			return wrongRequest(e);
		}
	}

//	=======================================================================
	private ResponseJava wrongRequest(Exception e) {
		return new ResponseJava(TcpResponse.WRONG_REQUEST, e.getMessage());
	}
}
