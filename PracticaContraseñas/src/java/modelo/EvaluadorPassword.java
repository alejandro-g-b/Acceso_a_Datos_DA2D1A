package modelo;

public class EvaluadorPassword {
    
    public static int calcularPuntuacionContraseña(String contraseña){
        
        int puntuacion = 0;
        
        if(contraseña.length() >= 8 && contraseña.length() <= 10){
            puntuacion += 20;
        } else if (contraseña.length() > 10 && contraseña.length() <= 12){
            puntuacion += 30;
        } else if (contraseña.length() > 12){
            puntuacion += 40;
        }
        
        if(contraseña.matches(".*[A-Z].*")){
            puntuacion += 10;
        }
        
        if(contraseña.matches(".*[0-9].*")){
            puntuacion += 10;
        }
        
        if(contraseña.matches(".*[!@#$%&*¡!?¿].*")){
            puntuacion += 10;
        }
        
        if(contraseña.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{13,}$")){
            puntuacion += 30;
        }
        
        return puntuacion;
    } 
}
