<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Race Winner</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Update Race Winner</h1>
  <%--
  1. 显示errors --> 字段错误
  2. 显示异常错误
  3. 回显
   --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/EditRaceServlet'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
	Location    :<input type="text" name="location" value="${form.location }"/>
	<span style="color: red; font-weight: 900">${errors.location }</span>
	<br/>
	Date(yyyy-mm-dd)    :<input type="text" name="date" value="${form.date }"/>
	<span style="color: red; font-weight: 900">${errors.date }</span>
	<br/>
	Previous Winning Team		:<input type="text" name="oldTeamName" value="${form.oldTeam }"/>
	<span style="color: red; font-weight: 900">${errors.oldTeam }</span>
	<br/>
	Updated Winning Team Name   :<input type="text" name="teamName" value="${form.team }"/>
	<span style="color: red; font-weight: 900">${errors.team }</span>
	<br/>
	<input type="submit" value="Submit Race Info"/>
</form>
  </body>
</html>
