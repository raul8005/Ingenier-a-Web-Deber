
package Carrera4100;

import java.util.ArrayList;

/**
 *
 * @author Raul Medina
 */
public class Carrera {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Thread> equipos = new ArrayList<Thread>();

        for (int i = 1; i <= 5; i++) {
            
            var hiloe = new Thread(new Equipo(i));
            hiloe.start();
            
            equipos.add(hiloe);
            hiloe.join();
        }
        

    }

}
