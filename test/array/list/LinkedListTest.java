package array.list;

import static array.list.ArrayList.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

	@Test(expected = IndexOutOfBoundsException.class)
	public void set_cannot_be_done_in_an_empty_list() {
		new LinkedList<Integer>().set(0, 2);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void set_cannot_be_done_when_index_is_lower_than_zero() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);

		list.set(-1, 12);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void set_cannot_be_done_when_index_is_greater_than_size() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);

		list.set(list.size() + 1, 12);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void set_cannot_be_done_when_index_is_equal_than_size() {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(31);

		list.set(list.size(), 12);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insert_value_out_of_bound_equal_size_plus_one() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");

		list.insert(list.size() + 1, "c");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insert_value_out_of_bound_greater_than_size() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");

		list.insert(5, "c");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insert_value_out_of_bound_lower_than_size() {
		LinkedList<String> list = new LinkedList<>();
		list.insert(-1, "c");
	}

	@Test
	public void insert_value_in_the_beginning() {
		LinkedList<String> list = new LinkedList<>();
		list.add("b");
		list.insert(0, "a");

		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
	}

	@Test
	public void insert_value_in_the_middle() {
		LinkedList<String> list = new LinkedList<>();
		list.add("a");
		list.add("c");
		list.insert(1, "b");

		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("c", list.get(2));
	}

	@Test
	public void insert_value_in_the_end() {
		LinkedList<String> list = new LinkedList<>();
		list.add("a");
		list.add("b");
		list.insert(list.size(), "c");

		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("c", list.get(2));
	}

	@Test
	public void return_index_0_when_a_first_position() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(0, list.indexOf("a"));
	}

	@Test
	public void return_index_0_when_null_first_position() {
		LinkedList<String> list = new LinkedList<>();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(0, list.indexOf(null));
	}

	@Test
	public void return_index_minus_1_when_does_not_found() {
		LinkedList<String> list = new LinkedList<>();

		list.add("b");
		list.add("b");
		list.add("b");

		assertEquals(-1, list.indexOf("a"));
	}

	@Test
	public void return_index_1_when_first_position_is_null() {
		LinkedList<String> list = new LinkedList<>();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(1, list.indexOf("a"));
	}

	@Test
	public void return_index_2_when_b_third_position() {
		LinkedList<String> list = new LinkedList<>();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.indexOf(new String(new char[] { 'b' })));
	}

	// indexof any middle

	@Test
	public void return_index_2_when_a_first_position_after_1() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.indexOf("a", 1));
	}

	@Test
	public void return_index_0_when_a_first_position_after_0() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(0, list.indexOf("a", 0));
	}

	@Test
	public void return_index_2_when_a_first_position_after_2() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.indexOf("a", 2));
	}

	@Test
	public void return_index_2_when_first_position_asked_is_null() {
		LinkedList<String> list = new LinkedList<>();

		list.add(null);
		list.add(null);
		list.add("b");
		list.add("a");

		assertEquals(1, list.indexOf(null, 1));
	}

	@Test
	public void return_index_minus_1_when_does_not_found_after_first_position() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("b");
		list.add("b");

		assertEquals(-1, list.indexOf("a", 1));
	}

	@Test
	public void return_index_3_when_first_position_asked_is_null() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add(null);
		list.add("b");
		list.add("a");

		assertEquals(3, list.indexOf("a", 1));
	}

	@Test
	public void return_index_2_when_b_third_position_after_first_position() {
		LinkedList<String> list = new LinkedList<>();

		list.add("b");
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.indexOf(new String(new char[] { 'b' }), 1));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void throw_exception_when_index_equal_size() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		list.indexOf("a", list.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void throw_exception_when_index_greater_than_size() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		list.indexOf("a", list.size() + 1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void throw_exception_when_index_lower_than_0() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		list.indexOf("a", -1);
	}

	@Test
	public void addAll_should_accept_2_arguments() {
		LinkedList<String> list = new LinkedList<>();

		list.addAll("a", "b");

		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
	}

	@Test
	public void addAll_should_accept_1_argument() {
		LinkedList<String> list = new LinkedList<>();

		list.addAll("a");

		assertEquals("a", list.get(0));
	}

	@Test
	public void addAll_should_accept_no_arguments() {
		LinkedList<String> list = new LinkedList<>();

		list.addAll();

		assertTrue(list.isEmpty());
	}

	@Test
	public void addAll_should_accept_null_array() {
		LinkedList<String> list = new LinkedList<>();

		// String[] array = { null }; // list.addAll((String) null);
		// array = null; // list.addAll((String[]) null);
		list.addAll((String[]) null);

		assertTrue(list.isEmpty());
	}

	@Test
	public void when_list_has_elements_addAll_should_accept_2_arguments() {
		LinkedList<String> list = new LinkedList<>();
		list.add("x");
		list.add("y");
		list.add("z");

		list.addAll("a", "b");

		assertEquals("a", list.get(3));
		assertEquals("b", list.get(4));
	}

	@Test
	public void when_list_has_elements_addAll_should_accept_1_argument() {
		LinkedList<String> list = new LinkedList<>();
		list.add("x");
		list.add("y");
		list.add("z");

		list.addAll("a");

		assertEquals("a", list.get(3));
	}

	@Test
	public void when_list_has_elements_addAll_should_accept_no_arguments() {
		LinkedList<String> list = new LinkedList<>();
		list.add("x");
		list.add("y");
		list.add("z");

		list.addAll();

		assertEquals(3, list.size());
	}

	@Test
	public void when_list_has_elements_addAll_should_accept_null_array() {
		LinkedList<String> list = new LinkedList<>();
		list.add("x");
		list.add("y");
		list.add("z");

		list.addAll((String[]) null);

		assertEquals(3, list.size());
	}

	@Test
	public void when_list_has_default_initial_capacity_and_addAll_with_10_million() {
		LinkedList<String> list = new LinkedList<>();

		final int maxLength = 10_000_000;
		final String[] array = new String[maxLength];
		for (int index = 0; index < maxLength; index++)
			array[index] = "aaa";

		list.addAll(array);

		assertEquals(maxLength, list.size());
	}

	@Test
	public void addAll_with_another_array_list() {
		LinkedList<String> list1 = new LinkedList<>();
		list1.addAll("a", "b", "c");

		ArrayList<String> list2 = new ArrayList<>();
		list2.addAll("x", "y", "z");

		list1.addAll(list2);

		assertEquals(6, list1.size());
		assertEquals("x", list1.get(3));
		assertEquals("y", list1.get(4));
		assertEquals("z", list1.get(5));
	}

	@Test
	public void addAll_with_another_null_array_list_should_add_nothing() {
		LinkedList<String> list1 = new LinkedList<>();
		list1.addAll("a", "b", "c");

		ArrayList<String> list2 = null;
		list1.addAll(list2);

		assertEquals(3, list1.size());
	}

	@Test
	public void addAll_with_another_empty_array_list_should_add_nothing() {
		LinkedList<String> list1 = new LinkedList<>();
		list1.addAll("a", "b", "c");

		ArrayList<String> list2 = new ArrayList<>();
		list1.addAll(list2);

		assertEquals(3, list1.size());
	}

	@Test
	public void insertAll_with_arrayList_should_call_addAll_when_index_is_equal_size() {
		LinkedList<String> list = new LinkedList<>();
		list.addAll("0", "1", "2", "3", "4");

		list.insertAll(5, of("a", "b"));

		assertEquals(7, list.size());
		assertEquals("0", list.get(0));
		assertEquals("1", list.get(1));
		assertEquals("2", list.get(2));
		assertEquals("3", list.get(3));
		assertEquals("4", list.get(4));
		assertEquals("a", list.get(5));
		assertEquals("b", list.get(6));
	}

	@Test
	public void insertAll_with_arrayList_should_call_addAll_when_list_is_empty_and_index_is_0() {
		LinkedList<String> list = new LinkedList<>();
		list.insertAll(0, of("a", "b"));

		assertEquals(2, list.size());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
	}

	@Test
	public void insertAll_with_arrayList_should_do_nothing_when_array_is_null() {
		LinkedList<String> list = new LinkedList<>();
		list.insertAll(0, (ArrayList<String>) null);

		assertEquals(0, list.size());
	}

	@Test
	public void insertAll_with_arrayList_should_do_nothing_when_array_is_null_and_list_has_elements() {
		LinkedList<String> list = new LinkedList<>();
		list.add("a");

		list.insertAll(0, (ArrayList<String>) null);

		assertEquals(1, list.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertAll_with_arrayList_should_validate_out_of_bounds_when_index_is_lower_than_0() {
		new LinkedList<String>().insertAll(-1, of("a"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertAll_with_arrayList_should_validate_out_of_bounds_when_index_is_greater_than_size() {
		new LinkedList<Integer>().insertAll(1, of(2));
	}

	@Test
	public void addAll_with_another_linked_list() {
		LinkedList<String> list1 = new LinkedList<>();
		list1.addAll("a", "b", "c");

		LinkedList<String> list2 = new LinkedList<>();
		list2.addAll("x", "y", "z");

		list1.addAll(list2);

		assertEquals(6, list1.size());
		assertEquals("x", list1.get(3));
		assertEquals("y", list1.get(4));
		assertEquals("z", list1.get(5));
	}

	@Test
	public void addAll_with_another_linked_list_and_then_update_the_list() {
		LinkedList<String> list1 = new LinkedList<>();
		list1.addAll("a", "b", "c");

		LinkedList<String> list2 = new LinkedList<>();
		list2.addAll("x", "y", "z");

		list1.addAll(list2); // [a, b, c, x, y, z]

		list2.set(1, "Rafael"); // [x, Rafael, z]

		assertEquals(6, list1.size());
		assertEquals("x", list1.get(3));
		assertEquals("y", list1.get(4));
		assertEquals("z", list1.get(5));
	}

	@Test
	public void addAll_with_another_null_linked_list_should_add_nothing() {
		LinkedList<String> list1 = new LinkedList<>();
		list1.addAll("a", "b", "c");

		LinkedList<String> list2 = null;
		list1.addAll(list2);

		assertEquals(3, list1.size());
	}

	@Test
	public void addAll_with_another_empty_linked_list_should_add_nothing() {
		LinkedList<String> list1 = new LinkedList<>();
		list1.addAll("a", "b", "c");

		LinkedList<String> list2 = new LinkedList<>();
		list1.addAll(list2);

		assertEquals(3, list1.size());
	}

	@Test
	public void insertAll_with_linked_list_should_call_addAll_when_index_is_equal_size() {
		LinkedList<String> list = new LinkedList<>();
		list.addAll("0", "1", "2", "3", "4");

		list.insertAll(5, LinkedList.of("a", "b"));

		assertEquals(7, list.size());
		assertEquals("0", list.get(0));
		assertEquals("1", list.get(1));
		assertEquals("2", list.get(2));
		assertEquals("3", list.get(3));
		assertEquals("4", list.get(4));
		assertEquals("a", list.get(5));
		assertEquals("b", list.get(6));
	}

	@Test
	public void insertAll_with_linked_list_should_add_items_in_the_middle() {
		LinkedList<String> list = new LinkedList<>();
		list.addAll("0", "1", "2", "3", "4");

		list.insertAll(3, LinkedList.of("a", "b"));

		assertEquals(7, list.size());
		assertEquals("0", list.get(0));
		assertEquals("1", list.get(1));
		assertEquals("2", list.get(2));
		assertEquals("a", list.get(3));
		assertEquals("b", list.get(4));
		assertEquals("3", list.get(5));
		assertEquals("4", list.get(6));
	}

	@Test
	public void insertAll_with_linked_list_should_add_items_in_the_beginning() {
		LinkedList<String> list = new LinkedList<>();
		list.addAll("0", "1", "2", "3", "4");

		list.insertAll(0, LinkedList.of("a", "b"));

		assertEquals(7, list.size());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("0", list.get(2));
		assertEquals("1", list.get(3));
		assertEquals("2", list.get(4));
		assertEquals("3", list.get(5));
		assertEquals("4", list.get(6));
	}

	@Test
	public void insertAll_with_linked_list_should_call_addAll_when_list_is_empty_and_index_is_0() {
		LinkedList<String> list = new LinkedList<>();
		list.insertAll(0, LinkedList.of("a", "b"));

		assertEquals(2, list.size());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
	}

	@Test
	public void insertAll_with_linked_list_should_do_nothing_when_array_is_null() {
		LinkedList<String> list = new LinkedList<>();
		list.insertAll(0, (LinkedList<String>) null);

		assertEquals(0, list.size());
	}

	@Test
	public void insertAll_with_linked_list_should_do_nothing_when_array_is_null_and_list_has_elements() {
		LinkedList<String> list = new LinkedList<>();
		list.add("a");

		list.insertAll(0, (LinkedList<String>) null);

		assertEquals(1, list.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertAll_with_linked_list_should_validate_out_of_bounds_when_index_is_lower_than_0() {
		new LinkedList<String>().insertAll(-1, LinkedList.of("a"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertAll_with_linked_list_should_validate_out_of_bounds_when_index_is_greater_than_size() {
		new LinkedList<Integer>().insertAll(1, LinkedList.of(2));
	}

	@Test
	public void insertAll_with_varargs_should_call_addAll_when_index_is_equal_size() {
		LinkedList<String> list = new LinkedList<>();
		list.addAll("0", "1", "2", "3", "4");

		list.insertAll(5, "a", "b");

		assertEquals(7, list.size());
		assertEquals("0", list.get(0));
		assertEquals("1", list.get(1));
		assertEquals("2", list.get(2));
		assertEquals("3", list.get(3));
		assertEquals("4", list.get(4));
		assertEquals("a", list.get(5));
		assertEquals("b", list.get(6));
	}

	@Test
	public void insertAll_with_varargs_should_add_items_in_the_middle() {
		LinkedList<String> list = new LinkedList<>();
		list.addAll("0", "1", "2", "3", "4");

		list.insertAll(3, "a", "b");

		assertEquals(7, list.size());
		assertEquals("0", list.get(0));
		assertEquals("1", list.get(1));
		assertEquals("2", list.get(2));
		assertEquals("a", list.get(3));
		assertEquals("b", list.get(4));
		assertEquals("3", list.get(5));
		assertEquals("4", list.get(6));
	}

	@Test
	public void insertAll_with_varargs_should_add_items_in_the_beginning() {
		LinkedList<String> list = new LinkedList<>();
		list.addAll("0", "1", "2", "3", "4");

		list.insertAll(0, "a", "b");

		assertEquals(7, list.size());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("0", list.get(2));
		assertEquals("1", list.get(3));
		assertEquals("2", list.get(4));
		assertEquals("3", list.get(5));
		assertEquals("4", list.get(6));
	}

	@Test
	public void insertAll_with_varargs_should_call_addAll_when_list_is_empty_and_index_is_0() {
		LinkedList<String> list = new LinkedList<>();
		list.insertAll(0, "a", "b");

		assertEquals(2, list.size());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
	}

	@Test
	public void insertAll_with_varargs_should_do_nothing_when_array_is_null() {
		LinkedList<String> list = new LinkedList<>();
		list.insertAll(0, (String[]) null);

		assertEquals(0, list.size());
	}

	@Test
	public void insertAll_with_varargs_should_do_nothing_when_array_is_null_and_list_has_elements() {
		LinkedList<String> list = new LinkedList<>();
		list.add("a");

		list.insertAll(0, (String[]) null);

		assertEquals(1, list.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertAll_with_varargs_should_validate_out_of_bounds_when_index_is_lower_than_0() {
		new LinkedList<String>().insertAll(-1, "a");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertAll_with_varargs_should_validate_out_of_bounds_when_index_is_greater_than_size() {
		new LinkedList<Integer>().insertAll(1, 2);
	}

	@Test
	public void return_index_2_when_a_last_position() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.lastIndexOf("a"));
	}

	@Test
	public void return_index_0_when_null_last_position() {
		LinkedList<String> list = new LinkedList<>();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(0, list.lastIndexOf(null));
	}

	@Test
	public void return_index_minus_1_when_does_not_found_for_last_indexof() {
		LinkedList<String> list = new LinkedList<>();

		list.add("b");
		list.add("b");
		list.add("b");

		assertEquals(-1, list.lastIndexOf("a"));
	}

	@Test
	public void return_index_2_when_last_position_is_null() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("a");
		list.add(null);

		assertEquals(2, list.lastIndexOf("a"));
	}

	@Test
	public void return_index_1_when_b_second_position() {
		LinkedList<String> list = new LinkedList<>();

		list.add("a");
		list.add("b");
		list.add("a");
		list.add(null);

		assertEquals(1, list.lastIndexOf(new String(new char[] { 'b' })));
	}
}
