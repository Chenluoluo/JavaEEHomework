<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<fmt:setBundle basename="cn.ciwest.message.blog" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ param.number }<fmt:message key="blog.view.title" /></title>
<link rel="stylesheet" href="../static/css/uikit.min.css">
<link rel="stylesheet" href="../static/css/uikit.gradient.min.css">
<link rel="stylesheet" href="../static/css/awesome.css">
<script src="../static/js/jquery.min.js"></script>
<script src="../static/js/uikit.min.js"></script>
<script type="text/javascript">
	$(function() {
		if( '${ param.author }' == '${ user.getUsername() }'){
			$("#modify").removeClass("uk-hidden");
			$("#remove").removeClass("uk-hidden");
		}
	});
</script>
</head>
<body class="uk-height-1-1">
	<nav class="uk-navbar uk-navbar-attached uk-margin-bottom">
	<div class="uk-container uk-container-center">
		<a href="#" class="uk-navbar-brand"><fmt:message key="menu.blog" /></a>
		<ul class="uk-navbar-nav">
			<li><a href="../home.jsp"><i class="uk-icon-home"></i> <fmt:message
						key="menu.home" /></a></li>
			<li><a href="../blog/edit.jsp"><i class="uk-icon-book"></i>
					<fmt:message key="menu.edit" /></a></li>
			<li><a href="../comment/comment.jsp"><i
					class="uk-icon-align-left"></i> <fmt:message key="menu.comment" /></a></li>
			<li><a href="../picture/picture.jsp"><i class="uk-icon-file"></i>
					<fmt:message key="menu.picture" /></a></li>
		</ul>
		<div class="uk-navbar-flip">
			<ul class="uk-navbar-nav">
				<li class="uk-parent" data-uk-dropdown><a href="#"><i
						class="uk-icon-user"></i> ${ user.getUsername() }</a>
					<div class="uk-dropdown uk-dropdown-navbar">
						<ul class="uk-nav uk-nav-navbar">
							<li><a href="../user/modify.jsp"><i class="uk-icon-cog"></i>
									<fmt:message key="menu.modify_information" /></a></li>
						</ul>
					</div></li>
				<li><a href="../user/logout.do"><i class="uk-icon-sign-in"></i>
						<fmt:message key="menu.logout" /></a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="uk-container uk-container-center">
		<div class="uk-grid">
			<!-- content -->
			<!-- 配置数据源 -->
			<sql:setDataSource dataSource="jdbc/mysql" var="mysql"
				scope="request" />
			<!-- 取得查询结果集 -->
			<sql:query sql="select * from HW_Blog where number=?"
				dataSource="${ mysql }" var="listBlog" scope="request">
				<sql:param value="${ param.number }"></sql:param>
			</sql:query>

			<div class="uk-width-medium-3-4">
				<!-- 输出 -->
				<c:forEach var="blog" items="${ listBlog.rows }">
					<article class="uk-article">
					<h2>
						<a href="view.jsp?number=${ blog.number }&author=${ blog.author }">${ blog.title }</a>
					</h2>
					<p class="uk-article-meta">${ blog.author }
						<fmt:message key="home.published_in" />
						${ blog.create_time }
					</p>
					<p>
						<a id="modify" href="modify.jsp?number=${ blog.number }" class="uk-hidden">修改</a>
						<a id="remove" href="remove.do?number=${ blog.number }" class="uk-hidden" style="color: red">删除</a>
					</p>
					<!-- <p>文章内容</p> -->
					<div class="post-body" itemprop="articleBody">${ blog.text }</div>
					</article>
				</c:forEach>
				<hr class="uk-article-divider">
				<div class="uk-width-medium-3-4">
					<h3>
						<fmt:message key="blog.view.comment_title" />
					</h3>
					<article class="uk-comment">
					 <header class="uk-comment-header"> <img
						class="uk-comment-avatar uk-border-circle" width="50" height="50"
						src="../static/img/user.png">
					<h4 class="uk-comment-title">「Stay hungry. Stay foolish.」</h4>
					</header>
					<div class="uk-comment-body">
						<form action="../comment/edit.do" method="post" id="form-comment"
							class="uk-form">
							<div class="uk-alert uk-alert-danger uk-hidden"></div>
							<div class="uk-form-row">
								<textarea name="context" rows="6"
									placeholder="<fmt:message key="blog.view.comment_tip" />"
									style="width: 100%; resize: none;"></textarea>
							</div>
							<div class="uk-form-row">
								<button type="submit" class="uk-button uk-button-primary">
									<i class="uk-icon-comment"></i> <fmt:message key="blog.view.commented" />
								</button>
							</div>
						</form>
					</div>
					</article>
					<hr class="uk-article-divider">
				</div>
			</div>


			<div class="uk-width-medium-1-4">
				<div class="uk-panel uk-panel-header">
					<h3 class="uk-panel-title">
						<fmt:message key="friendly_link.title" />
					</h3>
					<ul class="uk-list uk-list-line">
						<li><i class="uk-icon-thumbs-o-up"></i> <a target="_blank"
							href="#">编程</a></li>
						<li><i class="uk-icon-thumbs-o-up"></i> <a target="_blank"
							href="#">读书</a></li>
						<li><i class="uk-icon-thumbs-o-up"></i> <a target="_blank"
							href="#">Python教程</a></li>
						<li><i class="uk-icon-thumbs-o-up"></i> <a target="_blank"
							href="#">Git教程</a></li>
					</ul>
				</div>
			</div>
			<!-- // content -->
		</div>
	</div>

	<div class="uk-margin-large-top"
		style="background-color: #eee; border-top: 1px solid #ccc;">
		<div class="uk-container uk-container-center uk-text-center">
			<div class="uk-panel uk-margin-top uk-margin-bottom">
				<p>
					<a target="_blank" href="http://weibo.com/u/5661149316"
						class="uk-icon-button uk-icon-weibo"></a> <a target="_blank"
						href="https://github.com/chenluoluo"
						class="uk-icon-button uk-icon-github"></a> <a target="_blank"
						href="http://www.linkedin.com/in/chenluoluo"
						class="uk-icon-button uk-icon-linkedin-square"></a> <a
						target="_blank" href="https://twitter.com/chenluoluo"
						class="uk-icon-button uk-icon-twitter"></a>
				</p>
				<p>
					Powered by <a href="http://www.ciwest.cn">ChenLuoLuo</a>. Copyright
					2017. [<a href="#">Manage</a>]
				</p>
				<p>
					<a href="http://www.ciwest.cn" target="_blank">www.ciwest.cn</a>.
					All rights reserved.
				</p>
			</div>

		</div>
	</div>
</body>
</html>