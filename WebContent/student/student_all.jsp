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
					<div class="panel-heading">All Students</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-12">
								<span>
									<a class="btn btn-primary" id="myAdd" href="${ctx}/student/student_add.jsp">Add</a>
									<a class="btn btn-primary" id="myAddExcel" href="#">批量增加</a>
									<!--
									<a class="btn btn-primary" id="myAdd" href="#">Add</a>
									<a class="btn btn-primary" id="myAddByAjax" href="#">Add By Ajax</a>
									-->
								</span>
								<span class="pull-right">
									<a class="btn btn-primary" id="myPdf" href="javascript:">PDF</a>
									<a class="btn btn-primary" id="myExcel" href="javascript:">Excel</a>
								</span>
							</div>
						</div>
						<br>
						<form action="" method="post">
						<table id="myTable" class="table table-responsive table-hover table-bordered table-condensed table-striped">
							<thead>
								<tr>
									<th><input type="checkbox" id="myCheckbox"></th>
									<th>ID</th>
									<th>User Name</th>
									<th>Sex</th>
									<th>Birthday</th>
									<th>Degree</th>
									<th>Remark</th>
									<th>Non-Active</th>
									<th>V</th>
									<th>A</th>
									<th>C</th>
									<!--<th>A</th>-->
									<th>D</th>
									<th>P</th>
								</th>
							</thead>
							<tbody>
							<c:if test="${page.content.size()>0}">
								<c:forEach items="${page.content}" var="tbl">
								<tr>
									<td><input type="checkbox" name="box" value="${tbl.id}"></td>
									<td>${tbl.id}</td>
									<td>${tbl.userName}</td>
									<td>${tbl.sex}</td>
									<td>${tbl.birthday}</td>
									<td>${tbl.degree}</td>
									<td>${tbl.remark}</td>
									<td>${tbl.nonActive}</td>
									<td><a href="findonestudent.action?forWhere=view&id=${tbl.id}" target="_blank" title="View"><span class="glyphicon glyphicon-search"></span></a></td>
									<td><a href="findonestudent.action?forWhere=amend&id=${tbl.id}" title="Amend"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="findonestudent.action?forWhere=copy&id=${tbl.id}" title="Copy"><span class="glyphicon glyphicon-list"></span></a></td>
									<!--<td><a onClick="myClick('${tbl.id}')" id="myAmend" title="Amend"><span class="glyphicon glyphicon-th"></span></a></td>-->
									<td><a href="deletestudent.action?id=${tbl.id}" class="myDelete" title="Delete"><span class="glyphicon glyphicon-remove"></span></a></td>
									<td><a href="findonestudent.action?forWhere=pdf&id=${tbl.id}" target="_blank" title="PDF">P</span></a></td>
								</tr>
								</c:forEach>
							</c:if>
							</tbody>
						</table>
						</form>

						<br>
						
						<div class="row">
							<div class="col-sm-12">
								<p:page totalElements="${page.totalElements}" pageNo="${page.pageNo}" pageSize="${page.pageSize}" url="findallstudentbypager.action"/>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div><!--/.row-->
		
		<div class="row">

		</div><!--/.row-->

	</div>	<!--/.main-->

	<form class="form-horizontal" role="form" action="savestudent.action" method="post" name="myFormAdd" id="myFormAdd">
	<div id="myModalAdd" class="modal fade" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal">&times;</button>
					<h1 class="modal-title" id="myModalLabel">Please Add</h1>
				</div>
				<div class="modal-body" id="myModalBodyAdd">
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
					<button class="btn btn-primary" type="submit" id="mySubmitAdd">Save</button>
					<button class="btn btn-primary" type="button" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	</form>

	<form class="form-horizontal" role="form" action="savestudent.action" method="post" name="myFormAddByAjax" id="myFormAddByAjax">
	<div id="myModalAddByAjax" class="modal fade" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal">&times;</button>
					<h1 class="modal-title" id="myModalLabel">Please Add By Ajax</h1>
				</div>
				<div class="modal-body" id="myModalBodyAddByAjax">
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="submit" id="mySubmitAddByAjax">Save</button>
					<button class="btn btn-primary" type="button" data-dismiss="modal">Close</button>
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
				<div class="modal-body" id="myModalBodyAmend">
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="submit" id="mySubmitAmend">Save</button>
					<button class="btn btn-primary" type="button" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	</form>

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
	
	<form class="form-horizontal" role="form" action="export_excelInto.action" enctype="multipart/form-data" method="post" name="myFormAddExcel" id="myFormAddExcel">
	<div id="myModalAddExcel" class="modal fade" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal">&times;</button>
					<h1 class="modal-title" id="myModalLabel">Please upload</h1>
				</div>
				<div class="modal-body" id="myModalBodyAddExcel">
					<div class="form-group">
						<label for="userName" class="col-sm-3 control-label">Excel File:</label>
						<div class="col-sm-5">
							<input type="file" class="form-control" id="uploadFile" name="uploadFile" placeholder="Excel File" required>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="submit" id="mySubmitAddExcel">Upload</button>
					<button class="btn btn-primary" type="button" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	</form>
	
	<script src="${ctx}/vendor/jquery/jquery.min.js"></script>
	<script src="${ctx}/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ctx}/vendor/bootstrap-table/bootstrap-table.js"></script>
	
	<script src="${ctx}/vendor/jquery-validation/jquery.validate.min.js"></script>
	<script src="${ctx}/vendor/jquery-validation/messages_zh.js"></script>
	
	<script type="text/javascript">
		
		//$(function() {
			//$("#myAdd").click(function() {
				//$("#myModalAdd").modal("show");
			//});
		//});

		//$(function() {
			//$("#mySubmit").click(function() {
				//$("#myForm").submit();
				//$("#myModal").modal("hide");
			//});
		//});

		$(function() {
			$("#myAddByAjax").click(function() {
				$("#myModalBodyAddByAjax").load("${ctx}/student/add.jsp");
				$("#myModalAddByAjax").modal("show");

			});
		});

		function myClick(id) {
			$("#myModalBodyAmend").load("findonestudent.action?forWhere=amend&id="+id+"");
			$("#myModalAmend").modal("show");
		}

		$(function() {
			$("#myFormAdd").validate();
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
		
		function selectAll(){
			var str=document.getElementsByName("box");
			if(!$("#myCheckbox").attr("checked")){
				for(var i=0;i<str.length;i++){
					str[i].checked=true;
				}
			}else{
				for(var i=0;i<str.length;i++){
					str[i].checked=false;
				}
			}
		}
		
		$(function(){
			var str=document.getElementsByName("box");
	        $("#myCheckbox").click(function(){
	            if(this.checked) {
					for(var i=0;i<str.length;i++){
						str[i].checked=true;
					}
	            } else {
					for(var i=0;i<str.length;i++){
						str[i].checked=false;
					}
	            }
	        });
	    });
		
		var ids='';
		$(function(){
			$("#myPdf").click(function(){
				$("#myTable input[type='checkbox']").each(function(){
					if($(this).is(":checked")){if($(this).val()!='on'){ids=ids+$(this).val()+',';}}
				});
				if(ids==''){
					alert("请选择要导出的数据！");
				}else{
					if(confirm("确认导出选中数据吗？")){
						document.forms[1].action="export_pdfExport.action?ids="+ids;
						document.forms[1].submit();
						ids='';
					}else{
					//将复选框的状态更改为位选中，并清空所有的Id数值
						$.each($("#myTable input[type='checkbox']"),function(i,v){if($(v).attr("checked")=="checked"){ v.checked=false;}});ids='';
					}
				}
			});
		});
		
		var ids='';
		$(function(){
			$("#myExcel").click(function(){
				$("#myTable input[type='checkbox']").each(function(){
					if($(this).is(":checked")){if($(this).val()!='on'){ids=ids+$(this).val()+',';}}
				});
				if(ids==''){
					alert("请选择要导出的数据！");
				}else{
					if(confirm("确认导出选中数据吗？")){
						document.forms[1].action="export_excelExport.action?ids="+ids;
						document.forms[1].submit();
						ids='';
					}else{
					//将复选框的状态更改为位选中，并清空所有的Id数值
						$.each($("#myTable input[type='checkbox']"),function(i,v){if($(v).attr("checked")=="checked"){ v.checked=false;}});ids='';
					}
				}
			});
		});
		
		$(function() {
			$("#myFormAddExcel").validate({
				rules: {
					"uploadFile": {
						required: true
					}
				},
				messages: {
					"uploadFile": {
						required: "Please select your File!"
					}
				}
			});
		});
		
		$(function() {
			$("#myAddExcel").click(function() {
				$("#myModalAddExcel").modal("show");
			});
		});

		$(function() {
			$("#mySubmitAddExcel").click(function() {
				$("#myFormAddExcel").submit();
				//$("#myModalAddExcel").modal("hide");
				
				$("#myModalAddExcel").on('hide.bs.modal', function () {
					$("#myFormAddExcel").validate({
						rules: {
							"uploadFile": {
								required: true
							}
						},
						messages: {
							"uploadFile": {
								required: "Please select your File!"
							}
						}
					});
				});

			});
		});
	</script>

</body>
</html>