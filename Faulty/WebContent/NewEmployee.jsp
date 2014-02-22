<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name = "frmNewUser" action = "doNewEmployee" method ="get">
<p> Member: <%= session.getAttribute("email") %> Privilege:<%= session.getAttribute("privilege") %> <a href ="Logout.jsp">   Logout</a></p>
<label>Employee Forename :
<input type ="text" name= "NewEUsername" />
</label>
<p>
<label>Employee Surname:
<input type ="text" name= "Esurname"/>
</label>
</p>
<p>
<label>Employee Email Address:
<input type= "text" name= "Eemail">
</label>
</p>
<p>
<label>Privilege:</label>
<select id = "severity" name = "Epriv">
  <option value="Developer">Developer</option>
  <option value="Admin">Admin</option>
</select>
</p>
<p>
<label>Create a Password  :
<input type = "password" name = "Epasswrd" />
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