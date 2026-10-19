package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes:
 * - Algoritmo DEVE ser in-place (o uso de memória auxiliar deve ser O(1)).
 * - O tempo de seu algoritmo deve ser O(log n).
 * - Você deve usar a estratégia de busca binária para resolver o problema.
 * - Você DEVE usar recursão para resolver o problema. Sua solução não pode
 * conter loops (for, while, etc).
 * - Você NÃO pode usar return em métodos void
 * - Você NÃO pode usar mais de um retur em método que retorna algum valor
 * - Você NÃO pode criar atributos novos na classe
 * - Você pode implementar no máximo 2 métodos auxiliares com, no máximo, 4
 * parâmetros cada um.
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearchImpl implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		Integer result = null;
		if (array != null && array.length > 0) {
			result = floorRec(array, x, 0, array.length - 1);
		}
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		Integer result = null;
		if (array != null && array.length > 0) {
			result = ceilRec(array, x, 0, array.length - 1);
		}
		return result;
	}

	private Integer floorRec(Integer[] array, Integer x, int left, int right) {
		Integer result = null;
		if (left <= right) {
			int mid = left + (right - left) / 2;
			int cmp = array[mid].compareTo(x);
			if (cmp == 0) {
				result = array[mid];
			} else if (cmp > 0) {
				result = floorRec(array, x, left, mid - 1);
			} else {
				result = floorRec(array, x, mid + 1, right);
			}
		}
		return result;
	}

	private Integer ceilRec(Integer[] array, Integer x, int left, int right){
		Integer result = null;
		if(left <= right){
			int mid = left + (right - left) / 2;
			int cmp = array[mid].compareTo(x);
			if (cmp == 0) {
				result = array[mid];
			}else if (cmp < 0){
				result = ceilRec(array, x, mid + 1, right);
			}else{
				result = ceilRec(array, x, left, mid -1);
				if (result == null){
					result = array[mid];
				}
			}
		}
		return result;
	}
}
