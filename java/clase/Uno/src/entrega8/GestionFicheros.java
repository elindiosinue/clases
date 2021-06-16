package entrega8;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionFicheros {

    public static void leerDatosFichero(Tienda tienda) {        

        try {
            File file = new File("persistente.dat");
            if(!file.exists()){
                ContenidoAudiovisual ca1 = new ContenidoAudiovisual(1, "Memorias de África", 1978, "drama", "Sydney Pollack", 127, 'p');
                tienda.contenido.add(ca1);
                ContenidoAudiovisual ca2 = new ContenidoAudiovisual(2, "Friends", 1994, "comedia", "Gary Halvorson", 1, 1, 's');
                tienda.contenido.add(ca2);
                ContenidoAudiovisual ca3 = new ContenidoAudiovisual(3, "El padrino", 1972, "crimen", "Francis Ford Coppola", 545, 'p');
                tienda.contenido.add(ca3);
                ContenidoAudiovisual.setUltimoId(4);
                //tienda.rellenarContenido();
            }else{
                try (FileInputStream foe = new FileInputStream(file)) {
                    ObjectInputStream entrada = new ObjectInputStream(foe);
                    tienda.contenido = (ArrayList<ContenidoAudiovisual>) entrada.readObject();    // si pongo ca1 tampoco imprime
                    Iterator<ContenidoAudiovisual> it = (Iterator<ContenidoAudiovisual>) tienda.contenido.iterator();
                    while (it.hasNext()) {
                        ContenidoAudiovisual ca = it.next();
                        if(ContenidoAudiovisual.getUltimoId() < ca.getId())
                            ContenidoAudiovisual.setUltimoId(ca.getId()+1);
                    }
                    entrada.close();
                }
            }
        }
        catch(IOException e){
            System.out.println("Se ha producido un error. No se ha encontrado ningún fichero binario.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    public static void escribirDatosFicheroBinario(Tienda tienda) {        

        try {
            File file = new File("binario.dat");
            try (FileOutputStream fos = new FileOutputStream(file)) {
                Iterator<ContenidoAudiovisual> it = tienda.contenido.iterator();
                String contenido = "";
                while (it.hasNext()) {
                    ContenidoAudiovisual ca = it.next();
                    contenido = ca.getNombre() + ";" + ca.getAnio() + ";" + ca.getGenero()+ "\n";
                }
                fos.write(contenido.getBytes());
            }
        }
        catch(IOException e){
            System.out.println("Se ha producido un error. No se ha encontrado ningún fichero binario.");
        }
     
    }

    public static void escribirDatosFicheroPersistente(Tienda tienda) {        

        try {
            File file = new File("persistente.dat");
            try (FileOutputStream fos = new FileOutputStream(file)) {
                try(ObjectOutputStream entrada = new ObjectOutputStream(fos)){
                    entrada.writeObject(tienda.contenido);
                }
            }
        }
        catch(IOException e){
            System.out.println("Se ha producido un error. No se ha encontrado ningún fichero binario.");
        }
     
    }
}

