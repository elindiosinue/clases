
package inmobiliaria;


public class CInmueble {
   
    private String refCatastral;
    private static char modalidad;          // Venta o alquiler
    private String direccion;
    private int numHabitaciones;
    private float mCuadrados;
    private float precio;
    private static float impuesto;     // ITP (para inmuebles en venta)
    private static int contador = 1;           // llevará la cuenta de los inmuebles
    
    public CInmueble(char mod){
       modalidad = mod;
    }

    public static float pedirImpuesto (){
        
        System.out.println("Introduzca el impuesto (común para todos los inmuebles en venta): ");
        return Leer.datoFloat();
    }
    
    public static String pedirRefCatastral (){
        
        System.out.println("Introduzca la referencia catastral: ");
        return Leer.dato();
    }
    
    public String pedirDireccion (){
        
        System.out.println("Introduzca la dirección: ");
        return Leer.dato();
    }
    
    public int pedirNumHabitaciones (){
     
        boolean correcto = false;
        int num = 0;
        
        
        do
        {
            try{
                System.out.println("Número de habitaciones: ");
                num = Leer.datoInt();
                correcto = true;
            }
            catch (NumberFormatException e){
                System.out.println("que nooo.");
            }           
        }while (correcto == false);
              
        return num;
    }
    
    public float pedirMetrosC (){
        
        System.out.println("Metros cuatrados útiles: ");
        return Leer.datoFloat();
    }
    
    public static float pedirPrecio (char mod){
        
        if (mod == 'v')
            System.out.println("Precio venta: ");
        else
            System.out.println("Precio alquiler: ");
        return Leer.datoFloat();
        
    }
    
    public void visualizarDatos (String cad){
        System.out.println("\nDATOS DEL INMUEBLE: ");
        System.out.println("---------------------");
        System.out.println("\n\tReferencia catastral: " + cad);
        
        System.out.print("\n\tModalidad: ");
        
        if (getModalidad() == 'a')
            System.out.println("venta");
        else
            System.out.println("alquiler");
        
        System.out.println("\n\tDirección: " + getDireccion());      
        System.out.println("\n\tNúmero de habitaciones: " + getNumHabitaciones());
        System.out.println("\n\tMetros cuadrados útiles: " + getMCuadrados());
        System.out.println("\n\tPrecio: " + getPrecio());
    }
    
    public void subirPrecio (float cant){
        
        if (getModalidad() == 'a')
            setPrecio(getPrecio() + cant);
        else
           setPrecio ((float) ((float)(getPrecio() + cant) + (getImpuesto() * 0.10)));
        
        System.out.println("\n\tPrecio actualizado: " + getPrecio());
    }
    
    public void bajarPrecio (float cant){
        
        if (getModalidad() == 'a')
            setPrecio(getPrecio() - cant);
        else
            setPrecio ((float) ((float)(getPrecio() - cant) + (getImpuesto() * 0.10)));
        
        System.out.println("\n\tPrecio actualizado: " + getPrecio());
    }
   
    /*  SETTERS & GETTERS  (de todos los atributos). */

    public static float getImpuesto() {
        return impuesto;
    }
    
    public static int getContador() {
        return contador;
    } 
    
    public static char getModalidad() {
        return modalidad;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public String getRefCatastral() {
        return refCatastral;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public float getMCuadrados() {
        return mCuadrados;
    }

    public float getPrecio() {
        return precio;
    }
    
    public void setNumHabitaciones(int numHabit) {
        numHabitaciones = numHabit;
    }

    public void setMCuadrados(float mCuadr) {
        mCuadrados = mCuadr;
    }

    public void setDireccion(String direcc) {
        direccion = direcc;
    }

    public void setPrecio(float prec) {
        precio = prec;
    }

    public void setRefCatastral(String refCat) {
        refCatastral = refCat;
    }
    
    public static void setImpuesto(float imp) {      
            impuesto = imp;
    }
    
    public static void setModalidad(char modalidad) {
        CInmueble.modalidad = modalidad;
    }

    public static void setContador(int cont) {
        contador = cont;
    }
}
