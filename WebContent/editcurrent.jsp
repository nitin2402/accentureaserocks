<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />



<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	
<script>
	$(document).ready(function() {
		$(".header_09").hide();

	});
</script>
<script type='text/javascript' src='search.js'></script>
</head>


<body>
	
 <%-- <% 
		HttpSession session1 = request.getSession(false);
 %>
		<%-- if (session1 == null
				|| (String) session1.getAttribute("user") == null
				/*  || (String) session1.getAttribute("admin") != "admin" */ ) {
	%><jsp:forward page="login.jsp?msg=Please Login " />
	<%
		} 
	    
	< --%>
<%@ include file="header_admin.jsp" %>  

	<div id="templatemo_content">
	
	<%@ include file="common_left_admintool.jsp"%>



		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">Edit Current Release</div>


				
				<div>
<jstlcore:forEach items="${current}" var="list">
<form action="EditCurrent">
<table>
<tr>
		<td>Current Release</td>
		<td><input type="text" value="${list.currentRelease}" disabled="disabled" style="width:200px;"/>
				<input type="hidden" name="id" value="${list.currentRelease}" /></td> 
		</tr>
		<tr>		
		<td>Project Name</td>
		<td><input type="text" name="name" value="${list.projectName}" style="width:200px;"/></td>

</tr>
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
		<div id="templatemo_content_bottom">&nbsp;</div>
		<div id="templatemo_footer">
			Copyright © 2015 <a href="www.accenture.com">Accenture</a>
		</div>
	</div>
		</body>
</html>