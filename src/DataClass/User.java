package DataClass;

public class User {
	private String user_id;
  private String user_name;
  private String user_password;
public User() {}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getUser_password() {
	return user_password;
}
public void setUser_password(String user_password) {
	this.user_password = user_password;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public User( String user_name, String user_password) {
//	this.user_id = user_id;
	this.user_name = user_name;
	this.user_password = user_password;
}
public User(String user_name) {
	super();
	this.user_name = user_name;
}

  
}
