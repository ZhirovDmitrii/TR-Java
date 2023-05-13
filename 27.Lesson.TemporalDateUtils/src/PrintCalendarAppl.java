
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class PrintCalendarAppl
{
	private static final int DATE_WIDTH = 4;

	public static void main(String[] args)
	{
		int[] monthYear = args.length == 2 ? getMonthYear(args) : getCurrentMonthYear();
		if (monthYear == null)
		{
			System.out.println("Wrong input, must be <month number> <year number>");
			return;
		}
		printMonthYear(monthYear[0], monthYear[1]);
	}

	private static void printMonthYear(int month, int year)
	{
		printTitle(month, year);
		printWeekdayNames();
		printDates(month, year);		
	}

	private static void printDates(int month, int year)
	{
		int firstColumn = getFirstColumn(month, year);
		printOffset(firstColumn); 
		printNumbersFromOffset(firstColumn, month, year); 
	}

	private static int getFirstColumn(int month, int year)
	{
		LocalDate firstDate = LocalDate.of(year, month, 1);
		return firstDate.getDayOfWeek().getValue();
	}
	
	private static void printOffset(int firstColumn)
	{
		for (int i = DATE_WIDTH; i < firstColumn * DATE_WIDTH; i++) 
		{
			System.out.print(" ");
		}
	}

	private static void printNumbersFromOffset(int firstColumn, int month, int year)
	{
		YearMonth yearMonth = YearMonth.of(year, month);
		int nDays = yearMonth.lengthOfMonth();
		for (int i = 1; i <= nDays; i++)
		{
			System.out.printf("%" + DATE_WIDTH + "d", i);//%4d
			if (firstColumn == 7)
			{
				firstColumn = 1;
				System.out.println();
			} else
			{
				firstColumn++;
			}
		}
	}

	private static void printWeekdayNames()
	{
		System.out.print("  "); 
		for(int i=1; i<=7; i++)
		{
			DayOfWeek day = DayOfWeek.of(i);
			String daystr = day.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
			System.out.print(daystr + " ");
		}
		System.out.println();
	}

	private static void printTitle(int month, int year)
	{
		Month m = Month.of(month);
		String mstr = m.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("en"));
		System.out.printf("%8s%s %d\n", " ", mstr, year);
	}

	private static int[] getCurrentMonthYear()
	{
		LocalDate current = LocalDate.now();
		return new int[] {current.getMonthValue(), current.getYear()};
	}

//	If data is wrong, return null
//	[0] -> month
//	[1] -> year
	private static int[] getMonthYear(String[] args)
	{
		int[] res = new int[2];
		try
		{
			res[0] = Integer.parseInt(args[0]);
			res[1] = Integer.parseInt(args[1]);
			if (res[0] < 1 || res[0] > 12)
				return null;
		} catch (Exception e)
		{
			return null;
		}
		return res;
	}

}
