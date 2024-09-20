import EDA3.PilhaCheiaException;
import EDA3.PilhaVaziaException;
import EDA3.TADPilha;

/*
 * Author: Edilson Manjate
 * Date: 2024/09/18
 * Description: Resolução dos exercícios do trabalho 3 de Estrutura de Dados e Algoritmos da USTM
 * Docente: Engº. Godinho Quissico
 */

public class pilha {

    public static void main(String[] args) throws PilhaCheiaException, PilhaVaziaException {
        // <Contrutores>
        TADPilha<Integer> pilha = new TADPilha<>(5);

        int [] dados = {1,2,3,4,5};

        for (int i=0; i < dados.length; i++)
            try
            {
                pilha.push(dados[i]);
            }
            catch(PilhaCheiaException ex)
            {
                System.out.println(ex.getMessage());
            }
        

        TADPilha<Integer> pilha2 = new TADPilha<>(5);
        int [] dados2 = {1,2,3,9,8};
        for (int i=0; i < dados2.length; i++)
            try
            {
                pilha2.push(dados2[i]);
            }
            catch(PilhaCheiaException ex)
            {
                System.out.println(ex.getMessage());
            }
        
        // </Construtores>

        // <Testes>

        //exercicio1
        //ordemReversa(fila);
        
        //exercicio2
        //System.out.println(menorMaiorElemento(fila)); 
        
        // //exercicio3
        //  fila.makeEmpty();

        // //exercicio4
        //System.out.println("Total de elementos: "+contaElementos(fila));

        //exercicio5
        //System.out.println(elementoExiste(pilha2,3));

        //exercicio6     
        //System.out.println(topoFundoFila(fila));

        //exercicio7    
        //removeElemento(fila,2);

        //exercicio8
        //System.out.println(posicaoTopoFila(fila));

        //exercicio9
        //System.out.println(posicaoFundoFila(fila));

        //exercicio10
        // System.out.println(comparaPilha(fila,fila2));

        //exercicio11
        // var printPilha = verificaElementos(pilha,pilha2);
        // while (!printPilha.isEmpty()) {
        //     try {
        //         System.out.println(printPilha.pop());
        //     } catch (PilhaVaziaException e) {
        //         System.out.println(e.getMessage());
        //     }
        // }

        //exercicio12
        // TADPilha<Integer> printPilha = aglutinadorPilhasSemRepiticoes(pilha,pilha2);
        // while (!printPilha.isEmpty()) 
        //     try {
        //         System.out.println(printPilha.pop());
        //     } catch (PilhaVaziaException e) {
        //         System.out.println(e.getMessage());
        //     }

        //exercicio13
        // TADPilha<Integer> printPilha = verificaExistenciaNumeroPrimo(pilha2);
        // while (!printPilha.isEmpty())
        //     try {
        //         System.out.println(printPilha.pop());
        //     } catch (PilhaVaziaException e) {
        //         System.out.println(e.getMessage());
        //     }

        // </Testes>
    }

    // <Resolução>

    public static TADPilha<Integer> verificaExistenciaNumeroPrimo(TADPilha<Integer> pilha){
        TADPilha<Integer> pilhaAux = new TADPilha<>(pilha.size());

        while (!pilha.isEmpty()) {
            int elemento = 0;
            try {
                elemento = pilha.pop();
            } catch (PilhaVaziaException e) {
                System.out.println(e.getMessage());
            }

            if (isPrime(elemento))
                try {
                    pilhaAux.push(elemento);
                } catch (PilhaCheiaException e) {
                    System.out.println(e.getMessage());
                }
        }

        return pilhaAux;

    }

    public static boolean isPrime(int n) {
        if (n <= 1) 
            return false;
        

        for (int i = 2; i <= Math.sqrt(n); i++) 
            if (n % i == 0) {
                return false;
            }
        
        return true;
    }


    public static TADPilha<Integer> aglutinadorPilhasSemRepiticoes(TADPilha<Integer> pilha, TADPilha<Integer> pilha2) throws PilhaCheiaException, PilhaVaziaException{

        TADPilha<Integer> pilhaAux = new TADPilha<>(pilha.size()+pilha2.size());

        while (!pilha.isEmpty()) {
            int elemento = pilha.pop();
            var estado = elementoExiste(pilha2,elemento);
            if(!estado)
                try {
                    pilhaAux.push(elemento);
                } catch (PilhaCheiaException e) {
                    System.out.println(e.getMessage());
                }
        }

        return pilhaAux;
    }

