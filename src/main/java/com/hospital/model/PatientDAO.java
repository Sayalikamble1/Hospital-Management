package com.hospital.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {
	
	public int addPatient(Patient patient1) throws ClassNotFoundException,SQLException
	{
		 int count =0;
		String sql= "insert into hospital( PtientId,Name,Address,Phone)values(?,?,?,?)";
	
		Connection con=CreateConnection.getConnection();
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setInt(1,patient1.getPatientid());
		prst.setString(2,patient1.getName());
		prst.setString(3, patient1.getAddress());
		prst.setInt(4, patient1.getPhone());
		
		count=prst.executeUpdate();
		
		return count;
	}
	public Patient viewPatient(int pid)throws ClassNotFoundException,SQLException
	{
	
		Patient p=new Patient();
		Connection con=CreateConnection.getConnection();
		String sql= "select * from hospital where  PtientId=?";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setInt(1, pid);
		ResultSet rs=prst.executeQuery();
		while(rs.next())
		{
			p.setPatientid(rs.getInt("PtientId"));
			p.setName(rs.getString("Name"));
			p.setAddress(rs.getString("Address"));
			p.setPhone(rs.getInt("Phone"));
		}
		return p;
	}
	public  int updatePatient(int ptid,String ptname,String paddr,long phone)throws ClassNotFoundException,SQLException
	{
		
		Connection con=CreateConnection.getConnection();
		String sql="update hospital set Name=?,Address=?,Phone=? where PtientId=?";
		
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setInt(4,ptid);
		prst.setString(1, ptname);
		prst.setString(2, paddr);
		prst.setLong(3,phone);
		
		int c=prst.executeUpdate();
	return c;
		
	}
	public int deletePatient(int pid)throws ClassNotFoundException,SQLException
	{
		Patient p=new Patient();
		Connection con=CreateConnection.getConnection();
		String sql= "delete from hospital where PtientId=?";
		PreparedStatement prst=con.prepareStatement(sql);
		prst.setInt(1, pid);
		int c=prst.executeUpdate();
		return c;
	
	}

}