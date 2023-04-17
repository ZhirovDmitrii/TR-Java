import java.util.Comparator;

public interface IArray<E> {
	boolean add(E obj);				// add - true, not add - false (add to end)
	boolean add(int index, E obj);	// add by index and what i want add
	E get(int index);				// return object by index
	int size();						// return array size
	int indexOf(E obj);				// return object index from start array
	int lastIndexOf(E object);		// ................... from end array
	E remove(int index); 			// return object by index
	boolean remove(E obj);			// remove - true
	boolean contains(E obj);		// If there is an object in the array - true
	Object[] toArray();				// create object array, copy array from collection and return this array

	boolean set(E obj, int index);	// change value by index
	void addAll(MyArray<E> other);	// add all elements to our array from other array
	boolean removeAll(E obj);		// remove all elements from array
	void addAll(int index, MyArray<E> other);	// add to our array all elements from other array by index
	
	void sort(Comparator<E> comp);
}