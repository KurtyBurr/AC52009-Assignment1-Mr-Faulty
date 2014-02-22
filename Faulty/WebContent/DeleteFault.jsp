<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="com.abc.kurtis.stores.*" %>
<%@ page import="java.util.*" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Reporter List</title>
</head>

<form name = "frmDelete" action="DeleteFault" method="get">
<body>
<p> Member: <%= session.getAttribute("email") %> Privilege:<%= session.getAttribute("privilege") %> <a href ="Logout.jsp">   Logout</a></p>
<h1>Delete a Fault</h1>
<%
System.out.println("In render");
List<FaultsStore> lFaults = (List<FaultsStore>)request.getAttribute("DelF");
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
	<input type = "radio" name="delete" value=<%=md.getFaultid()%><a href="FaultSum?faultId=<%=md.getFaultid() %>" ><%=md.getFaultSummary() %></a>/><br/><%
}
}
%>

<input type="submit" name="submit" value="Delete">
</form>
<p>
</p>
<p>
<a href="FaultSubmit.jsp">Create and post a new fault</a>
</p>
</body>
</html>