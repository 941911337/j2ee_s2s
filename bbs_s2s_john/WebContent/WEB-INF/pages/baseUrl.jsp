<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
 	url+=request.getContextPath()+"/";
 %>
<base href="<%=url %>">
