<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="com.abc.kurtis.stores.*" %>
<%@ page import="java.util.*" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Developers</title>
</head>
<form name = "frmDelete" action="DeleteAdmin" method="get">
<body>
<p> Member: <%= session.getAttribute("email") %> Privilege:<%= session.getAttribute("privilege") %> <a href ="Logout.jsp">   Logout</a></p>
<h1>Delete An Admin</h1>
<%
System.out.println("In render");
List<ListEmp> lFaults = (List<ListEmp>)request.getAttribute("Faults");
if (lFaults==null){
 %>
	<p>No admins found</p>
	<% 
}else{
%>


<% 
Iterator<ListEmp> iterator;


iterator = lFaults.iterator();     
while (iterator.hasNext()){
	ListEmp md = (ListEmp)iterator.next();

	%>
	<input type ="radio" name="delR" value="<%=md.getAuthorid() %>" >Name: <%=md.getForename()%> <%=md.getSurname()%>     Role:<%=md.getPrivilege() %>    Fault ID:<%=md.getFid()%><br/><%		
}
}
%>

<input type="submit" name="submit" value="Delete">

<p>
</p>
<p>
<a href="AdminHome.jsp">Back to main page</a>
</p>
</form>
</body>
</html>