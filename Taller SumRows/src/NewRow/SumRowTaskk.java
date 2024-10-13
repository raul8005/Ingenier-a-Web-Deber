/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewRow;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Raul Medina
 */
public class SumRowTaskk implements Runnable {
     private int[] row;
    private final int pos;
    private final int [] sums;
    private CountDownLatch endController;
    int a;

    public SumRowTaskk(int[] row, int pos, int[] sums, CountDownLatch endController, int a) {
        this.row = row;
        this.pos = pos;
        this.sums = sums;
        this.endController = endController;
        this.a = a;
    }  
    
    @Override
    
    public void run() {
        
        var sum = 0;
        for (var num: row) {
            sum += num;
        }
        
        sums[pos] = sum;
        a= 9999;
        System.out.println("Hilo --> " + Thread.currentThread().getId());
        endController.countDown();
    }  
}
