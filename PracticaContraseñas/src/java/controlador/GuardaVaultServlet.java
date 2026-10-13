package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.RegistroPassword;
import modelo.VaultDAO;

@WebServlet (name="GuardaVaultServlet", urlPatterns={"/GuardaVaultServlet"})
public class GuardaVaultServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String clave = request.getParameter("clave");
        int nivelFortaleza = Integer.parseInt(request.getParameter("puntuacionClave"));
        String fechaRegistro = String.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        RegistroPassword registro = new RegistroPassword(clave,nivelFortaleza,fechaRegistro);
        
        ServletContext sc = request.getServletContext();
        String ruta = sc.getRealPath("/WEB-INF/vault.txt");
        ruta.replace('\\', '/');
        
        VaultDAO.guardarRegistro(registro,ruta);
        
        int contadorClaves = VaultDAO.leerRegistro(ruta).size();
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("contadorClaves", contadorClaves);
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
    }
}
