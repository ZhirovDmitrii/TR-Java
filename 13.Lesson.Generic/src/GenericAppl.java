
public class GenericAppl {

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) {
		String str = (String) get();

		int x = 10;
		double y = 10.1;
		boolean b = true;
		Object[] array = {x, y, b, str};
		
		Box<String> box = new Box<String>(str);
//		box.setValue(10);
//		Integer res = box.getValue();
		
		Box<Integer> box1 = new Box<Integer>(x);
		Box<Boolean> box2 = new Box<Boolean>(b);
		
		Pair<Integer, String> pair = new Pair<>(10, "hello");
		Pair<Integer, Integer> pair2 = new Pair<>(10, 10);
		Pair<Integer, String> pair3 = new Pair<>(100, "hello");
		
		Box[] array1 = {box, box1, box2};
		
		equalsPairs(pair, pair3);
		
		Integer i = 10;
		Number i1 = i;
//		Box<Number> box3 = box1;
		
	}
	
	public static <K, V> boolean equalsPairs(Pair<K, V> p1, Pair<K, V> p2)
	{
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}
	
	public static Object get()
	{
		return "str";
	}
}