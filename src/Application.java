import static java.lang.Math.abs;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		Pessoa rafael = new Pessoa("Rafael", 24);

		Class<Pessoa> clazz = Pessoa.class;
		try {
			Field field = clazz.getDeclaredField("idade");
			field.setAccessible(true); // private vira public. Final some

			Object value = field.get(rafael);
			System.out.println("A idade é: " + value);

			field.set(rafael, 250);

			value = field.get(rafael);

			System.out.println("A idade é: " + value);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

		// try {
		// Constructor<Pessoa> constructor =
		// Pessoa.class.getDeclaredConstructor(String.class, int.class);
		// constructor.setAccessible(true);
		// try {
		// Pessoa gabriel = constructor.newInstance("Gabriel", 35);
		// System.out.println(gabriel);
		// } catch (InstantiationException | InvocationTargetException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// } catch (SecurityException | IllegalArgumentException |
		// IllegalAccessException | NoSuchMethodException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	public static void main5(String[] args) {
		// Pessoa rafael = new Pessoa("Aa", 24);
		// Pessoa rafael2 = new Pessoa("BB", 24);
		//
		// System.out.println(rafael.hashCode());
		// System.out.println(rafael2.hashCode());
		//
		// String a = new String(new char[] { 'a', 'b', 'c' });
		// String b = "abc";
		//
		// System.out.println(a + " -> memory: " + System.identityHashCode(a) +
		// " -> hashCode: " + a.hashCode());
		// System.out.println(b + " -> memory: " + System.identityHashCode(b) +
		// " -> hashCode: " + b.hashCode());
		//
		// System.out.println("Aa".hashCode() + "," + "BB".hashCode());
		// System.out.println("Ba".hashCode() + "," + "CB".hashCode());
		// System.out.println("Ca".hashCode() + "," + "DB".hashCode());
		// System.out.println("Da".hashCode() + "," + "EB".hashCode());

		// System.out.println(rafael.getNome() + " -> " +
		// System.identityHashCode(rafael));
		// System.out.println(rafael.hashCode());
		//
		// System.out.println(rafael2.getNome() + " -> " +
		// System.identityHashCode(rafael2));
		// System.out.println(rafael2.hashCode());
		//
		// System.out.println(rafael == rafael2);
		// System.out.println(rafael.equals(rafael2));
	}

	public static void main3(String[] args) {
		Integer value = new Integer(90);
		Integer value2 = new Integer(90);

		System.out.println(value + " -> " + System.identityHashCode(value));
		System.out.println(value.hashCode());

		System.out.println(value2 + " -> " + System.identityHashCode(value2));
		System.out.println(value2.hashCode());

		System.out.println(value == value2);
		System.out.println(value.equals(value2));
	}

	public static void main1(String[] args) {
		final List<Integer> saldos = new LinkedList<>();

		saldos.add(1);
		saldos.add(0);
		saldos.add(12);
		saldos.add(21);
		saldos.add(31);
		saldos.add(22);
		saldos.add(-123);
		saldos.add(21);
		saldos.add(50);
		saldos.add(5000);
		saldos.add(5_000_000);
		saldos.add(500_000_000);
		saldos.add(90);

		final List<List<Integer>> organization = new ArrayList<List<Integer>>(100);
		for (int i = 0; i < 100; i++)
			organization.add(null);

		for (Integer saldo : saldos) {
			final int index = abs(saldo % 100);

			if (organization.get(index) == null)
				organization.set(index, new LinkedList<Integer>());

			final List<Integer> list = organization.get(index);

			if (!list.contains(saldo))
				list.add(saldo);
		}

		System.out.println(saldos);
		System.out.println(organization);
	}

	public static void main2(String[] args) {
		final List<String> names = new LinkedList<>();

		names.add("Rafael");
		names.add("Gabriel");
		names.add("Ludwig");
		names.add("João");
		names.add("josé");
		names.add("Alfredo");
		names.add("rafael");
		names.add("Leonildo");
		names.add("Astolfo");
		names.add("Bernardo");

		final List<List<String>> organization = new ArrayList<List<String>>(10);
		for (int i = 0; i < 10; i++)
			organization.add(null);

		for (String name : names) {
			final int index = abs(name.hashCode() % 10);

			if (organization.get(index) == null)
				organization.set(index, new LinkedList<String>());

			final List<String> list = organization.get(index);

			if (!list.contains(name))
				list.add(name);
		}

		System.out.println(names);
		System.out.println(organization);
	}
}
