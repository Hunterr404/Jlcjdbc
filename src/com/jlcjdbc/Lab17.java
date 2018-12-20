package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab17 {

	public static void main(String[] args) throws Exception{
		Connection con = JDBCUtil.getMySQLConnection();
		DatabaseMetaData md = con.getMetaData();
		System.out.println("URL :"+md.getURL());
		System.out.println("User :"+md.getUserName());
		System.out.println("Major Version"+md.getDatabaseMajorVersion());
		System.out.println("Minor Version"+md.getDatabaseMinorVersion());
		System.out.println("Full JOin :"+md.supportsFullOuterJoins());
		System.out.println("Product Name :"+md.getDatabaseProductName());
		System.out.println("Multiple RS :"+md.supportsMultipleOpenResults());
		System.out.println("DB"+md.getDatabaseProductName());
		System.out.println("DefaultTransactionIsolation: "+md.getDefaultTransactionIsolation());
		System.out.println("DriverName:" +md.getDriverName());
		System.out.println("JDBCMajorVersion : "+md.getJDBCMajorVersion());
		System.out.println("JDBCMinorVersion :"+md.getJDBCMinorVersion());
		
	}

}
