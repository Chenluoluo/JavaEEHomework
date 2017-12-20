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
import cn.ciwest.model.Comment;
import cn.ciwest.model.User;

/**
 * Servlet implementation class CommentEditAction
 */
@WebServlet("/comment/edit.do")
public class CommentEditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentEditAction() {
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
		int blognumber = Integer.parseInt(request.getParameter("blognumber"));
		String username = ((User) session.getAttribute("user")).getUsername();
		String content = request.getParameter("content");
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Comment comment = new Comment();
		comment.setBlognumber(blognumber);
		comment.setUsername(username);
		comment.setContent(content);
		comment.setTime(time);
		try {
			ServiceFactory.createCommentServer().createComment(comment);
			System.out.println("评论成功");
			response.sendRedirect("../home.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("评论失败");
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
