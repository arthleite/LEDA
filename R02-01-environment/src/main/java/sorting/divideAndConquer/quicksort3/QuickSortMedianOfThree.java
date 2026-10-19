package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {
            if (rightIndex - leftIndex < 3) {
                medianOfThree(array, leftIndex, rightIndex);
            } else {// vai tratar os trechos com mais de 4 elementos
                int p = partition(array, leftIndex, rightIndex);
                sort(array, leftIndex, p - 1); // parte a esquerda
                sort(array, p + 1, rightIndex); // parte a direita
            }
        }
	}

	private int partition(T[] array, int leftIndex, int rightIndex){ // ordena left, right e mid e devolve o indice do centro, que no final guarda a mediana
		int pivoIndex = medianOfThree(array, leftIndex, rightIndex);
        T pivo = array[pivoIndex];
        Util.swap(array, pivoIndex, rightIndex - 1);

        int i = leftIndex;
        int j = rightIndex - 1;

        while (i < j) {
            while (array[++i].compareTo(pivo) < 0) { }
            while (array[--j].compareTo(pivo) > 0) { }
            if (i < j) {
                Util.swap(array, i, j);
            }
        }
        // devolve o pivô para a posição final
        Util.swap(array, i, rightIndex - 1);
        return i;
	}
    // ordena os arrays com 2 ou 3 elementos
	private int medianOfThree(T[] array, int leftIndex, int rightIndex) {
        int mid = leftIndex + (rightIndex - leftIndex) / 2;

        if (array[mid].compareTo(array[leftIndex]) < 0) {
            Util.swap(array, leftIndex, mid);
        }
        if (array[rightIndex].compareTo(array[leftIndex]) < 0) {
            Util.swap(array, leftIndex, rightIndex);
        }
        if (array[rightIndex].compareTo(array[mid]) < 0) {
            Util.swap(array, mid, rightIndex);
        }
        return mid;
    }
}
