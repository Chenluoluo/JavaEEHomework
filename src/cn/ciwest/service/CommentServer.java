package cn.ciwest.service;

import java.util.List;

import cn.ciwest.model.Comment;

public interface CommentServer {

	public void createComment(Comment comment) throws Exception;

	public Comment getComment(int number) throws Exception;

	public void modifyComment(Comment comment) throws Exception;

	public void removeComment(int number) throws Exception;
	
	public List<Comment> getBlogComment(int blognumber) throws Exception ;

	public List<Comment> getAllComment() throws Exception;
}
