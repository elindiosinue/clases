/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import uno.librerias.PedirNombre;

/**
 *
 * @author rafola
 */
public class Uno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String nombre = PedirNombre.NOMBRE;
        
        PedirNombre pedirNombre = new PedirNombre();
        int num = pedirNombre.getNumero();
        
        String string;
        
        string = "";
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
    }
    
}
