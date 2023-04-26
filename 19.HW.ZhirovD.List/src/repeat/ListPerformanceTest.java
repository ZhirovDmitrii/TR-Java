package repeat;

import java.util.List;

public class ListPerformanceTest {
	private List<Integer> list;
	private int size;
	private int nRuns;
	private String listType;

	public ListPerformanceTest(List<Integer> list, int size, int nRuns, String listType) {
		super();
		this.list = list;
		this.size = size;
		this.nRuns = nRuns;
		this.listType = listType;
	}

	public List<Integer> getList() {
		return list;
	}

	public int getSize() {
		return size;
	}

	public int getnRuns() {
		return nRuns;
	}

	public String getListType() {
		return listType;
	}

	@Override
	public String toString() {
		return "ListPerformanceTest [list=" + list + ", size=" + size + ", nRuns=" + nRuns + ", listType=" + listType
				+ "]";
	}

//	============================================
	@SuppressWarnings("unused")
	private void setUp() {
		list.clear();
		for (int i = 1; i <= size; i++) {
			list.add(i);
		}
	}

	public void runAllTest() {
		addRemoveTest();
		containsTest();
		subListTest();
		getAtIndexTest();
		iteratotTest();
	}

	private void addRemoveTest() {
		setUp();
		int index;

		long start = System.currentTimeMillis();
		for (int i = 0; i < nRuns; i++) {
			index = getIndex();
			list.add(index, 665);
			list.remove(index);
		}
		testTimePrint("Add/remove test:", start, System.currentTimeMillis());
	}

	private void containsTest() {
		setUp();

		long start = System.currentTimeMillis();
		for (int i = 0; i < nRuns; i++) {
			list.contains(getIndex());
		}
		testTimePrint("Contains test:", start, System.currentTimeMillis());
	}

	private void subListTest() {
		setUp();
		int fInd, sInd;
		List<Integer> subNum = null;

		long start = System.currentTimeMillis();
		for (int i = 0; i < nRuns; i++) {
			fInd = getIndex();
			sInd = getIndex();
			if (fInd > sInd)
				subNum = list.subList(sInd, fInd);
			else
				subNum = list.subList(fInd, sInd);

			for (int j = 0; j < subNum.size(); j++)
				subNum.get(j);
		}
		testTimePrint("Sub test:", start, System.currentTimeMillis());
	}

	private void getAtIndexTest() {
		setUp();

		long start = System.currentTimeMillis();
		for (int i = 0; i < nRuns; i++) {
			list.get(getIndex());
		}
		testTimePrint("Get index test:", start, System.currentTimeMillis());
	}

	private void iteratotTest() {
		setUp();

		long start = System.currentTimeMillis();
		for(int i = 0; i < nRuns; i++) {
			for(int j = 0; j < list.size(); j++) {
				list.get(j);
			}
		}
		testTimePrint("Iterator test:", start, System.currentTimeMillis());
	}

	private int getIndex() {
		return (int) (Math.random() * size);
	}

	private void testTimePrint(String text, Long start, Long finish) {
		System.out.printf("%s - %s %d\n", listType, text, finish - start);
	}
}
