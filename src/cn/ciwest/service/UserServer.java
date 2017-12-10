package cn.ciwest.service;

import cn.ciwest.model.User;

public interface UserServer {
	
	public void createUser(User user) throws Exception;
	
	public User getUser(String username) throws Exception;
	
	public void modifyUser(User username) throws Exception;
	
	public void removeUser(String user) throws Exception; 
}
