package com.abc.kurtis.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * creates a new employee
 */
@WebServlet("/doNewEmployee")
public class doNewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doNewEmployee() {
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
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kfaultdb","root","Cl1m8t3;");
	    
	    //ResultSet doSubmit = null;
	    PreparedStatement pdoSubmit = null;
	    
	    String nEUser= request.getParameter("NewEUsername");
	    String Esurname = request.getParameter("Esurname");
	    String Eemail = request.getParameter("Eemail");
	    String Epass= request.getParameter("Epasswrd");
	    String privilege = request.getParameter("Epriv");
	   
	    
	    
	    	String sqlOption= "INSERT INTO author (forename, surname, email, pass, privilege) VALUES (?,?,?,?,?)";
	    	
	    	pdoSubmit = con.prepareStatement(sqlOption);
	    	pdoSubmit.setString(1, nEUser);
	    	pdoSubmit.setString(2, Esurname);
	    	pdoSubmit.setString(3, Eemail);
	    	pdoSubmit.setString(4, Epass);
	    	pdoSubmit.setString(5, privilege);
	    	
	    	
	    	pdoSubmit.executeUpdate();
	    	
	    	 response.sendRedirect("/Faulty/EmployeeLogin.jsp");
	    	
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
