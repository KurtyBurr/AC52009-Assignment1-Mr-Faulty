<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login</title>
</head>
<body>
<form name = "frmElogin" action="DoELogin" method="get">
<label>Employee Email address :
<input type ="text" name= "Eusername" />
</label>
<p>
<label>Employee Password  :
<input type = "password" name = "Epasswrd" />
</label>
</p>

<p>
<label>
<input type = "submit" name = "submit" value = "login" />
</label>
</p>
<p>
<a href="/Faulty/Index.jsp">Not an employee? Please return to the main Log in page</a>
</p>
</form>
</body>
</html>