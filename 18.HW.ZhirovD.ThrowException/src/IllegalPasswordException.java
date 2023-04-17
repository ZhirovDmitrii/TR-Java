
@SuppressWarnings("serial")
public class IllegalPasswordException extends RuntimeException {
	private String[] message;

	public IllegalPasswordException(String[] messages) {
		super();
		this.message = messages;
	}

	public String[] getMessages() {
		return message;
	}
}
