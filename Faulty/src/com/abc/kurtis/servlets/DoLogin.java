package com.abc.kurtis.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.*;

import javax.sql.*;
/**
 * this class gets the user name and password from the db and sets a session
 */
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Connection con = null;
		try{
		
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kfaultdb","root","Cl1m8t3;");
	    
	    ResultSet rsdoLogin = null;
	    PreparedStatement psdoLogin = null;
	    
	    String email= request.getParameter("Susername");
	    String pass= request.getParameter("passwrd");
	    
	    String message = "success";
	    
	    
	    	String sqlOption= "SELECT * FROM author where email=? and pass=?";
	    	
	    	psdoLogin = con.prepareStatement(sqlOption);
	    	psdoLogin.setString(1, email);
	    	psdoLogin.setString(2, pass);
	    	
	    	rsdoLogin=psdoLogin.executeQuery();
	    	
	    	
	    	if(rsdoLogin.next())
	    	{
	    	  String userName=rsdoLogin.getString("email")+ ""+rsdoLogin.getString("pass");
	    	  String privilege = rsdoLogin.getString("privilege");
	    	  session.setAttribute("email", email);
	    	  
	    	  
	    	  
	    	  if(privilege.equals("Reporter"))
	    	  {
	    		  System.out.println("You have logged in with reporter privileges");
	    		  response.sendRedirect("/Faulty/Faults");
	    		  session.setAttribute("privilege", privilege);
	    		  
	    	  }
	    	  if(privilege.equals("Admin"))
	    	  {
	    		  System.out.println("Log in employee window");
	    		  session.setAttribute("privilege", privilege);
	    		  response.sendRedirect("Error.jsp");
	    		  
	    	  }
	    	  
	    	  if(privilege.equals("Developer"))
	    	  {
	    		  System.out.println("Log in employee window");
	    		  session.setAttribute("privilege", privilege);
	    		  response.sendRedirect("Error.jsp");
	    		  
	    	  }
	    	  
	    	}
	    	  else
	    	  {
	    		  message = "No user";
	    		  response.sendRedirect("Index.jsp?error="+message);
	    	  }
	    	  
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    	try{
	    		
	    		if(con!=null)
	    		{
	    			con.close();
	    		}
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
