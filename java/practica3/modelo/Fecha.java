
// Hacer toString

package java3.modelo;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Fecha extends GregorianCalendar{
    
    // Creating an object of SimpleDateFormat
    SimpleDateFormat formateaFecha = new SimpleDateFormat("dd-MM-yyyy");
        
    // Primer método: de String a GregorianCalendar (pasando por int)   // Primer y único, no??
    public static GregorianCalendar pedirFecha(String fecha) {      // el enunciado pide que esta clase sea static. Por qué??
        
        GregorianCalendar gregCal = null;       
        
         try 
        {                                   
            gregCal = new GregorianCalendar (Integer.parseInt(fecha.substring(1,2)), Integer.parseInt(fecha.substring(3,5)), Integer.parseInt(fecha.substring(6,10)));
            
            // Los convierto a enteros pero no los guardo en ninguna variable int?? No hace falta porque lo pasamos directamente a GC??
            //System.out.println(fecha);
        }
        catch (Exception e) {
            // Por si, aunque tenga el formato correcto, los números
            // se pasan de un dia/mes/año válido.
            System.out.println("\n\tError: Valores fuera de rango.");
        }
        
        return gregCal;
    }

    // Mostrar fecha
    /*@Override       
    public String toString() {
        return "FECHA DE ALTA:\n{" + Empleado. '}';
    }  */
}

/*
1.5.- El método setFechaAlta(GregorianCalendar fecha), modificará la fecha de forma manual, para que
pueda ser diferente a la dada por el sistema.

1.6.- Las fechas se pueden pedir y mostrar como int o String. Se debe crear una clase estática (como
Terminal de la prácticas 01) para su tratamiento.

1.7.- - Contendrán el método abstracto toString().
*/

