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
<body>
<p> Member: <%= session.getAttribute("email") %> Privilege:<%= session.getAttribute("privilege") %> <a href ="Logout.jsp">   Logout</a></p>
<h1>List of Developers</h1>
<%
System.out.println("In render");
List<ListEmp> lFaults = (List<ListEmp>)request.getAttribute("Faults");
if (lFaults==null){
 %>
	<p>No faults found</p>
	<% 
}else{
%>


<% 
Iterator<ListEmp> iterator;


iterator = lFaults.iterator();     
while (iterator.hasNext()){
	ListEmp md = (ListEmp)iterator.next();

	%>
	<%=md.getAuthorid() %> Name: <%=md.getForename()%> <%=md.getSurname()%>     Role:<%=md.getPrivilege() %>    Fault ID:<%=md.getFid()%><br/><%
	
	

}
}
%>
<p>
</p>
<p>
<a href="AdminHome.jsp">Back to main page</a>
</p>
</body>
</html>