package com.abc.kurtis.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class deletes an admin from the db
 */
@WebServlet("/DeleteAdmin")
public class DeleteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Connection con = null;
				try{
				
			    Class.forName("com.mysql.jdbc.Driver").newInstance();
			    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Faultdb","root","Cl1m8t3;");
			    
			    //ResultSet doSubmit = null;
			    PreparedStatement pdoSubmit = null;
			    
			    String del= request.getParameter("delR");
			    
			    
			    
			    	String sqlOption= "DELETE FROM author where idauthor=?";
			    	
			    	pdoSubmit = con.prepareStatement(sqlOption);
			    	pdoSubmit.setString(1, del);
			    	
			    	
			    	pdoSubmit.executeUpdate();
			    	
			    	 response.sendRedirect("/Faulty/ListAdds");
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
