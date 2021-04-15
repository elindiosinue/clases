package uno.librerias;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rafola
 */
public class PedirNombre {
    private int numero;
    private int numeroZapato;
    public static String NOMBRE = "dhfusgu";
    
    public int getNumero(){
       return numero; 
    }
    
    public void setNumero(int num){
        int aux = 0;
        if (aux < num){
            numero = aux;
        }else{
            numero = num;
        }
    }
    
    public int getNumeroZapato(){
       return numeroZapato; 
    }
    
    public void setNumeroZapato(int num){
        numeroZapato = num;
    }
}
