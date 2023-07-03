
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import telran.net.TcpClientJava;

class TestClient extends TcpClientJava{

	public TestClient() throws Exception {
		super("localhost", 2000);	// 2000 from test server
		
	}

	@Test
	void testLength() throws Exception {
		String str = "12345";
		int length = sendReuest("length", str);
		assertEquals(5, length);
		
		String res = sendReuest("reverse", str);
		assertEquals("54321", res);
		close();
	}

}
