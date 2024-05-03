package com.practice.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	static final String Driver = "com.mysql.jdbc.Driver";
	static final String Url = "jdbc:mysql://localhost:3306/test";
	static final String User = "root";
	static final String Pass = "root";
	static Connection con;
	static {
		try {
			Class.forName(Driver);
			con=DriverManager.getConnection(Url, User, Pass);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	}


}
