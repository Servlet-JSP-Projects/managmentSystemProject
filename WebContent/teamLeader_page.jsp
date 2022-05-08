<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<link rel="stylesheet" href="css/style.css">

<title>Insert title here</title>
</head>
<body>
  <%@include file="/header/teamLeader_header.jsp"%>
  
  <table class="table table-bordered">
			<thead>
				<tr>
					<th>Task Name</th>
					<th>Description </th>
					<th>Create Date</th>
					<th>Finish Date</th>
					<th>Status</th>
					<th>Actions</th>
				</tr>
			</thead>					
			<tbody>
		        <c:forEach var="task" items="${listTask}">
					<tr>
					 	<td><c:out value="${task.name}"/></td>
					 	<td><c:out value="${task.description}"/></td>
					 	<td><c:out value="${task.createDate}"/></td>
					 	<td><c:out value="${task.finishDate}"/></td>
					 	<td><c:out value="${task.status}"/></td>
					 	<td><c:out value='-'/></td>	
					</tr>
			
				</c:forEach>
		   </tbody>
				
	</table>
	
	<table class="table table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email </th>
					<th>phone</th>
					<th>addres</th>
					<th>Actions</th>
				</tr>
			</thead>					
			<tbody>
		        <c:forEach var="employee" items="${DevloperTeamEmployee}">
					<tr>
					 	<td><c:out value="${employee.firstName} ${employee.lastName}"/></td>
					 	<td><c:out value="${employee.email}"/></td>
					 	<td><c:out value="${employee.phone}"/></td>
					 	<td><c:out value="${employee.addres}"/></td>
					 	<td><c:out value="-"/></td>
					</tr>
			
				</c:forEach>
		   </tbody>
				
	</table>
</body>
</html>