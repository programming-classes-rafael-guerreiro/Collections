package array.list;

import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> {

	private final Object[] queue;

	private int size = 0;

	private int begin = -1;
	private int end = 0;

	public ArrayQueue() {
		this(5);
	}

	public ArrayQueue(int capacity) {
		queue = new Object[capacity];
	}

	@Override
	public String toString() {
		return Arrays.toString(queue);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void enqueue(T value) {
		// [0, 1, 2, 3, 4]
		// [V, V, V, V, V]

		// 0 % 5 = 0
		// 1 % 5 = 1
		// 2 % 5 = 2
		// 3 % 5 = 3
		// 4 % 5 = 4
		// 5 % 5 = 0
		// 6 % 5 = 1

		// begin = 1
		// begin = 2

		if (end == begin)
			throw new IllegalStateException("Queue is full.");

		queue[end] = value;
		end = (end + 1) % queue.length;

		if (isEmpty())
			begin = 0;

		size++;
	}

	@Override
	public T dequeue() {
		if (isEmpty())
			throw new IllegalStateException("Queue is empty.");

		Object value = queue[begin];
		queue[begin] = null;

		begin = (begin + 1) % queue.length;

		if (end == begin)
			begin = -1;
		size--;
		return (T) value;
	}

	@Override
	public T poll() {
		if (isEmpty())
			throw new IllegalStateException("Queue is empty.");

		return (T) queue[begin];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
}
