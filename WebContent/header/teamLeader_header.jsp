<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<header>
	<h2>Task Management System</h2>
	<div style="width: 31.5rem; padding-left: 15rem;">
		<a href="<%=request.getContextPath()%>/Task?action=list">My Task</a>
		<a href="<%=request.getContextPath()%>/Task?action=new">Add Task</a> 
		<a href="<%=request.getContextPath()%>/Employee?action=developerTeam">Developer	Team</a>
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