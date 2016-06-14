<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" uri="/mytags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<br>
===================================================================
<br>
<p>JSTL标签</p>
<table border="1">
	<tr>
		<td>ID</td>
		<td>User Name</td>
		<td>Sex</td>
		<td>Remark</td>
		<td>View</td>
		<td>Amend</td>
		<td>Delete</td>
	</tr>
	<c:if test="${studentList.size()>0}">
		<c:forEach items="${studentList}" var="tbl">
		<tr>
			<td>${tbl.id}</td>
			<td>${tbl.userName}</td>
			<td>${tbl.sex}</td>
			<td>${tbl.remark}</td>
			<td><a href="findonestudent.action?forWhere=view&id=${tbl.id}" target="_blank">${tbl.id}</a></td>
			<td><a href="findonestudent.action?forWhere=amend&id=${tbl.id}">${tbl.id}</a></td>
			<td><a href="deletestudent.action?id=${tbl.id}">${tbl.id}</a></td>
		</tr>
		</c:forEach>
	</c:if>
</table>
<br>
<br>
<a href="add.jsp">Add</a>
<br>
<a href="findallstudent.action">All</a>
<br>
===================================================================

<br>
===================================================================
<br>
<p>分页</p>
<table border="1">
	<tr>
		<td>ID</td>
		<td>User Name</td>
		<td>Sex</td>
		<td>Remark</td>
		<td>View</td>
		<td>Amend</td>
		<td>Delete</td>
	</tr>
	<c:if test="${page.content.size()>0}">
		<c:forEach items="${page.content}" var="tbl">
		<tr>
			<td>${tbl.id}</td>
			<td>${tbl.userName}</td>
			<td>${tbl.sex}</td>
			<td>${tbl.remark}</td>
			<td><a href="findonestudent.action?forWhere=view&id=${tbl.id}" target="_blank">${tbl.id}</a></td>
			<td><a href="findonestudent.action?forWhere=amend&id=${tbl.id}">${tbl.id}</a></td>
			<td><a href="deletestudent.action?id=${tbl.id}">${tbl.id}</a></td>
		</tr>
		</c:forEach>
	</c:if>
</table>
<br>

<p:page totalElements="${page.totalElements}" 
 pageNo="${page.pageNo}"
 pageSize="${page.pageSize}"
 url="findallstudentbypager.action"/>
						 
<br>
<a href="add.jsp">Add</a>
<br>
<a href="findallstudentbypager.action">All By Pager</a>
<br>
===================================================================
<br>
<p>Struts标签</p>
<table border="1">
	<tr>
		<td>ID</td>
		<td>User Name</td>
		<td>Sex</td>
		<td>Remark</td>
	</tr>
	<s:if test="studentList.size()>0">
		<s:iterator value="studentList" id="my">
		<tr>
			<td>${id}</td>
			<td><s:property value="#my.userName"/></td>
			<td><s:property value="sex"/></td>
			<td></td>
		</tr>
		</s:iterator>
	</s:if>
	<s:else>
	<tr>
		<td colspan="4" align="center">Sorry, No Record!</td>
	</tr>
	</s:else>
</table>
<br>
<br>
<a href="findallstudent.action">All</a>
<br>
===================================================================
<br>
<a href="findallstudentbypager_bp.action">All for BP</a>
<br>
</body>
</html>