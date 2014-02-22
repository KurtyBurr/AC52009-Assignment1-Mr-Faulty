<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin home</title>
</head>
<body>
<p> Member: <%= session.getAttribute("email") %> Privilege:<%= session.getAttribute("privilege") %> <a href ="Logout.jsp">   Logout</a></p>
<h1>Admin home</h1>
<p>
<a href="/Faulty/ListAdds">Display all Admins</a>
</p>
<p>
<a href="/Faulty/DeleteAd">Delete an Admin</a>
</p>
<p>
<a href="/Faulty/ListE">Display all developers</a>
</p>
<p>
<a href="/Faulty/DeleteDev">Delete a developer</a>
</p>
<p>
<a href="/Faulty/ListReporters">Display all Reporters</a>
</p>
<p>
<a href="/Faulty/DeleteR">Delete a Reporter</a>
</p>
<p>
<a href="/Faulty/Faults">View all Faults</a>
</p>
<p>
<a href="/Faulty/EFault">Edit A Fault</a>
</p>
<p>
<a href="/Faulty/DelF">Delete a Fault</a>
</p>
<p>
<a href="NewEmployee.jsp">Create New Employee</a>
</p>


</body>
</html>