package NewRow;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Raul Medina
 */
public class SumRowTask {
    public static void main(String[] args) throws InterruptedException {
        int pos = 0;
        int a = 5;
        int[][] mat = RandomMatriz.generatematriz(12, 12);
        int[] sums = new int[mat.length];
        System.out.println("Longitud: " + mat.length);
        int numCores = Runtime.getRuntime().availableProcessors();
        //Hereda y tiene varios hijos (Parcial)
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numCores);// Crea ThreadPoolExecutor de hilos igual al número de núcleos.
        CountDownLatch endController = new CountDownLatch(mat.length);// Inicializa un CountDownLatch para esperar a que todas las tareas terminen.
        
        printMatrix(mat);
        System.out.println("Creando y ejecutando hilos");
        
        for (int[] row : mat) {
            Thread thread = new Thread(new SumRowTaskk(row, pos++, sums, endController, a));
            executor.execute(thread);//Ejecuta el hilo usando executor
        }
        
        endController.await();//espera que todos los hilos terminen de ejecutarse
        System.out.println("Fin");
        executor.shutdown();//Apaga el ejecutor

        int sumaTotal = 0;
        printRow(sums);
        System.out.println("Calculando suma final");
        for (int sum : sums) {
            sumaTotal += sum;
        }
        System.out.printf("Suma Total: %d\n", sumaTotal);
//        printRow(sums);
//        printMatrix(mat);
    }

    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int value : row) {
                System.out.printf("%d , ", value);
            }
            System.out.println();
        }
    }

    private static void printRow(int[] sums) {

        System.out.print("Vector: [");
        for (int i = 0; i < sums.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(sums[i]);
        }
        System.out.println("]");
    }

}
