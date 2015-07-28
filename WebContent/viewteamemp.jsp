<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

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
<%
	HttpSession session1 = request.getSession(false);
%>
<%
	if ((String) session1.getAttribute("admin") == "admin") {
%>

<script type='text/javascript' src='searchAdmin.js'></script>
<%
	}
%>

<%
	if ((String) session1.getAttribute("admin") == "user") {
%>
<script type='text/javascript' src='search.js'></script>
<%
	}
%>
</head>
<body>
	<%

HttpSession session2 = request.getSession(false);
if (session2 == null || (String)session2.getAttribute("user") == null  ){
    %><jsp:forward page="login.jsp?msg=Please Login " /><%
}
%>
	<div id="templatemo_container">
	<div id="templatemo_header">
		<div id="site_title_section">
			<div id="site_title">Talent Management Tool</div>
			<div id="slogan">Plan, Organize, Budget, Schedule</div>
			<div class="cleaner">&nbsp;</div>
		</div>
		<div id="welcome_msg"
			style="color: yellow; float: right; font-size: 12px;">
			Welcome ${user}&nbsp;<a href="logout.jsp">Logout</a>
			</div>

		<div id="header_section_code">"The talent management tool is an integrated software tool that addresses the four pillars of talent management: plan, organize, budget and schedule talents"</div>
	</div>

	<div id="templatemo_menu">
		<ul>
			<%
				 if ((String) session1.getAttribute("admin") == "admin") { 
			%>
			
				<li><a href="adminhome.jsp">Home</a></li>
			<li><a href="admintool.jsp"">Admin Tools</a></li>
			<li><a href="searchrequest.jsp">Workplan</a></li>
			<li><a href="ProjectAdmin.jsp">Projects</a></li>
			<li><a href="mainreports.jsp">Reports</a></li>
			<li><a href="admin_initiative.jsp">Initiatives</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#" class="last">Contact Us</a></li>
			<%
				 }
			%>
			<%
				 if ((String) session1.getAttribute("admin") == "user") { 
			%>

			<li><a href="userhome.jsp">Home</a></li>
			<li><a href="workplanvia.jsp">Workplan</a></li>
			<li><a href="user_initiative.jsp">Initiatives</a></li>
			<li><a href="ProjectUser.jsp">Project</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#" class="last">Contact Us</a></li>
			
			<%
				 } 
			%>
			
		</ul>
	</div>

	<div id="templatemo_content">
	
	<%@ include file="common_left.jsp" %>
	

		<div id="content_left">

		<%-- 	<div class="content_left_section">
				<div class="content_left_section_title">Search</div>
				<div class="content_left_section_content">
					<form action="#">
						<input type="text" id="search_field" name="search_field" /> <input
							type="submit" value="Search" id="search_button" />
						<div>
							<span id="msg1">${msg1}</span>
						</div>

					</form>
					<div class="cleaner">&nbsp;</div>
				</div>
				<div class="cleaner">&nbsp;</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div> --%>
			
				
			

			

		</div>
		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Team Employee Details</div>
					<div id="search">

				<div>


					<div style="font-size: 14px;">
						<div id="scrollable">${displaylist}</div> 
					</div>



					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>
			<div id="ajaxResponse"></div>
				<p class="error" style="font-size: 14px; color: red;">${message}</p>
			<div class="cleaner">&nbsp;</div>
		</div>
		</div>
		<div id="templatemo_content_bottom">&nbsp;</div>
		<div id="templatemo_footer">
			Copyright © 2015 <a href="www.accenture.com">Accenture</a>
		</div>
	</div>
</div>

</body>
</html>