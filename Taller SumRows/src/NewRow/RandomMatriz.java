/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewRow;

import java.util.Random;

/**
 *
 * @author Raul Medina
 */
public class RandomMatriz {
    
    private static Random random = new Random();
    
    public static int[][] generatematriz(int rows, int cols){
        int[][] output = new int[rows][cols];
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                output[i][j] = random.nextInt(10);
            }
        }
        
        return output;
    }
    
}
