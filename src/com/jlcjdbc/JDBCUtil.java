package com.jlcjdbc;
import java.sql.*;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class JDBCUtil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {
			System.out.println(ex);
		}		
	}

public static Connection getOracleConnection()throws SQLException{
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	Connection con = DriverManager.getConnection(url,"Anonymous","dharmu");
	return con;
}
public static Connection getMySQLConnection()throws SQLException{
	String url = "jdbc:mysql://localhost:3306/dharmudb";
	Connection con = DriverManager.getConnection(url,"root","dharmu");
	return con;
}
public static void cleanup(Statement st , Connection con) {
	try {
		if(st!=null)
			st.close();
		if(con!=null)
			con.close();
	}catch(Exception ex) {
		System.out.println(ex);
	}
}
public static void cleanup(ResultSet rs, Statement st , Connection con) {
	try {
		if(rs!=null)
			rs.close();
		if(st!=null)
			st.close();
		if(con!=null)
			con.close();
	}catch(Exception ex) {
		System.out.println(ex);
	}
}

}