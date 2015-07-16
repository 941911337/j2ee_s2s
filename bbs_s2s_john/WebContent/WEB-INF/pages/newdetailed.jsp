<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="baseUrl.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"  src="js/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(check);
		
	})
	
	function check() {
		var user="${sessionScope.currentUser.account}";
		if(user == ""){
			alert("登录后才能评论!");
			window.location.href="login.do?reurl=newdetailed&newsid=${news.id}";
			return false;
		}
	
	}
</script>
</head>
<body>
<div style="border: 1px black solid;width: 500px;">
	<div style="width: 500px; height:20px;">
		<a href="all!index" style="margin-left: 20px;">主页</a> 
		<span style="float: right">
		<s:if test="#session.currentUser != null">
			欢迎您,<a href="personal/personal" style="margin-right: 20px;"><s:property value="#session.currentUser.account"/></a><a href="all!cancel" style="margin-right: 20px;">注销</a>
		</s:if>
		<s:if test="#session.currentUser == null">
			<a href="skip?url=login&reurl=newdetailed&newsid=<s:property value="news.id"/>" style="margin-right: 20px;">登录</a><a href="skip?url=register" style="margin-right: 20px;">注册</a>
		</s:if>
		</span>
		
	</div>
	<div style=" width: 500px;  ">
		<table style="width: 100%">
		<tr><th><s:property value="news.title"/></th></tr>
		<tr><td style="text-align: center;"><s:property value="news.create_date"/></td></tr>
		<tr><td>&nbsp;&nbsp;<s:property value="news.content"/></td></tr>
		</table>
		<div>
			<table width="100%" style="text-align: center;">
				<tr><td>回复内容</td><td>回复者</td><td>回复时间</td></tr>
				<s:if test="RList.size()>0">
					<s:iterator var="item" value="RList">
						<tr>
						<td><s:property value="#item.content"/></td>
						<td><s:property value="#item.userName"/></td>
						<td><s:property value="#item.create_date"/></td>
						</tr>
					</s:iterator>
				</s:if>
				
			</table>
		</div>
	</div>
	<div>
		<form action="all!newsDetailsGet?newsid=<s:property value="news.id"/>" method="post">
		<textarea rows="5" cols="58" name="reply.content"></textarea>
		<input type="submit" value="回复" id="btn" style="float: right;">
		</form>
	</div>
</div>
</body>
</html>