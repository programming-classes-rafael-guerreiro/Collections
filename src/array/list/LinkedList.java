package array.list;

public class LinkedList<T> implements List<T> {
	private Element<T> head;
	private Element<T> tail;

	private int size = 0;

	@Override
	public void add(T s) {
		final Element<T> element = new Element<>(s);

		if (isEmpty())
			head = element;
		else
			tail.setNext(element);

		tail = element;
		size++;
	}

	@Override
	public void insert(int index, T value) {
		// TODO Auto-generated method stub

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

	private Element<T> getElement(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException(index);

		if (index == 0)
			return head;

		if (index == size - 1)
			return tail;

		Element<T> element = head;
		for (int count = 0; count < index; count++)
			element = element.getNext();

		return element;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int indexOf(T value, int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(T value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addAll(T... array) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAll(List<T> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertAll(int index, T... array) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertAll(int index, List<T> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	// inner-class
	private static class Element<E> {
		private E value;
		private Element<E> next;

		public Element(E value) {
			this(value, null);
		}

		public Element(E value, Element<E> next) {
			this.value = value;
			this.next = next;
		}

		public E getValue() {
			return value;
		}

		public E setValue(E value) {
			E old = this.value;
			this.value = value;
			return old;
		}

		public Element<E> getNext() {
			return next;
		}

		public void setNext(Element<E> next) {
			this.next = next;
		}

		public boolean hasNext() {
			return next != null;
		}
	}
}