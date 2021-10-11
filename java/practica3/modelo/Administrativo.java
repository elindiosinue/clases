
package java3.modelo;

import java.util.GregorianCalendar;
import jdk.nashorn.internal.parser.DateParser;


public class Administrativo extends Empleado {

    private int horasOficina;       // atributo del mismo tipo que inmuebles de "Agente". Atributo "Dato".
    private String tipoContrato;
    
    public Administrativo (String nombre, float sueldo/*String fechaAlta*/) {
        super(nombre);
        // Como la fecha la recibimos en forma de cadena, la parseamos.
        //this.setFechaAlta(DateParser.parseDate(fechaAlta));
        this.horasOficina = horasOficina;
        this.tipoContrato = tipoContrato;
    }
    
    public Administrativo (String nombre, float sueldo, /*String fechaAlta, */ int horasOficina, String tipoContrato) {
        super(nombre, sueldo/*fechaAlta*/);
        //DateParser.parseDate(fechaAlta);
        this.horasOficina = horasOficina;
        this.tipoContrato = tipoContrato;
    }

    /*********** GETTERS & SETTERS **************/
    
    public int getHorasOficina() {    
        return horasOficina;
    }
    
    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setHorasOficina(int horasOficina) {
        this.horasOficina = horasOficina;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    //////////////////////////////////////////////////////////////////
    
    @Override
    public int getDato() {
        return horasOficina;
    }
        
    @Override
    public String toString()
    {
        return    this.getNombre() + " \n "
                + this.getSueldo() + " \n "
                //+ this.getFechaAlta()) + " \n "               
                + this.getSueldoMaximo()+ " \n "
                + this.horasOficina + " \n "
                + this.tipoContrato;
    }
}
