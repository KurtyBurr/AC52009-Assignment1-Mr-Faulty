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
 * edits and fault and saves it to the db
 */
@WebServlet("/EditF")
public class EditF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditF() {
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
	    
	    PreparedStatement doSubmit = null;
	    PreparedStatement pdoSubmit = null;
	    
	   
	    String Ssummary= request.getParameter("Summary");
	    String description= request.getParameter("description");
	    String reporter= request.getParameter("reporter");
	    String severity= request.getParameter("severity");
	    String del = request.getParameter("upd");
	    String message = "success";
	    
	    
	    	String sqlOption= "UPDATE fault set  summary=?, details =?, author_idauthor=?, section_idsection=? where idfault=?";
	    	
	    	
	    	pdoSubmit = con.prepareStatement(sqlOption);
	    	
	    	pdoSubmit.setString(1, Ssummary);
	    	pdoSubmit.setString(2, description);
	    	pdoSubmit.setString(3, reporter);
	    	pdoSubmit.setString(4,severity);
	    	pdoSubmit.setString(5, del);
	    	System.out.println("del:"+del);
	    	
	    	pdoSubmit.executeUpdate();
	    	//doSubmit.executeUpdate();
	    	
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
