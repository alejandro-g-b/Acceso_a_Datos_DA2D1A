<%@page import="java.util.ArrayList"%>
<%@page import="modelo.RegistroPassword"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VAULT</title>
    </head>
    <body>
        <table cellpadding="3" cellspacing="3" border="1">
            <tr>
                <td align="center"><strong>Clave</strong></td>
                <td align="center"><strong>Nivel Fortaleza</strong>
                <td align="center"><strong>Fecha Registro</strong>
            </tr>
        <%@page import="controlador.ConsultaVaultServlet"%>
        <%
            ArrayList<RegistroPassword> lista = (ArrayList<RegistroPassword>) request.getAttribute("lista");
            HttpSession sesion = request.getSession();
            int contadorRegistros = (int) sesion.getAttribute("contadorClaves");
            
            for(int i=0; i<lista.size();i++){
                RegistroPassword registro = lista.get(i);
        %>
            <tr>
                <td align="center"><%=registro.getClave()%></td>
                <td align="center"><%=registro.getNivelFortaleza()%></td>
                <td align="center"><%=registro.getFechaRegistro()%></td>
            </tr>
        <%
            } 
        %>
        </table>
        <p>Contador: <%=contadorRegistros%></p>
        <form action="index.jsp" method="post">
            <input type="submit" value="Volver">
        </form>
    </body>
</html>
