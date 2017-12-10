package cn.ciwest.dao;

import java.util.List;

import cn.ciwest.model.Blog;

public interface BlogDao {
	public void createBlog(Blog blog) throws Exception;

	public Blog getBlog(int number) throws Exception;

	public void modifyBlog(Blog blog) throws Exception;

	public void removeBlog(int number) throws Exception;

	public List<Blog> getAllBlog() throws Exception;
}
