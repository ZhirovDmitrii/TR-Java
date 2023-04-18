package repeat;
import java.util.Comparator;

public class LengthStringComporator implements Comparator<String>
{

	@Override
	public int compare(String o1, String o2)
	{
		return o2.length() - o1.length();
	}

}