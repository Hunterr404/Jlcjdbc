package com.jlcjdbc;

/*
 * delimiter $
create procedure updateStudentData(id int,OUT tot int,out avrg float,out grade char(1))
begin
declare m1 int;
declare m2 int;
declare m3 int;
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
end$
*/
//SHOW CREATE PROCEDURE updateStudentData;
import java.sql.*;
import com.jlcjdbc.JDBCUtil;
/*
 * @Author : Hunterr
 * @company : JLC
 * @see		:https://github.com/Hunterr404
 */
public class Lab12 {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement  cs = null;
		try {
			int sid = 96;
			con = JDBCUtil.getMySQLConnection();
			cs = con.prepareCall("call updateStudentData(?,?,?,?)");
			//IN Parameter
			cs.setInt(1, sid);
			//Out Parameter
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.FLOAT);
			cs.registerOutParameter(4, Types.CHAR);
			cs.execute();
			System.out.println("Procedure Executed Successfully");
			
			//Accessing the value of out parameter
			int total = cs.getInt(2);
			float avg = cs.getFloat(3);
			String grade = cs.getString(4);
			System.out.println("Total: "+total);
			System.out.println("Average: "+avg);
			System.out.println("Grade: "+grade);
		}catch(SQLException e) {
			System.out.println("Error in Calling Stored Procedure");
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanup(cs, con);
		}
	}

}
