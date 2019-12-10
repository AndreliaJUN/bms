package DataClass;

public class Manager {
  private String manager_id;
  private String manager_name;
  private String manager_password;
public Manager(String manager_name, String manager_password) {
//	this.manager_id=manager_id;
	this.manager_name = manager_name;
	this.manager_password = manager_password;
}
public Manager() {}
public String getManager_name() {
	return manager_name;
}
public void setManager_name(String manager_name) {
	this.manager_name = manager_name;
}
public String getManager_password() {
	return manager_password;
}
public void setManager_password(String manager_password) {
	this.manager_password = manager_password;
}
public String getManager_id() {
	return manager_id;
}
public void setManager_id(String manager_id) {
	this.manager_id = manager_id;
}
  
}
