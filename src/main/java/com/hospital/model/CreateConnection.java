package com.hospital.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
	
	
	public static  Connection getConnection() 
	{
		Connection con=null;
		
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pgdac","root","root");
		}
		catch(SQLException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return con;
	}

}