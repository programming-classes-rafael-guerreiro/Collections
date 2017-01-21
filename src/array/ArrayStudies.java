package array;

import java.util.Arrays;

public class ArrayStudies {

	public static void main(String[] args) {
		// Parte 01
		// String[] array3 = new String[10];
		//
		// String array[];
		// array = new String[] { "a", "b", "c", "d", "e", };
		//
		// String array2[] = { "a", "b", "c", "d", "e", };
		//
		// System.out.println(array[3]);
		//
		// teste(array);
		// teste(new String[1]);
		// teste(new String[]{"abc"});

		// Parte 02
		// String array[] = { "a", "b", "c", "d", "e", };
		// System.out.println(array);// Imprime apenas o endereco de memória
		// array[4] = "gabriel";
		//
		// System.out.println(array[4].toString());
		// System.out.println(Arrays.toString(array));// Melhor forma de printar
		// // uma array inteira
		//
		// array = teste(array);
		// array[5] = "f";
		// System.out.println(Arrays.toString(array));
		// }
		//
		// private static String[] teste(String[] args) {
		//
		// String nova[] = new String[args.length + 1];
		//
		// for (int i = 0; i < args.length; i++) {
		// nova[i] = args[i];
		// }
		//
		// return nova;

		// Parte 03
		int array[] = { 5, 6, 4, 8, 4, 1, 3, 11, 1, 2, 6, 9 };
		// { 5, 4, 6, 4, 1, 3, 8, 1, 2, 6, 9, 11 };
		int cont = 0;

		// for (int i = 0; i < tamanho; i++) {
		// if (array[i] > array[i + 1]) {
		// int aux = array[i];
		// array[i] = array[i + 1];
		// array[i + 1] = aux;
		//
		//
		// }
		// i = -1;
		// tamanho--;
		// cont++;
		// }

		// Sort
		for (int tamanho = array.length - 1; tamanho >= 0; tamanho--) {
			for (int j = 0; j < tamanho; j++) {
				if (array[j] > array[j + 1]) {
					int aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
				}
				cont++;
			}
		}

		System.out.println(Arrays.toString(array));
		System.out.println("iteracoes: " + cont);

		// Reverse
		int interacoes = 0;

		for (int i = array.length - 1; i >= array.length >> 1; i--) {
			int aux = array[(array.length - 1) - i];

			array[(array.length - 1) - i] = array[i];
			array[i] = aux;

			interacoes++;
		}

		System.out.println(Arrays.toString(array));
		System.out.println(interacoes);

		// for each
		// for(int i = 0 ; i < array.length; i++){
		// int element = array[i];
		// System.out.println(element);
		// }
		// for(int element: array){
		// System.out.println(element);
		// }

	}

}
