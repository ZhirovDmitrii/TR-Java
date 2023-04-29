import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionIntro {
	public static void main(String[] args) {
		// take string length
		Function<String, Integer> function01 = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		System.out.println(function01.apply("Hello world!"));

		// take string and convert to upper case
		Function<String, String> function02 = new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		};
		System.out.println(function02.apply("Hello world!"));

		// string concatenation 
		BiFunction<String, String, String> function03 = new BiFunction<String, String, String>() {
			@Override
			public String apply(String t, String u) {
				return t + u;
			}
		};
		System.out.println(function03.apply("Hello", "world!"));
		
		ThreeFunction<String, String, String, String> myFunction = new ThreeFunction<String, String, String, String>() {
			@Override
			public String apply(String a, String b, String c) {
				return a+b+c;
			}
		};
		System.out.println(myFunction.apply("Hello", "world", "!"));
	}
}
