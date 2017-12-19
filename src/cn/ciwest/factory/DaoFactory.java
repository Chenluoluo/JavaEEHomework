package cn.ciwest.factory;

import cn.ciwest.dao.BlogDao;
import cn.ciwest.dao.CommentDao;
import cn.ciwest.dao.MessageDao;
import cn.ciwest.dao.PictureDao;
import cn.ciwest.dao.UserDao;
import cn.ciwest.dao.impl.BlogDaoImpl;
import cn.ciwest.dao.impl.CommentDaoImpl;
import cn.ciwest.dao.impl.MessageDaoImpl;
import cn.ciwest.dao.impl.PictureDaoImpl;
import cn.ciwest.dao.impl.UserDaoImpl;

public class DaoFactory {
	public static UserDao createUserDao(){
		return new UserDaoImpl();
	}
	public static BlogDao createBlogDao(){
		return new BlogDaoImpl();
	}
	public static CommentDao createCommentDao(){
		return new CommentDaoImpl();
	}
	public static PictureDao createPictureDao(){
		return new PictureDaoImpl();
	}
	public static MessageDao createMessageDao(){
		return new MessageDaoImpl();
	}
}