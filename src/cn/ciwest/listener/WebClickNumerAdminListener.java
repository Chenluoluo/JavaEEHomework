package cn.ciwest.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 请求Request对象生命周期监听器
 *
 */
@WebListener
public class WebClickNumerAdminListener implements ServletRequestListener {

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	public void requestDestroyed(ServletRequestEvent arg0) {

	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent event) {
		HttpServletRequest req = (HttpServletRequest) event.getServletRequest();
		String uri = req.getRequestURI();
		String url[] = uri.split("\\.");
		// picture.setPicture(picture);
		if (url[url.length - 1].equals("jsp")) {
			ServletContext application = event.getServletContext();
			int clicknum = (Integer) application.getAttribute("clicknum") + 1;
			application.setAttribute("clicknum", clicknum);
			System.out.println("网站请求次数：" + clicknum);
		}

	}

}
