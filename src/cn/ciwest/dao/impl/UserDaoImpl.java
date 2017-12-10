package cn.ciwest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.ciwest.dao.UserDao;
import cn.ciwest.factory.ConnectionFactory;
import cn.ciwest.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void createUser(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into HW_User (Username,Name,Password,Email,Phone) values (?,?,?,?,?)";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getPhone());
		ps.execute();
		ps.close();
		cn.close();
	}

	@Override
	public User getUser(String username) throws Exception {
		User user = null;
		String sql = "select * from  HW_User where username=?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setUsername(username);
			user.setName(rs.getString("Name"));
			user.setPassword(rs.getString("Password"));
			user.setEmail(rs.getString("Email"));
			user.setPhone(rs.getString("Phone"));
		} else {
			return null;
		}
		rs.close();
		ps.close();
		cn.close();
		return user;
	}

	@Override
	public void modifyUser(User user) throws Exception {
		String sql = "update HW_User set Name=?,Email=?,Phone=? where Username=?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPhone());
		ps.setString(4, user.getUsername());
		ps.executeUpdate();
		ps.close();
		cn.close();
	}

	@Override
	public void removeUser(String username) throws Exception {
		String sql = "delete from HW_User where Username=?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, username);
		ps.execute();
		ps.close();
		cn.close();
	}

}
