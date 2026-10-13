package modelo;

import java.util.Random;

public class GenerarContraseña {
    
    private static final int LONGITUD = 14;
    
    private static final String MINUSCULAS = "abcdefghijklmnñopqrstuvwxyz";
    private static final String MAYUSCULAS = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private static final String NUMEROS = "0123456789";
    private static final String CARACTERESESPECIALES = "!@#$%&*?";
    
    public static StringBuilder generarClave(){
        
        StringBuilder contraseña = new StringBuilder();
        String todos = MAYUSCULAS + MINUSCULAS + NUMEROS + CARACTERESESPECIALES;
        Random random = new Random();
        
        contraseña.append(String.valueOf(MINUSCULAS.charAt(random.nextInt(MINUSCULAS.length()))));
        contraseña.append(String.valueOf(MAYUSCULAS.charAt(random.nextInt(MAYUSCULAS.length()))));
        contraseña.append(String.valueOf(NUMEROS.charAt(random.nextInt(NUMEROS.length()))));
        contraseña.append(String.valueOf(CARACTERESESPECIALES.charAt(random.nextInt(CARACTERESESPECIALES.length()))));
        
        while(contraseña.length() < LONGITUD){
            contraseña.append(String.valueOf(todos.charAt(random.nextInt(todos.length()))));
        }
        return contraseña;
    }
}
