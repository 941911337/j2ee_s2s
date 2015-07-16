<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../baseUrl.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#add").click(add);
	})
	function add() {
		window.location.href="personal/personal!skipAddNews";
	}
</script>
</head>
<body>
<form action="personal/personal!newsList" method="post">
<div style="margin-left: 150px;">
	标题:<input type="text" name="title" value="<s:property value="title"/>">
	<input type="submit" value="提交"> <input type="reset" value="置空">
</div>
</form>
	<table width="500px;" style="border: 1px black solid; margin-top: 10px; text-align: center;">
		<tr><th>标题</th><th>时间</th><th>操作</th></tr>
		<s:if test="newsList !=null || newsList.size()>0">
			<s:iterator value="newsList" var="item">
				<tr>
				<td><a href="all!newsDetails?newsid=<s:property value="#item.id"/>" target="_top"><s:property value="#item.title"/></a></td>
				<td><s:property value="#item.create_date"/></td>
				<td><a href="personal/personal!delete?newsid=<s:property value="#item.id"/>">删除</a><a href="personal/personal!editNewGet?newsid=<s:property value="#item.id"/>">编辑</a></td>
				</tr>
				
			</s:iterator>
		</s:if>
	</table>
	<input type="button"  id="add" value="新增新闻"> 
	
</body>
</html>