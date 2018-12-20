package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab16 {

	public static void main(String[] args) {
		Connection con = null;
		Statement  st = null;
		ResultSet rs = null;
		try {
			con= JDBCUtil.getMySQLConnection();
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select sid,sname,semail,sphone from jlcstudents");
			System.out.println("**ALL REcords**");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getLong(4));
			}
				System.out.println("**INSERTING RECORD**");
				rs.moveToInsertRow();
				rs.updateInt(1, 999);
				rs.updateString(2, "DK");
				rs.updateString(3, "dk@jkc.com");
				rs.updateLong(4, 31909590);
				rs.insertRow();
				System.out.println("Record Inserted");
				
				System.out.println("**Updating 2nd Record**");
				rs.absolute(2);
				rs.updateString(2, "manish");
				rs.updateString(3, "manish@jlc");
				rs.updateLong(4, 41275999);
				rs.updateRow();
				System.out.println("record updated");
				
				System.out.println("** Deleting 3rd Record **");
				rs.absolute(3);
				rs.deleteRow();
				System.out.println("**Record Deleted**");
				
			
		}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.cleanup(st, con);
			}
	}

}
