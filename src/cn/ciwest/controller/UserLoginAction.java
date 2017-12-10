package cn.ciwest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ciwest.factory.ServiceFactory;
import cn.ciwest.model.User;

/**
 * Servlet implementation class UserLoginAction
 */
@WebServlet("/user/login.do")
public class UserLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginAction() {
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
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		
		try {
			if (ServiceFactory.createUserService().getUser(username) == null) {
				System.out.println("用户"+username+"不存在");
				response.sendRedirect("login.jsp");
			} else {
				user = ServiceFactory.createUserService().getUser(username);
				System.out.println("用户"+username+"存在");
				if(user.getPassword().equals(password)) {
					System.out.println("用户："+username+" 登录成功");
					session.setAttribute("user", user);
					response.sendRedirect("../home.jsp");
				} else {
					System.out.println("用户："+username+" 密码错误");
					response.sendRedirect("login.jsp");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
