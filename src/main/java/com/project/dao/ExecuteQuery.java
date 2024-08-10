package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.EncapsulatedClass;

public class ExecuteQuery 
{
	public static int isInsert(EncapsulatedClass ob)
	{
		int stataus=0;
		try 
		{
			Connection con = CreateConnection.isCreate();
			String insert = "insert into student(id,name,email,password)values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insert);
			  ps.setInt(1, ob.getId());
		        ps.setString(2, ob.getName());
		        ps.setString(3, ob.getEmail());
		        ps.setString(4, ob.getPassword());
			stataus=ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return stataus;
	}
	public static List<EncapsulatedClass> DataFetch()
	{
		List<EncapsulatedClass> li = new ArrayList<EncapsulatedClass>();
		try 
		{
			Connection con =CreateConnection.isCreate();
			String select = "select * from student";
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EncapsulatedClass en = new EncapsulatedClass();
				en.setId(rs.getInt(1));
				en.setName(rs.getString(2));
				en.setEmail(rs.getString(3));
				en.setPassword(rs.getString(4));
				li.add(en);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}
	
	public static EncapsulatedClass isUpdated(int id)
	{
		EncapsulatedClass en = new EncapsulatedClass();
		try 
		{
			Connection con = CreateConnection.isCreate();
			String update = "select * from student where id=?";
			PreparedStatement ps = con.prepareStatement(update);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				en.setId(rs.getInt(1));
				en.setName(rs.getString(2));
				en.setEmail(rs.getString(3));
				en.setPassword(rs.getString(4));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return en;
	}
	
	public static int isUpdat(EncapsulatedClass en)
	{
		Connection con = CreateConnection.isCreate();
		String up = "update student set name=?,email=?,password=? where id=?";
		int status=0;
		try {
			PreparedStatement ps = con.prepareStatement(up);
			ps.setString(1, en.getName());
			ps.setString(2, en.getEmail());
			ps.setString(3, en.getPassword());
			ps.setInt(4, en.getId());
			status=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	public static int isDeleted(int id)
	{
		int stataus=0;
		try 
		{
			Connection con = CreateConnection.isCreate();
			String delete = "delete from student where id=?";
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setInt(1, id);
			
			stataus=ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return stataus;
	}
	public static EncapsulatedClass isSerched(String name)
	{
		EncapsulatedClass en = new EncapsulatedClass();
		try 
		{
			Connection con = CreateConnection.isCreate();
			String ser = "select * from student where name=?";
			PreparedStatement ps = con.prepareStatement(ser);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				en.setId(rs.getInt(1));
				en.setName(rs.getString(2));
				en.setEmail(rs.getString(3));
				en.setPassword(rs.getString(4));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return en;
	}
	
}
