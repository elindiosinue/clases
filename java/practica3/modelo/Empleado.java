
package java3.modelo;

public abstract class Empleado {
    
    protected String nombre;
    protected float sueldo;
    //protected GregorianCalendar fechaAlta;
    protected static float sueldoMaximo = 3500;  // único para todos los empleados   
    
    public Empleado (String nombre)
    {
        this.nombre = nombre;
        //this.fechaAlta = new GregorianCalendar ();
        Empleado.sueldoMaximo = sueldoMaximo;
    }

    public Empleado (String nombre, float sueldo/*GregorianCalendar fechaAlta*/)
    {
        this.nombre = nombre;
        this.sueldo = sueldo;              
        //this.fechaAlta = fechaAlta;
        Empleado.sueldoMaximo = sueldoMaximo;
    }
    
    
    /*********** GETTERS & SETTERS **************/
    
    public String getNombre() {
        return nombre;
    }

    public float getSueldo() {
        return sueldo;
    }

    /*public GregorianCalendar getFechaAlta() {
        return fechaAlta;
    }*/

    public static float getSueldoMaximo() {
        return sueldoMaximo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    /*public void setFechaAlta(GregorianCalendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }  */ 

    public static void setSueldoMaximo(float sueldoMaximo) {
        Empleado.sueldoMaximo = sueldoMaximo;
    }
    
    ///////////////////////////////////////////////////////////////
    
    @Override
    public abstract String toString();
    
    public abstract int getDato();
}
