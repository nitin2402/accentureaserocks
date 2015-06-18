package com.accenture.tmt.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con;
	private DBConnection(){
		
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 con = DriverManager
					.getConnection("jdbc:ucanaccess://C:/Users/n.a.saini/Desktop/EmployeeDB.accdb");
			 return con;
	}
	
}
