import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {
		Movie[] array = {
				new Movie("a", 2022, 4),
				new Movie("b", 2023, 4.5),
				new Movie("c", 2022, 4.5),
				new Movie("d", 2023, 3.5),
				new Movie("e", 2023, 5.5),
				new Movie("aa", 2023, 5.5)
		};
		// opt 1 !!!
		Stream<Movie> s = Arrays.stream(array);
		
		// opt 2 !!!
		ArrayList<Movie> list = new ArrayList<>(Arrays.asList(array));
		Stream<Movie> s1 = list.stream();
		
		// opt 3
		IntStream s2 = "Helloworld".chars();

		// opt 4
		Stream<String> s3 = Stream.of("a", "b", "c");

		// opt 5
		Stream s4 = Stream.builder().add(1).add(2).add(3).build();
		
		// opt 6 - infinity stream
		IntStream.iterate(1, num -> num*2).limit(10).forEach(System.out::println);
	
		// opt 6.1
		Stream.generate(() -> "hello").limit(10).forEach(System.out::println);
		
		// opt 6.2
		Stream.generate(() -> new Random().nextBoolean()).limit(10).forEach(System.out::println);
		Stream.generate(() -> new Random().nextInt()).limit(10).forEach(System.out::println);
		Stream.generate(() -> new Random().nextLong()).limit(10).forEach(System.out::println);
		Stream.generate(() -> new Random().nextDouble()).limit(10).forEach(System.out::println);;
		
		System.out.println();
		Stream.generate(() -> new Random().ints()).limit(10).forEach(System.out::println);
		Stream.generate(() -> new Random().longs()).limit(10).forEach(System.out::println);
		Stream.generate(() -> new Random().doubles()).limit(10).forEach(System.out::println);
		
		// opt 7
		IntStream.range(0, 50).limit(10).forEach(System.out::println);
		System.out.println();
		
		s.forEach(System.out::println);
//		s.forEach(System.out::println);	- exception
//		s.forEach(elem -> System.out.println(elem));
	}

}
