<%@ page import="java.util.Map" %>
<%@ page import="com.servlet.domain.ShopStore" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Map<Long, Object> items = ShopStore.getInstance().getAllItems();
    request.setAttribute("items", items);
%>

<html>
<head>
    <title>Servlet</title>
</head>
<body>
<h1>Hello dear employee!</h1>
<form method="post" action="employee">

    <table>
        <c:forEach var="entry" items="${items}">

            <tr>
                <td><input type="checkbox" name="itemCheck" value="${entry.value.name}" id="${entry.key}"/></td>
                <td><c:out value="${entry.value.name}"/> </td>
            </tr>
        </c:forEach>
    </table>

    <input type="submit" value="check"/>
</form>


</body>
</html>
