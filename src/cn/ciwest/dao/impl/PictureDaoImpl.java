package cn.ciwest.dao.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.ciwest.dao.PictureDao;
import cn.ciwest.factory.ConnectionFactory;
import cn.ciwest.model.Picture;

public class PictureDaoImpl implements PictureDao {

	@Override
	public void createPicture(Picture picture, InputStream inputStream) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into HW_Picture (name,picture,type,create_time,author) values (?,?,?,?,?)";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, picture.getName());
		ps.setBlob(2, inputStream);
		ps.setString(3, picture.getType());
		ps.setString(4, picture.getCreate_time());
		ps.setString(5, picture.getAuthor());
		ps.execute();
		ps.close();
		cn.close();
	}

	@Override
	public Picture getPicture(int number) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from hw_picture where number=?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, number);
		ResultSet rs = ps.executeQuery();
		Picture picture = new Picture();
		if (rs.next()) {
			picture.setNumber(rs.getInt("number"));
			picture.setName(rs.getString("name"));
			picture.setPicture(rs.getBlob("picture"));
			picture.setType(rs.getString("type"));
			picture.setCreate_time(rs.getString("create_time"));
			picture.setAuthor(rs.getString("author"));
		} else {
			return null;
		}
		rs.close();
		ps.close();
		cn.close();
		return picture;
	}

	@Override
	public void modifyPicture(Picture picture) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePicture(int number) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from HW_Picture where number=?";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, number);
		ps.execute();
		ps.close();
		cn.close();
	}

	@Override
	public List<Picture> getAllPicture() throws Exception {
		// TODO Auto-generated method stub
		List<Picture> pictureList = new ArrayList<>();
		String sql = "select * from hw_picture";
		Connection cn = ConnectionFactory.getConnection();
		PreparedStatement ps = cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Picture picture = new Picture();
			picture.setNumber(rs.getInt("number"));
			picture.setName(rs.getString("name"));
			picture.setPicture(rs.getBlob("picture"));
			picture.setType(rs.getString("type"));
			picture.setCreate_time(rs.getString("create_time"));
			picture.setAuthor(rs.getString("author"));
			pictureList.add(picture);
		}
		rs.close();
		ps.close();
		cn.close();
		return pictureList;
	}

}
