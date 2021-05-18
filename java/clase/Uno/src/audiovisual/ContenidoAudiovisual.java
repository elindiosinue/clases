
package audiovisual;

import java.util.Date;

public abstract class ContenidoAudiovisual {
    
    private String nombre;
    private int anio;
    private String genero;
    private String director;
    private String plataforma;      // falta array!!
    private Date fechaEstreno;
    
    public abstract String calcularTimpoVisualizacion();
    
    
/* GETTERS AND SETTERS */
    
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

    public String getPlataforma() {
        return plataforma;
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

    public void setPlataforma(String plataf) {
        plataforma = plataf;
    }
}


