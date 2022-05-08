<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudfslare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
   <form action=Task?action=insert&id=<c:out value='${id}'/> method=post>  
	   	<div class="addTask">
	   	   <h3>Add new Task</h3>
	   	   Task Name<input type="text" name="name" >
           Task Description<textarea name="description" ></textarea>
  
           <button type="submit">Add Task</button> 
	   	</div>
    
   </form>
</body>
</html>