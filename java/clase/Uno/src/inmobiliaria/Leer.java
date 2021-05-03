package inmobiliaria;

import java.io.*;

public class Leer
{
  public static String dato()
  {
    String sdato = "";
    try
    {
      // Definir un flujo de caracteres de entrada: flujoE
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader flujoE = new BufferedReader(isr);
      // Leer. La entrada finaliza al pulsar la tecla Entrar
      sdato = flujoE.readLine();
    }
    catch(IOException e)
    {
      System.err.println("Error: " + e.getMessage());
    }
    return sdato; // devolver el dato tecleado
  }
  
  public static short datoShort()
  {
    try
    {
      return Short.parseShort(dato());
    }
    catch(NumberFormatException e)
    {
      return Short.MIN_VALUE; // valor más pequeño
    }
  }
  
  public static int datoInt() throws NumberFormatException
  {
    //try
    //{
      return Integer.parseInt(dato());
    /*}
    catch(NumberFormatException e)
    {
      throw e; // valor más pequeño
    }
    */
  }
  
  public static long datoLong()
  {
    try
    {
      return Long.parseLong(dato());
    }
    catch(NumberFormatException e)
    {
      return Long.MIN_VALUE; // valor más pequeño
    }
  }
  
  public static float datoFloat()
  {
    boolean correcto = false;
    float aux = 0;
    
    do
    {
        try
        {
            aux = Float.parseFloat(dato());
            correcto = true;   
        }
        catch(NumberFormatException e)
        {
            System.out.println ("\n***No se han introducido números.***\nVuelva a intentarlo, por favor:");     
        }
        catch(Exception e)
        {
            System.out.println ("\n***No se han introducido números.***\nVuelva a intentarlo, por favor:");        
        }
    }while (!correcto);
    return aux;         // me obliga a poner este return;
  }

  
  public static double datoDouble()
  {
    try
    {
      return Double.parseDouble(dato());
    }
    catch(NumberFormatException e)
    {
      return Double.NaN; // No es un número (valor double)
    }
  }
}