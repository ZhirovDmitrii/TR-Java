import java.util.Arrays;

public class CatAppl {

	public static void main(String[] args) {
//		Task 4
		Cat[] cats = { new Cat("Fluffy", "Persian", 5, 8.0), 
				new Cat("Mittens", "Siamese", 3, 6.5),
				new Cat("Whiskers", "Maine Coon", 2, 10.2), 
				new Cat("Tiger", "Bengal", 4, 7.8),
				new Cat("Felix", "British Shorthair", 6, 9.5) };

		// Sort in natural order
		Arrays.sort(cats);
		System.out.println("Sorted by name: ");
		for(int i = 0; i < cats.length; i++)
			System.out.println(cats[i].getName() + ", " + cats[i].getBreed() + ", " + cats[i].getAge() + ", " + cats[i].getWeigth());
		System.out.println();
		
		// Sort by name
		Arrays.sort(cats, new CatNameComparator());
		System.out.println("Sorted by breed: ");
		for(int i = 0; i < cats.length; i++)
			System.out.println(cats[i].getName() + ", " + cats[i].getBreed() + ", " + cats[i].getAge() + ", " + cats[i].getWeigth());
		System.out.println();
		
		// Sort by breed
		Arrays.sort(cats, new CatBreedComparator());
		System.out.println("Sorted by age: ");
		for(int i = 0; i < cats.length; i++)
			System.out.println(cats[i].getName() + ", " + cats[i].getBreed() + ", " + cats[i].getAge() + ", " + cats[i].getWeigth());
		System.out.println();
		
		// Sort by weight and age
		Arrays.sort(cats, new CatWeightAgeComparator());
		System.out.println("Sorted by weight: ");
		for(int i = 0; i < cats.length; i++)
			System.out.println(cats[i].getName() + ", " + cats[i].getBreed() + ", " + cats[i].getAge() + ", " + cats[i].getWeigth());
		System.out.println();
	}

}
