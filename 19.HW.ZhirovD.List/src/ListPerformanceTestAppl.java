import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTestAppl {
	private static final int SIZE = 10000;
	private static final int RUNS = 1000;
	
	public static void main(String[] args) {
		List<Integer> arrList = new ArrayList<>();
		List<Integer> linkList = new LinkedList<>();
		
		ListPerformanceTest arrayList = new ListPerformanceTest(arrList, SIZE, RUNS, "ARRAY LIST");
		ListPerformanceTest linkedList = new ListPerformanceTest(linkList, SIZE, RUNS, "LINKED LIST");
	
		arrayList.runAllTest();
		System.out.println();
		linkedList.runAllTest();
	}
}
