<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Login</title>
</head>
<body>
<h1>Sorry No Such User</h1>
<p>
</p>
<a href="Index.jsp">Please try again</a>

<%session.invalidate(); %>
</body>
</html>