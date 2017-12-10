package cn.ciwest.service.impl;

import cn.ciwest.factory.DaoFactory;
import cn.ciwest.model.Picture;
import cn.ciwest.service.PictureServer;

public class PictureServerImpl implements PictureServer {

	@Override
	public void createPicture(Picture picture) throws Exception {
		// TODO Auto-generated method stub
		DaoFactory.createPictureDao().createPicture(picture);
	}

	@Override
	public Picture getPicture(String name) throws Exception {
		// TODO Auto-generated method stub
		return DaoFactory.createPictureDao().getPicture(name);
	}

}
