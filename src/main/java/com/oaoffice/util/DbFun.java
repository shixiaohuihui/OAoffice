package com.oaoffice.util;

import java.io.IOException;
import java.sql.*;

import org.apache.log4j.Logger;

public class DbFun {
	
	static Logger logger = Logger.getLogger(DbFun.class);

	public static String filename="/database.properties";
	
	public static String driverClassName;
	public static String url;
	public static String user;
	public static String password;
	static {
		java.util.Properties prop=new java.util.Properties();
		
		try {
			prop.load(DbFun.class.getResourceAsStream(filename));
			driverClassName=prop.getProperty("driverClassName");
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(filename+"不存在.");
		}
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String msg="类全名【"+driverClassName+"】没有找到.";
			logger.error(msg);
		}
	}

	public static Connection getConn() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {

			// e.printStackTrace();
			String msg="类全名【\" + driverClassName + \"】没有找到。";
			logger.error(msg);
		}

		Connection conn = null;
		try {
			// 使用驱动管理器DriverManager，创建一个连接对象conn
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// e.printStackTrace();
			//System.out.println("连接数据库失败，请检查四大金刚的相关参数。");
			
			String msg="连接数据库失败，请检查四大金刚的相关参数。";
			logger.error(msg);
		}
		return conn;
	}

	public static void closeConn(Connection conn) {
		// 如果conn不为null，则关闭它
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeSt(Statement st) {
		// 如果st不为null，则关闭它
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeRs(ResultSet rs) {
		// 如果rs不为null，则关闭它
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs, Statement st, Connection conn) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);

	}

	public static int update(String sql) {

		// 三大对象
		Connection conn = null;
		Statement st = null;
		// ResultSet rs = null;
		int result = 0;
		try {
			// 创建conn
			conn = DbFun.getConn();
			// 使用conn，创建语句对象st
			st = conn.createStatement();
			// 使用st，创建结果集对象rs
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			// 如果conn不为null，则关闭它
			DbFun.close(null, st, conn);
		}
		return result;
	}

	public static ResultSet query(String sql) {

		// 三大对象
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int result = 0;

		try {
			// 创建conn
			conn = DbFun.getConn();
			// 使用conn，创建语句对象st
			st = conn.createStatement();
			// 使用st，创建结果集对象rs
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 如果conn不为null，则关闭它
			// DbFun.close(null, st, conn);
		}

		return rs;
	}

}
