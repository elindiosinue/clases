
package audiovisual;

public class Main {

    static final int LIMITE = 5;       // constante que indicará el máximo de opciones
    
    public static void main(String[] args) {
       
        
        int opcion;
        
        do{
            mostrarMenu ();
            opcion = leerOpcion ();
            tratarOpcion (opcion);
        }while (opcion != LIMITE);
    }
    
    public static void mostrarMenu (){
            System.out.println("MENU PRINCIPAL:");
            System.out.println("---------------");
            System.out.println("\t1. Alta de serie.");
            System.out.println("\t2. Alta de película.");
            System.out.println("\t3. Listado del contenido audiovisual.");
            System.out.println("\t4. Borrar contenido audiovisual.");
            System.out.println("\t5. Salir.");
    }
    
    
    /*
        Excepción tipo PROPAGACIÓN. Al meter una letra, desde Leer.datoInt () se 
        habrá propagado hasta aquí.
    */
    public static int leerOpcion ()
    {
        int opcion = 0;
        
        do
        {
            System.out.println("Introduzca opcion:");
            try
            {
                opcion = Leer.datoInt();
            }
            catch (NumberFormatException err)
            {
                System.out.println("\n***No se han introducido números.***\n Vuelva a intentarlo, por favor:");
            }
        }while ((opcion) != 1 && (opcion) != 2 && (opcion) != 3 && (opcion) != 4 && 
                    (opcion) != 5);     // controlamos la entrada de datos con do... while.
    
        return opcion;
    }

public static void tratarOpcion (int opcion) 
{
    switch (opcion)
    {
        /*case 1: altaSerie();
            break;
        case 2: altaPelicula();
            break;
        case 3: listadoContenidoAudiovisual ();
            break;
        case 4: borrarContenidoAudiovisual ();*/
    }
}

}