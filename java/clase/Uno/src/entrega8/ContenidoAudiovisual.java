package entrega8;

import java.io.Serializable;

public class ContenidoAudiovisual implements IContenidoAudiovisual, Serializable {

    static final int MAX = 30;       // constante que indicará el máximo de capítulos que puede tener cada temporada
    private static int ultimoId = 1;
    
    private int id = ultimoId;
    private String nombre;
    private int anio;
    private String genero;
    private String director;
    private int duracion;       // en minutos
    private int numTemporadas;
    Integer capPorTemporada[] = new Integer[30];
    private char tipo;
    private boolean estaAlquilado = false;      // por defecto será false. Cuando se alquile, cambiará a true.
    

    public ContenidoAudiovisual() {
    
    }
    
    public ContenidoAudiovisual(char t) {
        id = ultimoId++;
        tipo = t;
    }

    // constructor para cargar datos de películas directamente del fichero binario
    public ContenidoAudiovisual(int cod, String n, int aaaa, String gen, String dir, int dur, char t) {
        tipo = t;
        id = cod;
        nombre = n;
        anio = aaaa;
        genero = gen;
        director = dir;
        duracion = dur;
        if(ultimoId < cod)
            ultimoId = cod;
    }
    
    // constructor para cargar datos de series directamente del fichero binario
    public ContenidoAudiovisual(int cod, String n, int aaaa, String gen, String dir, int temp, int caps, char t) {
        tipo = t;
        id = cod;
        nombre = n;
        anio = aaaa;
        genero = gen;
        director = dir;
        numTemporadas = temp;
        Integer[] arr = new Integer[30];
        for(int i = 0; i < temp; i++)
            arr[i] = caps;
        capPorTemporada = arr;
        if(ultimoId < cod)
            ultimoId = cod;
    }
    
    public void confirmarAlquiler() {
        System.out.print("Se ha alquilado un elemento.");
    }

    public void pedirDatos() {

        setNombre(pedirNombre());
        setAnio(pedirAnio());
        setGenero(pedirGenero());
        setDirector(pedirDirector());
        
        if (getTipo() == 'p') {
            setDuracion(pedirDuracion());
        } else {
            if (getTipo() == 's') {
                setNumTemporadas(pedirNumTemporadas());

                System.out.println("Introduzca la cantidad de capítulos por temporada: ");

                for (int i = 0; i < getNumTemporadas(); i++) {

                    int x = pedirCapPorTemporada(i);
                    setCapPorTemporada(x, i);
                }
            }
        }   
    }

    public String pedirNombre() {

        System.out.println("Introduzca el titulo [" + getNombre() + "]:");
        return Leer.dato();
    }

    public int pedirAnio() {

        System.out.println("Introduzca el año de estreno: ");
        return Leer.datoInt();
    }

    public String pedirGenero() {

        System.out.println("Introduzca el genero: ");
        return Leer.dato();
    }

    public String pedirDirector() {

        System.out.println("Introduzca el director: ");
        return Leer.dato();
    }
    
    public int pedirDuracion() {

        System.out.println("Introduzca la duración: ");
        return Leer.datoInt();
    }
    
    public int pedirNumTemporadas() {

        System.out.println("Introduzca la cantidad de temporadas: ");
        return Leer.datoInt();
    }
    
    public int pedirCapPorTemporada(int i) {

        i = i + 1;
        System.out.println("\tTemporada " + i + ":");
        return Leer.datoInt();
    }

    public void visualizar() {

        System.out.print(getId() + " - ");
        System.out.print(getNombre() + " - ");
        System.out.print(getAnio() + " - ");
        System.out.print(getGenero() + " - ");
        System.out.print(getDirector() + " - ");
        
        if (getTipo() == 'p')
            System.out.println(getDuracion() + " minutos.");
        
        if (getTipo() == 's')
        System.out.println(getNumTemporadas() + " temporadas:");

        int y = 1;

        for (int i = 0; i < getNumTemporadas(); i++, y++) {
            System.out.println("\tTemporada" + y + ":" + getCapPorTemporada(i));
        }
    }

    /* GETTERS AND SETTERS */
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public String getGenero() {
        return genero;
    }

    public String getDirector() {
        return director;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public int getNumTemporadas() {
        return numTemporadas;
    }
    
    public int getCapPorTemporada(int i) {
        return capPorTemporada[i];
    }

    public char getTipo() {
        return tipo;
    }

    public boolean isEstaAlquilado() {
        return estaAlquilado;
    }

    public void setId(int i) {
        id = i++;
    }

    public void setNombre(String nom) {
        if(!"".equals(nom))
            nombre = nom;
    }

    public void setAnio(int aaaa) {
        anio = aaaa;
    }

    public void setGenero(String gen) {
        genero = gen;
    }

    public void setDirector(String dir) {
        director = dir;
    }
    
    public void setDuracion(int durac) {
        duracion = durac;
    }
    
    public void setNumTemporadas(int num_temp) {
        numTemporadas = num_temp;
    }
    
    public void setCapPorTemporada(int capPorTemp, int i) {
        capPorTemporada[i] = capPorTemp;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setEstaAlquilado(boolean estaAlquilado) {
        this.estaAlquilado = estaAlquilado;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        ContenidoAudiovisual.ultimoId = ultimoId;
    }
}
