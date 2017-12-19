package cn.ciwest.dao;

import java.util.List;

import cn.ciwest.model.Message;

public interface MessageDao {
	public void createMessage(Message message) throws Exception;

	public Message getMessage(int number) throws Exception;

	public void modifyMessage(Message message) throws Exception;

	public void removeMessage(int number) throws Exception;

	public List<Message> getAllComment() throws Exception;
}
