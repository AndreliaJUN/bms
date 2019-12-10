package DataClass;

import java.util.Date;

public class Record {
   private String book_name;
   private String book_ISBN;
   private String user_name;
   private String borrow_date;
   private String return_date;
   private String huan;
   private String yuyue;
public Record(String book_name, String book_ISBN, String user_name, String dt1, String dt2, String huan,
		String yuyue) {
	
	this.book_name = book_name;
	this.book_ISBN = book_ISBN;
	this.user_name = user_name;
	this.borrow_date = dt1;
	this.return_date = dt2;
	this.huan = huan;
	this.yuyue = yuyue;
}
public Record() {
	
}
public String getBook_name() {
	return book_name;
}
public void setBook_name(String book_name) {
	this.book_name = book_name;
}
public String getBook_ISBN() {
	return book_ISBN;
}
public void setBook_ISBN(String book_ISBN) {
	this.book_ISBN = book_ISBN;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getBorrow_date() {
	return borrow_date;
}
public void setBorrow_date(String borrow_date) {
	this.borrow_date = borrow_date;
}
public String getReturn_date() {
	return return_date;
}
public void setReturn_date(String return_date) {
	this.return_date = return_date;
}
public String gethuan() {
	return huan;
}
public void sethuan(String huan) {
	this.huan = huan;
}
public String getYuyue() {
	return yuyue;
}
public void setYuyue(String yuyue) {
	this.yuyue = yuyue;
}
   
}
