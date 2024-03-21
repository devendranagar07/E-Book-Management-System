package com.db;

import java.sql.*;
import java.sql.DriverManager;

public class ConnectionProvider {

	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			if(conn == null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","project2","123");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
