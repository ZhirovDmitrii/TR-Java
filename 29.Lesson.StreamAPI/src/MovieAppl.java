import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class MovieAppl {

	public static void main(String[] args) {
		Movie[] array = {
				new Movie("a", 2022, 4),
				new Movie("b", 2023, 4.5),
				new Movie("c", 2022, 4.5),
				new Movie("d", 2023, 3.5),
				new Movie("e", 2023, 5.5),
				new Movie("aa", 2023, 5.5),
				new Movie("aa", 2023, 5.5)
		};
		
		displayMoviesTitle(array, 2023, 4);
		System.out.println();
		displayMoviesTitleStream(array, 2023, 4);
		System.out.println();
		
//		===========================================
		Arrays.stream(array).distinct().skip(2).limit(3).forEach(System.out::println);
		System.out.println();
		
		Stream.of(1,2,3,4,5,6,7,8,9,1,2,3,4,5).takeWhile(t -> t < 6).forEach(System.out::println);
		System.out.println();
		Stream.of(1,2,3,4,5,6,7,8,9,1,2,3,4,5).dropWhile(t -> t < 6).forEach(System.out::println);
	}

	private static void displayMoviesTitleStream(Movie[] array, int year, double rating) {
		Arrays.stream(array)
		.filter(m -> m.year == year && m.rating >= rating)
//		.peek(t -> System.out.println(t)) - for check
		.sorted((m1,m2) -> {
			int res = Double.compare(m1.rating, m2.rating);
			return res==0 ? m1.title.compareTo(m2.title) : res;
		})
		.map(m -> m.title)
		.forEach(t -> System.out.println(t));
		
	}

//	==============================================================================
	private static void displayMoviesTitle(Movie[] array, int year, double rating)
	{
		ArrayList<Movie> list = new ArrayList<>();
		for(Movie m: array)
		{
			if(m.year == year && m.rating >= rating)
				list.add(m);
		}
		
		list.sort(new Comparator<Movie>()
		{

			@Override
			public int compare(Movie o1, Movie o2)
			{
				int res = Double.compare(o1.rating, o2.rating);
				return res==0 ? o1.title.compareTo(o2.title) : res;
			}
		});
		
		for(Movie m: list)
		{
			System.out.println(m.title);
		}
	}

}
