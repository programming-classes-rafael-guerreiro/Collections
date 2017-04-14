package array.list;

public class LinkedList<T> implements List<T> {
	private Element<T> head;
	private Element<T> tail;

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
		validateIndex(index);

		if (index == 0) {
			insertFirst(value);
			return;
		}

		if (index == size) {
			insertLast(value);
			return;
		}

		final Element<T> previous = getElement(index - 1);
		final Element<T> current = new Element<>(value, previous.getNext());
		previous.setNext(current);
		size++;
	}

	public void insertFirst(T value) {
		if (isEmpty()) {
			add(value);
			return;
		}

		final Element<T> element = new Element<T>(value, head);
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

	private Element<T> getElement(int index) {
		if (index < 0 || index >= size)
			throwIndexOutOfBounds(index);

		if (index == 0)
			return head;

		if (index == size - 1)
			return tail;

		Element<T> element = head;
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

		Element<T> element = head;
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

		add(array[0]);

		Element<T> current = tail;
		for (int index = 1; index < array.length; index++) {
			Element<T> element = new Element<>(array[index]);
			current.setNext(element);
			current = element;
		}

		tail = current;
		size += array.length - 1;
	}

	@Override
	public void addAll(List<T> list) {
		if (list == null || list.isEmpty())
			return;

		if (list instanceof LinkedList) {
			LinkedList<T> linked = (LinkedList<T>) list;

			try {
				tail.setNext(linked.head.clone());

				while (tail.getNext() != null)
					tail = tail.getNext();

				size += linked.size();
			} catch (CloneNotSupportedException e) {
			}

			return;
		}

		for (int index = 0; index < list.size(); index++)
			add(list.get(index));
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
	private static class Element<E> implements Cloneable {
		private E value;
		private Element<E> next;

		public Element(E value) {
			this(value, null);
		}

		public Element(E value, Element<E> next) {
			this.value = value;
			this.next = next;
		}

		@Override
		// TODO keep talking about memory reference.
		protected Element<E> clone() throws CloneNotSupportedException {
			if (next == null)
				return new Element<>(value);

			return new Element<E>(value, next.clone());
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