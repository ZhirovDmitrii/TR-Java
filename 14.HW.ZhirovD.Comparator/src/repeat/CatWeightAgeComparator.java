package repeat;

import java.util.Comparator;

public class CatWeightAgeComparator implements Comparator<Cat>{

	@Override
	public int compare(Cat o1, Cat o2) {
		int res = o1.getWeight().compareTo(o2.getWeight());
		if(res == 0)
			res = o1.getAge().compareTo(o2.getAge());
		return res;
	}
	
}
