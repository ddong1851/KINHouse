package com.ssafy.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/happyhouse?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static final String DB_ID = "ssafy";
	private static final String DB_PASS = "ssafy";

	private static DBUtil instance = new DBUtil();

	private DBUtil() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, DB_ID, DB_PASS);
	}

	public void close(AutoCloseable... closeables) {
		for (AutoCloseable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}