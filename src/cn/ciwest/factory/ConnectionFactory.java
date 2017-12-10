package cn.ciwest.factory;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ConnectionFactory {
	public static Connection getConnection() throws Exception {
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		Connection cn = dataSource.getConnection();
		// Class.forName("com.mysql.jdbc.Driver");
		// Connection
		// cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/homework","root","19971018cx");
		// System.out.println("数据库连接成功");
		return cn;
	}
}