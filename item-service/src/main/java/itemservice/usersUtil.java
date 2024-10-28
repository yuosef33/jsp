package itemservice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class usersUtil {
	
private DataSource DS;
public usersUtil(DataSource dataSource) {
	this.DS = dataSource;
}

public List<users> getAllUsers()throws SQLException{
	
	Connection con = null;
	Statement stat = null;
	try {	
		con = DS.getConnection();
		stat = con.createStatement();
		String sql = "select * from users";		
		ResultSet resultSet = stat.executeQuery(sql);
		List<users> allUsers=new ArrayList();		
		while(resultSet.next()) {
			users user=new users();
			user.setId(resultSet.getInt("user_id"));
			user.setUser_name(resultSet.getString("user_name"));
			user.setPassword(resultSet.getString("password"));
		allUsers.add(user);
				
		}
		return allUsers;
		
		}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.getMessage();
	} finally {
		con.close();
		stat.close();
	}
	return new ArrayList();
}
 



public void addUser (String un,String pass) throws SQLException{
	Connection con = null;
	PreparedStatement stat = null;
	try {
		con = DS.getConnection();
		String sql = "INSERT INTO users (user_name,password)"
				+"VALUES (?,?)";
		stat = con.prepareStatement(sql);
		stat.setString(1, un);
		stat.setString(2, pass);
		stat.execute();	
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	} finally {
		con.close();
		stat.close();
	}
	
}













}
