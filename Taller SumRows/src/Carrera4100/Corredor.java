package Carrera4100;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Raul Medina
 */
public class Corredor extends Equipo implements Runnable{

    Random random = new Random();
    int num_cor;

    public Corredor(int num_cor, int nombre) {
        super(nombre);
        this.num_cor = num_cor;
    }
    @Override
    public void run() {
        
        for (int j = 0; j < 100; j=j+10) {
        System.out.println("Equipo: " + nombre +", Corredor-> " + num_cor + ", Distancia: " + j);
        j = j + random.nextInt(1,4);
        }
         
    }
}















//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
//class Objeto {
//    private int valor1;
//    private int valor2;
//    private int valor3;
//    private int valor4;
//
//    public Objeto(int valor1, int valor2, int valor3, int valor4) {
//        this.valor1 = valor1;
//        this.valor2 = valor2;
//        this.valor3 = valor3;
//        this.valor4 = valor4;
//    }
//
//    public int[] getValores() {
//        return new int[]{valor1, valor2, valor3, valor4};
//    }
//
//    @Override
//    public String toString() {
//        return "[" + valor1 + ", " + valor2 + ", " + valor3 + ", " + valor4 + "]";
//    }
//}
//
//class LObjeto {
//    public static int[][] generarObjeto(int filas, int columnas) {
//        Random random = new Random();
//        int[][] matriz = new int[filas][columnas];
//        for (int i = 0; i < filas; i++) {
//            for (int j = 0; j < columnas; j++) {
//                matriz[i][j] = 1 + random.nextInt(20); // Valores aleatorios entre 1 y 20
//            }
//        }
//        return matriz;
//    }
//}
//
//class SumaPrimosTask implements Callable<Integer> {
//    private List<Objeto> subLista;
//
//    public SumaPrimosTask(List<Objeto> subLista) {
//        this.subLista = subLista;
//    }
//
//    @Override
//    public Integer call() {
//        int suma = 0;
//        for (Objeto objeto : subLista) {
//            for (int valor : objeto.getValores()) {
//                if (esPrimo(valor)) {
//                    suma += valor;
//                }
//            }
//        }
//        return suma;
//    }
//
//    private boolean esPrimo(int num) {
//        if (num <= 1) return false;
//        if (num == 2) return true;
//        if (num % 2 == 0) return false;
//        for (int i = 3; i <= Math.sqrt(num); i += 2) {
//            if (num % i == 0) return false;
//        }
//        return true;
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        List<Objeto> lista = new ArrayList<>();
//        int[][] obj = LObjeto.generarObjeto(500, 4);
//
//        for (int i = 0; i < obj.length; i++) {
//            Objeto objeto = new Objeto(obj[i][0], obj[i][1], obj[i][2], obj[i][3]);
//            lista.add(objeto);
//        }
//
//        // Número de hilos
//        int numHilos = 10;
//        ExecutorService executor = Executors.newFixedThreadPool(numHilos);
//        List<Future<Integer>> resultados = new ArrayList<>();
//
//        int tamañoSubLista = lista.size() / numHilos;
//        for (int i = 0; i < numHilos; i++) {
//            int inicio = i * tamañoSubLista;
//            int fin = (i == numHilos - 1) ? lista.size() : inicio + tamañoSubLista;
//            List<Objeto> subLista = lista.subList(inicio, fin);
//            SumaPrimosTask tarea = new SumaPrimosTask(subLista);
//            Future<Integer> resultado = executor.submit(tarea);
//            resultados.add(resultado);
//        }
//
//        int sumaTotalPrimos = 0;
//        for (Future<Integer> resultado : resultados) {
//            try {
//                sumaTotalPrimos += resultado.get();
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
//
//        executor.shutdown();
//        System.out.println("Sumatoria de los números primos: " + sumaTotalPrimos);
//    }
//}

