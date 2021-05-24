
package audiovisual;

public class ContenidoAudiovisual {
    
    static int ultId = 1;
    
    private int id;         // se corresponderá con la celda del vector + 1
    private String nombre;
    private int anio;
    private String genero;
    private String director;
    
    
    public ContenidoAudiovisual ()   // pasar el id en el constructor???????
    {                                     
        id = ultId++;
    }
    
    public void pedirDatosContAudiovisual (){
        this.setNombre(pedirNombre());
        this.setAnio(pedirAnio());
        this.setGenero(pedirGenero());
        this.setDirector(pedirDirector());
    }
    
    public static String pedirNombre (){
        
        System.out.println("Introduzca el titulo: ");
        return Leer.dato();
    }
    
    public static int pedirAnio (){
        
        System.out.println("Introduzca el año de estreno: ");
        return Leer.datoInt();
    }
    
    public static String pedirGenero (){
        
        System.out.println("Introduzca el genero: ");
        return Leer.dato();
    }
    
    public static String pedirDirector (){
        
        System.out.println("Introduzca el director: ");
        return Leer.dato();
    }
    
    public void visualizarContAudiovisual (){
        System.out.println("\tHOLA contenidoAudiovisual");
        System.out.print(this.getId() + " - ");
        System.out.print(this.getNombre() + " - ");
        System.out.print(this.getAnio() + " - ");
        System.out.print(this.getGenero() +  " - ");
        System.out.print(this.getDirector() + " - ");
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

    public void setId (int identificador) {
        id = identificador;
    }
    
    public void setNombre(String nom) {
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
}


