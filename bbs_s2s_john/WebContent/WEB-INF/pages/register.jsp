<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="baseUrl.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/register.css" rel="stylesheet" style="text/css">
<script type="text/javascript" src="js/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<title>注册</title>
</head>
<body>
<div id="form" >
<form action="all!register" method="post" >
<input type="hidden" id="flag" value="false">
 帐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:<input type="text" name="user.account" id="username" class="text">
 <span style="color: red" id="tip_name">*</span><br>
<br>
密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="user.password" id="password" class="text">
<span style="color: red">*</span><br>
<br>
确认密码:<input type="password" id="surepwd" class="text">
<span style="color: red">*</span><br>
<br>
姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" name="user.name" class="text"><br>
<br>
邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:<input type="text" name="user.email" class="text" id="email"><br>
<br>
<input type="submit" value="确定" id="btn_submit" class="button"> <input type="button" value="取消" id="btn_cancel" class="button">
</form>
</div>
</body>
</html>