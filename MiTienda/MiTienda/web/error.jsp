<%-- 
    Document   : error
    Created on : 18-dic-2012, 18:03:35
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Error en el acceso</h1>
        <% if (request.getParameter("error").equals("MiException")) { %>
        <p> <%= ((Exception) request.getAttribute("tipo")).toString() %> </p>
        <% } else { %>
        <h2>Ha habido un error interno del siguiente tipo:</h2>
        <p> <%= ((Exception) request.getAttribute("tipo")).toString() %> </p>
        <p>Por favor contacte con el administrador.</p>
        <%}%>
    </body>
</html>
