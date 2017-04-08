package array.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void add_one_element_to_the_end_should_increase_size_by_one() {
		LinkedList<Integer> list = new LinkedList<>();

		assertEquals(0, list.size());
		list.add(1);
		assertEquals(1, list.size());
	}

	@Test
	public void add_one_element_to_the_end_should_be_accessible_by_the_last_index() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);

		assertEquals((Integer) 31, list.get(0));
	}

	@Test
	public void add_first_element_must_be_the_head_and_tail() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);

		assertEquals((Integer) 31, list.getFirst());
		assertEquals((Integer) 31, list.getLast());
	}

	@Test
	public void add_three_elements_to_the_end_should_increase_size_by_three() {
		LinkedList<Integer> list = new LinkedList<>();

		assertEquals(0, list.size());
		list.add(31);
		list.add(32);
		list.add(33);
		assertEquals(3, list.size());
	}

	@Test
	public void add_three_elements_to_the_end_should_be_accessible_by_the_their_index() {
		LinkedList<Integer> list = new LinkedList<>();

		list.add(31);
		list.add(32);
		list.add(33);

		assertEquals((Integer) 31, list.get(0));
		assertEquals((Integer) 32, list.get(1));
		assertEquals((Integer) 33, list.get(2));
	}

	@Test
	public void add_three_elements_and_head_should_be_31_and_tail_should_be_33() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);
		list.add(32);
		list.add(33);

		assertEquals((Integer) 31, list.getFirst());
		assertEquals((Integer) 33, list.getLast());
	}

	@Test
	public void set_element_in_the_middle_change_the_element_on_the_index() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);
		list.add(32);
		list.add(33);

		assertEquals((Integer) 32, list.get(1));
		list.set(1, 12);
		assertEquals((Integer) 12, list.get(1));
	}

	@Test
	public void set_head_element_change_the_element_on_the_index() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);
		list.add(32);
		list.add(33);

		assertEquals((Integer) 31, list.getFirst());
		list.set(0, 12);
		assertEquals((Integer) 12, list.getFirst());
	}

	@Test
	public void set_tail_element_change_the_element_on_the_index() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);
		list.add(32);
		list.add(33);

		assertEquals((Integer) 33, list.getLast());
		list.set(list.size() - 1, 12);
		assertEquals((Integer) 12, list.getLast());
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void set_cannot_be_done_in_an_empty_list() {
		new LinkedList<Integer>().set(0, 2);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void set_cannot_be_done_when_index_is_lower_than_zero() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);

		list.set(-1, 12);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void set_cannot_be_done_when_index_is_greater_than_size() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);

		list.set(list.size() + 1, 12);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void set_cannot_be_done_when_index_is_equal_than_size() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);

		list.set(list.size(), 12);
	}
}
