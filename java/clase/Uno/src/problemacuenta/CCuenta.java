
package problemacuenta;

public class CCuenta {
    private int codigo;
    private String titular;
    private char tipo;
    private float saldo;
    private static float interes;
    
    public CCuenta(int cod, char t){
        codigo = cod;
        tipo = t;
    }

    public void pedirTitular (){
        System.out.println("Introduzca el titular de la cuenta: ");
        titular = Leer.dato();
    }
 
    public void definirTipoInteres (){
        System.out.println ("El tipo de interes anterior es: " + interes);
        System.out.println ("Introduzca el nuevo valor para el tipo de interes: ");
        interes = Leer.datoFloat();
        System.out.println ("El nuevo tipo de interes es: " + interes);
    }

    
    public void mostrarDatosCuenta (){
        mostrarCodigo();
        mostrarTitular();
        mostrarSaldo();
        mostrarTipo();
        mostrarInteres();
    }
    
    private void mostrarCodigo()    // Pongo "private" todos los mostrar porque solo se van a usar dentro de esta clase.
    {
        System.out.println("\nCodigo de la cuenta: " + codigo);
    }
    
    private void mostrarTitular()
    {
        System.out.println("\nTitular de la cuenta: " + titular);
    }
    
    private void mostrarSaldo()
    {
        System.out.println("\nSaldo de la cuenta: " + saldo);
    }
    
    private void mostrarTipo()
    {
        System.out.println("\nTipo de la cuenta: " + tipo);
    }
    
    private void mostrarInteres()
    {
        System.out.println("\nInterés de la cuenta: " + interes);
    }
    
    /*  SETTERS & GETTERS  (de todos los atributos). */

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public static float getInteres() {
        return interes;
    }

    /*public void setInteres(float interes) {
        CCuenta.interes = interes;
    }*/

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    
    

    
    
    
    
    
    
}