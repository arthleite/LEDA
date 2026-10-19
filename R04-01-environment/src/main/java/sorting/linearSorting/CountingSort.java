package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex >= rightIndex) {
        return;
    }

    // 1. Encontra o maior valor no intervalo
    int max = array[leftIndex];
    for (int i = leftIndex + 1; i <= rightIndex; i++) {
        if (array[i] > max) {
            max = array[i];
        }
    }

    // 2. Array de contadores com tamanho = max + 1
    int[] count = new int[max + 1];

    // 3. Conta as ocorrências
    for (int i = leftIndex; i <= rightIndex; i++) {
        count[array[i]]++;
    }

    // 4. Soma acumulada (posição final de cada valor)
    for (int i = 1; i < count.length; i++) {
        count[i] += count[i - 1];
    }

    // 5. Monta o array ordenado (de trás pra frente, mantém estabilidade)
    Integer[] output = new Integer[rightIndex - leftIndex + 1];
    for (int i = rightIndex; i >= leftIndex; i--) {
        output[count[array[i]] - 1] = array[i];
        count[array[i]]--;
    }

    // 6. Copia o resultado de volta para o array original
    for (int i = 0; i < output.length; i++) {
        array[leftIndex + i] = output[i];
    }
	}

}
