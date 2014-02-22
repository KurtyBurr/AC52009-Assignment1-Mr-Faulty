<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="com.abc.kurtis.stores.*" %>
<%@ page import="java.util.*" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Faults List</title>
</head>
<body>
<p> Member: <%= session.getAttribute("email") %> Privilege:<%= session.getAttribute("privilege") %> <a href ="Logout.jsp">   Logout</a></p>
<h1>Faults</h1>
<%
System.out.println("In render");
List<FaultsStore> lFaults = (List<FaultsStore>)request.getAttribute("Faults");
if (lFaults==null){
 %>
	<p>No faults found</p>
	<% 
}else{
%>


<% 
Iterator<FaultsStore> iterator;


iterator = lFaults.iterator();     
while (iterator.hasNext()){
	FaultsStore md = (FaultsStore)iterator.next();

	%>
	<a href="FaultSum?faultId=<%=md.getFaultid() %>" >ID:<%=md.getFaultid() %>    <%=md.getFaultSummary() %></a><br/><%
}
}
%>

<p>
</p>
<p>
<a href="FaultSubmit.jsp">Create and post a new fault</a>

</p>
<p>
<a href="/Faulty/EFault">Edit a fault</a>

</p>
</body>
</html>