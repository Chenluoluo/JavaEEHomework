package cn.ciwest.dao;

import cn.ciwest.model.User;

public interface UserDao {
	public void createUser(User user) throws Exception;

	public User getUser(String username) throws Exception;

	public void modifyUser(User user) throws Exception;

	public void removeUser(String username) throws Exception;

}