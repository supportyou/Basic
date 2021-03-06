<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="p" uri="/mytags" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic System</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<link href="${ctx}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${ctx}/vendor/bootstrap-table/bootstrap-table.css" rel="stylesheet"/>
	<link href="${ctx}/css/styles.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="left.jsp"></jsp:include>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">User</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">User</h1>
			</div>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">View User</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" action="" method="post" name="myFormView" id="myFormView">
							<div class="form-group">
								<label for="email" class="col-sm-3 control-label">Email:</label>
								<div class="col-sm-5 form-control-static">${user.email}</div>
							</div>
							<div class="form-group">
								<label for="status" class="col-sm-3 control-label">Status:</label>
								<div class="col-sm-5 form-control-static">${user.status}</div>
							</div>
							<div class="form-group">
								<label for="firstName" class="col-sm-3 control-label">First Name:</label>
								<div class="col-sm-5 form-control-static">${user.firstName}</div>
							</div>	
							<div class="form-group">
								<label for="lastName" class="col-sm-3 control-label">Last Name:</label>
								<div class="col-sm-5 form-control-static">${user.lastName}</div>
							</div>	
							<div class="form-group">    
								<label for="remark" class="col-sm-3 control-label">Remark:</label>
								<% //request.setAttribute("vEnter", "\n"); %>
								<c:set var="vEnter" value="<%=\"\n\"%>" />
								<div class="col-sm-5 form-control-static" id="remark">${fn:replace(user.remark,vEnter,'<br>')}</div>
							</div>
   						</form>
					</div><!--/.panel-body-->
				</div><!--/.panel-->
			</div><!--/.col-->
		</div><!--/.row-->
		
		<div class="row">

		</div><!--/.row-->

	</div>	<!--/.main-->
		
	
	<script src="${ctx}/vendor/jquery/jquery.min.js"></script>
	<script src="${ctx}/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ctx}/vendor/bootstrap-table/bootstrap-table.js"></script>
	
	<script src="${ctx}/vendor/jquery-validation/jquery.validate.min.js"></script>
	<script src="${ctx}/vendor/jquery-validation/messages_zh.js"></script>
	
</body>
</html>