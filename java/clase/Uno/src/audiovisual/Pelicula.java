
package audiovisual;

public class Pelicula extends ContenidoAudiovisual{
    
    private int duracion;       // en minutos
     
    public Pelicula (){        
         
    }
    
    public void pedirDatosContAudiovisual (){         // sobreescritura con la clase padre.
        super.pedirDatosContAudiovisual();
        this.setDuracion(pedirDuracion());
    }
    
    public static int pedirDuracion (){
        System.out.println("Introduzca la duración: ");
        return Leer.datoInt();
    }
    
    public void visualizarContAudiovisual (){         // sobreescritura con la clase padre.
        System.out.println("\tHOLA pelicula");
        super.visualizarContAudiovisual();
        System.out.print(this.getDuracion() + " minutos - ");
    }
    
/* GETTERS AND SETTERS */

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int durac) {
        duracion = durac;
    }
}
