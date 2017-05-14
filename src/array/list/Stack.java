package array.list;

public interface Stack<T> {
	int size();

	void push(T t);

	T pop();

	T peek();

	boolean isEmpty();
}
