import java.io.*;

class Principal
{
  public static void main(String args[]) throws IOException
  {
    int dividendo, divisor;
    float cociente = 0, resto = 0;
    String cadDividendo, cadDivisor;

    InputStreamReader via = new InputStreamReader(System.in);
    BufferedReader teclado = new BufferedReader(via);

    System.out.println("\n\n\tInserta el dividendo de la division: ");
    cadDividendo = teclado.readLine();
    dividendo = Integer.parseInt(cadDividendo);
    
    int intentos = 0; 
    do {
        System.out.println("\n\n\tInserta el divisor de la division: ");
        cadDivisor = teclado.readLine();
        divisor = Integer.parseInt(cadDivisor);
        
        try{
            cociente = division(dividendo, divisor);
            resto = dividendo % divisor;
        }catch(ArithmeticException e){
            System.out.println("\n\n\tNo se puede dividir por cero!!!!!");
        }
        
        intentos++;
    }while(intentos < 6 && divisor == 0);

    System.out.println("\n\nEl resultado de dividir " + dividendo + " entre " + divisor + " da " + cociente + ", resto " + resto);
  }
  
  public static float division(int dividendo, int divisor) throws ArithmeticException {
      return dividendo / divisor;
  }


/*
  public static void main(String args[])
  {
    int dividendo, divisor, cociente;
    String cadDividendo, cadDivisor;

    InputStreamReader via = new InputStreamReader(System.in);
    BufferedReader teclado = new BufferedReader(via);

    try
    {
      System.out.println("\n\n\tInserta el dividendo de la division: ");
      cadDividendo = teclado.readLine();
      dividendo = Integer.parseInt(cadDividendo);

      System.out.println("\n\n\tInserta el divisor de la division: ");
      cadDivisor = teclado.readLine();
      divisor = Integer.parseInt(cadDivisor);

      cociente = dividendo / divisor;

      System.out.println("\n\nEl resultado de dividir " + dividendo + " entre " + divisor + " da " + cociente);
    }
    catch(NumberFormatException e)
    {
      System.out.println("\n\nHas insertado letras en vez de numeros, por lo que la division no se va a realizar.");
    }
    catch(ArithmeticException e)
    {
      System.out.println("\n\nHas insertado un 0 como divisor, por lo que la division no se va a realizar.");
    }
    catch(Exception e)
    {
      System.out.println("\n\nSe ha producido algun error, por lo que la division no se va a realizar.");
    }
  }
*/
} 
