package entrega8;

import java.io.IOException;

public class Main {

    static final int SALIR = 0;

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Tienda tienda = new Tienda();

        GestionFicheros.leerDatosFichero(tienda); // esto está bien??
        
        int opcion = 0, opcion2;

        do {
            if(opcion != 1 && opcion != 2){
                mostrarMenuPrincipal();
                opcion = leerOpcion();
            }

            if (opcion == 1) {
                mostrarMenuUsuario();
                opcion2 = leerOpcionUsuario();
                tratarOpcionUsuario(opcion2, tienda);
            } else {
                mostrarMenuAdministrador();
                opcion2 = leerOpcionAdministrador();
                tratarOpcionAdministrador(opcion2, tienda);
            }
        } while (opcion2 != SALIR);
        
        GestionFicheros.escribirDatosFicheroPersistente(tienda);
    }

    public static void mostrarMenuPrincipal() {
        
        System.out.println("VIDEOCLUB:");
        System.out.println("----------");
        System.out.println("¿Eres USUARIO (pulsa 1) o ADMINISTRADOR (pulsa 2)?");
    }

    public static void mostrarMenuUsuario() {

        System.out.println("MENÚ USUARIO:");
        System.out.println("-------------");
        System.out.println("\t1. Alquilar contenido.");
        System.out.println("\t2. Comprar contenido.");
        System.out.println("\t3. Devolver contenido.");
        System.out.println("\t0. Salir.");
    }

    public static void mostrarMenuAdministrador() {
        System.out.println("MENÚ ADMINISTRADOR:");
        System.out.println("-------------------");
        System.out.println("\t1. Alta de contenido.");
        System.out.println("\t2. Baja de contenido.");
        //System.out.println("\t3. Modificación de contenido.");
        System.out.println("\t4. Listado de películas.");
        System.out.println("\t5. Listado de series.");
        System.out.println("\t6. Listado total.");
        System.out.println("\t0. Salir.");
    }

    /*
        Excepción tipo PROPAGACIÓN. Al meter una letra, desde Leer.datoInt () se 
        habrá propagado hasta aquí.
     */
    public static int leerOpcion() {
        int opcion = 0;

        do {
            System.out.println("Introduzca opcion:");
            try {
                opcion = Leer.datoInt();
            } catch (NumberFormatException err) {
                System.out.println("\n***No se han introducido números.***\n Vuelva a intentarlo, por favor:");
            }
        } while ((opcion) != 1 && (opcion) != 2);     // controlamos la entrada de datos con do... while.

        return opcion;
    }

    /*
        Excepción tipo PROPAGACIÓN. Al meter una letra, desde Leer.datoInt () se 
        habrá propagado hasta aquí.
     */
    public static int leerOpcionUsuario() {
        int opcion = 0;

        do {
            System.out.println("Introduzca opcion:");
            try {
                opcion = Leer.datoInt();
            } catch (NumberFormatException err) {
                System.out.println("\n***No se han introducido números.***\n Vuelva a intentarlo, por favor:");
            }
        } while ((opcion) < 0 || (opcion) > 3);     // controlamos la entrada de datos con do... while.

        return opcion;
    }

    public static int leerOpcionAdministrador() {
        int opcion = 0;

        do {
            System.out.println("Introduzca opcion:");
            try {
                opcion = Leer.datoInt();
            } catch (NumberFormatException err) {
                System.out.println("\n***No se han introducido números.***\n Vuelva a intentarlo, por favor:");
            }
        } while ((opcion) < 0 || (opcion) > 6);     // controlamos la entrada de datos con do... while.

        return opcion;
    }

    public static void tratarOpcionUsuario(int opcion2, Tienda tienda) {
        switch (opcion2) {
            case 1:
                tienda.alquilarContenido();
                break;
            case 2:
                tienda.comprarContenido();
                break;
            case 3:
                tienda.devolverContenido();
        }
    }

    public static void tratarOpcionAdministrador(int opcion2, Tienda tienda) {
        switch (opcion2) {
            case 1:
                tienda.altaContenido(tienda);
                break;
            case 2:
                tienda.bajaContenido(tienda);
                break;
            /*case 3:
                tienda.modificacionContenido(tienda);       // opción añadida para esta práctica
                break;*/
            case 4:
                tienda.listadoPeliculasDisponible();
                break;
            case 5:
                tienda.listadoSeriesDisponible();
                break;
            case 6:
                tienda.listadoCompletoDisponible();
        }
    }

    public static int elegirContenido() {

        System.out.println("¿Desea dar de alta una película (1) o una serie (2)?");
        int opcion = leerOpcion();

        return opcion;
    }
}
