import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MyHashSet<E> implements Set<E> {
	// FIELDS & Constructors
	List<E>[] table;
	int size;
	int capacity;
	double loadFactor;

	@SuppressWarnings("unchecked")
	public MyHashSet(int capacity, double loadFactor) {
		table = new LinkedList[capacity];
		this.capacity = capacity;
		this.loadFactor = loadFactor;
	}

	@SuppressWarnings("unchecked")
	public MyHashSet(int capacity) {
		table = new LinkedList[capacity];
		this.capacity = capacity;
		this.loadFactor = 0.75;
	}

	public MyHashSet() {
		this(16, 0.75); // link to MyHashSet(capacity, loadFactor)

		// Option 2
//		table = new LinkedList[16];
//		this.capacity = 16;
//		this.loadFactor = 0.75;
	}

//	==============================================================

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		int index = getIndex(o);
		if (table[index] == null)
			return false;

		return table[index].contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int totalCount = 0;
			int arrayIndex = 0;
			int listIndex = 0;

			@Override
			public boolean hasNext() {
				return totalCount < size;
			}

			/*
			 * null {1,2} {} {3,4,5} {6}
			 */
			@Override
			public E next() {
				// null
				// table[index] == null -> arrayIndex = 1
				while (table[arrayIndex] == null || table[arrayIndex].isEmpty()) {
					arrayIndex++; // 0 -> 1 ({1,2})
					// end with null -> next list {1,2}
				}

				// {1,2}
				// table[arrayList] = {1, 2}
				// get(listIndex) = 1 (listIndex now is 0) -> 2 (listIndex now is 1)
				E res = table[arrayIndex].get(listIndex);
				totalCount++; // 0 -> 1 -> 2

				// 0 < 1 TRUE -> 1 < 1 FALSE
				if (listIndex < table[arrayIndex].size() - 1) // size = 2, 2 - 1 = 1
					listIndex++; // 0 -> 1 -> to else
				else {
					listIndex = 0;
					arrayIndex++; // 1 -> 2
				}
				return res; // 2
			}
		};
	}

	@Override
	public Object[] toArray() {
		Object[] res = new Object[size];
		int index = 0;

		for (int i = 0; i < table.length; i++) {
			if (table[i] == null || table[i].isEmpty())
				continue;
			for (Object o : table[i]) {
				res[index] = o;
				index++;
			}
		}
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// DON'T TOUCH
		return null;
	}

	@Override
	public boolean add(E e) {
		if (contains(e)) // if duplicated
			return false;
		if (capacity < size)
			recreation();

		int index = getIndex(e);

		if (table[index] == null)
			table[index] = new LinkedList<>();

		table[index].add(e); // in tail
		size++;
		return true;
	}

	private int getIndex(Object obj) {
		int hash = obj.hashCode();
		return Math.abs(hash) % capacity;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void recreation() {
		capacity += 16;
		LinkedList[] temp = new LinkedList[capacity + 16];

		for (int i = 0; i < table.length; i++) {
			if (table[i] == null)
				continue;

			for (E obj : table[i]) {
				int index = getIndex(obj);

				if (temp[index] == null)
					temp[index] = new LinkedList<>();
				temp[index].add(obj);
			}
		}
		table = temp;
	}

	@Override
	public boolean remove(Object o) {
		if (!contains(o))
			return false;

		int index = getIndex(o);
		table[index].remove(o);
		size--;

		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object obj : c)
		{
			if (!contains(obj))
				return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		int oldSize = size;
		for (E e : c)
		{
			add(e);
		}
		return oldSize < size;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		int oldSize = size;
		MyHashSet<E> temp = new MyHashSet<>();
		for(E e: this)
		{
			if(c.contains(e))
				temp.add(e);
		}
		clear();
		addAll(temp);
		return oldSize != size;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		int oldSize = size;
		MyHashSet<E> temp = new MyHashSet<>();
		for(E e: this)
		{
			if(!c.contains(e))
				temp.add(e);
		}
		clear();
		addAll(temp);
		return oldSize != size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		table = new LinkedList[capacity];
		size = 0;
	}

}
