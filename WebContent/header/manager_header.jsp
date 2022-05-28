<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<header>
	<h2>Task Management System</h2>
	<div style="width: 30rem; padding-left: 15rem;">
		<a href="<%=request.getContextPath()%>/Task?action=list">My Task</a> 
		<a href="<%=request.getContextPath()%>/Task?action=new">Add Task</a>
		<div class="dropdown">
			<a class="icon">Employee <i class="fa fa-caret-down"></i></a>
			<div class="dropdown-content">
				<a href="<%=request.getContextPath()%>/Employee?action=all">All</a>
				<a href="<%=request.getContextPath()%>/Employee?action=team">Team</a>
				<a href="<%=request.getContextPath()%>/Employee?action=allDeveloper">Developer</a>
			</div>
		</div>
		<div class="dropdown">
			<a>Account <i class="fa fa-caret-down"></i></a>
			<div class="dropdown-content">
				<p>${sessionScope.currentEmployee.email}</p>
				<p>Type (${sessionScope.currentEmployee.employeeRule})</p>
				<a href="<%=request.getContextPath()%>/Employee?action=logout">Logout</a>
			</div>
		</div>
	</div>
</header>