
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body style="background-color: white;">

<form action=Login method=post class="loginform">
	<img src="img/task.jpg" width=850px;>
	<div class="logininput">
		<h2>Login to Task Management System</h2>
		<div class="inputcontainer">
			<i class="fa fa-user icon"></i>
			<input type="text" placeholder="Username" name="email" >
	    </div>
		<div class="inputcontainer">
			<i class="fa fa-lock icon"></i>
			<input type="text" placeholder="Password" name="password">
		</div>
	    <button type="submit">Login</button>
	</div>
</form>
</body>
</html>