import java.util.List;

class ListPerformanceTest {
	private List<Integer> list;
	private int size;	// size our array (length)
	private int nRuns;	// how many times will run the list (array)
	private String listType;

	public ListPerformanceTest(List<Integer> list, int size, int nRuns, String listType) {
		this.list = list;
		this.size = size;
		this.nRuns = nRuns;
		this.listType = listType;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
//	==========================================

	// will fill list with numbers from 1 to size
	@SuppressWarnings("unused")
	private void setUp() {
		list.clear(); // clear list after another method
		for (int i = 1; i <= size; i++)
			list.add(i);
	}

	// run all tests
	public void runAllTest() {
		addRemoveTest();
		containsTest();
		subListTest();
		getAtIndexTest();
		interatorTest();
	}
//	==========================================
	
	// will just iterate our array
	private void interatorTest() {
		setUp();// fill list

		long start = System.currentTimeMillis(); // start test

		for (int i = 0; i < nRuns; i++)
			for (int j = 0; j < list.size(); j++)
				list.get(j); // just take an elements our array AND make it NRUNS

		printResult("Iterator test", start, System.currentTimeMillis()); // finish test
	}
//	==========================================

	private void getAtIndexTest() {
		setUp();
		
		long start = System.currentTimeMillis();	// start test
		
		for(int i = 0; i < nRuns; i++)
			list.get(getIndex());	// just get index

		printResult("Get at index test", start, System.currentTimeMillis());
	}
	
//	==========================================

	private void subListTest() {
		setUp();
		
		long start = System.currentTimeMillis();	// start test
		
		int fInd, sInd;
		List<Integer> sub = null;
		
		for(int i = 0; i < nRuns; i++) {
			fInd = getIndex();
			sInd = getIndex();
			
			if(fInd > sInd)
				sub = list.subList(sInd, fInd);
			else
				sub = list.subList(fInd, sInd);
			
			// iterating
			for(int j = 0; j < sub.size(); j++)
				list.get(j);
		}
		
		printResult("Sub list test", start, System.currentTimeMillis());	// finish test
	}

//	==========================================
	
	// find elements nRuns
	private void containsTest() {
		setUp();	// fill list

		long start = System.currentTimeMillis(); // start test
		
		for(int i = 0; i < nRuns; i++)
			list.contains(getIndex());	// find random elements nRuns
	
		printResult("Contains test", start, System.currentTimeMillis()); // finish test
	}
	
//	==========================================

	// add and remove random element
	private void addRemoveTest() {
		setUp(); // fill list
		int index = 0;

		long start = System.currentTimeMillis(); // start test
		
		for (int i = 0; i < nRuns; i++) {
			// add
			index = getIndex();		// index = random index
			list.add(index, 1000);	// initialize this index element number = 1000
			
			// remove
			index = getIndex();		// index = random index
			list.remove(index);		// remove element this index
		}
		
		printResult("Add/remove test", start, System.currentTimeMillis()); // finish test
	}

	// generate random index from 0 to size-1
	private int getIndex() {
		return (int) (Math.random() * size);
	}

	private void printResult(String name, Long start, Long finish) {
		System.out.printf("list type:%s; test name:%s, running time:%d\n", listType, name, finish - start);
	}
}