
public enum Weekday {
	SUN, MON, TUE, WED, THU, FRI, SAT;
	
//	==== INTERVIEW TASK =====
	// what is week day after N days?
	public Weekday plusDays(int days) {
		Weekday[] array = values();	// take all enums
		int index = ordinal();		// take index
		return array[(index+days) % array.length];
	}
}
//public enum Weekday
//{
//	private String name;

//private Weekday(String name)
//{
//	this.name = nmae
//}

//Weekday SUN = new Weekday("SUN");
//}