<%@ page import="java.util.Map" %>
<%@ page import="com.servlet.domain.ShopStore" %>
<%@ page import="com.servlet.domain.Item" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Map<String, Item> items = ShopStore.getInstance().getAllItems();
    request.setAttribute("items", items);
    request.setAttribute("page", "items");
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
<h1>Shop items list</h1>
<a href="/app/employee?">Go back</a>

<form method="post" action="items">
    <table>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Supplier</th>
            <th>Count</th>
        </tr>

        <c:forEach var="entry" items="${items}">
            <tr>
                <td><c:out value="${entry.value.name}"/></td>
                <td><c:out value="${entry.value.price}"/></td>
                <td><c:out value="${entry.value.supplier}"/></td>
                <td><c:out value="${entry.value.count}"/></td>
            </tr>
        </c:forEach>
    </table>

    <h2>Type information about item and add it to the base: </h2>

    <table>
        <tr>
            <td><label for="itemName">Item name</label></td>
            <td><input type="text" id="itemName" name="itemName" placeholder="" autocomplete="off"/></td>
        </tr>
        <tr>
            <td><label for="itemCount">Count</label></td>
            <td><input type="text" name="itemCount" id="itemCount" placeholder="" autocomplete="off"/></td>
        </tr>
        <tr>
            <td><label for="itemPrice">Price</label></td>
            <td><input type="text" name="itemPrice" id="itemPrice" placeholder="" autocomplete="off"/></td>
        </tr>
        <tr>
            <td><label for="itemSupplier">Supplier</label></td>
            <td><input type="text" name="itemSupplier" id="itemSupplier" placeholder="" autocomplete="off"/></td>
        </tr>
    </table>

    <input type="submit" value="Add" style="margin-top: 10px"/>
</form>

<h2>${help}</h2>
</body>
</html>