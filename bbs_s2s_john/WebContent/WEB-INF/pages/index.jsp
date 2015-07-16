<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="baseUrl.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link style="text/css" rel="stylesheet" href="css/index.css">
<title>主页</title>
</head>
<body>
<div id="head">
		<s:if test="#session.currentUser !=null">
			<a href="all!cancel" class="a">注销</a> <span class="a"> 欢迎您,<a href="personal/personal"><s:property value="#session.currentUser.account"/></a></span> 
		</s:if>
		<s:if test="#session.currentUser ==null">
			<a href="skip?url=register" class="a">注册</a> <a href="skip?url=login" class="a">登陆</a>
		</s:if>
</div>
<div >
	<table>
		<tr>
			<th>标题</th>
			<th>时间</th>
			<th>作者</th>
		</tr>
		
		<s:if test="newsData == null || newsData.size()==0">
		</s:if>
		<s:if test="newsData != null || newsData.size()>0">
			<s:iterator var="item" value="newsData">
				<tr>
				<td><a href="all!newsDetails?newsid=<s:property value="#item.id"/>"><s:property value="#item.title"/></a></td>
				<td><s:property value="#item.create_date"/></td>
				<td><s:property value="#item.username"/></td>
				</tr>
			</s:iterator>
		</s:if>
		
		
	</table>
</div>

</body>
</html>