package org.itstep.javaee.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection() {
		Connection cons = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cons = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/quentinha?useTimezone=true&serverTimezone=UTC&useSSL=false", "root",
					"Leo76987878");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cons;
	}
}