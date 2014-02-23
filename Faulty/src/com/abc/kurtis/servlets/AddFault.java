package com.abc.kurtis.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * This class is used to add a fault to the DB
 */
@WebServlet("/AddFault")
public class AddFault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFault() {
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
	    
	    PreparedStatement doSubmit = null;
	    PreparedStatement pdoSubmit = null;
	    
	    String Ssummary= request.getParameter("Summary");
	    String description= request.getParameter("description");
	    String reporter= request.getParameter("reporter");
	    String severity= request.getParameter("severity");
	    String message = "success";
	    
	    
	    	String sqlOption= "INSERT INTO fault (summary, details, author_idauthor, section_idsection) VALUES (?,?,?,?)";
	    	String sql2 = "INSERT INTO author (idfault) VALUES(?)";
	    	
	    	pdoSubmit = con.prepareStatement(sqlOption);
	    	pdoSubmit.setString(1, Ssummary);
	    	pdoSubmit.setString(2, description);
	    	pdoSubmit.setString(3, reporter);
	    	pdoSubmit.setString(4,severity);
	    	
	    	doSubmit = con.prepareStatement(sql2);
	    	
	    	pdoSubmit.executeUpdate();
	    	doSubmit.executeUpdate();
	    	
	    	 response.sendRedirect("/Faulty/Faults");
	    	
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
