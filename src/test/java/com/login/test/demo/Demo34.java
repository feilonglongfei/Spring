package com.login.test.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo34 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con = null;
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con = DriverManager.getConnection("jdbc:odbc:ss", "sa", "");
		
		String sql = null;
		PreparedStatement preStatement = con.prepareStatement(sql);
		Statement statement = con.createStatement();
		
		preStatement.execute();
		statement.execute(sql);
		

	}
}
