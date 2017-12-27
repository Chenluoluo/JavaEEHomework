package cn.ciwest.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Session属性变化监听器
 *
 */
@WebListener
public class OnlineNumerAdminListener implements HttpSessionAttributeListener {

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = event.getName();
		if (name.equals("user")) {
			ServletContext application = event.getSession().getServletContext();
			int num = (Integer) application.getAttribute("onlinenum") + 1;
			application.setAttribute("onlinenum", num);
			System.out.println("当前在线人数：" + num);
		}

	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name = event.getName();
		if (name.equals("user")) {
			ServletContext application = event.getSession().getServletContext();
			int num = (Integer) application.getAttribute("onlinenum") - 1;
			application.setAttribute("onlinenum", num);
			System.out.println("当前在线人数：" + num);
		}

	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent arg0) {

	}

}
