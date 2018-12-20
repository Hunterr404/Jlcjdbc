package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */

public class Lab4 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st =null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getMySQLConnection();
			//con = JDBCUtil.getOracleConnection();
			String qry = "Select * from jlcstudents";
			st = con.createStatement();
			rs = st.executeQuery(qry);
			if(rs.next()) {
				do {
					int sid = rs.getInt(1);
					String nm = rs.getString(2);
					String eml = rs.getString(3);
					Long phn = rs.getLong(4);
					System.out.println(sid+"\t"+nm+"\t"+eml+"\t"+phn);
				}while(rs.next());
			}else
				System.out.println("No Record Found");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(rs, st, con);
		}
	}

}

