<%-- 
    Document   : Default
    Created on : Dec 25, 2018, 11:32:34 AM
    Author     : wateva
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Manager</title>
    </head>
    <body>
        <h1>Books list</h1>
        <jsp:useBean class="Model.BookFinderBean" id="finder" scope="request"/>
        <table>
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Author</td>
                <td>Status</td>
                <td>History</td>
                <td>Action</td>
            </tr>
            
            <c:forEach items="${finder.books}" var ="book">
                <tr>
                    <td>
                        <c:out value="${book.getCode()}"/>
                    </td>
                    <td>
                        <c:out value="${book.getName()}"/>
                    </td>
                    <td>
                        <c:out value="${book.getAuthor()}"/>
                    </td>
                    <td>
                        <c:out value="${book.getStatus()}"/>
                    </td>
                    <td>
                        <form action="BookHisFinder">
                            <input type="submit" value="Look History" />
                            <input type="hidden" name="id" value="${book.getId().toString()}" />
                        </form>
                    </td>
                    <td>
                        <form action="BookAction">
                            <c:choose>
                                <c:when test="${book.getStatus() == 'Chưa mượn'}">
                                    <input type="submit" value="Mượn sách" />
                                    <input type="hidden" name="status" value="Borrow" />
                                </c:when>
                                <c:otherwise>
                                    <input type="submit" value="Trả sách"/>
                                    <input type="hidden" name="status" value="Return" />
                                </c:otherwise>
                            </c:choose>
                                    <input type="hidden" name="id" value="${book.getId().toString()}" />
                                    
                        </form>
                    </td>
                </tr>
                </c:forEach>
        </table>
    </body>
</html>
