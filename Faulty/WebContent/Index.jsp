<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<a href="/Faulty/EmployeeLogin.jsp">Admin/ Developer Login</a><p></p>
<form name = "frmlogin" action="DoLogin" method="get">
<label>Email address :
<input type ="text" name= "Susername" />
</label>
<p>
<label>Password  :
<input type = "password" name = "passwrd" />
</label>
</p>

<p>
<label>
<input type = "submit" name = "submit" value = "login" />
</label>
</p>
<p>
<a href="/Faulty/NewUser.jsp">New user? Click here to create an account</a>
</p>
</form>
</body>
</html>