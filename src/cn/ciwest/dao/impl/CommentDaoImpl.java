package cn.ciwest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.ciwest.dao.CommentDao;
import cn.ciwest.factory.ConnectionFactory;
import cn.ciwest.model.Comment;

public class CommentDaoImpl implements CommentDao {

	@Override
	public void createComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into HW_Comment (blognumber,username,content,time) values (?,?,?,?)";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, comment.getBlognumber());
		ps.setString(2, comment.getUsername());
		ps.setString(3, comment.getContent());
		ps.setString(4, comment.getTime());
		ps.execute();
		ps.close();
		cn.close();
	}

	@Override
	public Comment getComment(int number) throws Exception {
		// TODO Auto-generated method stub
		Comment comment = null;
		String sql = "select * from HW_Comment where number=?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, number);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			comment = new Comment();
			comment.setNumber(number);
			comment.setBlognumber(rs.getInt("Blognumber"));
			comment.setUsername(rs.getString("Username"));
			comment.setContent(rs.getString("Content"));
			comment.setTime(rs.getString("Time"));
		} else {
			return null;
		}
		rs.close();
		ps.close();
		cn.close();

		return comment;
	}

	@Override
	public void modifyComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update HW_Comment set blognumber=?,username=?,content=?,time=? where number = ?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, comment.getBlognumber());
		ps.setString(2, comment.getUsername());
		ps.setString(3, comment.getContent());
		ps.setString(4, comment.getTime());
		ps.setInt(5, comment.getNumber());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public void removeComment(int number) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from HW_Comment where number=?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, number);
		ps.execute();
		ps.close();
		cn.close();
	}

	@Override
	public List<Comment> getBlogComment(int blognumber) throws Exception {
		// TODO Auto-generated method stub
		List<Comment> commentList = new ArrayList<>();
		String sql = "select * from HW_Comment where blognumber = ?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, blognumber);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Comment comment = new Comment();
			comment.setNumber(rs.getInt("Number"));
			comment.setBlognumber(rs.getInt("Blognumber"));
			comment.setUsername(rs.getString("Username"));
			comment.setContent(rs.getString("Content"));
			comment.setTime(rs.getString("Time"));
			commentList.add(comment);
		}
		rs.close();
		ps.close();
		cn.close();
		return commentList;
	}

	@Override
	public List<Comment> getAllComment() throws Exception {
		// TODO Auto-generated method stub
		List<Comment> commentList = new ArrayList<>();
		String sql = "select * from HW_Comment";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Comment comment = new Comment();
			comment.setNumber(rs.getInt("Number"));
			comment.setBlognumber(rs.getInt("Blognumber"));
			comment.setUsername(rs.getString("Username"));
			comment.setContent(rs.getString("Content"));
			comment.setTime(rs.getString("Time"));
			commentList.add(comment);
		}
		rs.close();
		ps.close();
		cn.close();
		return commentList;
	}

}
