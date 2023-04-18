package repeat;

import java.util.Comparator;

public class CatBreedComparator implements Comparator<Cat>{

	@Override
	public int compare(Cat o1, Cat o2) {
		return o1.getBreed().compareTo(o2.getBreed());
	}

	
}
