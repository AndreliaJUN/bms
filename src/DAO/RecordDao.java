package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataClass.Book;
import DataClass.Record;
import JDBC.DataBase;

public class RecordDao {
	private static String Insert_sql = "insert into borrow_message(book_name,book_ISBN,user_name,borrow_date,return_date,huan,yuyue)values(?,?,?,?,?,?,?)";
	private static String Delete_sql = "delete * from borrow_message where book_ISBN=?";
	private static String Find_sql = "select * from borrow_message where user_name=?";
	protected static final String find_all_sql = "select * from borrow_message";
	protected static final String find_by_ISBN = "select * from borrow_message where book_ISBN=? and huan=?";
	protected static final String modify_sql = "update borrow_message set return_date=?,huan=? where book_ISBN=? and huan=?";
	protected static final String modify_sql2 = "update borrow_message set yuyue=? where book_ISBN=?";

	public Record Insert(Record record) throws Exception {
		DataBase db = new DataBase();
		Connection conn = db.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		pstmt = conn.prepareStatement(Insert_sql);
		pstmt.setString(1, record.getBook_name());
		pstmt.setString(2, record.getBook_ISBN());
		pstmt.setString(3, record.getUser_name());
		pstmt.setString(4, record.getBorrow_date());
		pstmt.setString(5, record.getReturn_date());
		pstmt.setString(6, record.gethuan());
		pstmt.setString(7, record.getYuyue());

		int n = pstmt.executeUpdate();
		if (n == 1) {

			return record;
		} else {
			return null;
		}
	}

//   查找指定用户的借阅记录
	public List<Record> Find(String user_name) throws Exception {
		DataBase db = new DataBase();
		Connection conn = db.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Record> rcd = new ArrayList<Record>();

		pstmt = conn.prepareStatement(Find_sql);
		pstmt.setString(1, user_name);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Record record = new Record(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8));
			rcd.add(record);
		}
		return rcd;
	}

//   查找所有用户的借阅记录
	public List<Record> FindAll() throws Exception {
		DataBase db = new DataBase();
		Connection conn = db.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Record> user_rcd = new ArrayList<Record>();

		pstmt = conn.prepareStatement(find_all_sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Record rcd = new Record();
			rcd.setBook_name(rs.getString(2));
			rcd.setBook_ISBN(rs.getString(3));
			rcd.setUser_name(rs.getString(4));
			rcd.setBorrow_date(rs.getString(5));
			rcd.setReturn_date(rs.getString(6));
			rcd.sethuan(rs.getString(7));
			rcd.setYuyue(rs.getString(8));
			user_rcd.add(rcd);
		}
		return user_rcd;
	}
//   查找指定书的当前被借的记录

	public Record Find3(String book_ISBN, String huan) throws Exception {
		DataBase db = new DataBase();
		Connection conn = db.getDBConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		pstmt = conn.prepareStatement(find_by_ISBN);
		pstmt.setString(1, book_ISBN);
		pstmt.setString(2, huan);
		rs = pstmt.executeQuery();

		if (rs.next()) {

			Record record = new Record(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8));
			return record;
		} else {
			return null;
		}
	}

	// 修改ISBN已知且未还的图书的归还日期，并且将状态改为已还
	public boolean Modify(String return_date, String ISBN, String huan) throws Exception {
		DataBase db = new DataBase();
		Connection conn = db.getDBConnection();
		PreparedStatement pstmt = null;

		pstmt = conn.prepareStatement(modify_sql);
		// 要修改的值
		pstmt.setString(1, return_date);
		pstmt.setString(2, "已还");

		// 查询条件
		pstmt.setString(3, ISBN);
		pstmt.setString(4, huan);
		int n = pstmt.executeUpdate();
		if (n == 1) {
			return true;
		} else {
			return false;
		}

	}
	//续借，修改归还日期，但是不改变未还的状态
	public boolean Modify3(String return_date, String ISBN, String huan) throws Exception {
		DataBase db = new DataBase();
		Connection conn = db.getDBConnection();
		PreparedStatement pstmt = null;

		pstmt = conn.prepareStatement(modify_sql);
		// 要修改的值
		pstmt.setString(1, return_date);
		pstmt.setString(2, "未还");

		// 查询条件
		pstmt.setString(3, ISBN);
		pstmt.setString(4, huan);
		int n = pstmt.executeUpdate();
		if (n == 1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean Modify2(String ISBN) throws Exception {
		DataBase db = new DataBase();
		Connection conn = db.getDBConnection();
		PreparedStatement pstmt = null;

		pstmt = conn.prepareStatement(modify_sql2);
		// 要修改的值
		pstmt.setString(1, "已预约");

		// 查询条件
		pstmt.setString(2, ISBN);

		int n = pstmt.executeUpdate();
		if (n == 1) {
			return true;
		} else {
			return false;
		}

	}
}
