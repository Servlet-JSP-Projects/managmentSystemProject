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

	<form action=Employee?action=insert&type=Developer&id=
		<c:out value='${id}'/> method=post>
		<div class=addEmplyee>
			<h3>Add new Developer</h3>
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
			<button type="submit" style="margin-top: 4rem;">Add</button>
		</div>
	</form>
</body>
</html>