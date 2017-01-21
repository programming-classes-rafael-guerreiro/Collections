package array.list;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void toString_returns_empty_brackets_for_empty_list() {
		assertEquals("[]", new ArrayList(5).toString());

	}

	@Test
	public void toString_returns_properly_formatted_array() {
		ArrayList list = new ArrayList(5);
		list.add("a");
		assertEquals("[a]", list.toString());

	}

	@Test
	public void toString_returns_properly_formatted_array_when_adds_null() {
		ArrayList list = new ArrayList(5);
		list.add(null);
		assertEquals("[null]", list.toString());
	}

	@Test
	public void returns_size_one_when_adds_null_to_an_empty_list() {
		ArrayList list = new ArrayList(5);
		list.add(null);
		assertEquals(1, list.size());
	}

	@Test
	public void when_adds_see_if_size_was_increased() {
		ArrayList list = new ArrayList(0);

		assertEquals(0, list.size());

		list.add(null);
		assertEquals(1, list.size());
	}

	@Test
	public void when_adds_see_if_size_was_increased_without_resizing_buffer() {
		ArrayList list = new ArrayList(5);

		assertEquals(0, list.size());

		list.add("");
		assertEquals(1, list.size());
	}

	@Test
	public void when_adds_1_million_size_should_be_1_million() {
		ArrayList list = new ArrayList(5);

		assertEquals(0, list.size());

		for (int i = 0; i < 1_000_000; i++)
			list.add(String.valueOf(i));

		assertEquals(1_000_000, list.size());
	}

	@Test
	public void when_clears_list_size_come_back_to_0() {
		ArrayList list = new ArrayList(5);

		for (int i = 0; i < 1_000; i++)
			list.add(String.valueOf(i));

		assertEquals(1_000, list.size());
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void when_clears_list_should_be_empty() {
		ArrayList list = new ArrayList(5);

		for (int i = 0; i < 1_000; i++)
			list.add(String.valueOf(i));

		assertFalse("The list should be populated, but is empty.", list.isEmpty());
		list.clear();
		assertTrue("The list should be empty, but is not.", list.isEmpty());
	}

	@Test
	public void when_update_value_see_it_was_done_correctly() {
		ArrayList list = new ArrayList(5);

		list.add("a");
		list.add("b");
		list.add("c");

		assertEquals("b", list.set(1, "test"));
		assertEquals("[a, test, c]", list.toString());
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void when_update_index_out_of_bound() {
		ArrayList list = new ArrayList(0);

		list.set(1, "test");
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void when_update_index_out_of_bound_with_default_constructor() {
		ArrayList list = new ArrayList();

		list.set(1, "test");
	}

	@Test
	public void confirm_the_empty_result() {
		ArrayList list = new ArrayList(5);

		assertTrue("The list should be empty, but is not.", list.isEmpty());

		list.add("a");

		assertFalse("The list should be populated, but is empty.", list.isEmpty());
	}

	@Test
	public void when_tries_to_get_index_inside_the_bounds() {
		ArrayList list = new ArrayList(10);

		list.add("test");

		assertEquals("test", list.get(0));

	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void when_tries_to_get_index_out_the_bounds() {
		ArrayList list = new ArrayList();

		list.add("test");

		list.get(2);
	}

	@Test
	public void return_index_0_when_a_first_position() {
		ArrayList list = new ArrayList();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(0, list.indexOf("a"));
	}

	@Test
	public void return_index_0_when_null_first_position() {
		ArrayList list = new ArrayList();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(0, list.indexOf(null));
	}

	@Test
	public void return_index_minus_1_when_does_not_found() {
		ArrayList list = new ArrayList();

		list.add("b");
		list.add("b");
		list.add("b");

		assertEquals(-1, list.indexOf("a"));
	}

	@Test
	public void return_index_1_when_first_position_is_null() {
		ArrayList list = new ArrayList();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(1, list.indexOf("a"));
	}

	@Test
	public void return_index_2_when_b_third_position() {
		ArrayList list = new ArrayList();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.indexOf(new String(new char[] { 'b' })));
	}

	// Lastindexof tests
	@Test
	public void return_index_2_when_a_last_position() {
		ArrayList list = new ArrayList();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.lastIndexOf("a"));
	}

	@Test
	public void return_index_0_when_null_last_position() {
		ArrayList list = new ArrayList();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(0, list.lastIndexOf(null));
	}

	@Test
	public void return_index_minus_1_when_does_not_found_for_last_indexof() {
		ArrayList list = new ArrayList();

		list.add("b");
		list.add("b");
		list.add("b");

		assertEquals(-1, list.lastIndexOf("a"));
	}

	@Test
	public void return_index_2_when_last_position_is_null() {
		ArrayList list = new ArrayList();

		list.add("a");
		list.add("b");
		list.add("a");
		list.add(null);

		assertEquals(2, list.lastIndexOf("a"));
	}

	@Test
	public void return_index_1_when_b_second_position() {
		ArrayList list = new ArrayList();

		list.add("a");
		list.add("b");
		list.add("a");
		list.add(null);

		assertEquals(1, list.lastIndexOf(new String(new char[] { 'b' })));
	}

}