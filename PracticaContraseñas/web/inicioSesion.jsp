<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIAR SESIÓN</title>
    </head>
    <body>
        <h3>INICIAR SESIÓN</h3>
        <form action="GestionarInicioSesion" method="post">
            <table cellpadding="3" cellspacing="3" border="1">
                <tr>
                    <td align="center">Introduce nombre de usuario:</td>
                    <td align="center"><input type="text" name="usuario"></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="ACEPTAR">
        </form>
    </body>
</html>
