package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab18 {

	public static void main(String[] args) {
		Connection con = null;
		Statement  st = null;
		ResultSet rs = null;
		try {
			con= JDBCUtil.getMySQLConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from jlcstudents");
			ResultSetMetaData md = rs.getMetaData();
			int cols = md.getColumnCount();
			System.out.println("Columns :"+cols);
			for(int i=1; i<=cols;i++) {
				String  clsNm= md.getColumnClassName(i);
				String colNm = md.getColumnName(i);
				String tabNm = md.getTableName(i);
				String tNm = md.getColumnTypeName(i);
				int size = md.getPrecision(i);
				System.out.println(colNm+"\t\t"+tabNm+"\t\t"+clsNm+"\t\t"+size);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanup(st, con);
		}

	}

}
