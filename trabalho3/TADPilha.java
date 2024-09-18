/**
 * 
 */
package trabalho3; // Declaração do pacote

/**
 * Data: 05/09/2024
 * Autor: 2P4LASIR2
 * Tema: TAD Pilha
 */
public class TADPilha <T> { // Declaração da classe genérica TADPilha
	
	private T[] data; // Array para armazenar os elementos da pilha
	private int nElements, size; // nElements armazena o número de elementos na pilha, size armazena o tamanho máximo da pilha
	
	// Inicialização da estrutura
	public TADPilha(int size) { // Construtor que recebe o tamanho da pilha
		this.data = (T[]) new Object[size]; // Inicializa o array com o tamanho especificado
		nElements = 0; // Inicializa o número de elementos como 0
		this.size = size; // Armazena o tamanho da pilha
	}
	
	public boolean isEmpty() { // Verifica se a pilha está vazia
		return nElements == 0; // Retorna true se nElements for 0
	}
	
	public boolean isFull() { // Verifica se a pilha está cheia
		return nElements >= data.length; // Retorna true se nElements for maior ou igual ao tamanho do array
	}
	
	public void makeEmpty() { // Esvazia a pilha
		nElements = 0; // Reseta o número de elementos para 0
		data = (T[]) new Object[size]; // Recria o array com o tamanho original
	}
	
	public T pop() throws PilhaVaziaException { // Remove e retorna o elemento do topo da pilha
		if (isEmpty()) // Verifica se a pilha está vazia
			throw new PilhaVaziaException("A pilha está vazia!!"); // Lança exceção se a pilha estiver vazia
		return data[--nElements]; // Decrementa nElements e retorna o elemento do topo
	}
	
	public void push(T element) throws PilhaCheiaException { // Adiciona um elemento ao topo da pilha
		if (isFull()) // Verifica se a pilha está cheia
			throw new PilhaCheiaException("A pilha está cheia!!"); // Lança exceção se a pilha estiver cheia
		data[nElements++] = element; // Adiciona o elemento e incrementa nElements
	}
	
	public T top() { // Retorna o elemento do topo da pilha sem removê-lo
		return (T) data[nElements - 1]; // Retorna o elemento do topo
	}
	
}
