package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab7 {

	public static void main(String[] args) {
		Connection con = null;
		Statement  st = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getMySQLConnection();
			
			String qry = null;
			qry = "select * from jlcstudents";
			//qry = "insert into jlcstudents values(96,'DandeS','dande@jlc',96969696)";
			
			st = con.createStatement();
			boolean b1 = st.execute(qry);
			if(b1) {
				rs = st.getResultSet();
				if(rs.next()) {
					do {
						int sid = rs.getInt(1);
						String nm = rs.getString(2);
						String em = rs.getString(3);
						long phn = rs.getLong(4);
						System.out.println(sid+"\t"+nm+"\t"+em+"\t"+phn);
					}while(rs.next());
				}
			}
			
			else {
				int x = st.getUpdateCount();
				System.out.println("Result: "+ x);
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(rs,st, con);
		}
	}

}
