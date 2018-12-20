package com.jlcjdbc;
import javax.sql.rowset.*;

/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab19 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		CachedRowSet rs = RowSetProvider.newFactory().createCachedRowSet();//new since java 9
		
		rs.setUrl("jdbc:mysql://localhost:3306/dharmudb");
		rs.setUsername("root");
		rs.setPassword("dharmu");
		rs.setCommand("select sid,sname,semail,sphone from jlcstudents");
		rs.execute();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
		}
		rs.absolute(1);
		rs.updateString(2, "Dande");
		rs.updateString(3, "Dande@jlc.com");
		rs.updateLong(4, 31904567);
		rs.acceptChanges();
		System.out.println("Updated");
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	

	}
}