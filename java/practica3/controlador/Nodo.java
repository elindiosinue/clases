
package java3.controlador;

public class Nodo {
    
    // Atributos
    private Object dato;
    private Nodo siguiente;
    private Nodo anterior;

    // Constructor
    public Nodo(Object nuevoObj) 
    {
        dato = nuevoObj;
        anterior = null;
        siguiente = null;
    }
  
    
    /*********** GETTERS & SETTERS **************/
    
    public Object getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
