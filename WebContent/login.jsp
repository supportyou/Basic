<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<link href="${ctx}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${ctx}/css/styles.css" rel="stylesheet">
</head>
<body>
	
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Log in</div>
				<div class="panel-body">
					<form role="form" action="login.action" method="post" name="myForm" id="myForm">
						<fieldset>
							<div class="form-group">
								<input class="form-control" name="user.email" type="text" placeholder="Email" value="supportyou@126.com">
							</div>
							<div class="form-group">
								<input class="form-control" name="user.password" type="password" placeholder="Password" value="953953">
							</div>
							<div class="form-group">
								<div class="col-sm-8" style="padding-left: 0; padding-right: 0;">
									<input class="form-control" name="cc" type="text" placeholder="Code">
								</div>
								<label for="imgcc" class="col-sm-4 control-label">
									<img src="cc.action" id="imgcc" title="Click for a new" style="cursor: pointer;" onclick="this.src='cc.action?'+Math.random();" />
								</label>
							</div>
							<div class="form-group">
								<div class="col-sm-12" style="padding-left: 0; padding-right: 0;">
									<div class="checkbox">
										<label>
											<input name="remember" type="checkbox" value="Remember Me">Remember Me
										</label>
									</div>
								</div>
							</div>
							<button class="form-control btn btn-primary" type="submit">Submit</button>
							<label for="errorMessage" class="control-label">${errorMessage}</label>
						</fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->

	<script src="${ctx}/vendor/jquery/jquery.min.js"></script>
	<script src="${ctx}/vendor/bootstrap/js/bootstrap.min.js"></script>
	
	<script src="${ctx}/vendor/jquery-validation/jquery.validate.min.js"></script>
	<script src="${ctx}/vendor/jquery-validation/messages_zh.js"></script>

	<script type="text/javascript">

		$(function() {
			$("#myForm").validate({
				rules: {
					"user.email": {
						required: true,
						email: true
					},
					"user.password": {
						required: true,
						minlength: 6
					},
					cc: {
						required: true
					}
				},
				messages: {
					"user.email": {
						required: "Please input your Email!",
						email: "Your Email is invalid!"
					},
					"user.password": {
						required: "Please input your Password!",
						minlength: "Your password must be more than 6!"
					},
					cc: {
						required: "Please input check code!",
					}
				}
			});
		});

	</script>

</body>

</html>
