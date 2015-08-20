package com.accenture.tmt.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	 static Properties prop = new Properties();
	static InputStream input = null;
	private static Connection con;
	private DBConnection(){
		
	}
	public  static Connection getConnection() throws ClassNotFoundException, SQLException{
		    try {
		    	
		    	
		    	Properties prop=new Properties();
		    	prop.load(DBConnection.class.getClassLoader()
	                    .getResourceAsStream("config.properties"));
		    	String db=prop.getProperty("DB");
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				con = DriverManager.getConnection(db);
				 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return con;
		
			
	}
	
}
