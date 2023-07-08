import telran.net.TcpClientJava;

public class CalculatorClient extends TcpClientJava{

	public CalculatorClient(String hostName, int port) throws Exception {
		super(hostName, port);
	}
	
	public Integer calculate (Integer operand01, Integer operand02, String operator) {
		Integer values[] = {operand01, operand02};
		return sendReuest(operator, values);
	}
}
