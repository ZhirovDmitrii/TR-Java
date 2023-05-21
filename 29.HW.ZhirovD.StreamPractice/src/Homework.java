import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Homework {
	public static void main(String[] args) {
		Movie[] array = {
				new Movie("a", 2022, 4),
				new Movie("b", 2023, 4.5),
				new Movie("c", 2022, 4.5),
				new Movie("d", 2023, 3.5),
				new Movie("e", 2023, 5.5),
				new Movie("aa", 2023, 5.5),
				new Movie("e", 2021, 5.5),
				new Movie("aa", 2023, 5.5)
		};

		
		// 1
		// Create a stream that will give you and outputs unique movie ratings to your console
		System.out.println("Task 1");
		Stream<Movie> s1 = Arrays.stream(array);
		
		s1.map(m -> m.rating).distinct().forEach(System.out::println);
		System.out.println();
		
		// 2
		// Create a stream that will give you and outputs only the first unique year of movies
		System.out.println("Task 2");
		ArrayList<Movie> arList = new ArrayList<>(Arrays.asList(array));
		Stream<Movie> s2 = arList.stream();
		
		s2.map(m -> m.year).limit(1).forEach(System.out::println);
		System.out.println();
		
		// 3
		// Create a stream that will give you and outputs only the second unique year of movies.
		System.out.println("Task 3");
//		Arrays.stream(array).map(m -> m.year).distinct().skip(1).findFirst();	// HOW output ?
		Arrays.stream(array).map(m -> m.year).distinct().skip(1).limit(1).forEach(System.out::println);
		System.out.println();
		
		// 4
		// Create a stream that will give you and outputs only the penultimate element of your array.
		System.out.println("Task 4");
		Arrays.stream(array).skip(array.length-2).limit(1).forEach(System.out::println);
		System.out.println();
		
		// 5
		// Create a stream that will announce each next movie in the list in a format "Next movie is <our movie>", but only if they are not repeated.
		System.out.println("Task 5");
		Arrays.stream(array).map(m -> m.title).distinct().forEach(m -> System.out.println("Next movie is " + m));
		System.out.println();
		
		// 6
		// static void displayShuffledArray(int[] ar) - gets sorted array and displays all numbers of the array in the random order (one code line is required)
		System.out.println("Task 6");
		int[] ar = {0,1,2,3,4,5,6,7,8,9};
		displayShuffledArray(ar);
		System.out.println("\n");
		
		// 7
		// static void sportLoto(int min, int max, int numberDigits)
		// will print out a certain number of random numbers to fill in lottery tickets. 
		// For example 7 out of 49, i.e. 7 unique numbers ranging from 1 to 49.
		System.out.println("Task 7");
		sportLoto(1, 49, 7);
		
	}
	
	static void displayShuffledArray(int[] ar) {
		IntStream.of(ar).boxed()
		.sorted(Comparator.comparing(e -> Math.random()))
		.forEach(num -> System.out.print(num + " "));
	}
	
	static void sportLoto(int min, int max, int numberDigits) {
		IntStream.rangeClosed(min, max).boxed()
		.sorted(Comparator.comparing(e -> Math.random()))
		.distinct()
		.limit(numberDigits)
		.forEach(num -> System.out.print(num + " "));
	}
	
}
