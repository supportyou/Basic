<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" uri="/mytags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link href="${ctx}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
		<link href="${ctx}/student/navbar-fixed-top.css" rel="stylesheet">
		<meta name="viewport" content="width=device-width, 
                                     initial-scale=1.0, 
                                     maximum-scale=1.0, 
                                     user-scalable=no">
	</head>
	<body>

	    <!-- Fixed navbar -->
	    <nav class="navbar navbar-default navbar-fixed-top">
	      <div class="container">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="#">Project name</a>
	        </div>
	        <div id="navbar" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav navbar-right">
	            <li class="active"><a href="#">Home</a></li>
	            <li><a href="#about">About</a></li>
	            <li><a href="#contact">Contact</a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	                <li><a href="#">Action</a></li>
	                <li><a href="#">Another action</a></li>
	                <li><a href="#">Something else here</a></li>
	                <li role="separator" class="divider"></li>
	                <li class="dropdown-header">Nav header</li>
	                <li><a href="#">Separated link</a></li>
	                <li><a href="#">One more separated link</a></li>
	              </ul>
	            </li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
	
	    <div class="container">

	      <div class="well well-lg">

					<table class="table table-responsive table-hover table-bordered table-condensed">
						<caption>所有学生列表</caption>
						<thead>
							<tr>
								<th>ID</th>
								<th>User Name</th>
								<th>Sex</th>
								<th>Remark</th>
								<th>View</th>
								<th>Amend</th>
								<th>AmendAjax</th>
								<th>Delete</th>
							</th>
						</thead>
						<tbody>
						<c:if test="${page.content.size()>0}">
							<c:forEach items="${page.content}" var="tbl">
							<tr>
								<td>${tbl.id}</td>
								<td>${tbl.userName}</td>
								<td>${tbl.sex}</td>
								<td>${tbl.remark}</td>
								<td><a href="findonestudent.action?forWhere=view&id=${tbl.id}" target="_blank"><span class="glyphicon glyphicon-list-alt"></span></a></td>
								<td><a href="findonestudent.action?forWhere=amend&id=${tbl.id}"><span class="glyphicon glyphicon-th"></span></a></td>
								<td><a onClick="myClick('${tbl.id}')" id="myAmend"><span class="glyphicon glyphicon-th"></span>Amend</a></td>
								<td><a href="deletestudent.action?id=${tbl.id}"><span class="glyphicon glyphicon-remove"></span></a></td>
							</tr>
							</c:forEach>
						</c:if>
						</tbody>
					</table>

					<br>
					
					<div class="row">
						<div class="col-md-3">
							<a class="btn btn-sm btn-primary" id="myAdd" href="#">Add</a>
						</div>
						<div class="col-md-3">
							<a class="btn btn-sm btn-primary" id="myAddByAjax" href="#">Add By Ajax</a>
						</div>
						<div class="col-sm-6">
							<p:page totalElements="${page.totalElements}" pageNo="${page.pageNo}" pageSize="${page.pageSize}" url="findallstudentbypager_bp.action"/>
						</div>
					</div>

	      </div>
	
	    </div> <!-- /container -->


		<div class="container">
			<hr>
			<div class="row">
				<div class="col-sm-12">&copy; 2016 All Rights Reserved.</div>
			</div>
		</div>

		<script src="${ctx}/vendor/jquery/jquery.js"></script>
		<script src="${ctx}/vendor/bootstrap/js/bootstrap.min.js"></script>

		<script src="${ctx}/vendor/jquery-validation/jquery.validate.min.js"></script>
		<script src="${ctx}/vendor/jquery-validation/messages_zh.js"></script>

		<script type="text/javascript">
			
			$(function() {
				$("#myAdd").click(function() {
					$("#myModal").modal("show");
				});
			});

			$(function() {
				$("mySubmit").click(function() {
					$("myForm").submit();
					$("#myModal").modal("hide");
				});
			});

			$(function() {
				$("#myAddByAjax").click(function() {
					$("#AddByAjaxBody").load("student/add.jsp");
					$("#myModalByAjax").modal("show");

				});
			});

			function myClick(id) {
				$("#AmendByAjaxBody").load("findonestudent.action?forWhere=amend&id="+id+"");
				$("#myModalAmend").modal("show");
			}

			$(function() {
				$("#myForm").validate();
			});

			$(function() {
				$("#myFormAmend").validate({
					rules: {
						"student.userName": {
							required: true,
							minlength: 2
						},
						"student.sex": "required"
					},
					messages: {
						"student.userName": {
							required: "Please input your User Name!",
							minlength: "必须大于2个!!"
						},
						"student.sex": "请输入性别！"
					}
				});
			});


		</script>

		<form class="form-horizontal" role="form" action="savestudent.action" method="post" name="myForm" id="myForm">
		<div id="myModal" class="modal fade" tabindex="-1" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" type="button" data-dismiss="modal">&times;</button>
						<h1 class="modal-title" id="myModalLabel">Please Add</h1>
					</div>
					<div class="modal-body">
						   <div class="form-group">
						      <label for="userName" class="col-sm-3 control-label">User Name:</label>
						      <div class="col-sm-5">
						         <input type="text" class="form-control" id="userName" name="student.userName" placeholder="User Name" required>
						      </div>
						   </div>
						   <div class="form-group">
						      <label for="sex" class="col-sm-3 control-label">Sex:</label>
						      <div class="col-sm-5">
						         <input type="text" class="form-control" id="sex" name="student.sex" placeholder="Sex" required>
						      </div>
						   </div>
						   <div class="form-group">
						      <label for="remark" class="col-sm-3 control-label">Remark:</label>
						      <div class="col-sm-5">
						         <input type="text" class="form-control" id="remark" name="student.remark" placeholder="Remark">
						      </div>
						   </div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-lg btn-primary" type="submit" id="mySubmit">Submit</button>
						<button class="btn btn-lg btn-primary" type="button" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		</form>

		<form class="form-horizontal" role="form" action="savestudent.action" method="post" name="myFormByAjax" id="myFormByAjax">
		<div id="myModalByAjax" class="modal fade" tabindex="-1" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" type="button" data-dismiss="modal">&times;</button>
						<h1 class="modal-title" id="myModalLabel">Please Add By Ajax</h1>
					</div>
					<div class="modal-body" id="AddByAjaxBody">
					</div>
					<div class="modal-footer">
						<button class="btn btn-lg btn-primary" type="submit" id="mySubmit">Submit</button>
						<button class="btn btn-lg btn-primary" type="button" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		</form>

		<form class="form-horizontal" role="form" action="updatestudent.action" method="post" name="myFormAmend" id="myFormAmend">
		<div id="myModalAmend" class="modal fade" tabindex="-1" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" type="button" data-dismiss="modal">&times;</button>
						<h1 class="modal-title" id="myModalLabel">Please Amend</h1>
					</div>
					<div class="modal-body" id="AmendByAjaxBody">
					</div>
					<div class="modal-footer">
						<button class="btn btn-lg btn-primary" type="submit" id="mySubmit">Submit</button>
						<button class="btn btn-lg btn-primary" type="button" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		</form>

	</body>
</html>


