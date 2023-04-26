package repeat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTestAppl {
	public static void main(String[] args) {
		List<Integer> arrList = new ArrayList<>();
		List<Integer> lnkList = new LinkedList<>();

		ListPerformanceTest arrListTest = new ListPerformanceTest(arrList, 1000, 10000, "ArrayList");
		ListPerformanceTest linListTest = new ListPerformanceTest(lnkList, 1000, 10000, "LinkedList");

		arrListTest.runAllTest();
		System.out.println();
		linListTest.runAllTest();
	}
}
