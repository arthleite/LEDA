package problems;

/**
 * Dado um array ordenado de inteiros ordenado, floor(x) eh o elemento do array menor 
 * (e mais proximo possível de x) ou igual a x (podendo x pertencer ou nao ao array). 
 * Analogamente, ceil(x) seria o elemento do array que é maior (e mais próximo 
 * possível de x) ou igual a x.
 * Note que o floor de ceil de um numero que está no array é o pr[oprio número.
 *
 * Caso o elemento não tenha floor nem ceil, deve retornar null
 * 
 * Exemplo: floor([4,6,8,10],7) = 6, ceil([4,6,8,10],7) = 8,
 * floor([4,6,8,10],8) = ceil([4,6,8,10],8) = 8
 * 
 * @author Adalberto
 *
 */
public interface FloorCeil {
	/**
	 * Metodo para calcular o floor de um dado numero do array usando a BST. 
	 * O floor de um numero eh o inteiro do array e que mais se aproxima do
	 * numero, por baixo, podendo ser menor ou o proprio numero.
	 *
	 * Caso o metodo nao encontre nenhum numero apropriado para retornar, deve-se
	 * retornar null.
	 */
	public Integer floor(Integer[] array, Integer x);

	/**
	 * Metodo para calcular o ceil de um dado numero do array usando a BST. 
	 * O ceil de um numero eh o inteiro do array e que mais se aproxima do
	 * numero, por cima, podendo ser maior ou o proprio numero.
	 *
	 * Caso o metodo nao encontre nenhum numero apropriado para retornar, deve-se
	 * retornar null.
	 */
	public Integer ceil(Integer[] array, Integer x);
	
}
