package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class VaultDAO {
    
    public static void guardarRegistro(RegistroPassword registro, String ruta){
        ArrayList<RegistroPassword> lista = leerRegistro(ruta);
        lista.add(registro);
        try(FileOutputStream archivo = new FileOutputStream(ruta); ObjectOutputStream salida = new ObjectOutputStream(archivo)){
            
            salida.writeObject(lista);
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public static ArrayList<RegistroPassword> leerRegistro(String ruta){
        
        ArrayList<RegistroPassword> lista = new ArrayList();
        
        try(FileInputStream archivo = new FileInputStream(ruta); ObjectInputStream entrada = new ObjectInputStream(archivo)){
            
            lista = (ArrayList<RegistroPassword>) entrada.readObject();
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } 
        return lista;
    }
}
