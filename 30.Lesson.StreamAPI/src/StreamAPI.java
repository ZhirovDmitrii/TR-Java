import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {
		Movie[] array = { new Movie("a", 2022, 4), new Movie("b", 2023, 4.5), new Movie("c", 2022, 4.5),
				new Movie("d", 2023, 3.5), new Movie("e", 2023, 5.5), new Movie("aa", 2023, 5.5) };

		double av = Arrays.stream(array).mapToDouble(m -> m.rating).average().getAsDouble();
		System.out.println(av);
		System.out.println();

		// boxing for save primitive in object -> collection
		List<Integer> randomList = new Random().ints(10, 0, 100).boxed().toList();
		System.out.println(randomList);
		System.out.println();

		DoubleSummaryStatistics stat = Arrays.stream(array).mapToDouble(m -> m.rating).summaryStatistics();
		System.out.printf("count = %d, sum = %.2f, min = %.2f, max = %.2f, avg = %.2f", stat.getCount(), stat.getSum(),
				stat.getMin(), stat.getMax(), stat.getAverage());
		System.out.println();
		System.out.println(stat);
		System.out.println();

		long count = stat.getCount();
		System.out.println(count);
		System.out.println();

		System.out.println(Arrays.stream(array).mapToDouble(m -> m.rating).distinct().count()); // 4 unique obj

		// !!! NOT USE
//		Arrays.stream(array).count();	// NO
//		int size = array.length;		// YES

		// DON'T DO THAT!!! it's for theory
		Stream.of("Mama mila ramu").flatMap(str -> Arrays.stream(str.split(" "))).forEach(System.out::println);
		System.out.println();

		String[] words = Stream.of("Mama mila ramu").flatMap(str -> Arrays.stream(str.split(" ")))
				.sorted((w1, w2) -> w2.compareTo(w1)).toArray(String[]::new);
		System.out.println(Arrays.toString(words));
		System.out.println("");

//		===== INTERVIEW TASK =====
		// [2,3,0,1] -> 0120123001
		System.out.println("Interview task");
		Stream.of(2, 3, 0, 1).flatMapToInt(num -> IntStream.rangeClosed(0, num)).forEach(num -> System.out.print(num));
		System.out.println("\n");
//	    ==========================

		List<List<String>> list = new ArrayList<>(Arrays.asList(
				new ArrayList<>(Arrays.asList("a", "b", "c")),
				new ArrayList<>(Arrays.asList("d", "e", "e", "a"))));

		String[] ar = list.stream().flatMap(l -> l.stream()).distinct().toArray(String[]::new); // (.toArray(() -> new
																								// String[0])
		System.out.println(Arrays.toString(ar));
		System.out.println();

		// flatMap
		Stream.of("hello", "world").flatMap(s -> s.chars().mapToObj(i -> (char) i)).forEach(System.out::print);
		System.out.println();
		// mapMulti
		Stream.of("hello", "world").mapMulti((s, sink) -> {
			for (char c : s.toCharArray()) {
				sink.accept(c);
			}
		}).forEach(n -> System.out.print(n));
		System.out.println("\n");

//		 ===== TERMINAL METODS =====
		// reduce
		int sum = Stream.of(1, 2, 3, 4).reduce(0, (id, n) -> id + n);
		System.out.println(sum);

		sum = Stream.of(1, 2, 3, 4).reduce((id, n) -> id + n).orElse(0);
		System.out.println(sum);

		ArrayList<Integer> list1 = new ArrayList<>();
		sum = list1.stream().reduce(2, (id, n) -> id + n);
		System.out.println(sum);

		sum = list1.stream().reduce((id, n) -> id + n).orElse(0);
		System.out.println(sum);
		System.out.println();

		// allMatch/anyMatch/noneMatch
//		 Movie[] array = {
//					new Movie("a", 2022, 4),
//					new Movie("b", 2023, 4.5),
//					new Movie("c", 2022, 4.5),
//					new Movie("d", 2023, 3.5),
//					new Movie("e", 2023, 5.5),
//					new Movie("aa", 2023, 5.5)
//			};

		System.out.println(Arrays.stream(array).allMatch(m -> m.year > 2000)); // true
		System.out.println(Arrays.stream(array).allMatch(m -> m.year > 2022)); // false
		System.out.println(Arrays.stream(array).anyMatch(m -> m.year == 2022)); // true
		System.out.println(Arrays.stream(array).noneMatch(m -> m.year == 2000)); // false
		System.out.println();
		
		// findFirst/findAny
		System.out.println(Arrays.stream(array).distinct().findFirst().get());
		System.out.println(Arrays.stream(array).distinct().findAny().get());
		
		System.out.println(Arrays.stream(array).parallel().distinct().findFirst().get());
		System.out.println(Arrays.stream(array).parallel().distinct().findAny().get());
		
		
		int[] nums = {1,2,3,4};
		Arrays.stream(nums).forEach(n -> System.out.print(n));
		System.out.println();
		Arrays.stream(nums).parallel().forEach(n -> System.out.print(n));
		System.out.println();
//		Arrays.stream(nums).forEachOrdered(n -> System.out.print(n)); 	// NOPE NOPE NOPE
//		System.out.println();
		Arrays.stream(nums).parallel().forEachOrdered(n -> System.out.print(n));
		System.out.println();
		
	}
}
