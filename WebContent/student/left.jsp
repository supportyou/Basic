<%@ page pageEncoding="UTF-8"%>
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li class="active"><a href="#"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
			<li><a href="findallstudentbypager.action"><span class="glyphicon glyphicon-th"></span> Student</a></li>
			<li><a href="findalldocumentbypager.action"><span class="glyphicon glyphicon-stats"></span> Document</a></li>
			<li><a href=""><span class="glyphicon glyphicon-list-alt"></span> Menu2</a></li>
			<li><a href=""><span class="glyphicon glyphicon-pencil"></span> Menu3</a></li>
			<li><a href=""><span class="glyphicon glyphicon-info-sign"></span> Menu4</a></li>
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> Settings <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 1
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 2
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 3
						</a>
					</li>
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
			<li><a href="logout.action"><span class="glyphicon glyphicon-user"></span> Login Page</a></li>
		</ul>
	</div><!--/.sidebar-->