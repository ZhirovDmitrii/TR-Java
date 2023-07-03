
import telran.net.RequestJava;
import telran.net.ResponseJava;
import telran.net.TcpResponse;
import telran.net.server.ProtocolJava;

public class ProtocolTest implements ProtocolJava{

	@Override
	public ResponseJava getResponseJava(RequestJava request) {
		String type = request.requestType;
		String data = (String) request.requestData;
		
		switch (type) {
		case "length": return getLength(data);
		case "reverse": return getReverse(data);
		default: return new ResponseJava(TcpResponse.UNKNOWN, null);
		}
		
	}

	private ResponseJava getReverse(String data) {
		try {
			String sb = new StringBuilder(data).reverse().toString();
			return new ResponseJava(TcpResponse.OK, sb);
		} catch (Exception e) {
			return new ResponseJava(TcpResponse.WRONG_REQUEST, null);
		}
	}

	private ResponseJava getLength(String data) {
		try {
			int length = data.length();
			return new ResponseJava(TcpResponse.OK, length);
		} catch (Exception e) {
			return new ResponseJava(TcpResponse.WRONG_REQUEST, null);
		}
	}
	
}
