<%-- 
    Document   : index
    Created on : 02-dic-2012, 22:16:19
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ej_Sesion1</title>
        <SCRIPT language="Javascript" type="text/JavaScript">
            function validar() {
                if (alfanumerico(document.ejemplo.usuario.value)==0) {
                    alert ("Introduzca su identificador.");
                    document.ejemplo.usuario.focus();
                    return;
                }
                if (alfanumerico(document.ejemplo.clave.value)==0) {
                    alert ("Introduzca la clave.");
                    document.ejemplo.clave.focus();
                    return;
                }
                document.ejemplo.submit();
            }
            
            function alfanumerico(txt) {
                // Devuelve 0 si la cadena esta vacia, 1 si es numerica 
                //o 2 si es alfanumerica
                var i;
                if (txt.length!=0) {
                    for (i=0;i<txt.length;i++){
                        if (txt.substr(i,1)<"0" || txt.substr(i,1)>"9") {
                            return 2;
                        }
                    }
                    return 1;
                }
                else
                    return 0;
            }
        </script>
            
    </head>
    <body>
        <% if (session.isNew()) {%>
        <%--Miramos si se han enviado cookies--%>
        <% Cookie[] cookies = request.getCookies();
            if (cookies == null) { // no hay cookie previa %>
        <h1>Rellene el siguiente formulario</h1>
        <p>Introduzca nombre de usuario y clave</p>
        <form action="controlador" name="ejemplo" method="post">
            Username: <input type="text" name="usuario"><br>
            Password: <input type="password" name="clave"><br><br>
            <input type="button" value="Entrar" onclick="validar()">
            <input type="reset" value="Vaciar">
        </form>
        <% } else {  // hay cookies
            String login = "";
            String anuncio = "";
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("MiTienda_user")) {
                    login = cookie.getValue();
                }
                if (cookie.getName().equals("ultimo_prod")) {
                    anuncio = cookie.getValue();
                }
            }%>
        <h1>Rellene el siguiente formulario</h1>
        <p>Introduzca nombre de usuario y clave</p>
        <form action="controlador" name="ejemplo" method="post">
            Username: <input type="text" name="usuario" value="<%=login%>"><br>
            Password: <input type="password" name="clave"><br><br>
            <input type="button" value="Entrar" onclick="validar()">
            <input type="reset" value="Vaciar">
        </form>
        <p style="color:red;text-decoration: blink;">
            Compre <%=anuncio%> </p>
            <% }%>
            <% } else {%>
            <% response.sendRedirect("controlador"); %>
            <% }%>
                
    </body>
</html>
    