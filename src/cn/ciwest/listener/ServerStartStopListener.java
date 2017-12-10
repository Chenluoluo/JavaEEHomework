package cn.ciwest.listener;

import java.sql.Connection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cn.ciwest.factory.ConnectionFactory;

/**
 * Application Lifecycle Listener implementation class ServerStartStopListener
 *
 */
@WebListener
public class ServerStartStopListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ServerStartStopListener() {
		System.out.println("服务器正初始化");
		// 初始化数据库连接池
		try {
			Connection connection = ConnectionFactory.getConnection();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("服务器已停止");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("服务器已启动");
	}

}
