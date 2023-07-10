package telran.employees;

import telran.employees.net.EmployeesProtocol;
import telran.employees.service.EmployeesMaps;
import telran.employees.service.IEmployees;
import telran.net.server.ProtocolJava;
import telran.net.server.ServerJava;

public class EmployeeServerAppls {
	private static final int PORT = 3000;
	
	public static void main(String[] args) throws Exception {
		IEmployees service = new EmployeesMaps();
		ProtocolJava protocol = new EmployeesProtocol(service);
		
		ServerJava sj = new ServerJava(protocol, PORT);
		sj.run();
	}

}
