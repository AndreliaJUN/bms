package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataClass.Book;
import JDBC.DataBase;

public class BookDao {
   protected static final String insert_sql="insert into book(book_name,book_author,book_ISBN,book_price,book_state)values(?,?,?,?,?)";
   protected static final String find_sql="select * from book where book_ISBN=? ";
   protected static final String delete_sql="delete from book where book_ISBN=? ";
   protected static final String modify_sql="update book set book_name=?,book_author=?,book_ISBN=?,book_price=?,book_state=? where book_ISBN=?";
   protected static final String modify_bookState_sql="update book set book_state=? where book_ISBN=?";
   protected static final String find_all_sql="select * from book";
//   增加图书记录
   public boolean Insert(Book book)throws Exception{
	   DataBase db=new DataBase();
	   Connection conn=db.getDBConnection();
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	  
		   pstmt=conn.prepareStatement(insert_sql);
//		   pstmt.setString(1, book.getBook_id());
		   pstmt.setString(1, book.getBook_name());
		   pstmt.setString(2, book.getBook_author());
		   pstmt.setString(3, book.getBook_ISBN());
		   pstmt.setString(4, book.getBook_price());
		   pstmt.setString(5, book.getBook_state());
		   int n=pstmt.executeUpdate();
		   if(n==1) {
			   return true;
		   }
		   else
			   return false;

   }
   
//   查找图书记录
   public boolean Find(Book book)throws Exception{
	   DataBase db=new DataBase();
	   Connection conn=db.getDBConnection();
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	   
	   pstmt=conn.prepareStatement(find_sql);
	   pstmt.setString(1, book.getBook_ISBN());
	   rs=pstmt.executeQuery();
	   if(rs.next()) {
		   return true;
	   }else {
		   return false;
	   }
   }
   
//   删除图书记录
   public boolean Delete(Book book)throws Exception{
	   DataBase db=new DataBase();
	   Connection conn=db.getDBConnection();
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	   
	   pstmt=conn.prepareStatement(delete_sql);
	   pstmt.setString(1, book.getBook_ISBN());
	   int n=pstmt.executeUpdate();
	   if(n==1) {
		   return true;
	   }
	   else return false;
   }
   
//   修改图书记录
   public boolean Modify(Book book2,String ISBN3)throws Exception{
	   DataBase db=new DataBase();
	   Connection conn=db.getDBConnection();
	   PreparedStatement pstmt=null;
	   
	   pstmt=conn.prepareStatement(modify_sql);
	   pstmt.setString(1, book2.getBook_name());
	   pstmt.setString(2,book2.getBook_author());
	   pstmt.setString(3, book2.getBook_ISBN());
	   pstmt.setString(4, book2.getBook_price());
	   pstmt.setString(5, book2.getBook_state());
	   pstmt.setString(6,ISBN3);
//	   System.out.println(ISBN3);
	   int n=pstmt.executeUpdate();
	  
	   if(n==1)return true;
	   else return false;
   }
//   查找图书,返回图书
   public Book Find2(String ISBN)throws Exception{
	   DataBase db=new DataBase();
	   Connection conn=db.getDBConnection();
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	   
	   pstmt=conn.prepareStatement(find_sql);
	   pstmt.setString(1, ISBN);
	   rs=pstmt.executeQuery();
	   if(rs.next()) {
		   Book book=new Book(rs.getString(2),rs.getString(3),ISBN,rs.getString(5),rs.getString(6));
		   return book;
	   }else {
		   return null;
	   }
   }
   public boolean Modify2(String ISBN,String state)throws Exception{
	   DataBase db=new DataBase();
	   Connection conn=db.getDBConnection();
	   PreparedStatement pstmt=null;
	   
	   pstmt=conn.prepareStatement(modify_bookState_sql);
	   pstmt.setString(1, state);
	   pstmt.setString(2,ISBN);
	   int n=pstmt.executeUpdate();
	   if(n==1) {
		   return true;
	   }else {
		   return false;
	   } 
   }
   //将所有图书信息找出来
   public List<Book>FindAll()throws Exception{
	   DataBase db=new DataBase();
	   Connection conn=db.getDBConnection();
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	   
	   pstmt=conn.prepareStatement(find_all_sql);
	   rs=pstmt.executeQuery();
	   List<Book>bk=new ArrayList<Book>();
	   while(rs.next()) {
		   Book book=new Book();
		   book.setBook_name(rs.getString(2));
		   book.setBook_author(rs.getString(3));
		   book.setBook_ISBN(rs.getString(4));
		   book.setBook_price(rs.getString(5));
		   book.setBook_state(rs.getString(6));
		   bk.add(book);
	   }
	   return bk;
   }
}
