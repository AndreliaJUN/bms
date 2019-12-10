package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
	public Connection getDBConnection()throws Exception{ 
		  String driverName="com.mysql.jdbc.Driver";
		  String userName="root";
		  String userPwd="199924";
		  String dbName="library";
		  String url1="jdbc:mysql://localhost:3306/"+dbName;
		  String url2="?user="+userName+"&password="+userPwd;
		  String url3="&userUnicode=true&characterEncoding=UTF-8";
		  String url=url1+url2+url3;
		  Class.forName(driverName);
		  Connection conn=DriverManager.getConnection(url);
		  return conn;
	  }
	  public void free(Connection conn,PreparedStatement stmt,ResultSet rs) throws SQLException {
		  if(rs!=null) rs.close();
		  if(stmt!=null) stmt.close();
		  if(conn!=null) conn.close();
	  }
}
