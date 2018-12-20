package com.jlcjdbc;
import java.sql.*;
import java.util.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab14 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement  ps = null;
		try {
			con = JDBCUtil.getMySQLConnection();
			String sql = "insert into jlcstudents (sid,sname) values(?,?)";
			ps = con.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			char choice = 'Y';
			do {
				System.out.println("enter Name");;
				String nm = sc.nextLine();
				System.out.println("Enter id");;
				int id = sc.nextInt();
				ps.setInt(1, id);
				ps.setString(2, nm);
				ps.addBatch();
				System.out.println("Do you want to add more: ");
				sc.nextLine();
				choice = sc.nextLine().charAt(0);
			}while(choice=='y');
			int res[] = ps.executeBatch();
			for(int i=0;i<res.length;i++) {
				System.out.println("RES: "+res[i]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.cleanup(ps, con);
		}
	}

}
