import java.util.Comparator;

public class CatNameComparator implements Comparator<Cat>{
//	Task 3.1
	@Override
	public int compare(Cat o1, Cat o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
