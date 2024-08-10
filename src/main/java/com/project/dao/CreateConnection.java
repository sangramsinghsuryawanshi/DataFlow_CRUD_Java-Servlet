package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection 
{
	public static Connection isCreate()
	{
		Connection conn=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/org","root","12345");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
