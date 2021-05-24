package audiovisual;

public class Tienda {

    private static final int TAM = 4;       // constante que indicará el máximo de objetos

    private ContenidoAudiovisual[] contenidoAlquilado = new ContenidoAudiovisual[TAM];
    private ContenidoAudiovisual[] contenidoDisponible = new ContenidoAudiovisual[TAM];

    public int elegirContenido() {

        System.out.println("¿Desea dar de alta una película (1) o una serie (2)?");
        int opcion = Main.leerOpcion();

        return opcion;
    }

    public void alquilarContenido() {

        int op = elegirContenido();

        if (op == 1) {

        }
    }

    public void altaContenido() {
        if (contenidoDisponible.length == TAM - 1) {
            System.out.println("El videoclub está completo. No se puede introducir más contenido.");
            return;
        }

        int op = elegirContenido();

        if (op == 1) {
            Pelicula pelicula = new Pelicula();
            pelicula.pedirDatosContAudiovisual();
            introducirContenidoEnDisponible(pelicula);
        } else {
            Serie serie = new Serie();
            serie.pedirDatosContAudiovisual();
            introducirContenidoEnDisponible(serie);
        }
        System.out.println("Se ha dado de alta el contenido en el videoclub.");
    }

    public void introducirContenidoEnDisponible(ContenidoAudiovisual ca) {

        boolean listo = false;
        int i = 0;

        do {
            if (contenidoDisponible[i] == null) {
                contenidoDisponible[i] = ca;
                listo = true;
            }
            i++;
        } while ((i < contenidoDisponible.length) && (!listo));
    }

    public void listadoCompleto() {

        for (int i = 0; i < contenidoDisponible.length; i++) {
            if (contenidoDisponible[i] instanceof Pelicula) {
                System.out.println("\tHOLA tiendaB");
                ((Pelicula) contenidoDisponible[i]).visualizarContAudiovisual();
            }

            if (contenidoDisponible[i] instanceof Serie) {
                ((Serie) contenidoDisponible[i]).visualizarContAudiovisual();
            }
        }
    }

}
