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

<p>JSTL标签</p>
<form action="updatestudent.action" method="post" name="myform">

User Name: <input type="text" name="student.userName" value="${student.userName}">
<br>
Sex:<input type="text" name="student.sex" value="${student.sex}">
<br>
Remark:<input type="text" name="student.remark" value="${student.remark}">

<input type="submit" value="Submit">

<input type="hidden" name="student.id" value="${student.id}">

</form>
<br>
Struts标签显示错误提示1：<s:fielderror></s:fielderror>
<br>
Struts标签显示错误提示2:  <s:property value="fieldErrors['userName'][0]" />
<br>
JSTL标签显示错误提示: ${fieldErrors.userName[0]}

</body>
</html>