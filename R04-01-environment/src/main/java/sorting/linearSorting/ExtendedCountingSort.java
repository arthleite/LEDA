package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex < 0 || rightIndex >= array.length
				|| leftIndex >= rightIndex) {
			return;
		}

		int min = array[leftIndex];
		int max = array[leftIndex];
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] < min) {
				min = array[i];
			}
			if (array[i] > max) {
				max = array[i];
			}
		}

		
		int[] count = new int[max - min + 1];
		for (int i = leftIndex; i <= rightIndex; i++) {
			count[array[i] - min]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		Integer[] sorted = new Integer[rightIndex - leftIndex + 1];
		for (int i = rightIndex; i >= leftIndex; i--) {
			sorted[--count[array[i] - min]] = array[i];
		}

		for (int i = 0; i < sorted.length; i++) {
			array[leftIndex + i] = sorted[i];
		}

	}

}
