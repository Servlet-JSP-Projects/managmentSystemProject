<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<% 
	   switch(session.getAttribute("employeeRule").toString()){
	   case "Developer":%><%@include file="/header/developer_header.jsp"%><%
	   break; 
	   case "TeamLeader":%><%@include file="/header/teamLeader_header.jsp"%><%
	   break; 
	   case "Manager" :%><%@include file="/header/manager_header.jsp"%><%
	   break; 
	  } 
   %>
   
   
 	<h3>Teams</h3>
 	<a class="btn" href="Employee?action=newTeam">Add Team</a>
 
   <table class="table table-bordered" style="width:50%;">
			<thead>
				<tr>
					<th>Team Name</th>
					<th>TeamLeader</th>
					<th>No.Developer</th>
					<th>TeamLeader Actions</th>
					<th>Developer Actions</th>
				</tr>
			</thead>					
			<tbody>
		        <c:forEach var="team" items="${listTeam}">
					<tr>
					 	<td><c:out value="${team.teamName}"/></td>
					 	<td><c:out value="${team.teamLeader}"/></td>
					 	<td><c:out value="${team.numberDev}"/></td>
					 	<td style="text-align:center;">
						<a href="Task?action=list&id=<c:out value='${team.teamLeaderID}'/>">Show Tasks</a>
					 	</td>
					 	<td style="text-align:center;">					 	
						<a href="Employee?action=developerTeam&id=<c:out value='${team.teamID}'/>">Show Developers</a>
					 	</td>
					</tr>
			
				</c:forEach>
		   </tbody>
				
	</table>
</body>
</html>