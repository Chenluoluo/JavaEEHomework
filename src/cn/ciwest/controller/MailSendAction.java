package cn.ciwest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciwest.tool.MailTool;

import cn.ciwest.model.Mail;

/**
 * Servlet implementation class MailSendAction
 */
@WebServlet("/mailsend.do")
public class MailSendAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailSendAction() {
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
		String from = request.getParameter("form");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		Mail mail = new Mail();
		mail.setFrom(from);
		mail.setSubject(subject);
		mail.setContent(content);
		try {
			MailTool.sendMail(mail);
			System.out.println("邮件发送成功");
			response.sendRedirect("home.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("邮件发送失败");
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
