package com.official.web.tool.tpl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public final class JdbcUtils {
	private static String url = "localhost";
//	private static String url = "jdbc:mysql://59.110.218.135:3306/g4m";
	private static String databaseName = "g4m";
	private static String user = "root";
	private static String password = "Murong123";
	private static DataSource myDataSource = null;


	public static DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		// config.setMaximumPoolSize(db_max_conn);
		config.setDataSourceClassName("com.mysql.cj.jdbc.MysqlDataSource");
//		config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
		config.addDataSourceProperty("serverName", url);
		config.addDataSourceProperty("port", 5555);
		config.addDataSourceProperty("databaseName", databaseName);
		config.addDataSourceProperty("user", user);
		config.addDataSourceProperty("password", password);
		return new HikariDataSource(config);
	}
	
	
	private JdbcUtils() {

	}

	static {
		try {
			// 1.注册
			// Class.forName("com.mysql.jdbc.Driver");
			// Properties prop = new Properties();
			// InputStream is =
			// JdbcUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			// prop.load(is);
			// 使用的是DBCP方式来加载数据库连接信息
			myDataSource = dataSource();
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}


	// 获得数据源
	public static DataSource getDataSource() {
		return myDataSource;
	}

	public static Connection getConnection() throws SQLException {
		return myDataSource.getConnection();
	}

	public static void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null)
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}
	}
}
