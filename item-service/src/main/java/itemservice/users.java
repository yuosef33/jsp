package itemservice;

public class users {
private int id;	
private String user_name;
private String password;




public users() {
	
}

public users(int id, String user_name, String password) {

	this.id = id;
	this.user_name = user_name;
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}
