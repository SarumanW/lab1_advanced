<%@ page import="java.util.Map" %>
<%@ page import="com.servlet.domain.ShopStore" %>
<%@ page import="com.servlet.domain.Item" %>
<%@ page import="com.servlet.domain.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Map<String, Customer> customers = ShopStore.getInstance().getAllBlackList();
    request.setAttribute("customers", customers);
%>

<html>
<head>
    <style>
        body, input {
            font-size: 16px;
            font-family: arial, sans-serif;
        }

        div {
            display: block;
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

        tr:nth-child(even) {
            background-color: #dddddd;
        }

    </style>

    <title>Servlet</title>
</head>
<body>
<h1>Black list of customers</h1>
<a href="/app/employee?">Go back</a>

<form method="post" action="items">
    <table>
        <tr>
            <th>Customer Name</th>
        </tr>

        <c:forEach var="entry" items="${customers}">
            <tr>
                <td><c:out value="${entry.value.customerName}"/></td>
            </tr>
        </c:forEach>
    </table>

</form>

</body>
</html>