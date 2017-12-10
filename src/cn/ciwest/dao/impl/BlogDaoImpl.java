package cn.ciwest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.ciwest.dao.BlogDao;
import cn.ciwest.factory.ConnectionFactory;
import cn.ciwest.model.Blog;

public class BlogDaoImpl implements BlogDao {

	@Override
	public void createBlog(Blog blog) throws Exception {
		String sql="insert into HW_Blog (title,author,type,decoration,create_time,alter_time,text) values (?,?,?,?,?,?,?)";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, blog.getTitle());
		ps.setString(2, blog.getAuthor());
		ps.setString(3, blog.getType());
		ps.setString(4, blog.getDecoration());
		ps.setString(5, blog.getCreate_time());
		ps.setString(6, blog.getAlter_time());
		ps.setString(7, blog.getText());
		ps.execute();
		ps.close();
		cn.close();

	}

	@Override
	public Blog getBlog(int number) throws Exception {
		Blog blog=null;
		String sql="select * from HW_Blog where number=?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setInt(1, number);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			blog=new Blog();
			blog.setNumber(number);
			blog.setTitle(rs.getString("Author"));
			blog.setAuthor(rs.getString("Author"));
			blog.setType(rs.getString("Type"));
			blog.setDecoration(rs.getString("decoration"));
			blog.setCreate_time(rs.getString("create_time"));
			blog.setAlter_time(rs.getString("text"));
		} else {
			return null;
		}
		rs.close();
		ps.close();
		cn.close();
		
		return blog;
	}

	@Override
	public void modifyBlog(Blog blog) throws Exception {
		String sql="update HW_Blog set title=?,type=?,decoration=?,alter_time=?,text=? where number = ?";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, blog.getTitle());
		ps.setString(2, blog.getType());
		ps.setString(3, blog.getDecoration());
		ps.setString(4, blog.getAlter_time());
		ps.setString(5, blog.getText());
		ps.setInt(6, blog.getNumber());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public void removeBlog(int number) throws Exception {
		String sql = "delete from HW_Blog where number=?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, number);
		ps.execute();
		ps.close();
		cn.close();
	}

	@Override
	public List<Blog> getAllBlog() throws Exception {
		List<Blog> blogList = new ArrayList<>();
		String sql="select * from HW_Blog";
		Connection cn=ConnectionFactory.getConnection();
		PreparedStatement ps=cn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Blog blog=new Blog();
			blog.setNumber(rs.getInt("number"));
			blog.setTitle(rs.getString("title"));
			blog.setAuthor(rs.getString("author"));
			blog.setType(rs.getString("type"));
			blog.setDecoration(rs.getString("decoration"));
			blog.setCreate_time(rs.getString("create_time"));
			blog.setAlter_time(rs.getString("text"));
			blogList.add(blog);
		}
		rs.close();
		ps.close();
		cn.close();
		return blogList;
	}

}
