package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DataClass.Manager;
import JDBC.DataBase;

public class ManagerDao {
	protected static final String insert_sql="insert into manager(manager_id,manager_name,manager_password)values(?,?,?)";
	   protected static final String delete_sql="delete from manager where manager_name=?";
	   protected static final String find_sql="select * from manager where manager_name=?";
	   protected static final String modefy_sql="update manager set manager_id=?,manager_name=?,manager_password=?where manager_name=?";
	   
	

	   public boolean find(Manager manager)throws Exception
	   {
		   DataBase db =new DataBase();
		   Connection conn=db.getDBConnection();
		   PreparedStatement pstmt=null;
		   ResultSet rs=null;
		   
			   pstmt=conn.prepareStatement(find_sql);
			  
			   pstmt.setString(1,manager.getManager_name());
			   
			   rs=pstmt.executeQuery();
			   if(rs.next()) {
				   return true;
			   }
			   return false;
		  
//			   db.free(conn, pstmt, rs);
		   
	   }
}
