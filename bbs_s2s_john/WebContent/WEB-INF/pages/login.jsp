<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="baseUrl.jsp"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link href="css/login.css" style="text/css" rel="stylesheet">
<title>登录</title>
</head>
<body>
	<div class="g-bd">
		<div class="g-mn1">
			<div class="g-mnc1" style="margin-left: 40%">
			<s:property value="#parameters.name"/>
				<form action="all!login?reurl=<s:property value="#parameters.reurl"/>&newsid=<s:property value="#parameters.newsid"/>" method="post" id="form">
					<input type="hidden" id="flag" value="true"> 帐号:<input
						type="text" id="username" name="user.account"><br> <span
						id="tip1" style="color: red"></span> <br> 密码:<input
						type="password" id="password" name="user.password"><br> <span
						id="tip2" style="color: red"></span><br> <input type="button"
						value="登陆" id="btn"> <input type="button" value="取消">
				</form>
			</div>
		</div>
	</div>
</body>
</html>