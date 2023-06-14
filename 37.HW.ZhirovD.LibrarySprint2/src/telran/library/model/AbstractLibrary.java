package telran.library.model;

@SuppressWarnings("serial")
public abstract class AbstractLibrary implements ILibrary{
	protected int maxPickPeriod;
	protected int minPickPeriod;
	
	public AbstractLibrary() {
		super();
		this.maxPickPeriod = 30;
		this.minPickPeriod = 3;
	}

	public int getMaxPickPeriod() {
		return maxPickPeriod;
	}

	public void setMaxPickPeriod(int maxPickPeriod) {
		this.maxPickPeriod = maxPickPeriod;
	}

	public int getMinPickPeriod() {
		return minPickPeriod;
	}

	public void setMinPickPeriod(int minPickPeriod) {
		this.minPickPeriod = minPickPeriod;
	}

}
