<%-- 
    Document   : Carro
    Created on : 09-dic-2012, 14:11:47
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap, java.util.Set, java.util.Iterator" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Carro</title>
    </head>
    <body>
        <h1>Mi Tienda On-Line</h1>
        <h2>Bienvenido Sr./Sra. <%= session.getAttribute("usuario")%> </h2>
        <br>
        <p>Su carro tiene los siguientes productos:</p>
        <table border="1px" style="text-align: center">
            <tr>
                <th style="width: 150px">Producto</th>
                <th style="width: 50px">Importe</th>
            </tr>
            <% HashMap <String,String> carro = (HashMap) session.getAttribute("carro");
                //Set <String> producto = carro.keySet();
                //Iterator <String> it = producto.iterator();
                //while (it.hasNext()) { 
                for (String key : carro.keySet()) {%>
            <tr>
                <td> <%= key %></td>
                <td> <%= carro.get(key) %> €</td>
                
            </tr>
            <% } %>
        </table>
        <form action="controlador" name="productos" method="post">
            <input type="hidden" name="pagina" value="carro">
            <input type="submit" name="accion" value="Finalizar Compra">
            <input type="submit" name="accion" value="Ver Catalogo">
        </form>
    </body>
</html>
