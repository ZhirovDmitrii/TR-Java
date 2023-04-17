public interface IArray {
	boolean add(Object obj);			// add - true, not add - false (add to end)
	boolean add(int index, Object obj);	// add by index and what i want add
	Object get(int index);				// return object by index
	int size();							// return array size
	int indexOf(Object obj);			// return object index from start array
	int lastIndexOf(Object object);		// ... from end array
	Object remove(int index); 			// return object by index
	boolean remove(Object obj);			// remove - true
	boolean contains(Object obj);		// If there is an object in the array - true
	Object[] toArray();					// create object array, copy array from collection and return this array
}