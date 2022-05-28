<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
   <%@include file="/header/header.jsp"%>
	  
   <c:if test="${(isMyTask == 'no')}">
	 <h3><c:out value="${employeeName}"/> Tasks</h3>
   </c:if>
   <c:if test="${(isMyTask == 'yes')}">
	 <h3>My Tasks</h3>
	 <a class="btn" href="Task?action=deleteComp">Delete Completed tasks</a>
   </c:if>
   <table class="table table-bordered">
			<thead>
				<tr>
					<th>Task Name</th>
					<th>Description </th>
					<th>Create Date</th>
					<th>Finish Date</th>
					<th>Status</th>
					<c:if test="${(isMyTask != 'no')}">
						<th>Task Actions</th>
                    </c:if>
				</tr>
			</thead>					
			<tbody>
		        <c:forEach var="task" items="${listTask}">
					<tr>
					 	<td><c:out value="${task.name}"/></td>
					 	<td><c:out value="${task.description}"/></td>
					 	<td style="text-align:center;"><c:out value="${task.createDate}"/></td>
					 	<td style="text-align:center;"><c:out value="${task.finishDate}"/></td>
					 	<td><c:out value="${task.status}"/></td>					 	
					 	<c:if test="${(isMyTask != 'no')}">
					 		<td>
							 	<c:if test="${(task.status == 'Completed')}">
							 		<a href="Task?action=uncompleted&id=<c:out value='${task.taskID}'/>">UnComplete</a>
							 	    &nbsp;&nbsp; 
		                        </c:if>
		                        <c:if test="${(task.status == 'In Progress')}">
							 		<a href="Task?action=completed&id=<c:out value='${task.taskID}'/>">Complete</a>
							 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                        </c:if>
		                        <c:if test="${(employeeRule == 'TeamLeader')||(employeeRule == 'Manager')}">
							 		<a href="Task?action=delete&id=<c:out value='${task.taskID}'/>">Delete</a>
		                        </c:if>
					 	    </td>
	                    </c:if>	
					</tr>
				</c:forEach>
		   </tbody>
	</table>
</body>

</html>