<%
    session=request.getSession(false);
    if(session.getAttribute("currentEmployee")!=null)
    {
        response.sendRedirect("Task?action=list");
    }
%> 
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body style="background-color: white;">

<div class="home">
	<div>
	<h2>Task Management System</h2>
	<p>In this WebSite  there  are three types of users Manager, Team leaders, Developers to manage the tasks between them. </p>
    <a href="<%=request.getContextPath()%>/login.jsp">Login</a>
    </div>
    <img src="img/task.jpg" width=1050px;>	
</div>    
	
</body>
</html>