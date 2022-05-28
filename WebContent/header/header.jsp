<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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