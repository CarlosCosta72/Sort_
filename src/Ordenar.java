import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ordenar {
    public static void main(String[] args) {
       String teste1="src/instancias-num/num.1000.1.in";
       String teste2= "src/instancias-num/num.1000.2.in";
       String teste3= "src/instancias-num/num.1000.3.in";
       String teste4= "src/instancias-num/num.1000.4.in";
       String teste5= "src/instancias-num/num.10000.1.in";
       String teste6= "src/instancias-num/num.10000.2.in";
       String teste7= "src/instancias-num/num.10000.3.in";
       String teste8= "src/instancias-num/num.10000.4.in";
       String teste9= "src/instancias-num/num.100000.1.in";
       String teste10= "src/instancias-num/num.100000.2.in";
       String teste11= "src/instancias-num/num.100000.3.in";
       String teste12= "src/instancias-num/num.100000.4.in";
        calcTempo(teste1, 1001, "num.1000.1");
        calcTempo(teste2, 1001, "num.1000.2");
        calcTempo(teste3, 1001, "num.1000.3");
        calcTempo(teste4, 1001, "num.1000.4");
        calcTempo(teste5, 10001, "num.10000.1");
        calcTempo(teste6, 10001, "num.10000.2");
        calcTempo(teste7, 10001, "num.10000.3");
        calcTempo(teste8, 10001, "num.10000.4");
        calcTempo(teste9, 100001, "num.100000.1");
        calcTempo(teste10, 100001, "num.100000.2");
        calcTempo(teste11, 100001, "num.100000.3");
        calcTempo(teste12, 100001, "num.100000.4");
        System.out.println("\n\n");
        System.out.println("Fim");
      }
      
      private static void intercala(long[] vetor, int inicio, int meio, int fim) {
        
        long[] novoVetor = new long[fim - inicio];

        int i = inicio;
        int m = meio;
        int pos = 0;
        
        while(i < meio && m < fim) {

          if(vetor[i] <= vetor[m]) {
            novoVetor[pos] = vetor[i];
            pos++;
            i++;
          } else {
            novoVetor[pos] = vetor[m];
            pos++;
            m++;
          }
        }

        while(i < meio) {
          novoVetor[pos] = vetor[i];
          pos++;
          i++;
        }

        while(m < fim) {
          novoVetor[pos] = vetor[m];
          pos++;
          m++;
        }

        for(pos = 0, i = inicio; i < fim; i++, pos++) {
          vetor[i] = novoVetor[pos];
        }
      }

      private static void mergeSortRecursivo(int inicio, int fim, long[] vetor) {

        if(inicio < fim - 1) {
          int meio = (inicio + fim) / 2;
          
          mergeSortRecursivo(inicio, meio, vetor);
          
          mergeSortRecursivo(meio, fim, vetor);
          
          intercala(vetor, inicio, meio, fim);
        }
      }
    /* 
      private static void mergeSort(int[] vetor) {
        int tamanho= vetor.length;
        int elementos = 1;
 
        int inicio, meio, fim;
        

        while(elementos < tamanho) {
   
          inicio = 0;
    
          while(inicio + elementos < tamanho) {
        
            meio = inicio + elementos;
         
            fim = inicio + 2 * elementos;
            
         
            if(fim > tamanho)
              fim = tamanho;
            
           
            intercala(vetor, inicio, meio, fim);
            
         
            inicio = fim;
          }
          
        
          elementos = elementos * 2;
        }
      }
      */


      public static void quickSort(long[] vetor,int inicio,int fim){
        
            if(inicio<fim){
                int p=partition(vetor,inicio,fim);
                quickSort(vetor, inicio,p-1);
                quickSort(vetor, p+1, fim);
            }

      }
      private static int partition(long[] vetor,int inicio,int fim){
        long pivot=vetor[fim];
        int i=inicio;
        for(int j=inicio;j<fim;j++){
            if(vetor[j]<=pivot){
                long aux=vetor[j];
                vetor[j]=vetor[i];
                vetor[i]=aux;
                i++;
            }
        }
        long aux=vetor[i];
        vetor[i]=vetor[fim];
        vetor[fim]=aux;
        return i;
      } 
      public static void bubbleSort(long[] vetor){
        for(int i=0;i<vetor.length;i++){
            for(int j=0;j<vetor.length-i-1;j++){
                if(vetor[j]>vetor[j+1]){
                    long aux= vetor[j+1];
                    vetor[j+1]=vetor[j];
                    vetor[j]=aux;
                }
            }
        }
    }
    public static void selectionSort(long[] vetor){
        for (int i = 0; i < vetor.length - 1; i++)  
        {  
            int menor = i;  
            for (int j = i + 1; j < vetor.length; j++){  
                if (vetor[j] < vetor[menor]){  
                    menor = j; 
                }  
            }  
            long menorNumero = vetor[menor];   
            vetor[menor] = vetor[i];  
            vetor[i] = menorNumero;  
        }  
    }  
    
   public static void insertionSort(long[] vetor){
        for (int i = 1; i < vetor.length; i++){
			
			long aux = vetor[i];
			int j = i;
			
			while ((j > 0) && (vetor[j-1] > aux)){
				vetor[j] = vetor[j-1];
				j -= 1;
			}
			vetor[j] = aux;

		}
    }
  public static long[] vetor(String caminho, int tamanho){
    long [] vetor= new long[tamanho];
     try {
          
          File arquivo= new File(caminho);
          Scanner sc= new Scanner(arquivo);
          int i=0;
          while(sc.hasNextInt()){
            
            vetor[i]= sc.nextLong();
            i++;
          }
          sc.close();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
    return vetor;
  }
  public static void calcTempo(String caminho, int tamanho,String nome){
        long [] vetor= vetor(caminho,tamanho);
        long start= System.currentTimeMillis();
        bubbleSort(vetor);
        long end= System.currentTimeMillis();
        System.out.println("Tempo decorrido pelo metodo bubble sort na instancia:"+ nome);
        System.out.printf("%.10f ms%n", (end - start) / 1000d);

        System.out.println("\n\n");

        vetor= vetor("src/instancias-num/num.1000.1.in",1001);
        start= System.currentTimeMillis();
        insertionSort(vetor);
        end= System.currentTimeMillis();
        System.out.println("Tempo decorrido pelo metodo insertion_sort na instancia: "+ nome);
        System.out.printf("%.10f ms%n", (end - start) / 1000d);

        System.out.println("\n\n");

        vetor= vetor("src/instancias-num/num.1000.1.in",1001);
        start= System.currentTimeMillis();
        selectionSort(vetor);
        end= System.currentTimeMillis();
        System.out.println("Tempo decorrido pelo metodo selection_sort na instancia: "+ nome);
        System.out.printf("%.10f ms%n", (end - start) / 1000d);

        System.out.println("\n\n");

        vetor= vetor("src/instancias-num/num.1000.1.in",1001);
        start=System.currentTimeMillis();
        mergeSortRecursivo(0,vetor.length,vetor);
        end= System.currentTimeMillis();
        System.out.println("Tempo decorrido pelo metodo merge_sort na instancia: "+nome);
        System.out.printf("%.10f ms%n", (end - start) / 1000d);

        System.out.println("\n\n");

        vetor= vetor("src/instancias-num/num.1000.1.in",1001);
        start=System.currentTimeMillis();
        quickSort(vetor, 0, vetor.length-1);
        end= System.currentTimeMillis();
        System.out.println("Tempo decorrido pelo metodo quick_sort na instancia: "+ nome);
        System.out.printf("%.10f ms%n", (end - start) / 1000d);
        System.out.println("\n\n");
  }
}
