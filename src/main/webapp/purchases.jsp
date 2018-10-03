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
            border: none;
            text-align: left;
            padding: 8px;
            width: calc(100vh / 5);
        }

        td, th:nth-child(1) {
            width: 30px;
        }

        .inside {
            border: 1px solid #dddddd;
        }
    </style>

    <script type="text/javascript">

        function setAttributee(value) {
            console.log(value);
            document.getElementById('added').setAttribute('value', value);
        }

    </script>


    <title>Servlet</title>
</head>
<body>
<h1>Purchases list</h1>
<a href="/app/employee?">Go back</a>

<h2>${help}</h2>

<form method="post" action="purchase">

    <input type="hidden" id="added" name="customerId" value="">

    <table>
        <tr>
            <th></th>
            <th>Customer Name</th>
            <th>Item name</th>
            <th>Item count</th>
        </tr>

        <c:forEach var="entry" items="${purchases}">
            <tr>
            <td>
                <input type="submit" value="Add to blacklist" id="${entry.value.customer.customerId}" onclick="setAttributee(id)"/>
                <input type="hidden" name="addToBlackList" value="${entry.value.customer.customerId}">
            </td>
            <td><c:out value="${entry.value.customer.customerName}"/></td>
            <td>
            <c:forEach begin="0" var="item" items="${entry.value.items}">
                <tr class="inside">
                    <td></td>
                    <td></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.count}"/></td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
</form>


</body>
</html>