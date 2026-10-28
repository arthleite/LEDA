package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex >= rightIndex) {
			return;
		}
		int min = array[leftIndex];
		int max = array[leftIndex];

		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] < min) min = array[i];
			if (array[i] > max) max = array[i];
		}

		int[] count = new int[max - min + 1];
		for (int i = leftIndex; i <= rightIndex; i++) {
			count[array[i] - min]++;
		}

		int pos = leftIndex;
		for (int i = 0; i < count.length; i++) {
			while (count[i]-- > 0) {
				array[pos++] = i + min;
			}
		}
	}
}
