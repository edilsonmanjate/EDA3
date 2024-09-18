import trabalho3.FilaCheiaException;
import trabalho3.FilaVaziaException;
import trabalho3.TADFila;

public class resolucao {

    public static void main(String[] args) throws FilaVaziaException, FilaCheiaException {
        TADFila<Integer> fila = new TADFila<>(5);

        int [] dados = {1,2,3,4,5};

        for (int i=0; i < dados.length; i++)
            try
            {
                fila.enqueue(dados[i]);
            }
            catch(FilaCheiaException ex)
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
        //System.out.println(posicaoFundoFila(fila));

    }

    public static boolean comparaPilha(TADFila<Integer> fila1,TADFila<Integer> fila2)
    {
        boolean iguas = false;



        return iguas;
    }


    public static int posicaoFundoFila(TADFila<Integer> fila){
        int nElementos = 0;
        int elemento = 0;

            while (!fila.isEmpty()) 
                try {
                    elemento = fila.dequeue();
                    
                    nElementos++;
                } catch (FilaVaziaException e) {
                    System.out.println(e.getMessage());
                }
            
            System.out.println((nElementos)+"º: "+elemento);

            return nElementos;
    }

    public static int posicaoTopoFila(TADFila<Integer> fila){
        int posicao = 0;
        
        if(!fila.isEmpty()) {
            posicao = 1;
        }

        return posicao;
    }

    public static void removeElemento(TADFila<Integer> fila,int elementoARemover) throws FilaVaziaException, FilaCheiaException{
        int elemento = 0;
        TADFila<Integer> filaAux = new TADFila<Integer>(fila.size());
        while (!fila.isEmpty()) {
           try {
            elemento = fila.dequeue();
            
           } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
           }

            if (elemento!=elementoARemover)
                try {
                    filaAux.enqueue(elemento);
                } catch (FilaCheiaException e) {
                    System.out.println(e.getMessage());
                }
        }

        while (!filaAux.isEmpty()) {
            try {
                fila.enqueue(filaAux.dequeue());
            } catch (FilaCheiaException e) {
                System.out.println(e.getMessage());
            }
            
        }
        System.out.println("Total de elementos: "+contaElementos(fila));
    }

    public static String topoFundoFila(TADFila<Integer> fila){
        int topo = 0;
        int fundo = 0;

        int sizeAux = fila.size(); 
        
        while (!fila.isEmpty()) {
            try {
                //primeira vez
                if(fila.size()==sizeAux)
                    topo = fila.dequeue();
                
                fundo = fila.dequeue(); 

            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }
        return "Topo: "+topo+", Fundo: "+fundo;
    }

    public static boolean elementoExiste(TADFila<Integer> fila,int procurado) throws FilaVaziaException{
        boolean existe = false;
        int elemento =0;

        while (!fila.isEmpty()) {
            try {
                elemento = fila.dequeue();
                if (elemento==procurado)
                    existe =true;

            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }

        return existe;
    }

    public static int contaElementos(TADFila<Integer> fila) {
        int nElementos = 0;
        int elemento = 0;

            while (!fila.isEmpty()) 
                try {
                    elemento = fila.dequeue();
                    System.out.println((nElementos+1)+"º: "+elemento);
                    nElementos++;
                } catch (FilaVaziaException e) {
                    System.out.println(e.getMessage());
                }

            return nElementos;
    }
    
    public static void ordemReversa(TADFila<Integer> fila) {
        System.out.println("Fila em ordem reversa: ");

        while (!fila.isEmpty()) {
            try {
                System.out.print(fila.dequeue() + " ");
            } catch (FilaVaziaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String menorMaiorElemento(TADFila<Integer> fila) {
        int maior = 0;
        int menor = Integer.MAX_VALUE;  
        
        try {
            while (!fila.isEmpty()) {
                int elemento = fila.dequeue();

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
