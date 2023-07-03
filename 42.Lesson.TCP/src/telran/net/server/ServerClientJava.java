package telran.net.server;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import telran.net.RequestJava;
import telran.net.ResponseJava;


public class ServerClientJava implements Runnable{
	ObjectOutputStream out;
	ObjectInputStream in;
	Socket socket;	// client
	ProtocolJava protocol;
	
	public ServerClientJava(Socket socket, ProtocolJava protocol) throws Exception {
		super();
		this.socket = socket;
		this.protocol = protocol;
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
	}

	@Override
	public void run() {
		try {
			while (true) {
				RequestJava request = (RequestJava) in.readObject();
				ResponseJava response = protocol.getResponseJava(request);
				out.writeObject(response);
			}
		} catch (EOFException e) {
			System.out.println("Client closed connection");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
	}

}
