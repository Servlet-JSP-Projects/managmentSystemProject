<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<header>
	<h2>Task Management System</h2>
	<div style="margin-left: 15rem; width: 16rem;">
		<a href="<%=request.getContextPath()%>/Task?action=list">Tasks</a>
		<div class="dropdown">
			<a>Account <i class="fa fa-caret-down "></i></a>
			<div class="dropdown-content">
				<p>${sessionScope.currentEmployee.email}</p>
				<p>Type (${sessionScope.currentEmployee.employeeRule})</p>
				<a href="<%=request.getContextPath()%>/Employee?action=logout">Logout</a>
			</div>
		</div>
	</div>
</header>