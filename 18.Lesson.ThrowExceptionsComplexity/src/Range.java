public class Range {
	int min, max;

	public Range(int min, int max) {
		if (min >= max)
			throw new RuntimeException("min >= max");
		this.min = min;
		this.max = max;
	}

	public void checkNumber(int num) throws Exception {
		if (num < min)
			throw new NumberLessMinException();
		if (num > max)
			throw new NumberGreaterMaxException();
	}
}
