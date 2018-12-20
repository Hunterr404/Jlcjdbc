package com.jlcjdbc;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
/*
  delimiter $$
create procedure updateStudentResult(id int)
begin
declare m1 int;
declare m2 int;
declare m3 int;
declare tot int;
declare avrg float;
declare grade char(1);
select marks1, marks2, marks3 into m1,m2,m3 from students where sid = id;
set tot = m1+m2+m3;
set avrg = tot/3;
if(avrg>=85) then
set grade = 'A';
elseif(avrg>=75) then
set grade = 'B';
elseif(avrg>=65)then
set grade = 'C';
else 
set grade = 'D';
end if;
update students set total = tot, average = avrg, grade = grade where sid=id;
end$$
*/
/*
 * SHOW CREATE PROCEDURE updateStudentResult;//shows stored procedure
 */
public class Lab11 {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement  cs = null;
		try {
			int sid = 97;
			con = JDBCUtil.getMySQLConnection();
			cs = con.prepareCall("call updateStudentResult(?)");
			cs.setInt(1, sid);
			cs.execute();
			System.out.println("Procedure Executed Successfully");
		}catch(SQLException e) {
			System.out.println("Error in Calling Stored Procedure");
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanup(cs, con);
		}
	}

}
