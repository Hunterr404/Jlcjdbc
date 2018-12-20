package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab5 {

	public static void main(String[] args) {
		Connection con = null;
		Statement  st = null;
		try {
			con = JDBCUtil.getMySQLConnection();
			int sid = 97;
			String nm = "Manish";
			String em = "manish@jlc.com";
			long phn = 9797979797797L;
			String qry = String.format("insert into jlcstudents values(%d,'%s','%s',%d)", sid,nm,em,phn);
			System.out.println(qry);
			st = con.createStatement();
			int x = st.executeUpdate(qry);
			if(x==1)
				System.out.println("Record Inserted Successfully");
			else
				System.out.println("No Record Found");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(st, con);
		}
	}

}
