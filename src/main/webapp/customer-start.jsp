<%@ page import="java.util.Map" %>
<%@ page import="com.servlet.domain.ShopStore" %>
<%@ page import="com.servlet.domain.Item" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Map<String, Item> items = ShopStore.getInstance().getAllItems();
    request.setAttribute("items", items);
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
                width: calc(100vh/5);
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
        <h1>Hello dear customer!</h1>
        <a href="/app">Go back</a>
        <h2>Choose items and their count and press button 'Buy!'</h2>

        <form method="post" action="customer">
            <table>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Supplier</th>
                    <th>Count</th>
                    <th>You got</th>
                </tr>

                <c:forEach var="entry" items="${items}">
                    <tr>
                        <td><input type="checkbox" name="itemCheck" value="${entry.value.itemId}" id="${entry.key}"/></td>
                        <td><c:out value="${entry.value.name}"/></td>
                        <td><c:out value="${entry.value.price}"/></td>
                        <td><c:out value="${entry.value.supplier}"/></td>
                        <td><c:out value="${entry.value.count}"/></td>
                        <td><input type="text" name="productsCount" placeholder="" autocomplete="off"/></td>
                    </tr>
                </c:forEach>
            </table>

            <input type="text" name="customerName" placeholder="Type your full name" autocomplete="off"/>
            <input type="submit" value="Buy"/>
        </form>

    <h2>${thanks}</h2>
    </body>
</html>