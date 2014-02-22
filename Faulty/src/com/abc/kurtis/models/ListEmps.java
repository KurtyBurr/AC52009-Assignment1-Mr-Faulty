package com.abc.kurtis.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.sql.DataSource;

import com.abc.kurtis.stores.ListEmp;

public class ListEmps {
	private DataSource _ds = null;
	public ListEmps(){

	}

	public void setDatasource(DataSource _ds){
		this._ds=_ds;
		System.out.println("Set Data Source in Model"+_ds.toString());
	}

    public LinkedList<ListEmp> getFaults(){
		LinkedList<ListEmp> psl = new LinkedList<ListEmp>();
		Connection Conn;
		ListEmp ps = null;
		ResultSet rs = null;
		try {
			Conn = _ds.getConnection();
		} catch (Exception et) {

			System.out.println("No connection");
			return null;
		}

		PreparedStatement pmst = null;
		Statement stmt = null;
		String sqlQuery = "select * from author where privilege='Developer'";
		System.out.println("Query " + sqlQuery);
		try {
			try {
				// pmst = Conn.prepareStatement(sqlQuery);
				stmt = Conn.createStatement();
			} catch (Exception et) {
				System.out.println("Can't create prepare statement");
				return null;
			}
			System.out.println("Created prepare");
			try {
				// rs=pmst.executeQuery();
				rs = stmt.executeQuery(sqlQuery);
			} catch (Exception et) {
				System.out.println("Can not execut query here " + et);
				return null;
			}
			System.out.println("Statement executed");
			if (rs.wasNull()) {
				System.out.println("result set was null");
			} else {
				System.out.println("Well it wasn't null");
			}
			while (rs.next()) {
				System.out.println("Getting RS");
				ps = new ListEmp();
				ps.setAuthortid(rs.getString("idauthor"));
				ps.setForename(rs.getString("forename"));
				ps.setSurname(rs.getString("surname"));
				ps.setEmail(rs.getString("email"));
				ps.setPrivilege(rs.getString("privilege"));
				ps.setFid(rs.getString("idfault"));
				psl.add(ps);
			}
		} catch (Exception ex) {
			System.out.println("Opps, error in query " + ex);
			return null;
		}

		try {

			Conn.close();
		} catch (Exception ex) {
			return null;
		}
		return psl;

	}
}
