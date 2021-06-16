package entrega8;

import java.io.*;

public class Leer {

    public static String dato() {
        String sdato = "";
        try {
            // Definir un flujo de caracteres de entrada: flujoE
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader flujoE = new BufferedReader(isr);
            // Leer. La entrada finaliza al pulsar la tecla Entrar
            sdato = flujoE.readLine();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return sdato; // devolver el dato tecleado
    }

    public static short datoShort() {
        try {
            return Short.parseShort(dato());
        } catch (NumberFormatException e) {
            return Short.MIN_VALUE; // valor más pequeño
        }
    }

    public static int datoInt() {
        return Integer.parseInt(dato());
    }

    public static long datoLong() {
        try {
            return Long.parseLong(dato());
        } catch (NumberFormatException e) {
            return Long.MIN_VALUE; // valor más pequeño
        }
    }

    /**
     * Excepción tipo CAPTURA. Ante la posibilidad de que se introduzcan datos
     * erróneos (letras, por ejemplo), se trata con un bloque try / catch en la
     * propia función (local). Siempre que se pida un dato de tipo float
     * sabremos que está controlado (precio, impuesto...)
     *
     * @return
     */
    public static float datoFloat() {
        boolean correcto = false;
        float f = 0;

        do {
            try {
                f = Float.parseFloat(dato());
                correcto = true;
            } catch (NumberFormatException e) {
                System.out.println("\n***No se han introducido números.***\n Vuelva a intentarlo, por favor:");
            } catch (Exception e) {
                System.out.println("\n***Ha ocurrido un error.***\n Por favor, vuelva a intentarlo:");
            }
        } while (correcto == false);

        return f;
    }

    public static double datoDouble() {
        try {
            return Double.parseDouble(dato());
        } catch (NumberFormatException e) {
            return Double.NaN; // No es un número (valor double)
        }
    }
}
