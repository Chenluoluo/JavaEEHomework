package cn.ciwest.dao;

import cn.ciwest.model.Picture;

public interface PictureDao {
	public void createPicture(Picture picture) throws Exception;

	public Picture getPicture(String name) throws Exception;
}
