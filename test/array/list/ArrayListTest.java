package array.list;

import static array.list.ArrayList.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void toString_returns_empty_brackets_for_empty_list() {
		assertEquals("[]", new ArrayList<String>(5).toString());
	}

	@Test
	public void toString_returns_properly_formatted_array() {
		ArrayList<String> list = new ArrayList<>(5);
		list.add("a");
		assertEquals("[a]", list.toString());
	}

	@Test
	public void toString_returns_properly_formatted_array_when_adds_null() {
		ArrayList<String> list = new ArrayList<>(5);
		list.add(null);
		assertEquals("[null]", list.toString());
	}

	@Test
	public void returns_size_one_when_adds_null_to_an_empty_list() {
		ArrayList<String> list = new ArrayList<>(5);
		list.add(null);
		assertEquals(1, list.size());
	}

	@Test
	public void when_adds_see_if_size_was_increased() {
		ArrayList<String> list = new ArrayList<>(0);

		assertEquals(0, list.size());

		list.add(null);
		assertEquals(1, list.size());
	}

	@Test
	public void when_adds_see_if_size_was_increased_without_resizing_buffer() {
		ArrayList<String> list = new ArrayList<>(5);

		assertEquals(0, list.size());

		list.add("");
		assertEquals(1, list.size());
	}

	@Test
	public void when_adds_1_million_size_should_be_1_million() {
		ArrayList<String> list = new ArrayList<>(5);

		assertEquals(0, list.size());

		for (int i = 0; i < 1_000_000; i++)
			list.add(String.valueOf(i));

		assertEquals(1_000_000, list.size());
	}

	@Test
	public void when_clears_list_size_come_back_to_0() {
		ArrayList<String> list = new ArrayList<>(5);

		for (int i = 0; i < 1_000; i++)
			list.add(String.valueOf(i));

		assertEquals(1_000, list.size());
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void when_clears_list_should_be_empty() {
		ArrayList<String> list = new ArrayList<>(5);

		for (int i = 0; i < 1_000; i++)
			list.add(String.valueOf(i));

		assertFalse("The list should be populated, but is empty.", list.isEmpty());
		list.clear();
		assertTrue("The list should be empty, but is not.", list.isEmpty());
	}

	@Test
	public void when_update_value_see_it_was_done_correctly() {
		ArrayList<String> list = new ArrayList<>(5);

		list.add("a");
		list.add("b");
		list.add("c");
		
		assertEquals("b", list.set(1, "test"));
		assertEquals("[a, test, c]", list.toString());
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void when_update_index_out_of_bound() {
		ArrayList<String> list = new ArrayList<>(0);

		list.set(1, "test");
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void when_update_index_out_of_bound_equal_size() {
		ArrayList<String> list = new ArrayList<>(0);

		list.set(list.size(), "test");
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void when_update_index_out_of_bound_with_default_constructor() {
		ArrayList<String> list = new ArrayList<>();

		list.set(1, "test");
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void when_update_index_out_of_bound_equal_size_with_default_constructor() {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.set(list.size(), "test");
	}

	@Test
	public void confirm_the_empty_result() {
		ArrayList<String> list = new ArrayList<>(5);

		assertTrue("The list should be empty, but is not.", list.isEmpty());

		list.add("a");

		assertFalse("The list should be populated, but is empty.", list.isEmpty());
	}

	@Test
	public void when_tries_to_get_index_inside_the_bounds() {
		ArrayList<String> list = new ArrayList<>(10);

		list.add("test");

		assertEquals("test", list.get(0));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void when_tries_to_get_index_out_the_bounds() {
		ArrayList<String> list = new ArrayList<>();

		list.add("test");
		list.get(2);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void when_tries_to_get_index_out_the_bounds_equal_size() {
		ArrayList<String> list = new ArrayList<>();

		list.add("test");
		list.get(list.size());
	}

	// indexof any from beggining

	@Test
	public void return_index_0_when_a_first_position() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(0, list.indexOf("a"));
	}

	@Test
	public void return_index_0_when_null_first_position() {
		ArrayList<String> list = new ArrayList<>();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(0, list.indexOf(null));
	}

	@Test
	public void return_index_minus_1_when_does_not_found() {
		ArrayList<String> list = new ArrayList<>();

		list.add("b");
		list.add("b");
		list.add("b");

		assertEquals(-1, list.indexOf("a"));
	}

	@Test
	public void return_index_1_when_first_position_is_null() {
		ArrayList<String> list = new ArrayList<>();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(1, list.indexOf("a"));
	}

	@Test
	public void return_index_2_when_b_third_position() {
		ArrayList<String> list = new ArrayList<>();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.indexOf(new String(new char[] { 'b' })));
	}

	// indexof any middle

	@Test
	public void return_index_2_when_a_first_position_after_1() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.indexOf("a", 1));
	}

	@Test
	public void return_index_0_when_a_first_position_after_0() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(0, list.indexOf("a", 0));
	}

	@Test
	public void return_index_2_when_a_first_position_after_2() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.indexOf("a", 2));
	}

	@Test
	public void return_index_2_when_first_position_asked_is_null() {
		ArrayList<String> list = new ArrayList<>();

		list.add(null);
		list.add(null);
		list.add("b");
		list.add("a");

		assertEquals(1, list.indexOf(null, 1));
	}

	@Test
	public void return_index_minus_1_when_does_not_found_after_first_position() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("b");
		list.add("b");

		assertEquals(-1, list.indexOf("a", 1));
	}

	@Test
	public void return_index_3_when_first_position_asked_is_null() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add(null);
		list.add("b");
		list.add("a");

		assertEquals(3, list.indexOf("a", 1));
	}

	@Test
	public void return_index_2_when_b_third_position_after_first_position() {
		ArrayList<String> list = new ArrayList<>();

		list.add("b");
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.indexOf(new String(new char[] { 'b' }), 1));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void throw_exception_when_index_equal_size() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		list.indexOf("a", list.size());
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void throw_exception_when_index_greater_than_size() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		list.indexOf("a", list.size() + 1);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void throw_exception_when_index_lower_than_0() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		list.indexOf("a", -1);
	}

	// Lastindexof tests
	@Test
	public void return_index_2_when_a_last_position() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(2, list.lastIndexOf("a"));
	}

	@Test
	public void return_index_0_when_null_last_position() {
		ArrayList<String> list = new ArrayList<>();

		list.add(null);
		list.add("a");
		list.add("b");
		list.add("a");

		assertEquals(0, list.lastIndexOf(null));
	}

	@Test
	public void return_index_minus_1_when_does_not_found_for_last_indexof() {
		ArrayList<String> list = new ArrayList<>();

		list.add("b");
		list.add("b");
		list.add("b");

		assertEquals(-1, list.lastIndexOf("a"));
	}

	@Test
	public void return_index_2_when_last_position_is_null() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("a");
		list.add(null);

		assertEquals(2, list.lastIndexOf("a"));
	}

	@Test
	public void return_index_1_when_b_second_position() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");
		list.add("a");
		list.add(null);

		assertEquals(1, list.lastIndexOf(new String(new char[] { 'b' })));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void insert_value_out_of_bound_equal_size_plus_one() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");

		list.insert(list.size() + 1, "c");
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void insert_value_out_of_bound_greater_than_size() {
		ArrayList<String> list = new ArrayList<>();

		list.add("a");
		list.add("b");

		list.insert(5, "c");
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void insert_value_out_of_bound_lower_than_size() {
		ArrayList<String> list = new ArrayList<>();
		list.insert(-1, "c");
	}

	@Test
	public void insert_value_in_the_beginning() {
		ArrayList<String> list = new ArrayList<>();
		list.add("b");
		list.insert(0, "a");

		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
	}

	@Test
	public void insert_value_in_the_middle() {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.insert(1, "b");

		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("c", list.get(2));
	}

	@Test
	public void insert_value_in_the_end() {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.insert(list.size(), "c");

		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("c", list.get(2));
	}

	@Test
	public void when_adds_10_million_and_insert_into_position_0() {
		ArrayList<String> list = new ArrayList<>(5);
		for (int i = 0; i < 10_000_000; i++)
			list.add(String.valueOf(i));
		list.insert(0, "a");

		assertEquals("a", list.get(0));
		assertEquals("9999999", list.get(10_000_000));
	}

	@Test
	public void when_insert_100_000_at_beginning() {
		ArrayList<String> list = new ArrayList<>(5);
		for (int i = 0; i < 100_000; i++)
			list.insert(0, String.valueOf(i));

		assertEquals("99999", list.get(0));
		assertEquals("0", list.get(99999));
	}

	@Test
	public void addAll_should_accept_2_arguments() {
		ArrayList<String> list = new ArrayList<>();

		list.addAll("a", "b");

		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
	}

	@Test
	public void addAll_should_accept_1_argument() {
		ArrayList<String> list = new ArrayList<>();

		list.addAll("a");

		assertEquals("a", list.get(0));
	}

	@Test
	public void addAll_should_accept_no_arguments() {
		ArrayList<String> list = new ArrayList<>();

		list.addAll();

		assertTrue(list.isEmpty());
	}

	@Test
	public void addAll_should_accept_null_array() {
		ArrayList<String> list = new ArrayList<>();

		// String[] array = { null }; // list.addAll((String) null);
		// array = null; // list.addAll((String[]) null);
		list.addAll((String[]) null);

		assertTrue(list.isEmpty());
	}

	@Test
	public void when_list_has_elements_addAll_should_accept_2_arguments() {
		ArrayList<String> list = new ArrayList<>();
		list.add("x");
		list.add("y");
		list.add("z");

		list.addAll("a", "b");

		assertEquals("a", list.get(3));
		assertEquals("b", list.get(4));
	}

	@Test
	public void when_list_has_elements_addAll_should_accept_1_argument() {
		ArrayList<String> list = new ArrayList<>();
		list.add("x");
		list.add("y");
		list.add("z");

		list.addAll("a");

		assertEquals("a", list.get(3));
	}

	@Test
	public void when_list_has_elements_addAll_should_accept_no_arguments() {
		ArrayList<String> list = new ArrayList<>();
		list.add("x");
		list.add("y");
		list.add("z");

		list.addAll();

		assertEquals(3, list.size());
	}

	@Test
	public void when_list_has_elements_addAll_should_accept_null_array() {
		ArrayList<String> list = new ArrayList<>();
		list.add("x");
		list.add("y");
		list.add("z");

		list.addAll((String[]) null);

		assertEquals(3, list.size());
	}

	@Test
	public void when_list_has_initial_capacity_and_addAll_exceeds() {
		ArrayList<String> list = new ArrayList<>(5);
		list.addAll("a", "b", "c", "d", "e", "f", "g", "h");

		assertEquals(8, list.size());
	}

	@Test
	public void when_list_has_default_initial_capacity_and_addAll_with_10_million() {
		ArrayList<String> list = new ArrayList<>();

		final int maxLength = 10_000_000;
		final String[] array = new String[maxLength];
		for (int index = 0; index < maxLength; index++)
			array[index] = "aaa";

		list.addAll(array);

		assertEquals(maxLength, list.size());
	}

	// [0, 1, 2, 3, 4] // size = 5
	// [0, 1, 2, null, null, 3, 4] // size = 5 + 2 => 7 // index = 3

	@Test
	public void insertAll_should_move_2_elements_when_size_is_5_and_index_is_3() {
		ArrayList<String> list = new ArrayList<>(5);
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

	// [0, 1, 2, 3, 4] // size = 5
	// [0, null, null, 1, 2, 3, 4] // size = 5 + 2 => 7 // index = 1
	@Test
	public void insertAll_should_move_5_elements_when_size_is_5_and_index_is_0() {
		ArrayList<String> list = new ArrayList<>(5);
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
	public void insertAll_should_call_addAll_when_index_is_equal_size() {
		ArrayList<String> list = new ArrayList<>();
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
	public void insertAll_should_call_addAll_when_list_is_empty_and_index_is_0() {
		ArrayList<String> list = new ArrayList<>();
		list.insertAll(0, "a", "b");

		assertEquals(2, list.size());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
	}

	@Test
	public void insertAll_should_do_nothing_when_array_is_null() {
		ArrayList<String> list = new ArrayList<>();
		list.insertAll(0, (String[]) null);

		assertEquals(0, list.size());
	}

	@Test
	public void insertAll_should_do_nothing_when_array_is_null_and_list_has_elements() {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");

		list.insertAll(0, (String[]) null);

		assertEquals(1, list.size());
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void insertAll_should_validate_out_of_bounds_when_index_is_lower_than_0() {
		new ArrayList<String>().insertAll(-1, "a");
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void insertAll_should_validate_out_of_bounds_when_index_is_greater_than_size() {
		new ArrayList<Integer>().insertAll(1, 2);
	}

	@Test
	public void remove_at_the_beginning_should_decrease_the_size_by_one() {
		ArrayList<String> list = new ArrayList<>();
		list.addAll("a", "b", "c");

		assertEquals("a", list.remove(0));

		assertEquals(2, list.size());
		assertEquals("b", list.get(0));
		assertEquals("c", list.get(1));
	}

	@Test
	public void remove_at_the_end_should_decrease_the_size_by_one() {
		ArrayList<String> list = new ArrayList<>();
		list.addAll("a", "b", "c");

		assertEquals("c", list.remove(2));

		assertEquals(2, list.size());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void remove_should_validate_out_of_bounds_when_index_is_lower_than_0() {
		new ArrayList<String>().remove(-1);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void remove_should_validate_out_of_bounds_when_index_is_equal_0() {
		new ArrayList<Integer>().remove(0);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void remove_should_validate_out_of_bounds_when_index_is_greater_than_size() {
		new ArrayList<String>().remove(1);
	}

	@Test
	public void addAll_with_another_array_list() {
		ArrayList<String> list1 = new ArrayList<>();
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
		ArrayList<String> list1 = new ArrayList<>();
		list1.addAll("a", "b", "c");

		ArrayList<String> list2 = null;
		list1.addAll(list2);

		assertEquals(3, list1.size());
	}

	@Test
	public void addAll_with_another_empty_array_list_should_add_nothing() {
		ArrayList<String> list1 = new ArrayList<>();
		list1.addAll("a", "b", "c");

		ArrayList<String> list2 = new ArrayList<>();
		list1.addAll(list2);

		assertEquals(3, list1.size());
	}

	@Test
	public void insertAll_with_arrayList_should_move_2_elements_when_size_is_5_and_index_is_3() {
		ArrayList<String> list = new ArrayList<>(5);
		list.addAll("0", "1", "2", "3", "4");

		list.insertAll(3, of("a", "b"));

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
	public void insertAll_with_arrayList_should_move_5_elements_when_size_is_5_and_index_is_0() {
		ArrayList<String> list = new ArrayList<>(5);
		list.addAll("0", "1", "2", "3", "4");

		list.insertAll(0, of("a", "b"));

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
	public void insertAll_with_arrayList_should_call_addAll_when_index_is_equal_size() {
		ArrayList<String> list = new ArrayList<>();
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
		ArrayList<String> list = new ArrayList<>();
		list.insertAll(0, of("a", "b"));

		assertEquals(2, list.size());
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
	}

	@Test
	public void insertAll_with_arrayList_should_do_nothing_when_array_is_null() {
		ArrayList<String> list = new ArrayList<>();
		list.insertAll(0, (ArrayList<String>) null);

		assertEquals(0, list.size());
	}

	@Test
	public void insertAll_with_arrayList_should_do_nothing_when_array_is_null_and_list_has_elements() {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");

		list.insertAll(0, (ArrayList<String>) null);

		assertEquals(1, list.size());
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void insertAll_with_arrayList_should_validate_out_of_bounds_when_index_is_lower_than_0() {
		new ArrayList<String>().insertAll(-1, of("a"));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void insertAll_with_arrayList_should_validate_out_of_bounds_when_index_is_greater_than_size() {
		new ArrayList<Integer>().insertAll(1, of(2));
	}
}
