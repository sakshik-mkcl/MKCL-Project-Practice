package com.practice.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.practice.entity.User;
import com.practice.utils.DBUtils;

public class UserDao{
	
	static Connection con= DBUtils.getConnection();

	public void UserDao()  {
         con = DBUtils.getConnection();
        System.out.println("connection estab");
	}
	

	
   public int save(User u) {
	   //System.out.println(u);
	   try {
		   
	    PreparedStatement insertStmt=con.prepareStatement( "INSERT INTO user VALUES(?,?,?,?,?)");
	  

	   insertStmt.setInt(1, u.getId());
		insertStmt.setString(2,u.getFirstname() );
		insertStmt.setString(3,u.getLastname() );
		insertStmt.setString(4, u.getEmail());
		insertStmt.setString(5,u.getPassword() );
		int rows = insertStmt.executeUpdate();
		
	   }catch(Exception e) {
		   e.printStackTrace();
		   System.out.println("hello2");
	   }

	   return 1;
	}


  
}
