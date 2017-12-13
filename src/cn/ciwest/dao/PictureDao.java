package cn.ciwest.dao;

import java.util.List;

import cn.ciwest.model.Picture;

public interface PictureDao {
	public void createPicture(Picture picture) throws Exception;

	public Picture getPicture(String name) throws Exception;

	public void modifyPicture(Picture picture) throws Exception;

	public void removePicture(int number) throws Exception;

	public List<Picture> getAllPicture() throws Exception;
}
