import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class MyLinkedList<T> implements IArray<T> {
	// !!! CLASS - NODE
	private static class Node<T> {
		T data; // link to object
		Node<T> pred;
		Node<T> next;

		public Node(T data, MyLinkedList.Node<T> pred, MyLinkedList.Node<T> next) {
			super();
			this.data = data;
			this.pred = pred;
			this.next = next;
		}
	}

	// FIELDS
	int size; // 0
	Node<T> head; // null
	Node<T> tail; // null
//	=========================================	

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> current = head;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				T obj = current.data;
				current = current.next;
				return obj;
			}
		};
	}

	@Override
	public boolean add(T obj) {
		if (obj == null)
			return false;

		Node<T> node = new Node<T>(obj, tail, null);
		// link to data (this our obj),
		// link to tail (pred) = null,
		// link to head(next) = null, because we don't have next obj now

		// 1st element (none pred/tail)
		if (tail == null) {
			head = node; // 1 obj
			tail = node; // 1 obj
		} else {
			// next elements
			tail.next = node; // LINK to 2... obj
			node.pred = tail; // LINK to 1... obj
		}
		tail = node; // 2 obj
		size++;

		return true;
	}

	@Override
	public boolean add(int index, T obj) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> node = new Node<T>(obj, null, null);

		// if empty - node is head and tail
		if (size == 0)
			head = tail = node;
		// add in head
		else if (index == 0) {
			node.next = head; // LINK to next obj
			head.pred = node; // LINK to prev obj
			head = node; // new element is head
		}
		// add in tail
		else if (index == size) {
			node.pred = tail; // LINK to tail
			tail.next = node; // LINK to prev obj
			tail = node; // LINK to new obj
		}
		// add in middle
		else {
			Node<T> curr = head;
			for (int i = 0; i < index - 1; i++)
				curr = curr.next;

			node.pred = curr; // pred LINK new obj to current
			node.next = curr.next; // next LINK new obj to nex element LINK after current obj...
			curr.next.pred = node; // update pred LINK
			curr.next = node; // update next LINK new element curr to new obj
		}
		size++;
		return true;
	}

	@Override
	public T get(int index) {
		Node<T> node = getNodeByIndex(index);
		return node.data;
	}

	private Node<T> getNodeByIndex(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException();

		Node<T> current;
		if (index <= size / 2) {
			current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		} else {
			current = tail;
			for (int i = size - 1; i > index; i--)
				current = current.pred;
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(T obj) {
		Node<T> node = head;
		int index = 0;

		while (node != null) {
			if (node.data.equals(obj)) {
				return index;
			}
			node = node.next;
			index++;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T object) {
		int index = 0;

		if (object == null) {
			for (Node<T> current = head; current != null; current = current.next) {
				if (current.data == null)
					return index;
				index++;
			}
		} else {
			for (Node<T> current = head; current != null; current = current.next) {
				if (current.data.equals(object))
					return index;
				index++;
			}
		}
		return -1;
	}

	@Override
	public T remove(int index) {
		Node<T> node = getNodeByIndex(index);

		// if(head.equals(tail))
		if (size == 1) {
			head = null;
			tail = null;
		}
		// delete 1st element
		else if (node.pred == null) {
			node.next.pred = null;
			head = head.next;
		}
		// delete last element
		else if (node.next == null) {
			node.pred.next = null;
			tail = tail.pred;
		}
		// delete between first and last elements
		else {
			node.pred.next = node.next;
			// took from the pred node a LINK to deleted obj and reinitialized to the next
			// obj from deleted
			node.next.pred = node.pred;
			// took from the next node a LINK to deleted obj and reinitialized the the pred
			// obj from deleted
		}

		size--;
		return node.data;
	}

	@Override
	public boolean remove(T obj) {
		Node<T> node = head;

		while (node != null) {
			if (node.data.equals(obj)) {
				if (node == head) {
					head = node.next;
					if (head != null) {
						head.pred = null;
					}
				} else if (node == tail) {
					tail = node.pred;
					tail.next = null;
				} else {
					node.pred.next = node.next;
					node.next.pred = node.pred;
				}
				size--;
				return true;
			}
			node = node.next;
		}
		return false;
	}

	@Override
	public boolean contains(T obj) {
//		Node<T> node = head;
//	    while (node != null) {
//	        if (node.data.equals(obj)) {
//	            return true;
//	        }
//	        node = node.next;
//	    }
//	    return false;

		return indexOf(obj) != -1;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		Node<T> curr = head;
		int index = 0;

		while (curr != null) {
			arr[index++] = curr.data;
			curr = curr.next;
		}
		return arr;
	}

	@Override
	public boolean set(T obj, int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		node.data = obj;
		return true;
	}

	@Override
	public void addAll(IArray<T> other) {
		for (T item : other)
			add(item);
	}

	@Override
	public boolean removeAll(T obj) {
		Node<T> node = head;
		int index = 0;
		boolean result = false;

		while (node != null) {
			if (node.data.equals(obj)) {
				remove(index);
				result = true;
				// shift elements, current index need don't touch so that checking next element
				index--;
			}
			node = node.next;
			index++;
		}
		return result;
	}

	@Override
	public void addAll(int index, IArray<T> other) {
		if (other == null) {
			return;
		}
		int pos = index;
		for (T obj : other)
			add(pos++, obj);
	}

	@Override
	public void sort(Comparator<T> comp) {
		
	}

	@Override
	public boolean removeIf(Predicate<T> pred) {
		boolean modified = false;
	    Node<T> node = head;
	    while (node != null) {
	        Node<T> next = node.next;
	        if (pred.test(node.data)) {
	            removeNode(node);
	            modified = true;
	        }
	        node = next;
	    }
	    return modified;
	}

	private void removeNode(Node<T> node) {
		if (node == null) {
	        return;
	    }
	    if (node.pred != null) {
	        node.pred.next = node.next;
	    } else {
	        head = node.next;
	    }
	    if (node.next != null) {
	        node.next.pred = node.pred;
	    } else {
	        tail = node.pred;
	    }
	    size--;
	}

	@Override
	public int indexOf(Predicate<T> pred) {
		Node<T> current = head;
		int index = 0;
		
		while (current != null) {
			if (pred.test(current.data)) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Predicate<T> pred) {
		Node<T> current = tail;
		int index = size - 1;
		while (current != null) {
			if (pred.test(current.data)) {
				return index;
			}
			current = current.pred;
			index--;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
}
