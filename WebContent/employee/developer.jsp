<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/header/header.jsp"%>

	<c:if test="${(employeeRule == 'Manager')}">
		<h3>Developers</h3>
		<a class="btn" href="Employee?action=new&id=<c:out value='${id}'/>">Add
			Developer</a>
	</c:if>
	<c:if test="${(employeeRule == 'TeamLeader')}">
		<h3>My Developers Team</h3>
	</c:if>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Address</th>
				<c:if
					test="${(employeeRule == 'TeamLeader') || (employeeRule == 'Manager')}">
					<th>Actions</th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${listDeveloperTeam}">
				<tr>
					<td><c:out value="${employee.firstName} ${employee.lastName}" /></td>
					<td><c:out value="${employee.email}" /></td>
					<td><c:out value="${employee.phone}" /></td>
					<td><c:out value="${employee.addres}" /></td>
					<c:if test="${(employeeRule == 'TeamLeader')}">
						<td style="text-align: center;">
						    <a href="Task?action=new&id=<c:out value='${employee.employeeID}'/>">Add</a>
							&nbsp;&nbsp;
							<a href="Task?action=list&id=<c:out value='${employee.employeeID}'/>">Show</a>
						</td>
					</c:if>
					<c:if test="${(employeeRule == 'Manager')}">
						<td style="text-align: center;">
						    <a href="Employee?action=delete&id=<c:out value='${employee.employeeID}'/>">Delete Employee</a>
						    &nbsp;&nbsp;&nbsp;&nbsp; 
						    <a href="Task?action=list&id=<c:out value='${employee.employeeID}'/>">Show Tasks</a>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>