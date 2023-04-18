package repeat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class MyArray<E> implements IArray<E> {

	private static final int DEFAULT_CAPACITY = 16;

	private Object[] array; // don't touch
	private int size = 0;
//	====================================================

	public MyArray(int capacity) {
		array = new Object[capacity];
	}

	public MyArray() {
//		array = new Object[DEFAULT_CAPACITY];
		this(DEFAULT_CAPACITY);
	}
//	====================================================

	@Override
	public boolean add(E obj) {
		if (obj == null)
			return false;
		if (size == array.length)
			allocateArray();

		array[size] = obj;
		size++;
		return true;
	}

	private void allocateArray() {
		array = Arrays.copyOf(array, array.length + DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if (index < 0 || index >= size)// last index - size-1
			return null;
		return (E) array[index];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(E obj) {
		if (obj == null)
			return -1;

		for (int i = 0; i < size; i++) {
			if (array[i].equals(obj)) // not array[i] == object, BECAUSE with objects works only equals
				return i;
		}

		return -1; // error
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size)
			return null;

		Object res = array[index];

		if (index < size - 1)
			System.arraycopy(array, index + 1, array, index, size - index - 1);
		size--;

		return (E) res;
	}

	@Override
	public boolean remove(E obj) {
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

	@Override
	public boolean add(int index, E obj) {
		if (index < 0 || index > size || obj == null)
			return false;
		if (size == array.length)
			allocateArray();

		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;

		return true;
	}

	@Override
	public boolean contains(E obj) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(obj))
				return true;
		}

		return false;
	}

	@Override
	public int lastIndexOf(E obj) {
		if (obj == null)
			return -1;

		for (int i = size - 1; i >= 0; i--) {
			if (array[i].equals(obj))
				return i;
		}

		return -1;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

//	===== HW =====

	// Task 2
	@Override
	public boolean set(E obj, int index) {
		if (obj == null || index < 0 || index >= size)
			return false;

		array[index] = obj;

		return true;
	}

	// Task 3
	@Override
	public void addAll(MyArray<E> other) {
		if (other == null || other.size() == 0)
			return;

		for (int i = 0; i < other.size; i++) {
			add(other.get(i));		// take element by index via get() and via add() in array
		}
	}

	// Task 4
//	Teacher solutions
	@Override
	public boolean removeAll(E obj) {
		if(obj == null)
			return false;
		
		//Solution 1
//		boolean flag = false;
//		for(int i=0; i<size; i++)
//		{
//			if(array[i].equals(obj))
//			{
//				remove(obj);   {1,12,2} -> 1
//				i--;
//				flag = true;
//			}
//		}
//		return flag;

		//Solution 2
//		int temp = size;
//		for (int i=size-1; i >=0; i--)
//		{
//			if (array[i].equals(obj))
//				remove(i);
//		}
//		return temp != size;
		
		// Solution 3
		int count = 0;
		while (remove(obj))
			count++;
		return count>0;
	}

	// Task 5
//	Teacher solution
	@Override
	public void addAll(int index, MyArray<E> other) {
		if (index >= 0 && index <= size && other != null && other.size() != 0)
		{
			if (index == size)
				addAll(other);
			else
			{
				shiftRight(index, other.size);
				System.arraycopy(other.array, 0, array, index, other.size);
				size += other.size;
			}
		}
	}

	private void shiftRight(int ind, int otherSize)
	{
		if (size + otherSize > array.length)
		{
			int newCapacity = Math.max(size + otherSize, array.length + DEFAULT_CAPACITY);
			array = Arrays.copyOf(array, newCapacity);
		}
		System.arraycopy(array, ind, array, ind + otherSize, size - ind);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort(Comparator<E> comp) {
		boolean flag = true;
		int index = size-1;
		do
		{
			flag = true;
			for(int i=0; i<index; i++)
			{
				if(comp.compare((E)array[i], (E)array[i+1]) > 0)
				{
					swap(i, i+1);
					flag = false;
				}
			}
			index--;
		}
		while(!flag);
	}
	
	@SuppressWarnings("unchecked")
	private void swap(int i, int j)
	{
		E temp = (E) array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean removeIf(Predicate<E> pred) {
		if(pred == null)
			return false;
		
		Object[] buf = new Object[array.length];	// create empty array
		int indBuf = 0;		// create size for buf
		
		for(int i = 0; i < size; i++) {
			if(!pred.test((E)array[i]))
					buf[indBuf++] = array[i];	// if FALSE - save elements
		}
		
		array = buf;	// overwriting array
		boolean res = indBuf != size;	// check length
		size = indBuf;	// overwriting length array
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(Predicate<E> pred) {
		if(pred == null)
			return -1;
		
		for(int i = 0; i < size; i++)
			if(pred.test((E)array[i]))
					return i;
		
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int lastIndexOf(Predicate<E> pred) {
		if(pred == null)
			return -1;
		
		for(int i = size - 1; i >= 0; i--)
			if(pred.test((E)array[i]))
				return i;
		
		return -1;
	}
}