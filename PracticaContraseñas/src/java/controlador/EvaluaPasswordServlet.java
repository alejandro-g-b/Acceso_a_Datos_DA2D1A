package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EvaluadorPassword;
import modelo.GenerarContraseña;

@WebServlet (name="EvaluaPasswordServlet", urlPatterns={"/EvaluaPasswordServlet"})
public class EvaluaPasswordServlet extends HttpServlet{
    
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String boton = request.getParameter("boton");
        
        if("GENERAR".equals(boton)){
            
            StringBuilder clave = GenerarContraseña.generarClave();
            String contraseña = clave.toString();
            int puntuacionClave = EvaluadorPassword.calcularPuntuacionContraseña(contraseña);
            
            request.setAttribute("clave", contraseña);
            request.setAttribute("puntuacionClave", puntuacionClave);
            request.getRequestDispatcher("/resultadoAnalisis.jsp").forward(request, response);
            
        } else {
        
            String contraseña = request.getParameter("claveCandidata");
        
            if(!contraseña.isEmpty()) {
            
                int puntuacionClave = EvaluadorPassword.calcularPuntuacionContraseña(contraseña);
        
               request.setAttribute("clave", contraseña);
               request.setAttribute("puntuacionClave", puntuacionClave);
               request.getRequestDispatcher("/resultadoAnalisis.jsp").forward(request, response);
            } else {
               response.setContentType("text/html;charset=UTF-8");
               try(PrintWriter error = response.getWriter()) {
                    error.println("<!DOCTYPE html");
                    error.println("<html>");
                    error.println("<head>");
                    error.println("<title>ERROR</title>");
                    error.println("</head>");
                    error.println("<body>");
                    error.println("<h3>ERROR: Se debe introducir una contraseña</h3>");
                    error.println("</body>");
                    error.println("</html>");
               }
            }
        }
        
        Cookie ultimaAuditoria = new Cookie("fechaActual",String.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        ultimaAuditoria.setMaxAge(60*60*24);
        response.addCookie(ultimaAuditoria);
    }
}
