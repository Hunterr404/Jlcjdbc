package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab15 {

	public static void main(String[] args) {
		Connection con = null;
		Statement  st = null;
		ResultSet rs = null;
		try {
			con= JDBCUtil.getMySQLConnection();
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery("select * from jlcstudents");
			System.out.println("**FOREWARD DIRECTION**");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
			}
			System.out.println("**Reverse Direction**");
			while(rs.previous()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
			}
				System.out.println("**First Record**");
				rs.first();
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
				System.out.println("**Last record**");
				rs.last();
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
				System.out.println("**4th Record**");
				rs.absolute(4);
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(st, con);
		}
	}

}
