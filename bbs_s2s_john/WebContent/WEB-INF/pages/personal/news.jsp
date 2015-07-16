<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../baseUrl.jsp" %>
	<%@ taglib  prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/news.js"></script>
</head>
<body>
	<form action="personal/personal!editNewPost" method="post">
	<input type="hidden" name="newsid" value="<s:property value="newsInfo.id"/>">
	
		<table>
			<tr>
				<td>标题:</td>
				<td><input type="text" name="title1" id="title" value="<s:property value="newsInfo.title"/>"><span style="color: red;">*</span></td>
			</tr>
			<tr>
				<td valign="top">内容:</td>
				<td><textarea name="content" rows="5" cols="30"> <s:property value="newsInfo.content"/></textarea></td>
			</tr>
		</table>
		<input type="submit" value="提交" id="sub_btn" style="margin-left: 20px;"> <input
			type="button" id="btn" value="返回" style="margin-left: 15px;">

	</form>
</body>
</html>