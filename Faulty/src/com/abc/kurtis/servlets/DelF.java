package com.abc.kurtis.servlets;


import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.abc.kurtis.lib.*;
import com.abc.kurtis.stores.*;
import com.abc.kurtis.models.*;
/**
 * this class gets a list of faults and passes it to delete fault
 */
@WebServlet(
		urlPatterns = { 
				
				"/DelF",
		}, 
		initParams = { 
				@WebInitParam(name = "data-source", value = "jdbc/kfaultdb")
		})
public class DelF extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource _ds = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelF() {
        super();
        // TODO Auto-generated constructor stub
       
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
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
		Iterator<FaultsStore> iterator;
		FaultModel Faults = new FaultModel(); //Create a new instance of the model

		Faults.setDatasource(_ds);
		LinkedList<FaultsStore> psl = Faults.getFaults(); // Get a list of all faults

		/* If we want to forward to a jsp page do this */
		request.setAttribute("DelF", psl); //Set a bean with the list in it
		RequestDispatcher rd = request.getRequestDispatcher("/DeleteFault.jsp"); 
			
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}