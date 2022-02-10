<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1 style="text-align: center;">Manage this database:</h1>
<div style="font-size: 15pt;">
<div style="text-align: center">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a>	|&nbsp; 
			<a href="<c:url value='/jsps/user/init.jsp'/>" target="_parent">Initialize</a><br> 
			
			<a href="<c:url value='/jsps/user/insertDriver.jsp'/>" target="_parent">Insert Driver</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/insertRace.jsp'/>" target="_parent">Insert Race</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/insertTeam.jsp'/>" target="_parent">Insert Team</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/insertLap.jsp'/>" target="_parent">Insert Lap Record</a><br> 
			
			<a href="<c:url value='/jsps/user/showDrivers.jsp'/>" target="_parent">View Drivers</a>	|&nbsp; 
			<a href="<c:url value='/jsps/user/showRaces.jsp'/>" target="_parent">View Races</a>		|&nbsp; 
			<a href="<c:url value='/jsps/user/showTeams.jsp'/>" target="_parent">View Teams</a>     |&nbsp;
			<a href="<c:url value='/jsps/user/showLaps.jsp'/>" target="_parent">View Lap Records</a><br>
			
			<a href="<c:url value='/jsps/user/deleteDriver.jsp'/>" target="_parent">Delete Drivers</a> |&nbsp;
			<a href="<c:url value='/jsps/user/deleteRaces.jsp'/>" target="_parent">Delete Races</a> |&nbsp;
			<a href="<c:url value='/jsps/user/deleteTeams.jsp'/>" target="_parent">Delete Teams</a> |&nbsp;
			<a href="<c:url value='/jsps/user/deleteLaps.jsp'/>" target="_parent">Delete Lap Records</a><br>
			
			<a href="<c:url value='/jsps/user/editDriver.jsp'/>" target="_parent">Update Driver Info</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/editTeams.jsp'/>" target="_parent">Update Team Info</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/editLap.jsp'/>" target="_parent">Update Lap Records</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/editRace.jsp'/>" target="_parent">Update Race Winner</a> |&nbsp; 

		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/item.jsp'/>" target="body">Query Result</a>&nbsp;&nbsp;
		</c:otherwise>
	</c:choose>
</div>
</div>
  </body>
</html>
