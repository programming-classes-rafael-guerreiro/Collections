package array.list;

import static java.lang.System.arraycopy;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class ArrayList<T> implements List<T> {
	private Object[] array;
	private int size = 0;

	public static <E> ArrayList<E> asList(E... array) {
		return new ArrayList<>(array);
	}

	public static <E> ArrayList<E> of(E... array) {
		if (array == null || array.length == 0)
			return new ArrayList<>(0);

		ArrayList<E> list = new ArrayList<>(array.length);
		list.addAll(array);
		return list;
	}

	public ArrayList() {
		this(16);
	}

	public ArrayList(int initialSize) {
		array = new Object[initialSize];
	}

	private ArrayList(Object[] array) {
		this.array = array;
		size = array.length;
	}

	@Override
	public String toString() {
		if (size == 0)
			return "[]";

		final StringBuilder builder = new StringBuilder("[").append(array[0]);
		for (int i = 1; i < size; i++)
			builder.append(',').append(' ').append(array[i]);

		return builder.append(']').toString();
	}

	// methods
	public void add(T s) {
		checkSpace(1);
		array[size++] = s;
		// equal to
		// array[size] = s;
		// size++;
	}

	public void insert(int index, T value) {
		insertAll(index, value);
	}

	public int size() {
		return size;
	}

	private void checkSpace(int space) {
		if (hasSpace(space))
			return;

		increaseSpace(space);
	}

	private boolean hasSpace(int space) {
		return size + space < array.length;
	}

	private void increaseSpace(int space) {
		Object[] newArray = new Object[((array.length + 1) * 2) + space];

		// for (int i = 0; i < array.length; i++) {
		// newArray[i] = array[i];
		// }
		//
		System.arraycopy(array, 0, newArray, 0, array.length);

		array = newArray;
	}

	public void clear() {
		array = new Object[16];
		size = 0;
	}

	public T set(int index, T value) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException(index);

		T oldValue = (T) array[index];
		array[index] = value;
		return oldValue;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T get(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException(index);
		return (T) array[index];
	}

	public int indexOf(T value) {
		return indexOf(value, 0);
	}

	// a b c d e a b c d e
	// indeof (b) retorna 1
	//

	public int indexOf(T value, int position) {
		if (0 > position || position >= size)
			throw new ArrayIndexOutOfBoundsException(position);
		for (int i = position; i < size; i++) {
			int index = compare(value, i);
			if (index != -1)
				return index;
		}
		return -1;
	}

	public int lastIndexOf(T value) { // [a,a,a,a,a,a] deve retornar 5
		for (int i = size - 1; i >= 0; i--) {
			int index = compare(value, i);
			if (index != -1)
				return index;
		}
		return -1;
	}

	private int compare(T value, int i) {
		if (array[i] == value)
			return i;

		if (value == null) {
			if (array[i] == null)
				return i;
		} else if (value.equals(array[i]))
			return i;
		return -1;
	}

	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	public void addAll(T... array) {
		if (array == null || array.length == 0)
			return;

		addAll(array.length, array);
	}

	public void addAll(List<T> list) {
		if (list == null || list.isEmpty())
			return;

		if (list instanceof ArrayList) {
			ArrayList<T> l = (ArrayList<T>) list;
			addAll(l.size, l.array);
			return;
		}

		checkSpace(list.size());
		for (int index = 0; index < list.size(); index++)
			add(list.get(index));
	}

	private void addAll(final int length, Object[] array) {
		checkSpace(length);
		System.arraycopy(array, 0, this.array, size, length);
		size += length;
	}

	public void insertAll(int index, T... array) {
		validateIndex(index);

		if (array == null || array.length == 0)
			return;

		insertAll(index, array.length, array);
	}

	public void insertAll(int index, List<T> list) {
		validateIndex(index);

		if (list == null || list.isEmpty())
			return;

		if (list instanceof ArrayList) {
			ArrayList<T> l = (ArrayList<T>) list;
			insertAll(index, l.size, l.array);
			return;
		}

		checkSpace(list.size());
		for (int ix = 0; ix < list.size(); ix++)
			insert(index + ix, list.get(ix));
	}

	private void insertAll(final int index, final int length, Object[] array) {
		if (index == size) {
			addAll(length, array);
			return;
		}

		checkSpace(length);

		arraycopy(this.array, index, this.array, index + length, size - index);
		arraycopy(array, 0, this.array, index, length);

		size += length;
	}

	public T remove(final int index) {
		validateIndex(index);

		final T value = (T) array[index];

		arraycopy(array, index + 1, array, index, size - index);
		array[--size] = null;

		return value;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public T next() {	
				return get(index++);
			}
		};
	}

	private void validateIndex(int index) {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException(index);
	}

	// como criar a lista

	// OK - adicionar no fim
	// OK - contar o Array
	// OK - toString
	// OK - alterar
	// OK - checar se é vazia
	// OK - limpar o Array
	// OK - ler alguma posicao
	// OK - retornar o primeiro indice de um valor na lista
	// OK - retornar o ultimo indice de um valor na lista
	// OK - adicionar em qualquer posi��o
	// OK - retornar o primeiro indice de um valor na lista a partir de um
	// indice
	// OK - adicionar vários elementos no final
	// OK - adicionar mais de um elemento em qualquer posicao
	// OK - retirar de uma posicao

	// Habilitar foreach

	// ordenar a lista maior > menor
	// ordenar a lista menor > maior
	// procurar valor na lista
}
