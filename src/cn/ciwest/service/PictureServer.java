package cn.ciwest.service;

import cn.ciwest.model.Picture;

public interface PictureServer {

	public void createPicture(Picture blog) throws Exception;
	
	public Picture getPicture(String name) throws Exception;
}
