package array.list;

import java.util.Arrays;

public class ArrayList {
	// constant

	// fieds

	private String[] array;
	private int size = 0;

	// constructor
	public ArrayList() {
		this(16);

	}

	public ArrayList(int initialSize) {
		array = new String[initialSize];
	}

	@Override
	public String toString() {
		if (size == 0)
			return "[]";
		String s = "";
		String comma = "[";
		for (int i = 0; i < size; i++) {
			s += comma + array[i];
			comma = ", ";
		}
		return s + "]";
	}

	// methods
	public void add(String s) {
		checkSpace();
		array[size++] = s;
		// equal to
		// array[size] = s;
		// size++;
	}

	public int size() {
		return size;
	}

	private void checkSpace() {
		if (hasSpace())
			return;

		increaseSpace();
	}

	private boolean hasSpace() {
		return size < array.length;
	}

	private void increaseSpace() {
		String[] newArray = new String[(array.length + 1) * 2];

		// for (int i = 0; i < array.length; i++) {
		// newArray[i] = array[i];
		// }
		//
		System.arraycopy(array, 0, newArray, 0, array.length);

		array = newArray;
	}

	public void clear() {
		array = new String[16];
		size = 0;
	}

	public String set(int index, String value) {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException(index);
		String oldValue = array[index];
		array[index] = value;
		return oldValue;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String get(int index) {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException(index);
		return array[index];
	}

	public int indexOf(String value) { // [a,a,a,a,a,a] deve retornar 0
		for (int i = 0; i < size; i++) {
			int index = compare(value, i);
			if (index != -1)
				return index;

		}
		return -1;
		// hipotestes
		// 1) Array[i] == null e value != null
		// 2) Array[i] != null e value != null
		// 3) Array[i] == null e value == null
		// 4) Array[i] != null e value == null
	}

	public int lastIndexOf(String value) { // [a,a,a,a,a,a] deve retornar 5
		for (int i = size - 1; i >= 0; i--) {
			int index = compare(value, i);
			if (index != -1)
				return index;
		}
		return -1;
	}

	private int compare(String value, int i) {
		if (array[i] == value)
			return i;

		if (value == null) {
			if (array[i] == null)
				return i;
		} else if (value.equals(array[i]))
			return i;
		return -1;
	}

	public boolean contains(String value) {
		return indexOf(value) != -1;
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

	// adicionar no meio
	// adicionar mais de um elemento no final
	// adicionar mais de um elemento em qualquer posicao
	// retirar de uma posicao

	// ordenar a lista maior > menor
	// ordenar a lista menor > maior
	// procurar valor na lista

	// retornar o primeiro indice de um valor na lista a partir de um indice
	//
}