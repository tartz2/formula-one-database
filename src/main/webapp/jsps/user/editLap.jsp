<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Lap Record</title>
    
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
  <h1>Update Existing Lap Record</h1>
  <%--
  1. 显示errors --> 字段错误
  2. 显示异常错误
  3. 回显
   --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/EditLapServlet'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
	Driver Name    :<input type="text" name="driverName" value="${form.driverName }"/>
	<span style="color: red; font-weight: 900">${errors.driverName }</span>
	<br/>
	Location   :<input type="text" name="location" value="${form.location }"/>
	<span style="color: red; font-weight: 900">${errors.location }</span>
	<br/>
	Updated Lap Time (hh:mm:ss)    :<input type="text" name="lapTime" value="${form.lapTime }"/>
	<span style="color: red; font-weight: 900">${errors.lapTime }</span>
	<br/>
	<input type="submit" value="Submit Lap Record"/>
</form>
  </body>
</html>
