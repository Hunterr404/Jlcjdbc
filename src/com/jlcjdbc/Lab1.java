package com.jlcjdbc;
import java.sql.*;
public class Lab1 {
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dharmudb", "root", "dharmu");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Anonymous", "dharmu");
			String sql = "insert into jlcstudents values (66,'Aman','Aman@jlc',54445554)";
			st = con.createStatement();
			int x = st.executeUpdate(sql);
			if(x==1) {
				System.out.println("Record Inserted");
			}else
				System.out.println("Record not Inserted");
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
