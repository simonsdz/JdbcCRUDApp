package com.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {

	// to avoid object creation
	private JdbcUtil() {
	}

	// loading and registering the Driver
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Connection connection = null;

	// creating a connection through Hikaricp jar
	public static Connection getJdbcConnection() throws SQLException {
		HikariConfig config = new HikariConfig(
				"C:\\Users\\003XPG744\\eclipse-workspace\\CRUDApp\\src\\com\\properties\\application.properties");
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource.getConnection();
	}
}
