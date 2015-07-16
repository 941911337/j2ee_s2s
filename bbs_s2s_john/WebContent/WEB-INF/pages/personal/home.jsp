<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../baseUrl.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人主页</title>
<style type="text/css">
a{ 
	text-decoration: none;
}
a:hover{
	text-decoration:underline;
}
</style>
</head>
<body style="width: 800px; height: 700px; margin-left: 100px;">
<div style="border: 1px black solid; width: 100%; height: 100px;"> 
	<span style="float: left;margin: 10px;"><a href="all!index">主页</a></span>
	<span style="float: right;margin: 10px;"><a href="personal/personal">我的帐号</a><a href="all!cancel" style="margin-left: 10px;">注销</a></span>
</div>
<div style="border: 1px black solid; width:30%; height: 599px; float:left;">
	<ul style="list-style: none;">
		<li style="margin-top: 10px;"><a href="personal/personal!newsList" target="mainFrame">我的新闻</a></li>
		<li style="margin-top: 10px;"><a href="personal/personal!editPwdGet" target="mainFrame">密码更新</a></li>
	</ul>
</div>
<div style="border: 1px black solid; width:69%; height: 599px; float:right;">
<iframe name="mainFrame" width="100%" height="100%" src="personal/personal!newsList" frameborder="0"></iframe>
</div>
</body>
</html>