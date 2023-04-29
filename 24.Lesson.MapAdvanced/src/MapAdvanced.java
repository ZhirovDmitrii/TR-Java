
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapAdvanced {

	public static void main(String[] args) {
		Map<String, Integer> months = new HashMap<>();
		fillMap(months);
		System.out.println(months);
		
		months.replaceAll(new BiFunction<String, Integer, Integer>() {
			@Override
			public Integer apply(String t, Integer u) {
				return u * 10;
			}
		});
		System.out.println(months);
		
		// if BiFunction return != null		if BiFunction return null
		// compute == put					compute == remove
		// not have a key - add value		delete a value by key
		// have a key - overwrite value	
		months.compute("Jan", new BiFunction<String, Integer, Integer>() {
			@Override
			public Integer apply(String t, Integer u) {
				return u+1;	// jan=10 -> jan=11
			}
		});
		System.out.println(months);
		
		// "DEC" - not in map == exception
		months.compute("Dec", new BiFunction<String, Integer, Integer>() {
			@Override
			public Integer apply(String t, Integer u) {
				// but now compute how put and add "Dec"=100
				return u == null ? 100 : u+1;
			}
		});
		System.out.println(months);
		
		months.compute("Jan", new BiFunction<String, Integer, Integer>() {
			@Override
			public Integer apply(String t, Integer u) {
				return null;	// remove "Jan"
			}
		});
		System.out.println(months);
		
		// computeIfAbsent == putIfAbsent - that is there is no key in map
		months.computeIfAbsent("Feb", new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				int res = Integer.MAX_VALUE;
				res -= 150;
				return res;
			}
		});
		System.out.println(months);	// we have "Feb" in map - nothing will change
		
		months.computeIfAbsent("Jan", new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				int res = Integer.MAX_VALUE;
				res -= 150;
				return res;
			}
		});
		System.out.println(months);	// we not have "Jan" in map - put in map
		
		// reverse computeIfAbsent - that is there is key im map == put
		months.computeIfPresent("Jan", new BiFunction<String, Integer, Integer>() {
			@Override
			public Integer apply(String t, Integer u) {
				return u-100;
			}
		});
		System.out.println(months);
		
		
		months.computeIfPresent("Apr", new BiFunction<String, Integer, Integer>() {
			@Override
			public Integer apply(String t, Integer u) {
				return u = 100;	// put "Apr"=100
			}
		});
		System.out.println(months);
		System.out.println();
		
//		===== INTERVIEW TASK =====
		System.out.println("Interview task");
		// swap key and value
		// J=1
		// K=1
		// B=2
		
		// 1 -> List{J, K}
		// 2 -> List{B}
		months.put("Nov", 100);
		Map<Integer, List<String>> res = swapKeyValue(months);
		System.out.println(res);
		System.out.println();
//		===== END =====
		
		// merge()
		// if not have a key - add a pair K, V
		// if have a key and key have a value - by key swap a value which calculate V
		//										 1	 JAN value	new JAN value
		months.merge("Jan", 1, new BiFunction<Integer, Integer, Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return u + t;
			}
		});
		System.out.println(months);
		
		// not have key Oct
		months.merge("Oct", 1, new BiFunction<Integer, Integer, Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return u + t;	// put new a pair - Oct=1
			}
		});
		System.out.println(months);
		
		months.merge("Oct", 1, new BiFunction<Integer, Integer, Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return null;	// remove Oct
			}
		});
		System.out.println(months);
	}
	
	private static Map<Integer, List<String>> swapKeyValue(Map<String, Integer> map){
		Map<Integer, List<String>> res = new HashMap<>();	// create empty map
		for(String str: map.keySet()) {		// iterate all keys
			Integer value = map.get(str);	// take a value from a key
			// by key (value)
			res.compute(value, new BiFunction<Integer, List<String>, List<String>>() {

				@Override
				public List<String> apply(Integer t, List<String> u) {
					if(u == null)
						u = new ArrayList<>();	// create key
					u.add(str);		// add old key
					return u;
				}
			});
		}
		return res;
	}
		

	private static void fillMap(Map<String, Integer> months) {
		months.put("Jan", 1);
		months.put("Feb", 2);
		months.put("Mar", 3);
		months.put("Apr", 4);
	}
}