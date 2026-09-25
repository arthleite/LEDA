package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor {

	// O array interno onde os objetos manipulados são guardados
	private Object[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(Object o){
		if(isCheio()){
			throw new IllegalArgumentException("Vetor cheio!!");
		}
		indice++;
		arrayInterno[indice] = o;
	}

	// Remove um objeto do vetor
	public Object remover(Object o) {
		Object removido = null;
		int posicao = -1;

		for (int i = 0; i <= indice; i++){
			if (arrayInterno[i].equals(o)){
				posicao = i;
				removido = arrayInterno[i];
			}
		}
		if(posicao != -1){
			for(int i = 0; i < indice; i++){
				arrayInterno[i] = arrayInterno[i + 1];
			}
			arrayInterno[indice] = null;
			indice--;
		}

		return removido;
	}

	// Procura um elemento no vetor
	public Object procurar(Object o) {
		Object encontrado = null;
		for (int i = 0; i <= indice; i++){
			if(arrayInterno[i].equals(o)){
				encontrado = arrayInterno[i];
			} 
		}
		return encontrado;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return indice == tamanho - 1;
	}

}
