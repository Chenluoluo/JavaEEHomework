package cn.ciwest.service;

import java.io.InputStream;
import java.util.List;

import cn.ciwest.model.Picture;

public interface PictureServer {

	public void createPicture(Picture picture, InputStream inputStream) throws Exception;

	public Picture getPicture(int number) throws Exception;

	public void modifyPicture(Picture picture) throws Exception;

	public void removePicture(int number) throws Exception;

	public List<Picture> getAllPicture() throws Exception;
}
