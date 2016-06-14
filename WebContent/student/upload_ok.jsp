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
				<h1 class="page-header">File</h1>
			</div>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Upload File OK</div>
					<div class="panel-body">

						<s:iterator value="newFileName" var="nfn" status="stu">
						<a href="download.action?fileName=${nfn}" target="_blank">${nfn}</a><br>     
						</s:iterator>  
						
						<br>
						<s:iterator value="fileSize" var="fs" status="stu">
						${fs}<br>     
						</s:iterator>
						
						<br>
						<s:iterator value="fileContentType" var="fct" status="stu">
						${fct}<br>     
						</s:iterator>
						
						   
						${remark}



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

		function addmore() {

			var td=document.getElementById("addfile");
			var br=document.createElement("br");
			var input=document.createElement("input");
			var button=document.createElement("input");

			input.type="file";
			input.name="ufile";
			button.type="button";
			button.value="删除";

			button.onclick=function() {
				td.removeChild(br);
				td.removeChild(input);
				td.removeChild(button);
			};

			td.appendChild(br);
			td.appendChild(input);
			td.appendChild(button);
		}    
	</script>
	
</body>
</html>