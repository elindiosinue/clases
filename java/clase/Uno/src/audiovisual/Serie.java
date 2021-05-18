
package audiovisual;

public class Serie {
    
    private int num_temporadas;
    private String cap_por_temporada;       // falta array!!
    
    
    
/* GETTERS AND SETTERS */

    public int getNum_temporadas() {
        return num_temporadas;
    }

    public String getCap_por_temporada() {
        return cap_por_temporada;
    }

    public void setNum_temporadas(int num_temp) {
        num_temporadas = num_temp;
    }

    public void setCap_por_temporada(String cap_por_temp) {
        cap_por_temporada = cap_por_temp;
    }
}
