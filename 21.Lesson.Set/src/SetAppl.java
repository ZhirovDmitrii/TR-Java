import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetAppl {
	public static void main(String[] args) {
		// initialization and print hash code
		Rectangle r1 = new Rectangle(10, 20);
		Rectangle r2 = new Rectangle(20, 10);
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());

		Rectangle r3 = new Rectangle(1, 1); // collision
		Rectangle r4 = new Rectangle(0, 32); // collision
		System.out.println(r3.hashCode());
		System.out.println(r4.hashCode());

		Rectangle r5 = new Rectangle(20, 10);	// duplicate r2
		System.out.println(r5.hashCode());
		
		System.out.println();
		
		// =======================================
		
		// HashSet
		Set<Rectangle> set = new HashSet<>(Arrays.asList(r1, r2, r3, r4, r5)); // elements will sort by hash code
		System.out.println(set);
		// LinkedHashSet
		Set<Rectangle> set01 = new LinkedHashSet<>(Arrays.asList(r1, r2, r3, r4, r5)); // not sort
		System.out.println(set01);
		
		// print option 2
//		for (Rectangle r : set)
//			System.out.println(r)

		System.out.println();
		
		// ===========================================
		
		// reinitialization field (bug)
		r1.x = 100;
		set01.remove(r1);
		System.out.println(set01); // '100' is not removing - it is bug
		System.out.println();
		
		// ======= INTERVIEW TASK =======
		// remove duplicate elements
		System.out.println("Interview task");
		Integer[] array = { 1000, 2, 30, 3, 3, 3, 50, 1000, 8, 8, 10 }; // 1000,2,30,3,50,8,10
		System.out.println(Arrays.toString(array));
		Integer[] res = noDuplicated(array);
		System.out.println(Arrays.toString(res));
		System.out.println();
		// ===========================================================
	
		// TreeHashSet
		Set<Rectangle> set02 = new TreeSet<>(Arrays.asList(r1,r2,r3,r4,r5));
		System.out.println(set02);
		System.out.println();
		
		// ======= INTERVIEW TASK  =======
		// remove duplicate elements 
		// and in range from 10 to 50
		System.out.println("Interview task");
		TreeSet<Integer> tmp = new TreeSet<>(Arrays.asList(array));
		System.out.println(tmp);
		tmp.subSet(10, true, 50, true).clear();
		System.out.println(tmp);
		
	}

	private static Integer[] noDuplicated(Integer[] array) {
		return new LinkedHashSet<>(Arrays.asList(array)).toArray(new Integer[0]);
	}

}
