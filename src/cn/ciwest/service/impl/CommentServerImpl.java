package cn.ciwest.service.impl;

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
	public Comment getComment(String content) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createCommentDao().getComment(content);
	}

}
