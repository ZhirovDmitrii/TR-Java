package telran.net;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResponseJava implements Serializable{
	public TcpResponse code;
	public Serializable responseData;
	
	public ResponseJava(TcpResponse code, Serializable responseData) {
		super();
		this.code = code;
		this.responseData = responseData;
	}
}
