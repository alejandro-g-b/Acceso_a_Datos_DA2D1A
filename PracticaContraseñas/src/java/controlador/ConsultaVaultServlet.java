package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.RegistroPassword;
import modelo.VaultDAO;

@WebServlet (name="ConsultaVaultServlet", urlPatterns={"/ConsultaVaultServlet"})
public class ConsultaVaultServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ServletContext sc = request.getServletContext();
        String ruta = sc.getRealPath("/WEB-INF/vault.txt");
        ruta.replace('\\','/');
        
        ArrayList<RegistroPassword> lista = VaultDAO.leerRegistro(ruta);
        
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("contadorClaves", lista.size()); 
      
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("/vaultHistorico.jsp").forward(request, response);
    }
}
