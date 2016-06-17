<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
hello, world!!!
<br>

<a href="findallstudent.action">All Student</a>
<br>
<a href="findallstudentforjson.action">All Student For Json</a>
<br>
<a href="mail.action">Email</a>
<br>
============================
<br>
<br>
<p>Struts标签</p>
<table border="1">
	<tr>
		<td>ID</td>
		<td>User Name</td>
		<td>Sex</td>
	</tr>
	<s:if test="studentList.size()>0">
		<s:iterator value="studentList">
		<tr>
			<td>${id}</td>
			<td>${userName}</td>
			<td>${sex}</td>
		</tr>
		</s:iterator>
	</s:if>
	<s:else>
	<tr>
		<td colspan="3" align="center">Sorry, No Record!</td>
	</tr>
	</s:else>
</table>


</body>
</html>