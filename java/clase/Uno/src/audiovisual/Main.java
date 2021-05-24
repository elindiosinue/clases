package audiovisual;

public class Main {

    private static final int SALIR = 0;

    public static void main(String[] args) {

        Tienda tienda = new Tienda();

        int opcion, opcion2;

        do {
            mostrarMenuPrincipal();
            opcion = leerOpcion();

            if (opcion == 1) {
                mostrarMenuUsuario();
                opcion2 = leerOpcionUsuario();
                tratarOpcionUsuario(opcion2, tienda);
            } else {
                mostrarMenuAdministrador();
                opcion2 = leerOpcionAdministrador();
                tratarOpcionAdministrador(opcion2, tienda);
            }
        } while (opcion != SALIR);
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
        System.out.println("\t3. Listado de películas.");
        System.out.println("\t4. Listado de series.");
        System.out.println("\t5. Listado total.");
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
        } while ((opcion) < 0 || (opcion) > 5);     // controlamos la entrada de datos con do... while.

        return opcion;
    }

    public static void tratarOpcionUsuario(int opcion2, Tienda tienda) {
        switch (opcion2) {
            case 1:
                tienda.alquilarContenido();
                break;
            /*case 2: comprarContenido();
            break;
        case 3: devolverContenido ();*/
        }
    }

    public static void tratarOpcionAdministrador(int opcion2, Tienda tienda) {
        switch (opcion2) {
            case 1:
                tienda.altaContenido();
                break;
            /*case 2: bajaContenido();
            break;
        case 3: listadoPeliculas();
            break;
        case 4: listadoSeries();
            break;*/
            case 5:
                tienda.listadoCompleto();
        }
    }

}
