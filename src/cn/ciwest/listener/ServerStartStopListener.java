package cn.ciwest.listener;

import java.sql.Connection;

import javax.servlet.ServletContext;
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
		ServletContext application=sce.getServletContext();
		//服务器启动后，设置在线人数为0
		application.setAttribute("onlinenum", 0);
		//服务器启动后，设置网站点击次数为0
		application.setAttribute("clicknum", 0);
		System.out.println("服务器已启动");
	}

}
