package cn.ciwest.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.ciwest.factory.ServiceFactory;
import cn.ciwest.model.Picture;
import cn.ciwest.model.User;

/**
 * Servlet implementation class PictureUploadAction
 */
@WebServlet("/picture/upload.do")
public class PictureUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PictureUploadAction() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		// 1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		upload.setSizeMax(10 * 1024 * 1024);// 设置上传的文件总的大小不能超过5M
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> fileItem = items.iterator();
			Picture picture = new Picture();
			while (fileItem.hasNext()) {
				FileItem item = (FileItem) fileItem.next();
				if (item.isFormField()) {
					if ("name".equals(item.getFieldName())) {
						String name = item.getString();
						byte source [] = name.getBytes("iso8859-1");
					    name = new String (source,"UTF-8");
						System.out.println(name);
						picture.setName(name);
					}
				} else {
					String name = item.getName();
					String names[] = name.split("\\.");
					// picture.setPicture(picture);
					picture.setType(names[names.length - 1]);
					picture.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					picture.setAuthor(((User) session.getAttribute("user")).getUsername());
					ServiceFactory.createPictureServer().createPicture(picture, item.getInputStream());
				}
			}
			System.out.println("图片保存成功");
			response.sendRedirect("../home.jsp");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("图片保存失败");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("图片保存失败");
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
