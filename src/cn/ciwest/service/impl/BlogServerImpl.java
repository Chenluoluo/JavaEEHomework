package cn.ciwest.service.impl;

import java.util.List;

import cn.ciwest.factory.DaoFactory;
import cn.ciwest.model.Blog;
import cn.ciwest.service.BlogServer;

public class BlogServerImpl implements BlogServer {

	@Override
	public void createBlog(Blog blog) throws Exception {
		DaoFactory.createBlogDao().createBlog(blog);

	}

	@Override
	public Blog getBlog(int number) throws Exception {
		return DaoFactory.createBlogDao().getBlog(number);
	}

	@Override
	public void modifyBlog(Blog blog) throws Exception {
		DaoFactory.createBlogDao().modifyBlog(blog);
	}

	@Override
	public void removeBlog(int number) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createBlogDao().removeBlog(number);
	}

	@Override
	public List<Blog> getAllBlog() throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createBlogDao().getAllBlog();
	}

}