    public static TADPilha<Integer> verificaElementos(TADPilha<Integer> pilha, TADPilha<Integer> pilha2) throws PilhaCheiaException, PilhaVaziaException{
        TADPilha<Integer> pilhaAux = new TADPilha<>(pilha.size());

        while (!pilha.isEmpty()) {
            int elemento = pilha.pop();
            var estado = elementoExiste(pilha2,elemento);
            if(!estado)
                try {
                    pilhaAux.push(elemento);
                } catch (PilhaCheiaException e) {
                    System.out.println(e.getMessage());
                }
        }

        return pilhaAux;
    }


    public static boolean comparaPilha(TADPilha<Integer> pilha1,TADPilha<Integer> pilha2)
    {
        boolean iguas = false;
        
        if(pilha1.size()==pilha2.size())
        {
            int elemento1 = 0;
            int elemento2 = 0;

            while (!pilha1.isEmpty()) 
                try {
                    elemento1 = pilha1.pop();
                    elemento2 = pilha2.pop();
                    if(elemento1==elemento2)
                        iguas = true;
                    else
                    {
                        iguas = false;
                        break;
                    }
                } catch (PilhaVaziaException e) {
                    System.out.println(e.getMessage());
                }
        }

        return iguas;
    }

    public static int posicaoFundoFila(TADPilha<Integer> pilha) throws PilhaVaziaException{
        int nElementos = 0;
        int elemento = 0;

        while (!pilha.isEmpty()) 
            try {
                elemento = pilha.pop();
                
                nElementos++;
            } catch (PilhaVaziaException e) {
                System.out.println(e.getMessage());
            }
        
        System.out.println((nElementos)+"º: "+elemento);

        return nElementos;
    }

    public static int posicaoTopoFila(TADPilha<Integer> pilha){
        if(!pilha.isEmpty()) 
            return pilha.size();
        
        return 0;
    }

    public static void removeElemento(TADPilha<Integer> pilha,int elementoARemover) throws PilhaVaziaException, PilhaCheiaException{
        int elemento = 0;
        TADPilha<Integer> filaAux = new TADPilha<Integer>(pilha.size());
        while (!pilha.isEmpty()) {
           try {
            elemento = pilha.pop();
            
           } catch (PilhaVaziaException e) {
                System.out.println(e.getMessage());
           }

            if (elemento!=elementoARemover)
                try {
                    filaAux.push(elemento);
                } catch (PilhaCheiaException e) {
                    System.out.println(e.getMessage());
                }
        }

        while (!filaAux.isEmpty()) {
            try {
                pilha.push(filaAux.pop());
            } catch (PilhaCheiaException e) {
                System.out.println(e.getMessage());
            }
            
        }
        System.out.println("Total de elementos: "+contaElementos(pilha));
    }

    public static String topoFundoFila(TADPilha<Integer> pilha){
        int topo = 0;
        int fundo = 0;

        int sizeAux = pilha.size(); 
        
        while (!pilha.isEmpty()) {
            try {
                //primeira vez
                if(pilha.size()==sizeAux)
                    topo = pilha.pop();
                
                fundo = pilha.pop(); 

            } catch (PilhaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }
        return "Topo: "+topo+", Fundo: "+fundo;
    }

    public static boolean elementoExiste(TADPilha<Integer> pilha,int procurado) throws PilhaVaziaException{
        boolean existe = false;
        int elemento =0;

        while (!pilha.isEmpty()) {
            try {
                elemento = pilha.pop();
                if (elemento==procurado)
                    existe =true;

            } catch (PilhaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }

        return existe;
    }

    public static int contaElementos(TADPilha<Integer> pilha) {
        int nElementosOG = pilha.size();
        int nElementos = pilha.size();
        int elemento = 0;

            while (!pilha.isEmpty()) 
                try {
                    elemento = pilha.pop();
                    System.out.println((nElementos)+"º: "+elemento);
                    nElementos--;
                } catch (PilhaVaziaException e) {
                    System.out.println(e.getMessage());
                }

            return nElementosOG;
    }
    
    public static void ordemReversa(TADPilha<Integer> pilha) {
        System.out.println("Fila em ordem reversa: ");

        while (!pilha.isEmpty()) {
            try {
                System.out.print(pilha.pop() + " ");
            } catch (PilhaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String menorMaiorElemento(TADPilha<Integer> pilha) {
        int maior = 0;
        int menor = Integer.MAX_VALUE;  
        
        try {
            while (!pilha.isEmpty()) {
                int elemento = pilha.pop();

                if (elemento > maior)
                    maior = elemento;

                if (elemento < menor)
                    menor = elemento;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return "Menor:"+String.valueOf(menor)+", Maior:"+String.valueOf(maior);
    }

    // </Resolução>
}
