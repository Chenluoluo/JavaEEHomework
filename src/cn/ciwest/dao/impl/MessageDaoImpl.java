package cn.ciwest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.ciwest.dao.MessageDao;
import cn.ciwest.factory.ConnectionFactory;
import cn.ciwest.model.Comment;
import cn.ciwest.model.Message;

public class MessageDaoImpl implements MessageDao {

	@Override
	public void createMessage(Message message) throws Exception {
		String sql = "insert into HW_Message (username,content,time) values (?,?,?)";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, message.getUsername());
		ps.setString(2, message.getContent());
		ps.setString(3, message.getTime());
		ps.execute();
		ps.close();
		cn.close();
	}

	@Override
	public Message getMessage(int number) throws Exception {
		String sql = "select * from HW_Message where number=?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, number);
		Message message = null;
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			message = new Message();
			message.setNumber(number);
			message.setUsername(rs.getString("Username"));
			message.setContent(rs.getString("Content"));
			message.setTime(rs.getString("Time"));
		} else {
			return null;
		}
		rs.close();
		ps.close();
		cn.close();
		return message;
	}

	@Override
	public void modifyMessage(Message message) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMessage(int number) throws Exception {
		String sql = "delete from HW_Message where number=?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, number);
		ps.execute();
		ps.close();
		cn.close();

	}

	@Override
	public List<Message> getAllComment() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
