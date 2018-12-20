package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab10 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement  ps = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getMySQLConnection();
			
			String qry = null;
			//qry = "update jlcstudents set phone=90909009090";
			//qry = "insert into jlcstudents values(94,'Kumar','kumar@jlc',9494949494)";
			qry = "select * from jlcstudents";
			ps = con.prepareStatement(qry);
			boolean b1 = ps.execute();
			if(b1) {
				rs = ps.getResultSet();
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
				int x = ps.getUpdateCount();
				System.out.println("Result: "+ x);
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(rs,ps, con);
		}
	}

	}


