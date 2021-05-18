/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiovisual;

/**
 *
 * @author rafola
 */
public class Tienda {
    private static final int TAM = 20;
    private ContenidoAudiovisual [] contenidoAlquilado = new ContenidoAudiovisual [TAM];
    private ContenidoAudiovisual [] contenidoDisponible = new ContenidoAudiovisual [TAM];
    
    public void alquilarContenido(ContenidoAudiovisual audiovisual){
        ContenidoAudiovisual aux = null;
        int i = 0;
        do{
            if(contenidoDisponible[i].getNombre().equals(audiovisual.getNombre())){
                aux = contenidoDisponible[i];
                contenidoDisponible[i] = null;
                anadirContenidoAlquilado(aux);
            }
            i++;
        }while(i < contenidoDisponible.length && aux != null);
    }
    
    public void verContenidoDisponible(){
        for(int i = 0; i< contenidoDisponible.length; i++){
            if(contenidoDisponible[i] instanceof Serie){
                contenidoDisponible[i].getAnio();
            }else if(contenidoDisponible[i] instanceof Pelicula){
                
            }
        }
        
    }
    
    public void anadirContenidoDisponible(ContenidoAudiovisual ca){
        
    }
    
    public void anadirContenidoAlquilado(ContenidoAudiovisual ca){
        boolean anadido = false;
        int i = 0;
        do{
            if(contenidoDisponible[i] == null){
                contenidoDisponible[i] = ca;
            }
            i++;
        }while(i < contenidoDisponible.length && anadido);
        
    }
    
    
    
}
