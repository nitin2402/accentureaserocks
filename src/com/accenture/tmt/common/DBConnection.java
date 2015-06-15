package com.accenture.tmt.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public static Connection connect() {
		Connection conn = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String password = "";
			String dbName = "C:/Users/simlee.das/Desktop/Database12.accdb";
			String bd = dbName + ";PWD=" + password;
			String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
					+ bd + ";";
			 conn = DriverManager.getConnection(url);
			/*PreparedStatement ps = conn
					.prepareStatement("select * from abc where userName=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();*/
			
		

		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}

}
