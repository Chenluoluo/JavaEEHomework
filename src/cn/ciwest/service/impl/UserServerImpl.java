package cn.ciwest.service.impl;

import cn.ciwest.factory.DaoFactory;
import cn.ciwest.model.User;
import cn.ciwest.service.UserServer;

public class UserServerImpl implements UserServer {

	@Override
	public void createUser(User user) throws Exception {

		DaoFactory.createUserDao().createUser(user);

	}

	@Override
	public User getUser(String username) throws Exception {

		return DaoFactory.createUserDao().getUser(username);
	}

	@Override
	public void modifyUser(User user) throws Exception {
		DaoFactory.createUserDao().modifyUser(user);
		
	}

	@Override
	public void removeUser(String username) throws Exception {
		DaoFactory.createUserDao().removeUser(username);
		
	}

}
