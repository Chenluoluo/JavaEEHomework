package cn.ciwest.service.impl;

import java.util.List;

import cn.ciwest.factory.DaoFactory;
import cn.ciwest.model.Comment;
import cn.ciwest.service.CommentServer;

public class CommentServerImpl implements CommentServer {

	@Override
	public void createComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createCommentDao().createComment(comment);
	}

	@Override
	public Comment getComment(int number) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createCommentDao().getComment(number);
	}

	@Override
	public void modifyComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createCommentDao().modifyComment(comment);
	}

	@Override
	public void removeComment(int number) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createCommentDao().removeComment(number);
	}

	@Override
	public List<Comment> getAllComment() throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createCommentDao().getAllComment();
	}

}
