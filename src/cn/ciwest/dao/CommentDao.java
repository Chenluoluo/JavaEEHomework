package cn.ciwest.dao;

import cn.ciwest.model.Comment;

public interface CommentDao {
	public void createComment(Comment comment) throws Exception;

	public Comment getComment(String content) throws Exception;
}
