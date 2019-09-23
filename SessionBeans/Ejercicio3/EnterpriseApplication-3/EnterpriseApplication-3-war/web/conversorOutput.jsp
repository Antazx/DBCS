<%-- 
    Document   : conversorOutput
    Created on : 19-sep-2019, 23:01:28
    Author     : Anta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Conversor Kilometros - Millas</h1><br>
        
        <div>
            <form action="Controlador" method="post">
                <p>Kilometros: <input type="number" name="kilometros" min="0""></p>
                <p>Millas:     <input type="number" name="millas" min="0" value="${millas}"</p>
                <p><input type="submit"/></p>
            </form>
        </div>
    </body>
</html>
