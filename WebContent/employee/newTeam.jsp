<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@include file="/header/header.jsp"%>

	<form action=Employee?action=insertTeam method=post>
		<div class=addTeam>
			<h3>Add new Team</h3>
			Team Name<input type="text" name="teamName"> <br> <b>
			Team Leader Information</b> <br> <br>
			<div class="name">
				<div>
					First Name<input type="text" name="firstName">
				</div>
				<div>
					Last Name<input type="text" name="lastName">
				</div>
			</div>
			 Email<input type="text" name="email">
			 Address <input type="text" name="address">
			 Phone<input type="text" name="phone">
			<button type="submit" style="margin-top: 0.4rem">Add</button>
		</div>
	</form>
</body>
</html>