package cn.ciwest.factory;

import cn.ciwest.service.BlogServer;
import cn.ciwest.service.CommentServer;
import cn.ciwest.service.MessageServer;
import cn.ciwest.service.PictureServer;
import cn.ciwest.service.UserServer;
import cn.ciwest.service.impl.BlogServerImpl;
import cn.ciwest.service.impl.CommentServerImpl;
import cn.ciwest.service.impl.MessageServerImpl;
import cn.ciwest.service.impl.PictureServerImpl;
import cn.ciwest.service.impl.UserServerImpl;

public class ServiceFactory {
	public static UserServer createUserService() {
		return new UserServerImpl();
	}

	public static BlogServer createBlogService() {
		return new BlogServerImpl();
	}

	public static CommentServer createCommentServer() {
		return new CommentServerImpl();
	}

	public static PictureServer createPictureServer() {
		return new PictureServerImpl();
	}
	
	public static MessageServer createMessageServer() {
		return new MessageServerImpl();
	}
}