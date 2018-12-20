package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab6 {

	public static void main(String[] args) {
		Connection con = null;
		Statement  st = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getMySQLConnection();
			int sid = 97;
			
			String qry = String.format("select * from jlcstudents where sid=%d", sid);
			
			st = con.createStatement();
			rs = st.executeQuery(qry);
					
			if(rs.next()) {
				int id = rs.getInt(1);
				String nm = rs.getString(2);
				String eml = rs.getString(3);
				long phn = rs.getLong(4);
				System.out.println(id+"\t"+nm+"\t"+eml+"\t"+phn);
			}
			else
				System.out.println("Sorry Student not Found");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(st, con);
		}
	}
	}


