package cn.ciwest.service;

import cn.ciwest.model.Comment;

public interface CommentServer {

	public void createComment(Comment comment) throws Exception;

	public Comment getComment(String content) throws Exception;
}
