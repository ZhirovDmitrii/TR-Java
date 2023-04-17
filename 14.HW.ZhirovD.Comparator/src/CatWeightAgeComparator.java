import java.util.Comparator;

public class CatWeightAgeComparator implements Comparator<Cat>{
// Task 3.3
	@Override
	public int compare(Cat o1, Cat o2) {
		int res = o1.getWeigth().compareTo(o2.getWeigth());
		
		if(res == 0) {
			res = o1.getAge().compareTo(o2.getAge());
		}
		return res;
	}

}
