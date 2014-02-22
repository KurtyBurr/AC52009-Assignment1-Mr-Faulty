<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log out</title>
</head>
<body>
<form name = "frmlogout" action="Logout" method="get">

<%session.invalidate(); %>
<h1>You have been successfully logged out</h1>

<a href="Index.jsp">Return home</a>
</body>
</html>