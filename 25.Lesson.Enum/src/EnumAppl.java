import java.util.Arrays;

public class EnumAppl {

	public static void main(String[] args) {
		Weekday first = Weekday.FRI;
		Weekday second = Weekday.FRI;
		System.out.println(first == second);
		
		displayCommentWeekday(first);
		displayCommentWeekday(Weekday.MON);
		displayCommentWeekday(Weekday.SAT);
		
		Person person = new Person(1, "Vasya", Person.Gender.MALE);
		System.out.println(person);
		
		// value() - return all values in array
		Weekday[] array = Weekday.values();
		System.out.println(Arrays.toString(array));
		
		// valueOf() - return obj by name
		System.out.println(Weekday.valueOf("SUN"));
		Weekday day = Weekday.valueOf("MON");	// return obj MON by name "MON"
//		day = Weekday.valueOf(null); - null pointer exception
		
		// ordinal() - return index from enum
		System.out.println(Weekday.SUN.ordinal()); // 0
		System.out.println(Weekday.SAT.ordinal()); // 6
		
		// name() - return string name by obj (reverse valueOf)
		String name = Weekday.FRI.name();
		System.out.println(name);
		
//		===== INTERVIEW TASK ==== Continue
		System.out.println(Weekday.SUN.plusDays(15));
	}
	
	

	public static void displayCommentWeekday(Weekday day)
	{
		switch(day)
		{
		case SUN: System.out.println("First working day in Israel");
			break;
		case SAT: System.out.println("Shabat");
			break;
		case FRI: System.out.println("Week end for Israel");
			break;
		default: System.out.println("Regular working day");
		}
	}

}
