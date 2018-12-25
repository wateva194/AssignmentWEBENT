<%-- 
    Document   : Detail
    Created on : Dec 25, 2018, 11:32:34 AM
    Author     : wateva
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book history</h1>
        <jsp:useBean class="Model.BookFinderBean" id="finder" scope="request"/>
        <table>
            <tr>
                <td>OrderNo</td>
                <td>Name</td>
                <td>CreatedDTG</td>
                <td>Status</td>
            </tr>
            
            <c:forEach items="${finder.getBookHistories()}" var ="bookHistory">
                <tr>
                    <td>
                        <c:out value="${bookHistory.getOrderNo().toString()}"/>
                    </td>
                    <td>
                        <c:out value="${bookHistory.getName()}"/>
                    </td>
                    <td>
                        <c:out value="${bookHistory.getCreatedDTG().toString()}"/>
                    </td>
                    <td>
                        <c:out value="${bookHistory.getStatus()}"/>
                    </td>
                </tr>
                </c:forEach>
        </table>
    </body>
</html>
