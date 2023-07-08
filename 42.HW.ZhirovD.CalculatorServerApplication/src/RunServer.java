import telran.net.server.ServerJava;

public class RunServer {

	public static void main(String[] args) throws Exception {
		ServerJava sj = new ServerJava(new ProtocolCalculator(), 2000);
		sj.run();

	}

}
