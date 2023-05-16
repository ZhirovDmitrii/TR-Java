import java.util.HashMap;
import java.util.Map;

public class Anagram {

//	Use the merge() method and lambda expression when working with the map instead of getOrDefault() and put() methods
	public static boolean isAnagram(String word, String string) {
		if (word == null || word.isBlank() || string == null || string.isBlank())
			throw new IllegalArgumentException("The word must not be blank or null");
		if (string.length() > word.length())
			throw new IllegalArgumentException("An anagram must not be larger then the original word");
		
        Map<Character, Integer> mp = new HashMap<>();

        // calculate a characters in word
        // Integer.sum(value1, value2)
        // value1 = value by key.
        // if character by key not exist in map: value1 = 1
        // if character by key exist in map: value1 = old value + 1
        // value2 = 1
        word.chars().forEach(ch -> mp.merge((char) ch, 1, Integer::sum));
        

        // check if a string is an anagram
        for (char ch : string.toCharArray()) {
            if (!mp.containsKey(ch) || mp.get(ch) == 0) {
                return false;
            }
            mp.merge(ch, -1, Integer::sum);
        }

        return true;
	}

}
