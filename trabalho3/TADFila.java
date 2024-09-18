package trabalho3;

import java.util.Arrays;

/**
 * Data: 12/09/2024
 * Autor: 2P4LASIR2
 * Tema: TAD Fila
 */
public class TADFila <T> {

	private T[] data; // Array para armazenar os elementos da fila
	private byte[] info; // Array para armazenar o estado dos elementos (0 = vazio, 1 = ocupado, 2 = frente da fila)
	private int nElements, size; // nElements é o número de elementos na fila, size é o tamanho máximo da fila

	// Construtor que inicializa a fila com um tamanho específico
	public TADFila(int size) {
		this.size = size;
		makeEmpty(); // Inicializa a fila como vazia
	}

	// Método para esvaziar a fila
	public void makeEmpty() {
		data = (T[]) new Object[size]; // Cria um novo array de elementos
		info = new byte[size]; // Cria um novo array de estados
		nElements = 0; // Define o número de elementos como 0
		Arrays.fill(info, (byte) 0); // Preenche o array de estados com 0 (vazio)
	}

	// Método para verificar se a fila está vazia
	public boolean isEmpty() {
		return nElements == 0;
	}

	// Método para verificar se a fila está cheia
	public boolean isFull() {
		return nElements >= size;
	}

	// Método para adicionar um elemento à fila
	public void enqueue(T element) throws FilaCheiaException {
		if (isFull())
			throw new FilaCheiaException("A Fila está cheia!!");

		if (isEmpty()) {
			data[nElements] = element; // Adiciona o elemento na posição 0
			info[nElements++] = 2; // Marca a posição 0 como a frente da fila
		} else {
			int i = 0;
			while (info[i] != 2)
				i++; // Encontra a posição da frente da fila
				int j;
				for (j = i + 1; j < info.length; j++)
					if (info[j] == 0)
						break; // Encontra a próxima posição vazia

				if (j == size) {
					int j2 = 0;
					while (info[j2] != 0)
						j2++; // Encontra a próxima posição vazia no início do array
					info[j2] = 1; // Marca a posição como ocupada
					data[j2] = element; // Adiciona o elemento
				} else {
					info[j] = 1; // Marca a posição como ocupada
					data[j] = element; // Adiciona o elemento
				}
				nElements++; // Incrementa o número de elementos
		}
	}

	// Método para remover um elemento da fila
	public T dequeue() throws FilaVaziaException {
		if (isEmpty())
			throw new FilaVaziaException("A Fila está vazia!!");

		int i = 0;
		while (info[i] != 2)
			i++; // Encontra a posição da frente da fila

		if (i + 1 < size) {
			if (info[i + 1] == 1)
				info[i + 1] = 2; // Marca a próxima posição ocupada como a nova frente da fila
		} else {
			if (info[0] == 1)
				info[0] = 2; // Marca a posição 0 como a nova frente da fila se a fila estiver no final do array
		}
		info[i] = 0; // Marca a posição atual como vazia
		nElements--; // Decrementa o número de elementos

		return data[i]; // Retorna o elemento removido
	}

	// Método para retornar o elemento da frente da fila
	public int size() {
		return nElements;
	}
}
