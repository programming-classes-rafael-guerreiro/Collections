package array.list;

import static array.list.ArrayList.asList;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {
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
		else
			tail.setNext(element);

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

		final Node<T> previous = getElement(index - 1);
		final Node<T> current = new Node<>(value, previous.getNext());
		previous.setNext(current);
		size++;
	}

	public void insertFirst(T value) {
		if (isEmpty()) {
			add(value);
			return;
		}

		final Node<T> element = new Node<T>(value, head);
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
		if (index < 0 || index >= size)
			throwIndexOutOfBounds(index);

		if (index == 0)
			return head;

		if (index == size - 1)
			return tail;

		Node<T> element = head;
		for (int count = 0; count < index; count++)
			element = element.getNext();

		return element;
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
		if (position < 0 || position >= size)
			throwIndexOutOfBounds(position);

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
		// TODO Auto-generated method stub
		return 0;
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

		Node<T> current = null;
		if (index > 0)
			current = getElement(index - 1);

		Node<T> first = null;
		final Node<T> next = current == null ? head : current.getNext();
		for (T e : list) {
			Node<T> newElement = new Node<>(e);

			if (current != null)
				current.setNext(newElement);

			current = newElement;
			if (first == null)
				first = current;
		}

		current.setNext(next);

		if (index == 0)
			head = first;

		size += list.size();
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
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
		private E value;
		private Node<E> next;

		public Node(E value) {
			this(value, null);
		}

		public Node(E value, Node<E> next) {
			this.value = value;
			this.next = next;
		}

		@Override
		// TODO keep talking about memory reference.
		protected Node<E> clone() throws CloneNotSupportedException {
			if (next == null)
				return new Node<>(value);

			return new Node<E>(value, next.clone());
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
	}
}