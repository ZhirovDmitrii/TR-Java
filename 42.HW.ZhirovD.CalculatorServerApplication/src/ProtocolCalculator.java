import java.util.HashMap;
import java.util.function.BinaryOperator;

import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TcpResponse;
import telran.net.server.ProtocolJava;

public class ProtocolCalculator implements ProtocolJava{

//	===== CALCULATOR =====
	static HashMap<String, BinaryOperator<Integer>> mapOperations;
	static
	{
		mapOperations = new HashMap<>();
		mapOperations.put("+", (o1, o2) -> o1 + o2);
		mapOperations.put("-", (o1, o2) -> o1 - o2);
		mapOperations.put("*", (o1, o2) -> o1 * o2);
		mapOperations.put("/", (o1, o2) -> o1 / o2);
	}
//	===== END CALCULATOR =====
	
	@Override
	public ResponseJava getResponseJava(RequestJava request) {
		try {
			String operator = request.requestType;
			Integer[] operand = (Integer[]) request.requestData;
			
			Integer res = mapOperations.get(operator).apply(operand[0], operand[1]);
			return new ResponseJava(TcpResponse.OK, res);
		} catch (Exception e) {
			return new ResponseJava(TcpResponse.WRONG_REQUEST, e.getMessage());
		}
	}

}
