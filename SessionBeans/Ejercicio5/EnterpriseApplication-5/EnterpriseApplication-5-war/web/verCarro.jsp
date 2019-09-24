<%-- 
    Document   : verCarro
    Created on : 24-sep-2019, 10:18:23
    Author     : Anta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tu Carro</title>
    </head>
    <body>
        <c:forEach begin="0" end="${fn:length(centralityList) - 1}" var="index">
            <tr>
               <td><c:out value="${centralityList[index]}"/></td>
               <td><c:out value="${labelList[index]}"/></td>
            </tr>
        </c:forEach>
    </body>
</html>
