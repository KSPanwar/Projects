package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JSPDao{
	
	String sqlQuery = "Select * from login where userName = ? and pass = ?";
	String url = "jdbc:mysql://localhost:3306/jsp_database";
	String databaseUserName = "root";
	String databasepassword = "P@nwar1234";
	public boolean isVerified(String username,String userpassword) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,databaseUserName,databasepassword);
			PreparedStatement st = conn.prepareStatement(sqlQuery);
			st.setString(1, username);
			st.setString(2, userpassword);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}