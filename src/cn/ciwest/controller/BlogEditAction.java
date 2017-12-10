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
import cn.ciwest.model.Blog;
import cn.ciwest.model.User;

/**
 * Servlet implementation class BlogEditAction
 */
@WebServlet("/blog/edit.do")
public class BlogEditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogEditAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String title = request.getParameter("title");
		String author = ((User) session.getAttribute("user")).getUsername();
		String type = request.getParameter("type");
		String decoration = request.getParameter("decoration");
		String create_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String alter_time = "";
		String text = request.getParameter("text");
		Blog blog = new Blog();
		blog.setTitle(title);
		blog.setAuthor(author);
		blog.setType(type);
		blog.setDecoration(decoration);
		blog.setCreate_time(create_time);
		blog.setAlter_time(alter_time);
		blog.setText(text);
		try {
			ServiceFactory.createBlogService().createBlog(blog);
			System.out.println("文章保存成功");
			response.sendRedirect("../home.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文章保存失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
