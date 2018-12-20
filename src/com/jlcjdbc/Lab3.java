package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab3 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st =null;
		try {
			con=JDBCUtil.getMySQLConnection();
			//con=JDBCUtil.getOracleConnection();
			String sql = "insert into jlcstudents values(98,'Vas','vas@jlc',9898989898)";
			st=con.createStatement();
			int x = st.executeUpdate(sql);
			if(x==1) {
				System.out.println("Record inserted");;
			}else {
				System.out.println("record Not Inserted");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(st, con);
		}
	}

}
