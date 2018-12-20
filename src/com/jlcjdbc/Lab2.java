package com.jlcjdbc;
import java.sql.*;
public class Lab2 {
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
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "Anonymous", "dharmu");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dharmudb", "root", "dharmu");
			String sql = "select * from jlcstudents";
			st = con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				int sid = rs.getInt(1);
				String sn = rs.getString(2);
				String em = rs.getString(3);
				long ph = rs.getLong(4);
				System.out.println(sid+"\t"+sn+"\t"+em+"\t"+ph);
			}
				
			
		}catch(Exception e) {
					e.printStackTrace();
			}
		
		/*finally {
			try {
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}*/
		}

}