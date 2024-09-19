import trabalho3.PilhaCheiaException;
import trabalho3.PilhaVaziaException;
import trabalho3.TADPilha;

public class resolucao {

    public static void main(String[] args) throws PilhaCheiaException, PilhaVaziaException {
        TADPilha<Integer> fila = new TADPilha<>(5);

        int [] dados = {1,2,3,4,5};

        for (int i=0; i < dados.length; i++)
            try
            {
                fila.push(dados[i]);
            }
            catch(PilhaCheiaException ex)
            {
                System.out.println(ex.getMessage());
            }

        //exercicio1
        //ordemReversa(fila);
        
        //exercicio2
        //System.out.println(menorMaiorElemento(fila)); 
        
        // //exercicio3
        // fila.makeEmpty();

        // //exercicio4
        //System.out.println("Total de elementos: "+contaElementos(fila));

        //exercicio5
        //System.out.println(elementoExiste(fila,1));

        //exercicio6     
        //System.out.println(topoFundoFila(fila));

        //exercicio7    
        //removeElemento(fila,2);

        //exercicio8
        //System.out.println(posicaoTopoFila(fila));

        //exercicio9
        System.out.println(posicaoFundoFila(fila));


    }

    public static boolean comparaPilha(TADPilha<Integer> fila1,TADPilha<Integer> fila2)
    {
        boolean iguas = false;



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


    public static int posicaoTopoFila(TADPilha<Integer> fila){
        int posicao = 0;
        
        if(!fila.isEmpty()) {
            posicao = 1;
        }

        return posicao;
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

    public static String topoFundoFila(TADPilha<Integer> fila){
        int topo = 0;
        int fundo = 0;

        int sizeAux = fila.size(); 
        
        while (!fila.isEmpty()) {
            try {
                //primeira vez
                if(fila.size()==sizeAux)
                    topo = fila.pop();
                
                fundo = fila.pop(); 

            } catch (PilhaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }
        return "Topo: "+topo+", Fundo: "+fundo;
    }

    public static boolean elementoExiste(TADPilha<Integer> fila,int procurado) throws PilhaVaziaException{
        boolean existe = false;
        int elemento =0;

        while (!fila.isEmpty()) {
            try {
                elemento = fila.pop();
                if (elemento==procurado)
                    existe =true;

            } catch (PilhaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }

        return existe;
    }

    public static int contaElementos(TADPilha<Integer> fila) {
        int nElementos = 0;
        int elemento = 0;

            while (!fila.isEmpty()) 
                try {
                    elemento = fila.pop();
                    System.out.println((nElementos+1)+"º: "+elemento);
                    nElementos++;
                } catch (PilhaVaziaException e) {
                    System.out.println(e.getMessage());
                }

            return nElementos;
    }
    
    public static void ordemReversa(TADPilha<Integer> fila) {
        System.out.println("Fila em ordem reversa: ");

        while (!fila.isEmpty()) {
            try {
                System.out.print(fila.pop() + " ");
            } catch (PilhaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String menorMaiorElemento(TADPilha<Integer> fila) {
        int maior = 0;
        int menor = Integer.MAX_VALUE;  
        
        try {
            while (!fila.isEmpty()) {
                int elemento = fila.pop();

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



}
