package modelo;

import java.io.Serializable;

public class RegistroPassword implements Serializable {
    
    private String clave;
    private int nivelFortaleza;
    private String fechaRegistro;
    
    public RegistroPassword(String clave, int nivelFortaleza, String fechaRegistro){
        this.clave = clave;
        this.nivelFortaleza = nivelFortaleza;
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getClave(){
        return this.clave;
    }
    
    public int getNivelFortaleza(){
        return this.nivelFortaleza;
    }
    
    public String getFechaRegistro(){
        return this.fechaRegistro;
    }
}
