package array.list;

import static array.list.ArrayList.asList;

import java.util.Iterator;

// Single linked list
// Double linked list
public class LinkedList<T> implements List<T>, Stack<T>, Queue<T> {
	private Node<T> head;
	private Node<T> tail;

	private int size = 0;

	public static <E> LinkedList<E> of(E... array) {
		if (array == null || array.length == 0)
			return new LinkedList<>();

		LinkedList<E> list = new LinkedList<>();
		list.addAll(array);
		return list;
	}

	@Override
	public void add(T s) {
		final Node<T> element = new Node<>(s);

		if (isEmpty())
			head = element;
		else {
			element.setPrevious(tail);
			tail.setNext(element);
		}

		tail = element;
		size++;
	}

	@Override
	public void insert(int index, T value) {
		validateIndex(index);

		if (index == 0) {
			insertFirst(value);
			return;
		}

		if (index == size) {
			insertLast(value);
			return;
		}

		final Node<T> next = getElement(index);
		final Node<T> previous = next.getPrevious();
		final Node<T> current = new Node<>(previous, value, next);
		next.setPrevious(current);
		previous.setNext(current);

		size++;
	}

	public void insertFirst(T value) {
		if (isEmpty()) {
			add(value);
			return;
		}

		final Node<T> element = new Node<T>(null, value, head);
		head.setPrevious(element);
		head = element;

		size++;
	}

	public void insertLast(T value) {
		add(value);
	}

	private void validateIndex(int index) {
		if (index < 0 || index > size)
			throwIndexOutOfBounds(index);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public T set(int index, T value) {
		return getElement(index).setValue(value);
	}

	private Node<T> getElement(int index) {
		validateIndexInSize(index);

		if (index == 0)
			return head;

		if (index == size - 1)
			return tail;

		if (index < (size >> 1))
			return lookForward(index);

		return lookBackwards(index);
	}

	private Node<T> lookForward(int index) {
		Node<T> element = head;
		for (int count = 0; count < index; count++)
			element = element.getNext();

		return element;
	}

	private Node<T> lookBackwards(int index) {
		Node<T> element = tail;
		for (int count = size - 1; count > index; count--)
			element = element.getPrevious();

		return element;
	}

	private void validateIndexInSize(int index) {
		if (index < 0 || index >= size)
			throwIndexOutOfBounds(index);
	}

	private void throwIndexOutOfBounds(int index) {
		throw new IndexOutOfBoundsException("index out of range: " + index);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T get(int index) {
		return getElement(index).getValue();
	}

	public T getFirst() {
		if (isEmpty())
			throw new IllegalStateException("Cannot get first from empty linked list.");

		return head.getValue();
	}

	public T getLast() {
		if (isEmpty())
			throw new IllegalStateException("Cannot get last from empty linked list.");

		return tail.getValue();
	}

	@Override
	public int indexOf(T value) {
		return indexOf(value, 0);
	}

	@Override
	public int indexOf(T value, int position) {
		validateIndexInSize(position);

		if (isEmpty())
			return -1;

		Node<T> element = head;
		for (int index = 0; index < size; index++) {
			if (index >= position && compareValue(element.getValue(), value))
				return index;

			element = element.getNext();
		}

		return -1;
	}

	private boolean compareValue(T v1, T v2) {
		if (v1 == v2)
			return true;

		if (v1 == null)
			return false;

		return v1.equals(v2);
	}

	@Override
	public int lastIndexOf(T value) {
		if (isEmpty())
			return -1;

		Node<T> element = tail;
		for (int index = size - 1; index >= 0; index--) {
			if (compareValue(element.getValue(), value))
				return index;

			element = element.getPrevious();
		}

		return -1;
	}

	@Override
	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	@Override
	public void addAll(T... array) {
		if (array == null || array.length == 0) // guard clause
			return;

		addAll(asList(array));
	}

	@Override
	public void addAll(List<T> list) {
		if (list == null || list.isEmpty())
			return;

		for (T element : list)
			add(element);
	}

	@Override
	public void insertAll(int index, T... array) {
		validateIndex(index);
		if (array == null || array.length == 0)
			return;

		insertAll(index, asList(array));
	}

	@Override
	public void insertAll(int index, List<T> list) {
		validateIndex(index);
		if (list == null || list.size() == 0)
			return;

		if (index == size) {
			addAll(list);
			return;
		}

		Node<T> last = getElement(index);
		Node<T> current = last.getPrevious();
		Node<T> first = null;

		for (T e : list) {
			Node<T> newElement = new Node<>(current, e, null);

			if (current != null)
				current.setNext(newElement);

			current = newElement;
			if (first == null)
				first = current;
		}

		current.setNext(last);
		last.setPrevious(current);

		if (index == 0)
			head = first;

		size += list.size();
	}

	private void validateState() {
		if (isEmpty())
			throw new IllegalStateException("The linked list is empty.");
	}

	public T removeFirst() {
		validateState();

		T old = head.getValue();
		head = head.getNext();
		head.setPrevious(null);

		if (head == null)
			tail = null;

		size--;
		return old;
	}

	@Override
	public T remove(int index) {
		validateIndexInSize(index);

		if (index == 0)
			return removeFirst();

		Node<T> current = getElement(index);

		Node<T> previous = current.getPrevious();
		Node<T> next = current.getNext();

		previous.setNext(next);
		if (next == null)
			tail = previous;
		else
			next.setPrevious(previous);

		size--;
		return current.getValue();
	}

	@Override
	public void push(T value) {
		add(value);
	}

	@Override
	public T pop() {
		validateState();
		return remove(size - 1);
	}

	@Override
	public T peek() {
		validateState();
		return tail.getValue();
	}

	@Override
	public void enqueue(T value) {
		add(value);
	}

	@Override
	public T dequeue() {
		return removeFirst();
	}

	@Override
	public T poll() {
		validateState();
		return head.getValue();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> next = head;

			@Override
			public boolean hasNext() {
				return next != null;
			}

			@Override
			public T next() {
				T value = next.getValue();
				next = next.getNext();
				return value;
			}
		};
	}

	// inner-class
	private static class Node<E> implements Cloneable {
		private Node<E> previous;
		private E value;
		private Node<E> next;

		public Node(E value) {
			this(null, value, null);
		}

		public Node(Node<E> previous, E value, Node<E> next) {
			this.previous = previous;
			this.value = value;
			this.next = next;
		}

		@Override
		protected Node<E> clone() throws CloneNotSupportedException {
			final Node<E> previous = this.previous == null ? null : this.previous.clone();
			final Node<E> next = this.next == null ? null : this.next.clone();

			return new Node<E>(previous, value, next);
		}

		public E getValue() {
			return value;
		}

		public E setValue(E value) {
			E old = this.value;
			this.value = value;
			return old;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public boolean hasNext() {
			return next != null;
		}

		public Node<E> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<E> previous) {
			this.previous = previous;
		}

		public boolean hasPrevious() {
			return previous != null;
		}
	}
}