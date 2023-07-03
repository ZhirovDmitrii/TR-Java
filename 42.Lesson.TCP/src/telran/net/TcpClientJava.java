package telran.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class TcpClientJava implements Closeable{
	protected ObjectOutputStream out;
	protected ObjectInputStream in;
	protected Socket socket;
	
	public TcpClientJava(String hostName, int port) throws Exception{
		socket = new Socket(hostName, port);
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
	}
	
	@Override
	public void close() throws IOException {
		socket.close();
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T sendReuest(String requestType, Serializable requestData) {
		try {
			RequestJava request = new RequestJava(requestType, requestData);
			out.writeObject(request);
			ResponseJava response = (ResponseJava) in.readObject();
			
			if(response.code != TcpResponse.OK)
				throw new Exception(response.code.toString());
			
			return (T) response.responseData;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
