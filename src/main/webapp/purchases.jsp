<%@ page import="java.util.Map" %>
<%@ page import="com.servlet.domain.ShopStore" %>
<%@ page import="com.servlet.domain.Item" %>
<%@ page import="com.servlet.domain.Purchase" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Map<String, Purchase> purchases = ShopStore.getInstance().getAllPurchases();
    request.setAttribute("purchases", purchases);
%>

<html>
<head>
    <style>
        body, input {
            font-size: 16px;
            font-family: arial, sans-serif;
        }

        table {
            border-collapse: collapse;
            width: auto;
            margin: 10px 0 10px 0;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
            width: calc(100vh / 5);
        }

        td, th:nth-child(1) {
            width: 30px;
        }
    </style>

    <title>Servlet</title>
</head>
<body>
<h1>Purchases list</h1>
<a href="/app/employee?">Go back</a>

<form method="post" action="customer">
    <table>
        <tr>
            <th></th>
            <th>Customer Name</th>
            <th>Item name</th>
            <th>Item count</th>
        </tr>

        <c:forEach var="entry" items="${purchases}">
            <tr>
                <td><input type="checkbox" name="itemCheck" value="${entry.value.purchaseId}"/></td>
                <td><c:out value="${entry.value.customer.customerName}"/></td>
                <%--<td><c:out value="${entry.value.items[0].count}"/></td>--%>
                <td>
                    <c:out value="${entry.value.items[0].name}"/>
                    <c:forEach begin="1" var="item" items="${entry.value.items}">
                        <tr>
                            <td></td>
                            <td></td>
                            <td><c:out value="${item.name}"/></td>
                            <td><c:out value="${item.count}"/></td>
                        </tr>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>