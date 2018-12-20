package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab8 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement  ps = null;
		
		try {
			con = JDBCUtil.getMySQLConnection();
			int sid = 95;
			String nm = "Nivas";
			String em = "nivas@jlc.com";
			long phn = 959595959595L;
			String qry = "insert into jlcstudents values(?,?,?,?)";
			ps = con.prepareStatement(qry);
			ps.setInt(1,sid);
			ps.setString(2, nm);
			ps.setString(3, em);
			ps.setLong(4, phn);
			int x = ps.executeUpdate();
			if(x==1) {
				System.out.println("Record Inserted Successfully");
				}else
					System.out.println("No Record Found");
					
			
			}catch(Exception e) {
				e.printStackTrace();
			
		}finally {
			JDBCUtil.cleanup(ps, con);
		}
	}

}
