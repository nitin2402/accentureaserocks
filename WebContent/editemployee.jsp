
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pyramid Optimization</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type='text/javascript' src='search.js'></script>
<script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script>
<script type="text/javascript">
	$(function() {
		$('.last').click(
				function(event) {
					var email = 'chinu.mohanty@accenture.com';
					var subject = 'Feedback';
					var emailBody = 'Hi Chinu,';
					window.location = 'mailto:' + email + '?subject=' + subject
							+ '&body=' + emailBody;
				});
	});
</script>


</head>
<body><body><%@ include file="header_admin.jsp" %> 
	<jsp:include page="/fetchmodule.jsp" />

	<%

HttpSession session1 = request.getSession(false);
if (session1 == null  ||  (String)session1.getAttribute("user") == null || (Boolean)session1.getAttribute("admin") != true ){
    %><jsp:forward page="home.jsp?msg=Please Login as an Admin" /><%
}
%><div id="templatemo_content">

		<%@ include file="common_left_admintool.jsp"%>
	
		<div id="content_right">

			<div id="search" class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Edit Employee</div>


				<div>

<jstlcore:forEach items="${searchList}" var="list">

<form action="EditEmployee">
<table >
<tr>
				<td>EMPLOYEE ID:</td>
				<td><input type="text" value="${list.empId}" disabled="disabled" style="width:200px;"/>
				<input type="hidden" name="id" value="${list.empId}" /></td>

			</tr>
			<tr>
				<td>EMPLOYEE NAME:</td>
				<td><input type="text" name="name" value="${list.empName}" style="width:200px;"/></td>

			</tr>
		
			<tr>
				<td>EMPLOYEE LEVEL:</td>
				<td><input type="text" name="level" value="${list.level}" style="width:200px;"/></td>
			</tr>
			<tr>
				<td>EMPLOYEE DESIGNATION:</td>
				<td><input type="text" name="desig" value="${list.designation}" style="width:200px;"/></td>
			</tr>
			<tr>
				<td>EMPLOYEE EXPERTISE:</td>

				<td><input type="text" name="area" value="${list.expertise}" style="width:200px;"/></td>
			</tr>
			<tr>
				<td>EMPLOYEE ATTID:</td>
				<td><input type="text" name="att" value="${list.att}" style="width:200px;"/></td>

			</tr>
			<tr>
				<td>EMPLOYEE EMAIL:</td>
				<td><input type="text" name="email" value="${list.email}" style="width:200px;"/></td>

			</tr>
			<%-- <tr>
				<td>EMPLOYEE EXPERIENCE:</td>
				<td><input type="text" name="exp" value="${list.experience}"/></td>
			</tr> --%>
			<tr><td><input type="submit" value="Change"/></td></tr>
			</table>
			
</form>
</jstlcore:forEach>



					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>
			

			<div class="cleaner">&nbsp;</div>
		</div>
		<%@ include file="footer.jsp"%>
		</div>
	</div>


</body>
</html>





