package com.abc.kurtis.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * does employee login
 */
@WebServlet("/DoELogin")
public class DoELogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoELogin() {
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
	    
	    String email= request.getParameter("Eusername");
	    String pass= request.getParameter("Epasswrd");
	    String message = "success";
	    
	    
	    	String sqlOption= "SELECT * FROM author where email=? and pass=?";
	    	
	    	psdoLogin = con.prepareStatement(sqlOption);
	    	psdoLogin.setString(1, email);
	    	psdoLogin.setString(2, pass);
	    	
	    	rsdoLogin=psdoLogin.executeQuery();
	    	
	    	
	    	if(rsdoLogin.next())
	    	{
	    	  String EuserName=rsdoLogin.getString("email")+ ""+rsdoLogin.getString("pass");
	    	  
	    	  
	    	  session.setAttribute("email", email);
	    	  String priv = rsdoLogin.getString("privilege");
	    	  
	    	  if(priv.equals("Admin"))
	    	  {
	    		  System.out.println("You have logged in with admin privileges");
	    		  session.setAttribute("privilege", priv);
	    		  response.sendRedirect("AdminHome.jsp");
	    	  }
	    	  
	    	  if(priv.equals("Developer"))
	    	  {
	    		System.out.println("Developer privileges");
	    		session.setAttribute("privilege", priv);
	    		response.sendRedirect("DeveloperHome.jsp");
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
