package array.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayQueueTest {

	@Test
	public void should_be_able_to_enqueue_1_and_dequeue_1() {
		ArrayQueue<Integer> queue = new ArrayQueue<>(3);

		queue.enqueue(23);
		assertEquals(1, queue.size());
		assertEquals((Integer) 23, queue.dequeue());
		assertEquals(0, queue.size());
	}

	@Test
	public void should_be_able_to_enqueue_2_and_dequeue_1() {
		ArrayQueue<Integer> queue = new ArrayQueue<>(3);

		queue.enqueue(23);
		queue.enqueue(24);

		assertEquals(2, queue.size());
		assertEquals((Integer) 23, queue.dequeue());
		assertEquals(1, queue.size());
	}

	@Test(expected = IllegalStateException.class)
	public void should_not_be_able_to_enqueue_4() {
		ArrayQueue<Integer> queue = new ArrayQueue<>(3);

		try {
			queue.enqueue(23);
			queue.enqueue(24);
			queue.enqueue(25);
		} catch (IllegalStateException e) {
			throw new RuntimeException("This exception should not happen while enqueuing the first 3 elements.", e);
		}

		queue.enqueue(26);
	}

	@Test
	public void should_be_able_to_enqueue_5_and_dequeue_3() {
		ArrayQueue<Integer> queue = new ArrayQueue<>(3);

		queue.enqueue(23);
		queue.enqueue(24);
		assertEquals((Integer) 23, queue.dequeue());

		System.out.println(queue);

		queue.enqueue(25);
		assertEquals((Integer) 24, queue.dequeue());

		System.out.println(queue);

		queue.enqueue(26);
		System.out.println(queue);
		
		assertEquals((Integer) 25, queue.dequeue());

		System.out.println(queue);

		queue.enqueue(27);
		assertEquals(2, queue.size());

		System.out.println(queue);
	}

}
