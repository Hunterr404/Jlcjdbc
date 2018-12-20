package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab13 {

	public static void main(String[] args) {
		Connection con = null;
		Statement  st = null;
		try {
			con = JDBCUtil.getMySQLConnection();
			st = con.createStatement();
			String s1 = "insert into jlcstudents values(19,'Sri','sri@jlc',9898989898)";
			st.addBatch(s1);
			String s2 = "insert into jlcstudents values(18,'Nivas','nivas@jlc',565656566)";
			st.addBatch(s2);
			String s3 = "insert into jlcstudents values(17,'Dande','dande@jlc',32323232332)";
			st.addBatch(s3);
			String s4 = "insert into jlcstudents values(14,'Babajee','babajee@jlc',121212121221)";
			st.addBatch(s4);
			String s5 = "update jlcstudents set sphone = 3290347895 , semail = 'Hero@gmail.com' where sid=77";
			st.addBatch(s5);
			String s6 = "delete from jlcstudents where sid=99";
			st.addBatch(s6);
			int x[] = st.executeBatch();
			for(int i=0; i<x.length;i++) {
				System.out.println(x[i]);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanup(st, con);
		}
		
	}

}
