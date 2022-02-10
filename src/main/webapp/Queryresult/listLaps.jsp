<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Lap Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Driver</th>
		<th>Time</th>
		<th>Location</th>
	</tr>
<c:forEach items="${LapList}" var="lap">
	<tr>
		<td>${lap.name }</td>
		<td>${lap.time }</td>
		<td>${lap.location }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>