
package java3.modelo;

import java.util.GregorianCalendar;

public class Agente extends Empleado{
    
    private int inmuebles;      // cantidad de inmuebles activos (para venta/alquiler). Atributo "Dato".
                                // atributo del mismo tipo que horasOficina de "Administrativo".
    private float incentivoPorVenta;
    
    public Agente(String nombre, float sueldo/*, GregorianCalendar fechaAlta*/) {
        super(nombre);
        this.inmuebles = inmuebles;
        this.incentivoPorVenta = incentivoPorVenta;
    }
    
    public Agente(String nombre, float sueldo, /*GregorianCalendar fechaAlta, */ int inmuebles, float incentivoPorVenta) {
        super(nombre, sueldo/*, fechaAlta*/);
        this.inmuebles = inmuebles;
        this.incentivoPorVenta = incentivoPorVenta;
    }
    
    
    /*********** GETTERS & SETTERS **************/
    
    public float getIncentivoPorVenta() {
        return incentivoPorVenta;
    }

    public void setInmuebles(int inmuebles) {
        this.inmuebles = inmuebles;
    }

    public int getInmuebles() {
        return inmuebles;
    }

    public void setIncentivoPorVenta(float incentivoPorVenta) {
        this.incentivoPorVenta = incentivoPorVenta;
    }

    ///////////////////////////////////////////////////////////////////
    
    @Override
    public int getDato() {      
        return inmuebles;   
    }

    @Override
    public String toString()
    {
        return    this.getNombre() + " \n "
                + this.getSueldo() + " \n "
                //+ this.getFechaAlta()) + " \n "               
                + this.getSueldoMaximo()+ " \n "
                + this.inmuebles + " \n "
                + this.incentivoPorVenta;
    }    
}
