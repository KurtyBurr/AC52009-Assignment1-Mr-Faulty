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

/**
 * creates a new user
 */
@WebServlet("/doNewUser")
public class doNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doNewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		try{
		
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Faultdb","root","Cl1m8t3;");
	    
	    //ResultSet doSubmit = null;
	    PreparedStatement pdoSubmit = null;
	    
	    String nUser= request.getParameter("NewUsername");
	    String surname = request.getParameter("surname");
	    String email = request.getParameter("email");
	    String pass= request.getParameter("passwrd");
	   
	    
	    
	    	String sqlOption= "INSERT INTO author (forename, surname, email, pass, privilege) VALUES (?,?,?,?,'Reporter')";
	    	
	    	pdoSubmit = con.prepareStatement(sqlOption);
	    	pdoSubmit.setString(1, nUser);
	    	pdoSubmit.setString(2, surname);
	    	pdoSubmit.setString(3, email);
	    	pdoSubmit.setString(4, pass);
	    	
	    	
	    	pdoSubmit.executeUpdate();
	    	
	    	 response.sendRedirect("/Faulty/Index.jsp");
	    	
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
