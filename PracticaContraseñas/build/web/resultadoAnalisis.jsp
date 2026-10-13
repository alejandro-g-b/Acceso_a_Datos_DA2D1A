<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RESULTADO ANÁLISIS</title>
    </head>
    <body>
        
        <%
            String contraseña = (String) request.getAttribute("clave");
            int puntuacionClave = (int) request.getAttribute("puntuacionClave");
            String clave = (String) request.getAttribute("clave");
            
            String nivel, tiempoRotura;
            
            switch(puntuacionClave) {
                case 0:
                    nivel="Muy débil"; tiempoRotura="Instantáneo";
                    break;
                case 10:
                    nivel="Muy débil"; tiempoRotura="Unos segundos";
                    break;
                case 20:
                        nivel = "Débil"; tiempoRotura = "Unos minutos";
                        break;
                case 30:
                        nivel = "Débil"; tiempoRotura = "Unas horas";
                        break;
                case 40:
                        nivel = "Media"; tiempoRotura = "Unos días";
                        break;
                case 50:
                        nivel = "Media"; tiempoRotura = "Unas semanas";
                        break;
                case 60:
                        nivel = "Aceptable"; tiempoRotura = "Varios meses";
                        break;
                case 70:
                        nivel = "Fuerte"; tiempoRotura = "Varios años";
                        break;
                case 80:
                        nivel = "Fuerte"; tiempoRotura = "Varias décadas";
                        break;
                case 90:
                        nivel = "Muy fuerte"; tiempoRotura = "Siglos";
                        break;
                case 100:
                        nivel = "Excelente"; tiempoRotura = "Milenios";
                        break;
                default:
                        nivel = "Desconocido"; tiempoRotura = "No determinado";
                        break;
            }
        %>
        
        <h2>RESULTADOS ANÁLISIS</h2>
        <form action="GuardaVaultServlet" method="post">
            <input type="hidden" name="clave" value="<%=clave%>">
            <input type="hidden" name="puntuacionClave" value="<%=puntuacionClave%>">
            <table cellpadding="3" cellspacing="3" border="1">
                <tr>
                    <td align="center">Contraseña:</td>
                    <td align="center"><%=contraseña%></td>
                </tr>
                <tr>
                    <td align="center">Nivel de fortaleza:</td>
                    <td align="center"><%=puntuacionClave%></td>
                </tr>
                <tr>
                    <td align="center">Nivel:</td>
                    <td align="center"><%=nivel%></td>
                </tr>
                <tr>
                    <td align="center">Tiempo estimado de rotura:</td>
                    <td align="center"><%=tiempoRotura%></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Guardar en vault">
        </form>
        <form action="index.jsp" method="post">
            <br>
            <input type="submit" value="Volver">
        </form>
    </body>
</html>
