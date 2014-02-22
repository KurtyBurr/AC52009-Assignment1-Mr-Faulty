<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit a Fault</title>
</head>
<body>
<p> Member: <%= session.getAttribute("email") %> Privilege:<%= session.getAttribute("privilege") %> <a href ="Logout.jsp">   Logout</a></p>
<form name= "frmFaultSubmit" action ="AddFault" method = "get">
<label>Summary
</label>
<p>
</p>
<input type ="text" id="Summary" name= "Summary" />
<p>
<label>Description </label>
<p>
</p>
<textarea id="description" name = "description" rows = "10" cols ="60"></textarea><br></br>
<p>
<label>Reporter ID</label>
<p>
</p>
<input type = "text" id ="reporter" name = "reporter" />
<p>
<label>Severity</label>
<p>
</p>
<select id = "severity" name = "severity">
  <option value="1">Cassandra</option>
  <option value="2">Hadoop</option>
  <option value="3">Debian</option>
</select>

<p>
<label>
<input type = "submit" name = "submit" value = "Submit" />
</label>
</p>

</form>

</body>
</html>