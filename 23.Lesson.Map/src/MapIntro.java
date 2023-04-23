import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

public class MapIntro {

	public static void main(String[] args) {
		
		Map<String, Integer> months = new LinkedHashMap<>();
		//	Map<String, Integer> months = new HashMap<>();	// 
		fillMap(months);
		System.out.println(months);
		
		// put() - like add
		System.out.println(months.put("May", 5));	// return null
		System.out.println(months);
		
		System.out.println(months.put("May", 15));	// return 5 (old value)
		System.out.println(months);
		// if return null - put new value; if != null - not put, but value overwritten old value
		System.out.println("********************\n");
//		===========================
		
		Map<String, Integer> temp = new HashMap<>();
		fillMap(temp);
		temp.put("May", 100);
		temp.put("Jun", 6);
		System.out.println(temp);
		// put() find in months values jan,feb,mar,apr,may
		// then, put() is overwriting may, and put jun
		months.putAll(temp);	// putAll elements from temp to months
		System.out.println(months);
		System.out.println("********************\n");
//		===========================
		
		System.out.println(months.putIfAbsent("Jan", 10));	// have Jan in months - return 1
		System.out.println(months.putIfAbsent("Jul", 7));	// don't have Jul in months - return null
		System.out.println(months);
		// putIfAbsent() don't overwrite value if this value already exists and return KEY tis value
		// but if not exists - return NULL and put in value
		System.out.println("********************\n");
//		===========================
		
		// containsKey()/containsValue() - boolean
		System.out.println(months.containsKey("Jan"));	// true
		System.out.println(months.containsKey("Dec"));	// false
		System.out.println(months.containsValue(1));	// true
		System.out.println(months.containsValue(12));	// false
		System.out.println("********************\n");
//		===========================
		
		//	get() - if exists - return value
		//	if not - return null
		System.out.println(months.get("Jan"));	// return 1
		System.out.println(months.get("Dec"));	// return null
		System.out.println("********************\n");
//		===========================
		
		// getOrDefault() - if exists - return value
//		if not - return 0
		System.out.println(months.getOrDefault("Jan", 0));	// return 1 (value)
		System.out.println(months.getOrDefault("Dec", 0));	// return 0 (not exists in map)
		System.out.println("********************");
//		===========================
		
		// store null
		months.put(null, null); // OK
		months.put("Dec", null);
		System.out.println(months);
		System.out.println("********************\n");
//		===========================
		
		// remove(Object key) - return V
		System.out.println(months.remove(null));	// delete null=null from map - return null because KEY was null
		System.out.println(months.remove("Aug"));	// return null because not exist KEY "Aug"
		System.out.println(months.remove("Jan"));	// return 1 (value)
		System.out.println(months);
		System.out.println("********************\n");
//		===========================
		
		// remove(Object key, Object value) - return boolean
		System.out.println(months.remove("Feb",	100));	// false - KEY OK, VALUE is WRONG
		System.out.println(months.remove("Aug", 100));	// false
		System.out.println(months.remove("Feb",	2));	// true
		System.out.println("********************\n");
//		===========================
	
		// is Empty() and clear()
		System.out.println(months.isEmpty()); 	// false
		months.clear();
		System.out.println(months.isEmpty()); 	// true
		System.out.println(months);				// {}
		System.out.println("********************\n");
//		===========================
		
		// map cannot be iterated, but we can iterate keys and values
		fillMap(months);
		
		iteratingKeys(months);
		iteratingValues(months);
		interatingEntries(months);
		System.out.println("********************\n");
//		===========================
		
		// iterator. additional information
		// task - delete odd values
		months.values().removeIf(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t % 2 != 0;
			}
		});
		System.out.println(months); // deleted entries!!!
		
		months.keySet().removeAll(months.keySet());	// {}
		System.out.println(months);
		System.out.println("********************\n");
//		===========================
		
//		Map<Integer, Integer>
//		Map<Integer, List<String>>
//		Map<Integer, Map<String, Integer>>
//		Map<Integer, Map<String, Map<Integer, Integer>>>
//		... and more options...
		
		// generate random numbers and count how many times it was generated
		Map<Integer, Integer> randomNumbers = getRandomNumbers(0, 10 , 100);
		System.out.println(randomNumbers);
	}

//	=============== METHODS ===============
	private static Map<Integer, Integer> getRandomNumbers(int min, int max, int count) {
		TreeMap<Integer, Integer> temp = new TreeMap<>();
		for(int i = 0; i < count; i++) {
			int number = (int) (Math.random() * (max - min + 1) + min);	// generate random number
			// option 1
//			Integer value = temp.get(number);
//			Integer newValue = value == null ? 1 : ++value;
//			temp.put(number, newValue);
			
			// option 2
			Integer value = temp.getOrDefault(number, 0);
			temp.put(number, ++value);
			
			// option 3
//			temp.put(number, temp.getOrDefault(number, 0) + 1);
		}
		return temp;
	}
	// random = 5
	// 5 -> 1 (key)
	// 3 -> 1
	// 5 -> 2 (1+1)
	// 5 -> 3 (2+1)
	// 3 -> 2 (1+1)

	private static void interatingEntries(Map<String, Integer> obj) {
		System.out.println("Iterating entries");
		for(Map.Entry<String, Integer>e: obj.entrySet())	// get entries setters
			System.out.println(e);
	}

	private static void iteratingValues(Map<String, Integer> obj) {
		System.out.println("Iterating values");
		for(Integer v: obj.values())	// get values collections
			System.out.println(v);
	}

	private static void iteratingKeys(Map<String, Integer> obj) {
		System.out.println("Iterating keys");
		for(String k: obj.keySet())		// get keys setters
			System.out.println(k);
	}

	private static void fillMap(Map<String, Integer> months) {
		months.put("Jan", 1);
		months.put("Feb", 2);
		months.put("Mar", 3);
		months.put("Apr", 4);
	}

}
