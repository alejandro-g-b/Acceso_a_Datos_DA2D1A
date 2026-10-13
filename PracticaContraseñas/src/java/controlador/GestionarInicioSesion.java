package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet (name="GestionarInicioSesion", urlPatterns="/GestionarInicioSesion")
public class GestionarInicioSesion extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("usuario", usuario);
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
