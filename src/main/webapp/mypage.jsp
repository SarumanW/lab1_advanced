
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet</title>
</head>
<body>
<h1>Internet product shop</h1>
<h2>Choose your role:</h2>
<a href="employee-start.jsp">Employee</a>
<a href="customer-start.jsp">Customer</a>
<form method="post" action="CustomerServlet">
    <input type="hidden" name="name" value="Olichka">
    <input type="submit" value="Login" />
</form>
</body>
</html>
