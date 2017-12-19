package cn.ciwest.service.impl;

import java.util.List;

import cn.ciwest.factory.DaoFactory;
import cn.ciwest.model.Message;
import cn.ciwest.service.MessageServer;

public class MessageServerImpl implements MessageServer {

	@Override
	public void createMessage(Message message) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createMessageDao().createMessage(message);
	}

	@Override
	public Message getMessage(int number) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createMessageDao().getMessage(number);
	}

	@Override
	public void modifyMessage(Message message) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createMessageDao().modifyMessage(message);
	}

	@Override
	public void removeMessage(int number) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createMessageDao().removeMessage(number);
	}

	@Override
	public List<Message> getAllComment() throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createMessageDao().getAllComment();
	}

}
