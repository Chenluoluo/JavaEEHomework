package cn.ciwest.service.impl;

import java.io.InputStream;
import java.util.List;

import cn.ciwest.factory.DaoFactory;
import cn.ciwest.model.Picture;
import cn.ciwest.service.PictureServer;

public class PictureServerImpl implements PictureServer {

	@Override
	public void createPicture(Picture picture, InputStream inputStream) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createPictureDao().createPicture(picture,inputStream);
	}

	@Override
	public Picture getPicture(int number) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createPictureDao().getPicture(number);
	}

	@Override
	public void modifyPicture(Picture picture) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createPictureDao().modifyPicture(picture);
	}

	@Override
	public void removePicture(int number) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createPictureDao().removePicture(number);
	}

	@Override
	public List<Picture> getAllPicture() throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createPictureDao().getAllPicture();
	}

}
