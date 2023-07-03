
import telran.net.server.ServerJava;

public class TestServerAppl {
	public static void main(String[] args) throws Exception {
		ServerJava server = new ServerJava(new ProtocolTest(), 2000);
		server.run();
		
		
	}
}
