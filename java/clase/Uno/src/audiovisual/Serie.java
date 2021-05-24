
package audiovisual;

public class Serie extends ContenidoAudiovisual{
    
    private int numTemporadas;
    private int capPorTemporada;       // falta array!! (MODIFICAR TODO DESPUÉS!!)
    
    public Serie (){      
        
    }
    
    public void pedirDatosContAudiovisual (){         // sobreescritura con la clase padre.
        super.pedirDatosContAudiovisual();
        this.setNumTemporadas(pedirNumTemporadas());
        
        System.out.println("Introduzca la cantidad de capítulos por temporada: ");
        
        for (int i = 0; i < getNumTemporadas(); i++)         
            this.setCapPorTemporada(pedirCapPorTemporada(i));
    }
    
    public static int pedirNumTemporadas (){
        
        System.out.println("Introduzca la cantidad de temporadas: ");
        return Leer.datoInt();
    }
    
    public static int pedirCapPorTemporada (int i){
       
        i = i+1;
        System.out.println("\tTemporada " + i + ":");
        return Leer.datoInt();     
    }
    
    public void visualizarContAudiovisual (){         // sobreescritura con la clase padre.
        System.out.println("\tHOLA serie");
        super.visualizarContAudiovisual();
        System.out.println(this.getNumTemporadas() + " temporadas:");
        
        for (int i = 0; i < getNumTemporadas(); i++)
                System.out.println("\t"+ i + this.getCapPorTemporada());
    }
    
/* GETTERS AND SETTERS */

    public int getNumTemporadas() {
        return numTemporadas;
    }

    public int getCapPorTemporada() {
        return capPorTemporada;
    }

    public void setNumTemporadas(int num_temp) {
        numTemporadas = num_temp;
    }

    public void setCapPorTemporada(int capPorTemp) {
        capPorTemporada = capPorTemp;
    }
}
