import java.util.Arrays;

public class MyArray implements IArray {

	// Fields
	private static final int DEFAULT_CAPACITY = 16; // if user not enter capacity

	private Object[] array; // custom array
	private int size = 0; // number of array elements
//	====================================================

	// Constructors
	public MyArray(int capacity) {
		array = new Object[capacity];
	}

	public MyArray() {
//		array = new Object[DEFAULT_CAPACITY];
		this(DEFAULT_CAPACITY);
	}
//	====================================================

	@Override
	public boolean add(Object obj) {
		if (obj == null)
			return false;
		if (size == array.length)
			allocateArray(); // if no more space for new elements in array - create new space

		array[size] = obj; // write information about the new array by index
		size++;
		return true;
	}

	// Method - create more space for array elements and new link to array
	private void allocateArray() {
		array = Arrays.copyOf(array, array.length + DEFAULT_CAPACITY);
	}
	
//	====================================================


	@Override
	public Object get(int index) {
		if (index < 0 || index >= size)// last index - size-1
			return null;
		return array[index];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(Object obj) {
		if (obj == null)
			return -1;

		for (int i = 0; i < size; i++) {
			if (array[i].equals(obj)) // not array[i] == object, BECAUSE with objects works only equals
				return i;
		}

		return -1; // error
	}

	@Override
	public Object remove(int index) {
		if (index < 0 || index >= size)
			return null;

		Object res = array[index];

		if (index < size - 1)
			System.arraycopy(array, index + 1, array, index, size - index - 1);
		size--;

		return res;
	}

	@Override
	public boolean remove(Object obj) {
		// Option 1
		int index = indexOf(obj);
		return remove(index) != null;
		
		// Option 2
//		return remove(indexOf(obj)) != null;
		
		// Option 3
//		Object res = remove(index);
//		if(res == null)
//			return false;
//		else
//			return true;
	}

	//========= HW =========

		@Override
		public boolean add(int index, Object obj) {
			if(index < 0 || index > size || obj == null)
				return false;
			if (size == array.length)
				allocateArray();
			
			System.arraycopy(array, index, array, index + 1, size - index);
			array[index] = obj;
			size++;
			
			return true;
		}
	
	@Override
	public boolean contains(Object obj) {
		for(int i = 0; i < size; i++) {
			if(array[i].equals(obj))
				return true;
		}
		
		return false;
	}
	

	@Override
	public int lastIndexOf(Object obj) {
		if (obj == null)
			return -1;
		
		for(int i = size - 1; i >= 0; i--) {
			if(array[i].equals(obj))
				return i;
		}
		
		return -1;
	}

	@Override
	public Object[] toArray() {	
		return Arrays.copyOf(array, size); // size = 0
	}

}
