import trabalho3.FilaCheiaException;
import trabalho3.FilaVaziaException;
import trabalho3.TADFila;
/*
 * Author: Edilson Manjate
 * Date: 2024/09/18
 * Description: Resolução dos exercícios do trabalho 3 de Estrutura de Dados e Algoritmos da USTM
 * Docente: Engº. Godinho Quissico
 */

public class fila {
    public static void main(String[] args) throws FilaCheiaException {

        //<Contrutores>
        TADFila<Integer> fila = new TADFila<Integer>(5);   
        int [] dados = {1, 2, 3, 2, 1};
        for (int i = 0; i < dados.length; i++) 
            try {
                fila.enqueue(dados[i]);
            } catch (FilaCheiaException e) {
                e.printStackTrace();
            }


        TADFila<Integer> fila2 = new TADFila<Integer>(5);   
        int [] dados2 = {1, 2, 3, 4, 5};
        for (int i = 0; i < dados.length; i++) 
            try {
                fila2.enqueue(dados2[i]);
            } catch (FilaCheiaException e) {
                e.printStackTrace();
            }
        

        TADFila<String> fila3 = new TADFila<String>(5);   
        String [] dados3 = {"a", "!", "c", "2", "ç"};

        for (int i = 0; i < dados3.length; i++) 
            try {
                fila3.enqueue(dados3[i]);
            } catch (FilaCheiaException e) {
                e.printStackTrace();
            }

    // </Construtores>

        
    // <Testes">

    //Exercício 14
    //System.out.println(comparaFilas(fila, fila2));

    //Exercício 15
    //System.out.println(fila.size());

    //Exercício 16
    //System.out.println(ePalindromo(fila3));

    //Exercício 17
    //System.out.println(maiorElemento(fila2));

    //Exercício 18
    //System.out.println(somaElementos(fila));

    //Exercício 19
    //System.out.println(mediaElementos(fila));

    //Exercício 20
    //System.out.println(elemenExisteFila(fila, 16));

    //Exercício 21
    //System.out.println(primeiroElementoNaoRepedito(fila));3

    //Exercício 22
    //Repetição do 14

    //Exercício 23
    //System.out.println(somaPares(fila));
    
    //Exercício 24
    // fila = moverParesParaInicio(fila2);  
    // while (!fila.isEmpty()) 
    //     try {
    //         System.out.println(fila.dequeue());
    //     } catch (FilaVaziaException e) {
    //         System.out.println(e.getMessage());
    //     }

    //Exercício 25
    //contarElementos(fila3);
    

    // </Testes>
        
    }

    //<Resolução>

    public static void contarElementos(TADFila<String> fila) {
        int digitos = 0, caracteres = 0, especiais = 0;

        while (!fila.isEmpty()) {
            try {
                String elemento = fila.dequeue();
                for (char c : elemento.toCharArray()) {
                    if (Character.isDigit(c)) {
                        digitos++;
                    } else if (Character.isLetter(c)) {
                        caracteres++;
                    } else {
                        especiais++;
                    }
                }
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Dígitos: " + digitos);
        System.out.println("Caracteres: " + caracteres);
        System.out.println("Especiais: " + especiais);
    }

    public static TADFila<Integer> moverParesParaInicio(TADFila<Integer> fila) throws FilaCheiaException{
        TADFila<Integer> filaAux = new TADFila<Integer>(fila.size());
        TADFila<Integer> filaPares = new TADFila<Integer>(fila.size());
        TADFila<Integer> filaImpares = new TADFila<Integer>(fila.size());

        while (!fila.isEmpty()) 
            try {
                int elemento = fila.dequeue();
                if (elemento % 2 == 0)
                    filaPares.enqueue(elemento);
                else
                    filaImpares.enqueue(elemento);
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }

        while (!filaPares.isEmpty()) 
            try {
                filaAux.enqueue(filaPares.dequeue());
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }

        while (!filaImpares.isEmpty()) 
            try {
                filaAux.enqueue(filaImpares.dequeue());
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }

        return filaAux;
    }

    public static int somaPares(TADFila<Integer> fila) {
        int soma = 0;
        while (!fila.isEmpty()) 
            try {
                int elemento = fila.dequeue();
                if (elemento % 2 == 0)
                    soma += elemento;
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }
        return soma;
    }

    public static int primeiroElementoNaoRepedito(TADFila<Integer> fila) {
        int elemento = 0;
        while (!fila.isEmpty()) 
            try {
                int elementoAtual = fila.dequeue();
                if (!elemenExisteFila(fila, elementoAtual))
                    return elementoAtual;
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }
        return elemento;
    }

    public static boolean elemenExisteFila(TADFila<Integer> fila,int elemento) {
        while (!fila.isEmpty()) 
            try {
                if (fila.dequeue() == elemento)
                    return true;
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }

        return false;
    }

    public static int mediaElementos(TADFila<Integer> fila) {
        return  (somaElementos(fila) == 0) ? 1 : somaElementos(fila) / (fila.size() == 0 ? 1 : fila.size());
    }

    public static int somaElementos(TADFila<Integer> fila) {
        int soma = 0;
        while (!fila.isEmpty()) 
            try {
                soma += fila.dequeue();
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }
        return soma;
    }

    public static int maiorElemento(TADFila<Integer> fila) {
        int maior = 0;
        while (!fila.isEmpty()) 
            try {
                int elemento = fila.dequeue();
                if (elemento > maior)
                    maior = elemento;
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }
        
        return maior;
    }

    public static boolean ePalindromo(TADFila<Integer> fila) throws FilaCheiaException {

        TADFila<Integer> filaAux = new TADFila<Integer>(fila.size());
        
        for (int i = 0; i < fila.size(); i++) {
            try {
                filaAux.enqueue(fila.dequeue());
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < fila.size(); i++) {
            try {
                if (filaAux.dequeue() != fila.dequeue())
                    return false;
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }

    public static boolean comparaFilas(TADFila<Integer> fila1, TADFila<Integer> fila2) {
        if (fila1.size() != fila2.size())
            return false;

        while (!fila1.isEmpty()) 
            try {
                if (fila1.dequeue() != fila2.dequeue())
                    return false;
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }
        
        return true;
    }

    //</Resolução>
}
