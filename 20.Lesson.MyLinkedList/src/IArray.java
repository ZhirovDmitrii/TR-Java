import java.util.Comparator;
import java.util.function.Predicate;

public interface IArray<T> extends Iterable<T> {
	boolean add(T obj);				// add - true, not add - false (add to end)
	boolean add(int index, T obj);	// add by index and what i want add
	T get(int index);				// return object by index
	int size();						// return array size
	int indexOf(T obj);				// return object index from start array
	int lastIndexOf(T object);		// ................... from end array
	T remove(int index); 			// return object by index
	boolean remove(T obj);			// remove - true
	boolean contains(T obj);		// If there is an object in the array - true
	Object[] toArray();				// create object array, copy array from collection and return this array

	boolean set(T obj, int index);	// change value by index
	void addAll(IArray<T> other);	// add all elements to our array from other array
	boolean removeAll(T obj);		// remove all elements from array
	void addAll(int index, IArray<T> other);	// add to our array all elements from other array by index
	
	void sort(Comparator<T> comp);
	
	boolean removeIf(Predicate<T> pred);
	int indexOf(Predicate<T> pred);
	int lastIndexOf(Predicate<T> pred);
	
	boolean isEmpty();
	void clear();
}