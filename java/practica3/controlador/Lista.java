
package java3.controlador;

public class Lista {
    
    private static Nodo inicial;
    private static Nodo ultimo;   //para insertar al final
    private static Nodo move;      //"actual"
   
    
    
    public static void iniciarAtributos ()      // como la clase es estática no hacemos new (), pero inicializamos los
    {                                           // atributos para asegurar que apuntan a null al principio.
        inicial = null;
        ultimo = null;
        move = null;     
    }
    
    public Nodo getFirst ()
    {
        move = inicial;
        return move;
    }
    
    public static void insertar (Object obj)           // creación e inserción de los nodos
    {
        Nodo nuevo = new Nodo (obj);
        
        if (inicial == null) {                  // Si el primer nodo está vacío
            inicial = nuevo;                    // lo rellenamos con el nuevo
            ultimo = nuevo;
            move = nuevo;                     // y ponemos a move apuntando también a la primera posición
        }
        else {
            Nodo ultimoAux = ultimo;
            nuevo.setAnterior(ultimoAux);
            ultimoAux.setSiguiente(nuevo);
            ultimo = nuevo;
        }      
    }
    
    public static Object devuelveObjeto (){       
        return move.getDato();      
    }

    public static Nodo getInicial() {
        return inicial;
    }
    
    public static void avanzar() {
        if (move.getSiguiente() != null)
            move = move.getSiguiente();
    }
    
    public static void retroceder() {
        if (move.getAnterior() != null)
            move = move.getAnterior();
    }
  
    public static Nodo getUltimo() {
        return ultimo;
    }
    
    public static void showList(){
        
        Nodo show = inicial;
        
        while(show != null){
            
            System.out.println(show.getDato());
            show = show.getSiguiente();
        }       
    }
    
    public static boolean esPrimero(){
        return move == inicial;             // Devolverá true si move está apuntando al primero
    }
    
    public static boolean esUltimo(){
        return move == ultimo;             // Devolverá true si move está apuntando al último
    }
}
