<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New user</title>
</head>
<body>
<form name = "frmNewUser" action = "doNewUser" method ="get">

<label>Forename :
<input type ="text" name= "NewUsername" />
</label>
<p>
<label>Surname:
<input type ="text" name= "surname"/>
</label>
</p>
<p>
<label>Email Address:
<input type= "text" name= "email">
</label>
</p>
<p>
<label>Create a Password  :
<input type = "password" name = "passwrd" />
</label>
</p>

<p>
<label>
<input type = "submit" name = "submit" value = "Create" />
</label>
</p>

</form>
</body>
</html>