package telran.library.entities;

public class ReaderDelay{
	private Reader reader;
	private int delay;
	
	public ReaderDelay() {
		// TODO Auto-generated constructor stub
	}

	public ReaderDelay(Reader reader, int delay) {
		super();
		this.reader = reader;
		this.delay = delay;
	}

	public Reader getReader() {
		return reader;
	}

	public int getDelay() {
		return delay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + delay;
		result = prime * result + ((reader == null) ? 0 : reader.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReaderDelay other = (ReaderDelay) obj;
		if (delay != other.delay)
			return false;
		if (reader == null) {
			if (other.reader != null)
				return false;
		} else if (!reader.equals(other.reader))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReaderDelay [reader=" + reader + ", delay=" + delay + "]";
	}
	
	
}
