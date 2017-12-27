package cn.ciwest.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ciwest.factory.ServiceFactory;
import cn.ciwest.model.Message;
import cn.ciwest.model.User;

/**
 * Servlet implementation class MessageWriteAction
 */
@WebServlet("/message/write.do")
public class MessageWriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageWriteAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String username = ((User) session.getAttribute("user")).getUsername();
		String content = request.getParameter("content");
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

		Message message = new Message();
		message.setUsername(username);
		message.setContent(content);
		message.setTime(time);

		try {
			ServiceFactory.createMessageServer().createMessage(message);
			System.out.println("留言成功");
			response.sendRedirect("message.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("留言失败");
			response.sendRedirect("writeFailed.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
