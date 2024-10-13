package Carrera4100;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raul Medina
 */
public class Equipo implements Runnable{
    
    int nombre;

    Equipo(int nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        
        System.out.println("Nombre del equipo: " + nombre);
        
        ArrayList<Thread> corredores = new ArrayList<Thread>(); 
        
        for (int i = 1; i <=4 ; i++) {
            var hilo = new Thread(new Corredor(i, nombre));
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            corredores.add(hilo);
        }
        
    }
    
}
