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

   <div class="form-group">
      <label for="userName" class="col-sm-3 control-label">User Name:</label>
      <div class="col-sm-5">
         <input type="text" class="form-control" id="userName" name="student.userName" placeholder="User Name">
      </div>
   </div>
   <div class="form-group">
      <label for="sex" class="col-sm-3 control-label">Sex:</label>
      <div class="col-sm-5">
         <input type="text" class="form-control" id="sex" name="student.sex" placeholder="Sex">
      </div>
   </div>
   <div class="form-group">
      <label for="remark" class="col-sm-3 control-label">Remark:</label>
      <div class="col-sm-5">
         <input type="text" class="form-control" id="remark" name="student.remark" placeholder="Remark">
      </div>
   </div>

</body>
</html>