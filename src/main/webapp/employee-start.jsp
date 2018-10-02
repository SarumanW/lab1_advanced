<%@ page import="java.util.Map" %>
<%@ page import="com.servlet.domain.ShopStore" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Servlet</title>
</head>
<body>
<h1>Hello dear employee!</h1>

<form method="post" action="employee">
    <input type="submit" name="action" value="Items list"/>
    <input type="submit" name="action" value="Black Customers list"/>
    <input type="submit" name="action" value="Purchases list"/>
</form>
</body>
</html>
