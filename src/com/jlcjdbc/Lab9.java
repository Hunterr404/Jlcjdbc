package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab9 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement  ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getMySQLConnection();
			int sid = 96;
			String qry = "select * from jlcstudents where sid=?";
			ps = con.prepareStatement(qry);
			ps.setInt(1,sid);
			rs = ps.executeQuery();

			if(rs.next()) {
				int id = rs.getInt(1);
				String nm = rs.getString(2);
				String eml = rs.getString(3);
				long phn = rs.getLong(4);
				System.out.println(id+"\t"+nm+"\t"+eml+"\t"+phn);
				}else
					System.out.println("Sorry Record Not Found");
					
			
			}catch(Exception e) {
				e.printStackTrace();
			
		}finally {
			JDBCUtil.cleanup(rs,ps, con);
		}
	}

	}


