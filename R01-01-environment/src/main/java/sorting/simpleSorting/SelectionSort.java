package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex){
			for (int i = leftIndex; i < rightIndex; i++){
				int minIndex = i; // O indice tem q ser igual a i, pois essa será posição q estamos tentandop preencher 
				for (int j = i + 1; j <= rightIndex; j++){
					if( array[j].compareTo(array[minIndex])< 0){
						minIndex = j;
					}
				}
				if(minIndex != i){
					Util.swap(array, i, minIndex);
				}
			}
		}
	}
}
