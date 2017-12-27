package cn.ciwest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ciwest.factory.ServiceFactory;

/**
 * Servlet implementation class CommentRemoveAction
 */
@WebServlet("/comment/remove.do")
public class CommentRemoveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentRemoveAction() {
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
		String author = request.getParameter("author");
		int blognumber = Integer.parseInt(request.getParameter("blognumber"));

		int number = Integer.parseInt(request.getParameter("number"));

		try {
			ServiceFactory.createCommentServer().removeComment(number);
			System.out.println("评论删除成功");
			response.sendRedirect("../blog/view.jsp?number=" + blognumber + "&author=" + author);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("评论删除失败");
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
