package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataClass.Record;
import DataClass.User;
import JDBC.DataBase;

public class UserDao {
   protected static final String insert_sql="insert into user(user_name,user_password)values(?,?)";
   protected static final String delete_sql="delete from user where user_name=?";
   protected static final String find_sql="select * from user where user_name=?";
   protected static final String modefy_sql="update user set user_id=?,user_name=?,user_password=?where user_name=?";
  
   
   public boolean Insert(User user) throws Exception
   {
	   DataBase db=new DataBase();
	   Connection conn=db.getDBConnection();
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	  
		   pstmt=conn.prepareStatement(insert_sql);
//		   pstmt.setString(1, user.getUser_id());
		   pstmt.setString(1, user.getUser_name());
		   pstmt.setString(2, user.getUser_password());
		   int n =pstmt.executeUpdate();
		   if(n==1) {
			   return true;
		   }else {
			   return false;
		   }
	  
//		   db.free(conn, null, rs);
	   
	
	  
   }
   public boolean find(User user)throws Exception
   {
	   DataBase db =new DataBase();
	   Connection conn=db.getDBConnection();
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	   
		   pstmt=conn.prepareStatement(find_sql);
		  
		   pstmt.setString(1,user.getUser_name());
		  
		   rs=pstmt.executeQuery();
		   if(rs.next()) {
			   return true;
		   }
		   return false;
	  

	   
   }
   public boolean delete(User user)throws Exception
   {
	   DataBase db=new DataBase();
	   Connection conn=db.getDBConnection();
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	  
		   pstmt=conn.prepareStatement(delete_sql);
		   pstmt.setString(1, user.getUser_name());
		
		   int n =pstmt.executeUpdate();
		   if(n==1) {
			   return true;
		   }else {
			   return false;
		   } 
   }
   
}
