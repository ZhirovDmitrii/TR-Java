package repeat;

import java.util.Arrays;

public class CatAppl {
	public static void main(String[] args) {
		Cat c1 = new Cat("Fluffy", "Persian", 5, 8.0); 
		Cat c2 = new Cat("Mittens", "Siamese", 3, 6.5);
		Cat c3 = new Cat("Whiskers", "Coon", 2, 10.2); 
		Cat c4 = new Cat("Tiger", "Bengal", 4, 7.8);
		Cat c5 = new Cat("Felix", "British", 6, 9.5);
	
		Cat[] cats = {c1,c2,c3,c4,c5};
		
		System.out.println("Array is not sort");
		for(int i = 0; i < cats.length; i++)
			System.out.println(cats[i]);
		System.out.println();
		
		System.out.println("Natural sort (name-age-weight)");
		Arrays.sort(cats);
		for(int i = 0; i < cats.length; i++)
			System.out.println(cats[i]);
		System.out.println();
		
		System.out.println("Sort by name");
		Arrays.sort(cats, new CatNameComparator());
		for(int i = 0; i < cats.length; i++)
			System.out.println(cats[i]);
		System.out.println();
		
		System.out.println("Sort by breed");
		Arrays.sort(cats, new CatBreedComparator());
		for(int i = 0; i < cats.length; i++)
			System.out.println(cats[i]);
		System.out.println();
		
		System.out.println("Sort by weight-age");
		Arrays.sort(cats, new CatWeightAgeComparator());
		for(int i = 0; i < cats.length; i++)
			System.out.println(cats[i]);
	}
}
