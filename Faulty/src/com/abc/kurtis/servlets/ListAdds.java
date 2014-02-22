package com.abc.kurtis.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.abc.kurtis.lib.Dbutils;
import com.abc.kurtis.models.FaultModel;
import com.abc.kurtis.models.ListAds;
import com.abc.kurtis.models.ListEmps;
import com.abc.kurtis.models.Listrep;
import com.abc.kurtis.stores.FaultsStore;
import com.abc.kurtis.stores.ListEmp;

import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * lists all the admins and passes it to the jsp page
 */

@WebServlet(
		urlPatterns = {"/ListAdds"
		}, 
		initParams = { 
				@WebInitParam(name = "data-source", value = "jdbc/Faultdb")
		})
public class ListAdds extends HttpServlet {
	private DataSource _ds = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAdds() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
    	Dbutils db = new Dbutils();
		db.createSchema();
		_ds=db.assemble(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Starting GET");
		//String args[]=Convertors.SplitRequestPath(request);
		Iterator<ListEmp> iterator;
		ListAds Listr = new ListAds(); //Create a new instance of the model

		Listr.setDatasource(_ds);
		LinkedList<ListEmp> psl = Listr.getFaults(); // Get a list of all faults

		/* If we want to forward to a jsp page do this */
		request.setAttribute("Faults", psl); //Set a bean with the list in it
		RequestDispatcher rd = request.getRequestDispatcher("AllAdmins.jsp"); 

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
