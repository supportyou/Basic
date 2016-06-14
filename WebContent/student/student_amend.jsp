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
				<li class="active">Student</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Student</h1>
			</div>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Amend Students</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" action="updatestudent.action" method="post" name="myFormAmend" id="myFormAmend">
							<div class="form-group">
								<label for="userName" class="col-sm-3 control-label">User Name:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="userName" name="student.userName" placeholder="User Name" value="${student.userName}">
								</div>
								<div class="col-sm-1">
									<button class="btn btn-default btn-sm" id="myOpen" type="button">Open</button>
								</div>
							</div>
							<div class="form-group">
								<label for="sex" class="col-sm-3 control-label">Sex:</label>
								<label class="checkbox-inline">
									<input type="radio" id="sexMan" name="student.sex" value="Man" <c:if test="${student.sex == 'Man'}">checked</c:if>> Man
								</label>
								<label class="checkbox-inline">
									<input type="radio" id="sexWoman" name="student.sex" value="Woman" <c:if test="${student.sex == 'Woman'}">checked</c:if>> Woman
								</label>
							</div>
							<div class="form-group">
								<label for="birthday" class="col-sm-3 control-label">Birthday:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="birthday" name="student.birthday" placeholder="Birthday" value="${student.birthday}">
								</div>
							</div>
							<div class="form-group">
								<label for="degree" class="col-sm-3 control-label">Degree:</label>
								<div class="col-sm-5">
									<select class="form-control" id="degree" name="student.degree">
										<option <c:if test="${student.degree == '大学'}">selected</c:if>>大学</option>
										<option <c:if test="${student.degree == '中学'}">selected</c:if>>中学</option>
										<option <c:if test="${student.degree == '小学'}">selected</c:if>>小学</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="interest" class="col-sm-3 control-label">Interest:</label>
								<div class="col-sm-5">
									<select multiple size="4" class="form-control" id="interest" name="student.interest">
										<option <c:forTokens items="${student.interest}" delims="," var="interest"><c:if test="${fn:trim(interest) == '体育'}">selected</c:if></c:forTokens>>体育</option>
										<option <c:forTokens items="${student.interest}" delims="," var="interest"><c:if test="${fn:trim(interest) == '音乐'}">selected</c:if></c:forTokens>>音乐</option>
										<option <c:forTokens items="${student.interest}" delims="," var="interest"><c:if test="${fn:trim(interest) == '美术'}">selected</c:if></c:forTokens>>美术</option>
										<option <c:forTokens items="${student.interest}" delims="," var="interest"><c:if test="${fn:trim(interest) == '其它'}">selected</c:if></c:forTokens>>其它</option>
									</select>
								</div>
							</div>							
							<div class="form-group">
								<label for="remark" class="col-sm-3 control-label">Remark:</label>
								<div class="col-sm-5">
									<textarea class="form-control" rows="3" id="remark" name="student.remark" placeholder="Remark">${student.remark}</textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="nonActive" class="col-sm-3 control-label">Non-Active:</label>
								<div class="col-sm-5">
									<div class="checkbox">
										<label>
											<input type="checkbox" id="nonActive" name="student.nonActive" value="Yes" <c:if test="${student.nonActive == 'Yes'}">checked</c:if>>Will be Non-Active
										</label>
									</div>
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
						<input type="hidden" name="student.id" value="${student.id}">
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
	
	<script src="${ctx}/vendor/jquery-ui/jquery-ui.min.js"></script>
	<script src="${ctx}/vendor/jquery-validation/jquery.validate.min.js"></script>
	<script src="${ctx}/vendor/jquery-validation/messages_zh.js"></script>

	<script type="text/javascript">

		$(function() {
			$("#myFormAmend").validate({
				rules: {
					"student.userName": {
						required: true,
						minlength: 2,
						maxlength: 45
					},
					"student.birthday": {
						dateISO: true
					},
					"student.interest": {
						required: true,
						minlength: 2
					}
				},
				messages: {
					"student.userName": {
						required: "Please input your User Name!",
						minlength: "必须大于2个字符!",
						maxlength: "必须小于45个字符!"
					},
					"student.birthday": {
						dateISO: "必须输入一个有效的日期!"
					},
					"student.interest": {
						minlength: "必须选择两个兴趣爱好!"
					}
				}
			});
		});

		$("#birthday").datepicker({
			changeYear: true,
			changeMonth: true,
			dateFormat: "yy-mm-dd"
		});

		
	</script>
	
</body>
</html>