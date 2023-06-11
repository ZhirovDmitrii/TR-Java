package telran.library.model;


@SuppressWarnings("serial")
public abstract class AbstractLibrary implements ILibrary{
	protected int maxPickPeriod = 30;
	protected int minPickPeriod = 3;
	
	public AbstractLibrary() {
		super();
		this.maxPickPeriod = 30;
		this.minPickPeriod = 3;
	}

	public AbstractLibrary(int maxPickPeriod, int minPickPeriod) {
		super();
		this.maxPickPeriod = maxPickPeriod;
		this.minPickPeriod = minPickPeriod;
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
