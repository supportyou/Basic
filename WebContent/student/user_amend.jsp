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
	<link href="${ctx}/vendor/jquery-ui/jquery-ui.min.css" rel="stylesheet"/>
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
					<div class="panel-heading">Amend User</div>
					<div class="panel-body">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#1" data-toggle="tab">Profile</a></li>
							<li><a href="#2" data-toggle="tab">Password</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="1">
								<form class="form-horizontal" role="form" action="updateuser1.action" method="post" name="myFormAmend1" id="myFormAmend1">
									<div class="form-group">
										<label for="email" class="col-sm-3 control-label">Email:</label>
										<div class="col-sm-5">
											<input type="text" class="form-control disabled" id="email" name="user.email" placeholder="Email" value="${user.email}" disabled="">
											<p class="help-block">Your Email is for logging in and cannot be changed.</p>
										</div>
									</div>
									<div class="form-group">
										<label for="firstName" class="col-sm-3 control-label">First Name:</label>
										<div class="col-sm-5">
											<input type="text" class="form-control" id="firstName" name="user.firstName" placeholder="First Name" value="${user.firstName}">
										</div>
									</div>
									<div class="form-group">
										<label for="lastName" class="col-sm-3 control-label">Last Name:</label>
										<div class="col-sm-5">
											<input type="text" class="form-control" id="lastName" name="user.lastName" placeholder="Last Name" value="${user.lastName}">
										</div>
									</div>
									<div class="form-group">
										<label for="remark" class="col-sm-3 control-label">Remark:</label>
										<div class="col-sm-5">
											<textarea class="form-control" rows="3" id="remark" name="user.remark" placeholder="Remark">${user.remark}</textarea>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-2 col-md-offset-3">
											<button type="submit" class="form-control btn btn-primary">Submit</button>
										</div>
										<div class="col-md-2 col-md-offset-1">
											<button type="reset" class="form-control btn btn-warning">Reset</button>
										</div>
									</div>
								<input type="hidden" name="user.id" value="${user.id}">
								</form>
							</div><!--/.tab-pane-->
							<div class="tab-pane" id="2">
								<form class="form-horizontal" role="form" action="updateuser2.action" method="post" name="myFormAmend2" id="myFormAmend2">
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">Password:</label>
										<div class="col-sm-5">
											<input type="password" class="form-control" id="password" name="user.password" placeholder="Password" value="${user.password}">
										</div>
									</div>
									<div class="form-group">
										<label for="confirmPassword" class="col-sm-3 control-label">Confirm Password:</label>
										<div class="col-sm-5">
											<input type="password" class="form-control" id="confirmPassword" name="user.confirmPassword" placeholder="Confirm Password">
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-2 col-md-offset-3">
											<button type="submit" class="form-control btn btn-primary">Submit</button>
										</div>
										<div class="col-md-2 col-md-offset-1">
											<button type="reset" class="form-control btn btn-warning">Reset</button>
										</div>
									</div>
								<input type="hidden" name="user.id" value="${user.id}">
								</form>
							</div><!--/.tab-pane-->
						</div><!--/.tab-conent-->					
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
	
	<script src="${ctx}/vendor/jquery-ui/jquery-ui.min.js"></script>
	<script src="${ctx}/vendor/jquery-validation/jquery.validate.min.js"></script>
	<script src="${ctx}/vendor/jquery-validation/messages_zh.js"></script>

	<script type="text/javascript">

		$(function() {
			$("#myFormAmend1").validate({
				rules: {
					"user.firstName": {
						required: true,
						minlength: 2,
						maxlength: 45
					},
					"user.lastName": {
						required: true,
						minlength: 2,
						maxlength: 45
					}
				},
				messages: {
					"user.firstName": {
						required: "Please input your First Name!",
						minlength: "必须大于2个字符!",
						maxlength: "必须小于45个字符!"
					},
					"user.lastName": {
						required: "Please input your Last Name!",
						minlength: "必须大于2个字符!",
						maxlength: "必须小于45个字符!"
					}
				}
			});


			$("#myFormAmend2").validate({
				rules: {
					"user.password": {
						required: true,
						minlength: 2,
						maxlength: 45
					},
					"user.confirmPassword": {
						required: true,
						minlength: 2,
						maxlength: 45,
						equalTo: "#password"
					}
				},
				messages: {
					"user.password": {
						required: "Please input your Password!",
						minlength: "必须大于2个字符!",
						maxlength: "必须小于45个字符!"
					},
					"user.confirmPassword": {
						required: "Please input your Confirm Password!",
						minlength: "必须大于2个字符!",
						maxlength: "必须小于45个字符!",
						equalTo: "确认密码必须相同!"
					}
				}
			});
			
			$( "#myFormAmend3").validate({
				  rules: {
					"user.password": "required",
					"user.confirmPassword": {
				      equalTo: "#password"
				    }
				  }
			});

		});

	</script>
	
</body>
</html>