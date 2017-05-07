package array.list;

public class IterationTest {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		list.addAll(1, 2, 3, 4, 5, 6, 7);

		for (Integer value : list) {
			System.out.println("1. Next is: " + value);
		}
	}
}