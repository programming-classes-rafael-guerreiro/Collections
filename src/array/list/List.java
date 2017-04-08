package array.list;

@SuppressWarnings("unchecked")
public interface List<E> {
	void add(E s);

	void insert(int index, E value);

	int size();

	void clear();

	E set(int index, E value);

	boolean isEmpty();

	E get(int index);

	int indexOf(E value);

	int indexOf(E value, int position);

	int lastIndexOf(E value);

	boolean contains(E value);

	void addAll(E... array);

	void addAll(List<E> list);

	void insertAll(int index, E... array);

	void insertAll(int index, List<E> list);

	E remove(final int index);
}