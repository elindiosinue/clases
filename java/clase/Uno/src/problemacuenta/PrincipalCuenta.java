// 1. El tipo de interés toene que ser el mismo para las dos cuentas???

package problemacuenta;

public class PrincipalCuenta {

    public static void main(String[] args) {
       
        CCuenta cc = new CCuenta (1, 'C');
        CCuenta ca = new CCuenta (2, 'A');
        
        cc.pedirTitular();
        ca.pedirTitular();
        
        int opcion;
        
        do{
            mostrarMenu ();
            opcion = leerOpcion ();
            tratarOpcion (opcion, cc, ca);
        }while (opcion != 7);
        
        
    }
    
    public static void mostrarMenu (){
            System.out.println("MENU:");
            System.out.println("\tDefinir el tipo de interés de la entidad bancaria.");
            System.out.println("\tMostrar los datos de una cuenta.");
            System.out.println("\tRealizar un ingreso.");
            System.out.println("\tRealizar un reintegro.");
            System.out.println("\tActualizar el saldo.");
            System.out.println("\tComparar cuentas.");
            System.out.println("\t7.- Salir");
    }
    
    public static int leerOpcion ()
    {
        int opcion;
        do
        {
            System.out.println("Introduzca opcion:");
            opcion = Leer.datoInt();
            }while ((opcion) != 1 && (opcion) != 2 && (opcion) != 3 && (opcion) != 4 && 
                    (opcion) != 5 && (opcion) != 6 && (opcion) != 7);
        
        return opcion;
    }
    
    public static void tratarOpcion (int opcion, CCuenta cc, CCuenta ca)
    {
        int cod = pedirCodigo();    // devuelve el código que introduce el usuario. Sería mejor hacer esta función en CCuenta?? Me ha parecido mejor aquí.
        
        switch (opcion)
	{
            case 1: cc.definirTipoInteres();
                break;
            case 2: 
                    if(cod == cc.getCodigo())   // si cod coincide con el código de ese objeto
                        cc.mostrarDatosCuenta();
                    else
                        ca.mostrarDatosCuenta();
		break;
            case 3: //realizar_ingreso ();
		break;
            case 4: 
		break;
            case 5: 
                break;
            case 6: 
        }
    }
    
    public static int pedirCodigo()
    {
        int cod;
        
        System.out.println("\nIntroduzca el codigo de la cuenta: ");
        
        return cod = Leer.datoInt();
    }
}
        
       
   
