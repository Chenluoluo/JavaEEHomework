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
<title><fmt:message key="blog.modify.title" /></title>
<link rel="stylesheet" href="../static/css/uikit.min.css">
<link rel="stylesheet" href="../static/css/uikit.gradient.min.css">
<link rel="stylesheet" href="../static/css/awesome.css">
<script src="../static/js/jquery.min.js"></script>
<script src="../static/js/uikit.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#vm').show();
	});
</script>
</head>
<body class="uk-height-1-1">
	<nav class="uk-navbar uk-navbar-attached uk-margin-bottom">
	<div class="uk-container uk-container-center">
		<a href="#" class="uk-navbar-brand"><fmt:message
				key="menu.blog" /></a>
		<ul class="uk-navbar-nav">
			<li><a href="../home.jsp"><i class="uk-icon-home"></i> <fmt:message
						key="menu.home" /></a></li>
			<li><a href="edit.jsp"><i class="uk-icon-book"></i> <fmt:message
						key="menu.edit" /></a></li>
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
			
			<div class="uk-width-1-1 uk-margin-bottom">
				<div class="uk-panel uk-panel-box">
					<ul class="uk-breadcrumb">
						<li><a href="../home.jsp"><fmt:message key="menu.home" /></a></li>
						<li><a href="../picture/picture.jsp"><fmt:message
									key="menu.picture" /></a></li>
						<li><a href="../comment/comment.jsp"><fmt:message
									key="menu.comment" /></a></li>
					</ul>
				</div>
			</div>
			<div id="vm" class="uk-width-2-3">
			<c:forEach var="blog" items="${ listBlog.rows }">
			
				<form method="post" action="modify.do?number=${ blog.number }" class="uk-form uk-form-stacked">
					<div class="uk-alert uk-alert-danger uk-hidden"></div>
					<div class="uk-form-row">
						<label class="uk-form-label"><fmt:message key="blog.edit.form_title" /></label>
						<div class="uk-form-controls">
							<input v-model="title" name="title" type="text" placeholder="<fmt:message key="blog.edit.form_title" />"
								class="uk-width-1-1" value="${ blog.title }">
						</div>
					</div>
					<div class="uk-form-row">
						<label class="uk-form-label"><fmt:message key="blog.edit.form_type" /></label>
						<div class="uk-form-controls">
							<textarea v-model="type" rows="1" name="type" placeholder="<fmt:message key="blog.edit.form_type" />"
								class="uk-width-1-1" style="resize: none;">${ blog.type }</textarea>
						</div>
					</div>
					<div class="uk-form-row">
						<label class="uk-form-label"><fmt:message key="blog.edit.form_decoration" /></label>
						<div class="uk-form-controls">
							<textarea v-model="decoration" rows="4" name="decoration"
								placeholder="<fmt:message key="blog.edit.form_decoration" />" class="uk-width-1-1" style="resize: none;">${ blog.decoration }</textarea>
						</div>
					</div>
					<div class="uk-form-row">
						<label class="uk-form-label"><fmt:message key="blog.edit.form_text" /></label>
						<div class="uk-form-controls">
							<textarea v-model="text" rows="16" name="text" placeholder="<fmt:message key="blog.edit.form_text" />"
								class="uk-width-1-1" style="resize: none;" >${ blog.text }</textarea>
						</div>
					</div>
					<div class="uk-form-row">
						<button type="submit" class="uk-button uk-button-primary">
							<i class="uk-icon-save"></i> <fmt:message key="blog.modify.save" />
						</button>
						<a href="../home.jsp" class="uk-button"><i
							class="uk-icon-times"></i> <fmt:message key="blog.edit.cancel" /></a>
					</div>
				</form>
				
				</c:forEach>
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