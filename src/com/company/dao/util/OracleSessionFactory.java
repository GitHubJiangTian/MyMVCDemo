package com.company.dao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class OracleSessionFactory {
	/**
	 * 获取连接
	 * @return 与数据库的连接
	 * @throws Exception 
	 */
/*	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mvcdemo";
		String username = "root";
		String password = "0";
		Connection con = null;
		con = DriverManager.getConnection(url,username,password);
		return con;
	}*/
	
	private DataSource ds;
	private static OracleSessionFactory sessionFactory;
	
	private OracleSessionFactory() {
		ds = new ComboPooledDataSource("oracle");
	}
	
	public static OracleSessionFactory getInstance() {
		if(sessionFactory == null) {
			sessionFactory = new OracleSessionFactory();
		}
		return sessionFactory;
	}
	
	public Connection getSession() throws Exception {
		Connection con = ds.getConnection();
		return con;
	}
	/**
	 * 关闭资源
	 * @param rs 结果集
	 * @param ps 动态引用，用父接口类型接收子类接口对象
	 * @param con 连接
	 */
	public static void close(ResultSet rs, Statement ps, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
