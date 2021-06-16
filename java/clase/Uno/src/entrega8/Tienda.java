package entrega8;

import java.util.*;

public class Tienda {

    static final int SALIR = 0;
    
    ArrayList<ContenidoAudiovisual> contenido = new ArrayList<ContenidoAudiovisual>();
    

    public void altaContenido(Tienda tienda) {

        int op = Main.elegirContenido();

        if (op == 1) {
            ContenidoAudiovisual objeto = new ContenidoAudiovisual('p');
            objeto.pedirDatos();          
            contenido.add(objeto);
        } else {
            ContenidoAudiovisual objeto = new ContenidoAudiovisual('s');
            objeto.pedirDatos();   
            contenido.add(objeto);
        }
        System.out.println("Se ha dado de alta el contenido en el videoclub.");
    }

    public void alquilarContenido() {

        if (comprobarVacioDisponible() == 0) {
            return;
        }

        listadoCompletoDisponible();

        System.out.print("Introduzca el código del contenido que desea alquilar (numérico):");

        int op = Leer.datoInt();

        realizarAlquiler(op);
    }
    
    public void realizarAlquiler(int op) {

        ContenidoAudiovisual aux;
        aux = contenido.get(op - 1);
        contenido.remove(op - 1);
        aux.setEstaAlquilado(true);     // el contenido ahora estará alquilado
        contenido.add(op - 1, aux);         // lo introducimos en el mismo sitio donde "estaba".
        String tipo = "";
        if("p".equals(aux.getTipo()))
            tipo = "Película";
        else if("s".equals(aux.getTipo()))
            tipo = "Serie";
        System.out.println("Se ha alquilado: " + "La " + tipo + " " + aux.getNombre() );
    }

    public void comprarContenido() {

        if (comprobarVacioDisponible() == 0) {
            return;
        }

        listadoCompletoDisponible();

        System.out.print("Introduzca el código del contenido que desea comprar (numérico):");

        int op = Leer.datoInt();

        borrarContenidoDisponible(op);

        System.out.println("Se ha comprado un elemento del videoclub.");
    }

    public void devolverContenido() {

        /*if (comprobarVacioAlquilado() == 0) {
            return;
        }*/

        listadoCompletoAlquilado();

        System.out.print("Introduzca el código del contenido que desea devolver (numérico):");

        int op = Leer.datoInt();

        realizarDevolucion (op);

        System.out.println("Se ha devuelto un elemento del videoclub.");
    }

    public void bajaContenido(Tienda tienda) {

        if (comprobarVacioDisponible() == 0) {
            return;
        }

        listadoCompletoDisponible();

        System.out.print("Introduzca el código del contenido que desea borrar (numérico):");

        int op = Leer.datoInt();

        borrarContenidoDisponible(op);

        System.out.println("Se ha eliminado un elemento del videoclub.");
    }

    /*public void modificacionContenido(Tienda tienda) {

        if (comprobarVacioDisponible() == 0) {
            return;
        }

        listadoCompletoDisponible();

        System.out.print("Introduzca el CÓDIGO del contenido que desea modificar (numérico):");

        int op = Leer.datoInt();

        modificarContenidoDisponible(op);

        System.out.println("Se ha modificado un elemento del videoclub.");
    }*/

    /*public void modificarContenidoDisponible(int op) {

        ContenidoAudiovisual aux = new ContenidoAudiovisual();
        aux = contenido.get(op -1);
        
        System.out.print("Introduzca el CAMPO (numérico) que desea modificar:");
        
        int opcion;
        
        do
        {            
            menuModificacion();
            opcion = Leer.datoInt();
            
        }while (opcion != SALIR);
    }*/

    /*public static void menuModificacion (){
        
        System.out.println("\t1. Nombre.");
        System.out.println("\t2. Año.");
        System.out.println("\t3. Género.");
        System.out.println("\t4. Director.");
        System.out.println("\t0. Salir.");
    }*/
    /*
    Si el usuario o el administrador pulsan alguna opción antes de que haya algún 
    contenido audiovisual dado de alta.
     */
    public int comprobarVacioDisponible() {

        if (contenido.isEmpty()) {
            System.out.println("--No hay datos en el videoclub--");
            return 0;
        } else {
            return 1;
        }
    }

    public void borrarContenidoDisponible(int op) {
        
        ContenidoAudiovisual aux;
        aux = contenido.get(op - 1);
        contenido.remove(op - 1);         // lo introducimos en el mismo sitio donde "estaba".
        System.out.println("Se ha borrado.");
    }

    public void realizarDevolucion(int op) {

        ContenidoAudiovisual aux;
        aux = contenido.get(op - 1);
        aux.setEstaAlquilado(false);     // el contenido ahora estará disponible
        contenido.set(op - 1, aux);         // lo introducimos en el mismo sitio donde "estaba".
        System.out.println("Se ha devuelto un elemento.");
    }

    public void listadoPeliculasDisponible() {

        System.out.println(" - Películas:");

        Iterator<ContenidoAudiovisual> it = contenido.iterator();

        while (it.hasNext()) {
            ContenidoAudiovisual x = it.next();
            
            if ((x.getTipo() == 'p') && (x.isEstaAlquilado() == false))
                x.visualizar();           
        }
    }

    public void listadoSeriesDisponible() {

        System.out.println("\n - Series:");

        Iterator<ContenidoAudiovisual> it = contenido.iterator();

        while (it.hasNext()) {
            ContenidoAudiovisual x = it.next();
            
            if ((x.getTipo() == 's') && (x.isEstaAlquilado() == false))
                x.visualizar();  
        }
    }
    

    public void listadoCompletoDisponible() {

        if (comprobarVacioDisponible() == 0) {
            return;
        }

        System.out.println("***CONTENIDO DISPONIBLE DEL VIDEOCLUB***\n");

        listadoPeliculasDisponible();
        listadoSeriesDisponible();
    }

    public void listadoPeliculasAlquilado() {

        System.out.println(" - Películas:");

        Iterator<ContenidoAudiovisual> it = contenido.iterator();

        while (it.hasNext()) {
            ContenidoAudiovisual x = it.next();
            
            if ((x.getTipo() == 'p') && (x.isEstaAlquilado() == true))
                x.visualizar(); 
            }
    }

    public void listadoSeriesAlquilado() {

        System.out.println("\n - Series:");

        Iterator<ContenidoAudiovisual> it = contenido.iterator();

        while (it.hasNext()) {
            ContenidoAudiovisual x = it.next();
            
            if ((x.getTipo() == 's') && (x.isEstaAlquilado() == true))
                x.visualizar(); 
        }
    }

    public void listadoCompletoAlquilado() {

        System.out.println("***CONTENIDO ALQUILADO DEL VIDEOCLUB***\n");

        listadoPeliculasAlquilado();
        listadoSeriesAlquilado();
    }
}
