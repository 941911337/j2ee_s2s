<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../baseUrl.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/editpwd.js"></script>
<title>修改密码</title>
</head>
<body>
<form action="personal/personal!editPwdPost" method="post">
<input type="hidden" id="flag">
旧密码:<input type="password" id="oldpwd"><span style="color: red;" id="tip_pwd"></span><br>
<br>
新密码:<input type="password" id="newpwd" name="newPwd"><br>
<br>
确认密码:<input type="password" id="confirmpwd"><br>
<br>
<input type="submit" value="提交"  id="btn_submit"><input type="reset" value="取消" style="margin-left: 20px;">
</form>
</body>
</html>