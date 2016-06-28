<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<div class="panel-heading">All Documents</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-12">
								<span>
									<a class="btn btn-primary" id="myAdd" href="${ctx}/student/document_add.jsp">Add</a>
								</span>
								<span class="pull-right">
									<a class="btn btn-primary" id="" href="">Other</a>
								</span>
							</div>
						</div>
						<br>
						<table class="table table-responsive table-hover table-bordered table-condensed table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>File Topic</th>
									<th>File Name</th>
									<th>File Size</th>
									<th>V</th>
									<th>A</th>
									<th>C</th>
									<th>D</th>
								</th>
							</thead>
							<tbody>
							<c:if test="${page.content.size()>0}">
								<c:forEach items="${page.content}" var="tbl">
								<tr>
									<td>${tbl.id}</td>
									<td>${tbl.fileTopic}</td>
									<td><a href="download.action?fileName=${tbl.fileName}&newFileName=${tbl.newFileName}" target="_blank">${tbl.fileName}</a></td>
									<td>${tbl.fileSize}</td>
									<td><a href="findonedocument.action?forWhere=view&id=${tbl.id}" target="_blank" title="View"><span class="glyphicon glyphicon-search"></span></a></td>
									<td><a href="findonedocument.action?forWhere=amend&id=${tbl.id}" title="Amend"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="findonedocument.action?forWhere=copy&id=${tbl.id}" title="Copy"><span class="glyphicon glyphicon-list"></span></a></td>
									<td><a href="deletedocument.action?id=${tbl.id}" class="myDelete" title="Delete"><span class="glyphicon glyphicon-remove"></span></a></td>
								</tr>
								</c:forEach>
							</c:if>
							</tbody>
						</table>

						<br>
						
						<div class="row">
							<div class="col-sm-12">
								<p:page totalElements="${page.totalElements}" pageNo="${page.pageNo}" pageSize="${page.pageSize}" url="findalldocumentbypager.action"/>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div><!--/.row-->
		
		<div class="row">

		</div><!--/.row-->

	</div>	<!--/.main-->
		
	
	<div id="myModalDelete" class="modal fade" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal">&times;</button>
					<h1 class="modal-title" id="myModalLabel" style="color:#cc0000;"><span class="glyphicon glyphicon-warning-sign"></span> Delete Confirm</h1>
				</div>
				<div class="modal-body" id="myModalBodyAmend">
					<h4>Are you sure to delete it ?</h4>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="button" data-dismiss="modal">No</button>
					<button class="btn btn-primary" type="button" id="myDeleteYes">Yes</button>
				</div>
			</div>
		</div>
	</div>
	
	<script src="${ctx}/vendor/jquery/jquery.min.js"></script>
	<script src="${ctx}/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ctx}/vendor/bootstrap-table/bootstrap-table.js"></script>
	
	<script src="${ctx}/vendor/jquery-validation/jquery.validate.min.js"></script>
	<script src="${ctx}/vendor/jquery-validation/messages_zh.js"></script>
	
	<script type="text/javascript">

		$(function() {
			$(".myDelete").click(function() {
				var href = $(this).attr("href");
				
				$("#myModalDelete").modal("show");

				$("#myDeleteYes").one("click", function() {
					location.assign(href);
				});
				
				return false;
			});
		});
	</script>

</body>
</html>