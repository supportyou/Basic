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
				<li class="active">Document</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Document</h1>
			</div>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">New Document</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" action="savedocument.action" method="post" name="myFormAdd" id="myFormAdd" enctype="multipart/form-data">
							<table class="table table-responsive table-hover table-bordered table-condensed table-striped" id="myTable">
								<thead>
									<tr>
										<th>File Topic</th>
										<th>File</th>
										<th></th>
									</th>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" class="form-control" id="fileTopic" name="fileTopic" placeholder="File Topic" value="${document.fileTopic}"></td>
										<td><input type="file" class="form-control" id="file" name="file" placeholder="File"></td>
										<td>
											<a href="#"><span class="addRow glyphicon glyphicon-plus" title="Add Row"></span></a>
											<a href="#"><span class="removeRow glyphicon glyphicon-trash" title="Remove Row"></span></a>
										</td>
									</tr>
								</tbody>
							</table>
							<br>
							<div class="form-group">
								<div class="col-md-2 col-md-offset-3">
									<button type="submit" class="form-control btn btn-primary">Submit</button>
								</div>
								<div class="col-md-2 col-md-offset-1">
									<button type="reset" class="form-control btn btn-warning">Reset</button>
								</div>
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
	
	<script src="${ctx}/vendor/jquery-ui/jquery-ui.min.js"></script>
	<script src="${ctx}/vendor/jquery-validation/jquery.validate.min.js"></script>
	<script src="${ctx}/vendor/jquery-validation/messages_zh.js"></script>

	<script type="text/javascript">

		$(function() {
			$("#myFormAdd").validate({
				rules: {
					"fileTopic": {
						required: true,
						minlength: 2,
						maxlength: 45
					},
					"file": {
						required: true
					}
				},
				messages: {
					"fileTopic": {
						required: "Please input your File Topic!",
						minlength: "必须大于2个字符!",
						maxlength: "必须小于45个字符!"
					},
					"file": {
						required: "Please select your File!"
					}
				}
			});
		});


		$(".addRow").click(function() {
			var tr_row = $("#myTable>tbody>tr:first");
			var row = tr_row.clone(true);

			$("input[name='fileTopic']",row).val("");
			$("input[name='file']",row).val("");

			$("#myTable>tbody").append(row);
		});

		$(".removeRow").click(function() {
			if($("#myTable>tbody>tr").size() > 1) {
				$(this).parent().parent().parent().remove();
			}
		});

	</script>
	
</body>
</html>