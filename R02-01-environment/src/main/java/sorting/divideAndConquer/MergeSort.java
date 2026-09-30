package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array != null && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex){
			int meio = (leftIndex + rightIndex) / 2;

			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);

			merge(array, leftIndex, meio, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int meio, int rightIndex){
		T[] aux = (T[]) new Comparable[rightIndex - leftIndex + 1]; 
		// usa cast para transformar o array criado como combarable[] em T[]
		// Java nao permite criar diretamente um array de um tipo generico!!

		int i = leftIndex;
		int j = meio + 1;
		int k = 0;
		while(i <= meio && j <= rightIndex){
			if (array [i].compareTo(array[j]) <= 0){
				aux[k] = array[i];
				i++;
			} else {
				aux[k] = array[j];
				j++;
			}
			k++;
		}
		while (i <= meio){
			aux[k] = array[i];
			i++;
			k++;
		}
		while(j <= rightIndex){
			aux[k] = array[j];
			j++;
			k++;
		}
		for(k = 0; k < aux.length; k++){
			array[leftIndex + k] = aux[k];
		}
	}
}
