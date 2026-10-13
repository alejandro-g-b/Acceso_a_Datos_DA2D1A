<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GESTOR CONTRASEÑAS</title>
    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            String fechaUltimaAuditoria = "ninguna";
            if(cookies != null){
                for(int i=0; i<cookies.length;i++){
                    if(cookies[i].getName().equals("fechaActual")){
                        fechaUltimaAuditoria = cookies[i].getValue();
                        break;
                    }
                }
            }
            
            String usuario="";
            HttpSession sesion = request.getSession();
            if(sesion != null && sesion.getAttribute("usuario") != null){
                usuario = (String) sesion.getAttribute("usuario");
            }
        %>
        <form action="EvaluaPasswordServlet" method="post">
            <h2>GESTOR CONTRASEÑAS</h2>
            <h3>Bienvenido <%=usuario%></h3>
            <table cellspacing="3" cellpadding="3" border="1" >
                <tr>
                    <td align="center"><input type="text" name="claveCandidata" placeholder="Introduce contraseña"></td>
                    <td align="center"><input type="submit" name="boton" value="EVALUAR"></td>
                </tr>
                <tr>
                    <td align="center">Generar contraseña:</td>
                    <td align="center"><input type="submit" name="boton" value="GENERAR"></td>
                </tr>
            </table>
        </form>
        <p>Última contraseña analizada: <%=fechaUltimaAuditoria%></p>
        <form action="ConsultaVaultServlet" method="post">
            <input type="submit" value="Consultar vault">
        </form>
        <form action="inicioSesion.jsp" method="post">
            <br>
            <input type="submit" value="Iniciar sesión">
        </form>
    </body>
</html>
