<%-- 
    Document   : Comprar
    Created on : 07-dic-2012, 22:53:57
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.ProductDTO, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Catalogo</title>
    </head>
    <body>
        <h1>Mi Tienda On-Line</h1>
        <h2>Bienvenido Sr./Sra. <%= session.getAttribute("usuario")%> </h2>
        <p>Es el visitante <%= session.getAttribute("accesos") %> de nuestra tienda</p>
        <br>
        <p>Escoja producto y cantidad:</p>
        
        <table style="text-align: left">
            <tr>
                <th>Referencia</th>
                <th>Producto</th>
                <th>Precio</th>
                <th>Cantidad</th>
            </tr>
            <% ArrayList <ProductDTO> catalogo = (ArrayList <ProductDTO>) 
                    session.getAttribute("catalogo");
                   for (ProductDTO item : catalogo) {%>
            <tr>
                <form action="controlador" name="productos" method="post">
                <td style="width:3cm">
                    <%= item.getItem_id() %>
                </td>
                <td>
                    <%= item.getProd_desc() %>
                    <input type="hidden" name="Producto" value="<%= item.getProd_desc() %>">
                </td>
                <td style="width: 2cm">
                    <%= item.getPrice() %> €
                    <input type="hidden" name="Precio" value="<%= item.getPrice() %>">
                </td>
                <td style="text-align: center">
                    <!--<select name="<%--<%=item.getId()%>--%>">-->
                    <select name="Cantidad">
                        <option value="0">0
                        <option value="1">1
                        <option value="2">2
                        <option value="3">3
               </td>
               </tr>
                        <tr>
                            <td colspan="4">
            <input type="hidden" name="pagina" value="catalogo">
            <input type="submit" name="accion" value="Agregar a Carro">
            <input type="reset" value="Vaciar">
                            </td>
            </tr>
         </form>
            <% } %>
        </table>
            
    </body>
</html>
