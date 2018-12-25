<%-- 
    Document   : Search
    Created on : Dec 25, 2018, 11:32:34 AM
    Author     : wateva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find Book</title>
    </head>
    <body>
        <h1>Find Book</h1>
        <form action="BookFinder">
            <span style="color:red;">
                <c:out value="${param.msg}"/>
            </span>
            <input name="text"/><input type="submit"/>
        </form>
    </body>
</html>
