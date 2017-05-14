package array.list;

public interface Queue<T> {
	int size();

	void enqueue(T value);

	T dequeue();

	T poll();

	boolean isEmpty();
}
