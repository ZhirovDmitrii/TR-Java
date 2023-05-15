import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FPAppl
{

	public static void main(String[] args)
	{
		/*
		 * name?(x,y,z)
		 * {
		 * return x+y+z;
		 * }
		 * 
		 * opt 1
		 * (x, y, z) -> x+y+z 	- >1 arguments
		 * 
		 * opt 2
		 * () -> body 			- none arguments
		 * 
		 * opt 3
		 * x -> x*2 			- one argument
		 * 
		 * opt 4
		 * (x, y) -> {return x+y}
		 * 
		 * opt 5
		 * className::methodName
		*/
		
		
//		==================== NONE FUNCTIONAL ====================
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,10,5-2,-10,20));
		List<Integer> res = find(list, new Predicate<Integer>()
		{
			@Override
			public boolean test(Integer t)
			{
				return t >= 0;
			}
		});
		System.out.println(res);
		System.out.println();
		
//		==================== FUNCTIONAL ====================
//		=== option 1 - TRUE
		res = find(list, t -> t >= 0);
		System.out.println(res);
		System.out.println();
		
//		=== option 2
		res = find(list, t -> 
		{
			return t >= 0;
		});
		System.out.println(res);
		System.out.println();
		
//		==================== NONE FUNCTIONAL ====================
		list.sort(new Comparator<Integer>()
		{
			@Override
			public int compare(Integer o1, Integer o2)
			{
				return o1-o2;
			}
		});
		
//		==================== FUNCTIONAL ====================
		list.sort((n1, n2) -> n1-n2);
		System.out.println(list);
		System.out.println();
		
//		===
		list.sort((n1, n2) -> 
		{
			if(n1%2 == 0 && n2%2 != 0)	// missing
				return -1;
			if(n1%2==0 && n2%2==0)		// even sort
				return n1 - n2;
			if(n1%2!=0 && n2%2!=0)		// odd sort
				return n2-n1;
			return 1;					// else n1%2 != 0 && n2%2 == 0
		});
		System.out.println(list);
		System.out.println();
		
//		==================== Save variable ====================
		final Comparator<Integer> comp1 = (n1, n2) -> n1-n2;
		// Comparator<Integer> comp1 = (n1, n2) -> Integer.compare(n1,n2);
		
		final Comparator<Integer> comp2 = (n1, n2) -> 
		{
			if(n1%2 == 0 && n2%2 != 0)
				return -1;
			if(n1%2==0 && n2%2==0)
				return n1 - n2;
			if(n1%2!=0 && n2%2!=0)
				return n2-n1;
			return 1;
		};
		list.sort(comp1);
		list.sort(comp2);
		
		list.sort(Integer::compare); // Integer.compare(x, y)
		list.sort(FPAppl::evenOdd);  // FPAppl.evenOdd(n1, n2)
		System.out.println(list);
		System.out.println();
		
//		===
		list.forEach(elem -> System.out.println(elem));	// for(Integer elem : list) {System.out.println(elem));}
		System.out.println();
		
		list.forEach(System.out::println); // for (int i = 0; i < list.size(); i++) { System.out.println(list.get(i));}
		System.out.println();
		
//		===
		Printable p = s -> System.out.print(s);
		p.print("hello java");
	}
	
	
	private static int evenOdd(int n1, int n2)
	{
		if(n1%2 == 0 && n2%2 != 0)
			return -1;
		if(n1%2==0 && n2%2==0)
			return n1 - n2;
		if(n1%2!=0 && n2%2!=0)
			return n2-n1;
		return 1;
	}
	
	private static List<Integer> find(List<Integer> list, Predicate<Integer> pred)
	{
		List<Integer> res = new ArrayList<>();
		for(Integer num: list)
		{
			if(pred.test(num))
				res.add(num);
		}
		return res;
	}

}
