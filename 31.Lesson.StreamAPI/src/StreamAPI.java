
import java.util.Arrays;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {

	public static void main(String[] args) {
		Movie[] array = { 
				new Movie("a", 2022, 4), 
				new Movie("b", 2023, 4.5), 
				new Movie("c", 2022, 4.5),
				new Movie("d", 2023, 3.5), 
				new Movie("e", 2023, 5.5), 
				new Movie("aa", 2023, 5.5),
				new Movie("aa", 2023, 5.4)};
		
		String[] strArray = {"Java", "Java", "Jojo","Java Script", "C++", "Kotlin"};
		
		// opt 1
		List<Movie> list = Arrays.stream(array).distinct().collect(Collectors.toList());
		System.out.println(list);
		
		// opt 2
		list = Arrays.stream(array).distinct().toList();
		System.out.println(list);
		System.out.println();
		
		// set
		Set<Movie> set = Arrays.stream(array).skip(1).collect(Collectors.toSet());
		System.out.println(set);
		System.out.println();
		
		// map
		Map<String, Double> map = Arrays.stream(array).distinct()
																	// if in array duplicate
				.collect(Collectors.toMap(m -> m.title, m -> m.rating, (ov, nv) -> ov));	// return ov (aa = 5.5)
																	// ov - old value, nv - new value
																	// if return nv - aa = 5.4
		map.entrySet().forEach(System.out::println);
		System.out.println(map);
		System.out.println();
		
		
		// opt 1 - get string -> return string
		Map<String, Integer> strMap = Arrays.stream(strArray).distinct()
				.collect(Collectors.toMap(s -> s, String::length));
		System.out.println(strMap);
		
		// opt 2 - use Function.indentity() instead of s -> s
		Map<String, Integer> strMap01 = Arrays.stream(strArray).distinct()
				.collect(Collectors.toMap(Function.identity(), s -> s.length()));
		System.out.println(strMap01);
		System.out.println();
		
		
		// create LinkedList
		LinkedList<Movie> ll = Arrays.stream(array).collect(Collectors.toCollection(LinkedList::new));
		System.out.println(ll);
		System.out.println();
		
		
		// create LinkedHashSet
		LinkedHashSet<Movie> lhs = Arrays.stream(array).collect(Collectors.toCollection(LinkedHashSet::new));
//		LinkedHashSet<Movie> ts = Arrays.stream(array).collect(Collectors.toCollection(() -> new LinkedHashSet<>())); // option 2
		System.out.println(lhs);
		System.out.println();
		
		
		// groupingBy (always return Map<Key, List<V>>);
		Map<Double, List<Movie>> mapRating = Arrays.stream(array)
				.collect(Collectors.groupingBy(m -> m.rating));
		mapRating.entrySet().forEach(System.out::println);
		System.out.println();
		
		Map<Integer, Long> mapYearCount = Arrays.stream(array)
				.collect(Collectors.groupingBy(m -> m.year, Collectors.counting()));
		mapYearCount.entrySet().forEach(System.out::println);
		System.out.println();
		
//		String[] strArray = {"Java", "Java Script", "C++", "Kotlin"};
//		4 -> {J -> List{Java}}	4 = length()
//		11 -> {J -> List{JS}}	11 = length()
		Map<Integer, Map<Character, List<String>>> map01 = Arrays.stream(strArray)
				.collect(Collectors.groupingBy(String::length, 
						Collectors.groupingBy(s -> s.charAt(0))));
		System.out.println(map01);
		
		Map<Integer, Map<Character, Long>> map02 = Arrays.stream(strArray)
				.collect(Collectors.groupingBy(s -> s.length(), 
						Collectors.groupingBy(s -> s.charAt(0), Collectors.counting())));
		System.out.println(map02);
		System.out.println();
		
		
		// partitioningBy (always return bollean)
		Map<Boolean, List<Movie>> map03 = Arrays.stream(array)
				.collect(Collectors.partitioningBy(m -> m.rating > 4));
		map03.entrySet().forEach(System.out::println);
		
		Map<Boolean, Double> map04 = Arrays.stream(array)
				.collect(Collectors.partitioningBy(m -> m.rating > 4, Collectors.averagingDouble(m -> m.rating)));
		map04.entrySet().forEach(System.out::println);
		System.out.println();
		
		
		// joining (always return String)
		System.out.println(Arrays.stream(strArray).collect(Collectors.joining()));
		System.out.println(Arrays.stream(strArray).collect(Collectors.joining("*-*")));	// Delimiter
		System.out.println(Arrays.stream(strArray).collect(Collectors.joining("*-*", "Start: ", " End"))); // add before String and after string
		
		Map<Integer, String> map05 = Arrays.stream(strArray)
				.collect(Collectors.groupingBy(String::length, Collectors.joining(" ")));
		System.out.println(map05);
		System.out.println();
		
		
		// summarizing == Summary statistics
		Map<Integer, DoubleSummaryStatistics> dss = Arrays.stream(array)
				.collect(Collectors.groupingBy(m -> m.year, Collectors.summarizingDouble(m -> m.rating)));
		dss.entrySet().forEach(System.out::println);
		System.out.println();
		
		
		// collectingAndThen
		List<String> list01 = Arrays.stream(strArray)
				.collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
					Collections.reverse(l);
					return l.stream();
				})).toList();
		System.out.println(list01);
		
		
	}

}
