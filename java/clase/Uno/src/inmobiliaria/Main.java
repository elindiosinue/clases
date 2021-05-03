
package inmobiliaria;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static final int MAX_INMUEBLES = 4;       // constante que indicará el máximo de inmuebles a ingresar
    
    public static void main(String[] args) {
  
        CInmueble inmueble1 = new CInmueble ('a');      // alquiler
        CInmueble inmueble2 = new CInmueble ('a');      // alquiler
        CInmueble inmueble3 = new CInmueble ('v');      // venta
        CInmueble inmueble4 = new CInmueble ('v');      // venta
        
        int opcion = 0;
        
        do{
            mostrarMenu ();
            try {
                opcion = leerOpcion ();
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {                                           // Tratamiento de excepción tipo lanzamiento. Aquí se trata lo lanzado
                tratarOpcion (opcion, inmueble1, inmueble2, inmueble3, inmueble4);  // si ocurre algún problema relacionado con el sistema.
            } catch (Exception e) {
                System.out.println("***Se ha producido un error del sistema.");
            }
        }while (opcion != 5);
    }
    
    public static void mostrarMenu (){
            System.out.println("MENU PRINCIPAL:");
            System.out.println("---------------");
            System.out.println("\t1. Alta de inmueble.");
            System.out.println("\t2. Mostrar datos del inmueble.");
            System.out.println("\t3. Actualizar el precio del inmueble.");
            System.out.println("\t4. Comparar los inmuebles.");
            System.out.println("\t5. Salir.");
    }
    
    public static int leerOpcion () throws Exception
    {
        int opcion;
        do
        {
            System.out.println("Introduzca opcion:");
            opcion = Leer.datoInt();
            }while ((opcion) != 1 && (opcion) != 2 && (opcion) != 3 && (opcion) != 4 && 
                    (opcion) != 5);     // controlamos la entrada de datos con do... while.
        
        return opcion;
    }
    
    public static void tratarOpcion (int opcion, CInmueble inmueble1, CInmueble inmueble2, CInmueble inmueble3, CInmueble inmueble4) throws Exception
    {
        switch (opcion)
	{
            case 1: altaInmueble(inmueble1, inmueble2, inmueble3, inmueble4);
                break;
            case 2: mostrarDatosPorRefCatastral(inmueble1, inmueble2, inmueble3, inmueble4);
		break;
            case 3: actualizarPrecio (inmueble1, inmueble2, inmueble3, inmueble4);
		break;
            case 4: compararInmuebles (inmueble1, inmueble2, inmueble3, inmueble4);
        }
    }
    
    /**
     * 
     * PEDIMOS TODOS LOS DATOS DE LOS INMUEBLES
     */
    public static void altaInmueble (CInmueble inmueble1, CInmueble inmueble2, CInmueble inmueble3, CInmueble inmueble4) throws Exception {
      
        if (CInmueble.getContador() > MAX_INMUEBLES){
            throw new Exception("\n\tNo se pueden introducir más inmuebles.");
        }
        
        if (CInmueble.getContador() == 1)        // Solo lo pedirá la primera vez que da de alta un inmueble
            CInmueble.setImpuesto(CInmueble.pedirImpuesto());

        pedirRestoDatos (inmueble1, inmueble2, inmueble3, inmueble4);

        int cont = CInmueble.getContador();
                
        CInmueble.setContador(cont++);     

        System.out.println("\nSe ha dado de alta un inmueble en la base de datos. ");
    }
    
    public static void pedirRestoDatos (CInmueble inmueble1, CInmueble inmueble2, CInmueble inmueble3, CInmueble inmueble4) {
        
        if (CInmueble.getContador() == 1)
        {
            inmueble1.setRefCatastral(CInmueble.pedirRefCatastral());
            inmueble1.setDireccion(inmueble1.pedirDireccion());                       
            inmueble1.setNumHabitaciones(inmueble1.pedirNumHabitaciones());     // EJEMPLO DE EXCEPCION (TIPO PROPAGACIÓN)                                                 
            inmueble1.setMCuadrados(inmueble1.pedirMetrosC());
            inmueble1.setPrecio(CInmueble.pedirPrecio(CInmueble.getModalidad()));
        }
        else
        {
            if (CInmueble.getContador() == 2)
            {
                inmueble2.setRefCatastral(CInmueble.pedirRefCatastral());
                inmueble2.setDireccion(inmueble2.pedirDireccion());
                inmueble2.setNumHabitaciones(inmueble2.pedirNumHabitaciones());
                inmueble2.setMCuadrados(inmueble2.pedirMetrosC());
                inmueble2.setPrecio(CInmueble.pedirPrecio(CInmueble.getModalidad()));
            }
            else
            {
                if (CInmueble.getContador() == 3)
                {
                    inmueble3.setRefCatastral(CInmueble.pedirRefCatastral());
                    inmueble3.setDireccion(inmueble3.pedirDireccion());
                    inmueble3.setNumHabitaciones(inmueble3.pedirNumHabitaciones());
                    inmueble3.setMCuadrados(inmueble3.pedirMetrosC());
                    inmueble3.setPrecio(CInmueble.pedirPrecio(CInmueble.getModalidad()));
                }
                else
                {
                    if (CInmueble.getContador() == 4)
                    {
                        inmueble4.setRefCatastral(CInmueble.pedirRefCatastral());
                        inmueble4.setDireccion(inmueble4.pedirDireccion());
                        inmueble4.setNumHabitaciones(inmueble4.pedirNumHabitaciones());
                        inmueble4.setMCuadrados(inmueble4.pedirMetrosC());
                        inmueble4.setPrecio(CInmueble.pedirPrecio(CInmueble.getModalidad()));
                    }
                }
            }
        }
    }
    
    public static void mostrarDatosPorRefCatastral (CInmueble inmueble1, CInmueble inmueble2, CInmueble inmueble3, CInmueble inmueble4) throws IOException{

        String cad = CInmueble.pedirRefCatastral();
            
        if (inmueble1.getRefCatastral().equals(cad))
            inmueble1.visualizarDatos(cad);     // meto cadena en los parámetros o mejor "cogerla" de su objeto??
        else
        {
            if (inmueble2.getRefCatastral().equals(cad))
                    inmueble2.visualizarDatos(cad);
            else
            {
                if (inmueble3.getRefCatastral().equals(cad))
                    inmueble3.visualizarDatos(cad);
                else
                {
                    if (inmueble4.getRefCatastral().equals(cad))
                        inmueble4.visualizarDatos(cad);
                    else
                        System.out.println("\nHa introducido una referencia catastral incorrecta. ");
                }
            }
        }    
    }
    
    public static void actualizarPrecio (CInmueble inmueble1, CInmueble inmueble2, CInmueble inmueble3, CInmueble inmueble4) throws IOException
    {
        
        String cad = CInmueble.pedirRefCatastral();
        float p = preguntarCambioPrecio ();                   
        float cantidad = CInmueble.pedirPrecio (CInmueble.getModalidad());    
        
        if (p == 1)     // si se quiere subir el precio
            if (inmueble1.getRefCatastral().equals(cad))
                inmueble1.subirPrecio(cantidad);     
        else
        {
            if (inmueble2.getRefCatastral().equals(cad))
                    inmueble2.subirPrecio(cantidad);
            else
            {
                if (inmueble3.getRefCatastral().equals(cad))
                    inmueble3.subirPrecio(cantidad);
                else
                {
                    if (inmueble4.getRefCatastral().equals(cad))
                        inmueble4.subirPrecio(cantidad);
                    else
                        System.out.println("\nHa introducido una referencia catastral incorrecta. ");
                }
            }
        }    
        else      // será un 2 (bajada de precio) porque ya está validado anteriormente  
        {
            if (inmueble1.getRefCatastral().equals(cad))
                inmueble1.bajarPrecio(cantidad);     
            else
            {
                if (inmueble2.getRefCatastral().equals(cad))
                        inmueble2.bajarPrecio(cantidad);
                else
                {
                    if (inmueble3.getRefCatastral().equals(cad))
                        inmueble3.bajarPrecio(cantidad);
                    else
                    {
                        if (inmueble4.getRefCatastral().equals(cad))
                            inmueble4.bajarPrecio(cantidad);
                        else
                            System.out.println("\nHa introducido una referencia catastral incorrecta. ");
                    }
                }
            }    
        }    
    }
    
    public static float preguntarCambioPrecio (){
        
        float p;  
        
        do
        {
            System.out.println("\n¿Desea realizar una subida o una bajada del importe? (Indique 1 = S / 2 = B): ");
            p = Leer.datoFloat();
        }while (p != 1 && p != 2);
        
        return p;
    }
    
    public static void compararInmuebles (CInmueble inmueble1, CInmueble inmueble2, CInmueble inmueble3, CInmueble inmueble4){
        
        if (inmueble1.getRefCatastral() == null){       // si se marca la opción 4 antes de dar de alta inmuebles
            System.out.println("\nAún no hay datos de inmuebles en la base de datos."); 
            return;
        }
        
        if ((inmueble1.getRefCatastral() != null) && (inmueble2.getRefCatastral() != null)){
            
            System.out.println("\nALQUILER con más metros cuadrados:");       
            compararAlquiler (inmueble1, inmueble2);
        }
        else
            System.out.println("\nNo hay suficientes datos de inmuebles en alquiler.");  
        
        if ((inmueble3.getRefCatastral() != null) && (inmueble4.getRefCatastral() != null)){
            
        System.out.println("\nVENTA con más metros cuadrados:");
        compararAlquiler (inmueble3, inmueble4);        // reutilizo la función anterior, cambiando los parámetros
        }
        else
            System.out.println("\nNo hay suficientes datos de inmuebles en venta.");  
    }
       
    public static void compararAlquiler (CInmueble inmueble1, CInmueble inmueble2){
        
        float diferencia;
        
        if (inmueble1.getMCuadrados() > inmueble2.getMCuadrados()){
            
            diferencia = inmueble1.getMCuadrados() - inmueble2.getMCuadrados();
            
            System.out.println("\n" + inmueble1.getRefCatastral() + " --- " + inmueble1.getDireccion() + 
                ", con " + diferencia + " metros cuandrados más que el ubicado en " + inmueble2.getDireccion());           
        }    
        else
        {
            if (inmueble2.getMCuadrados() > inmueble1.getMCuadrados()){
                
                diferencia = inmueble2.getMCuadrados() - inmueble1.getMCuadrados();
                
                System.out.println("\n" + inmueble2.getRefCatastral() + " --- " + inmueble2.getDireccion() + 
                    ", con " + diferencia + "metros cuandrados más que el ubicado en " + inmueble1.getDireccion()); 
            }               
            else    
                System.out.println("\nLa superficie (metros cuadrados) de ambos inmuebles es la misma.");
        }
    }
    
    /*  
    TRATAMIENTO DE EXCEPCIÓN (tipo LANZAMIENTO). Se lanzará hacia el main, que es quien llama a pedirCadena (allí habrá que tratar el error).
    La excepción no se propaga hacia arriba porque no pertenece a RunTimeException).
    Para errores generales del sistema (de tipo IOException). Para errores que no se propagan automáticamente.
    */
    
}
