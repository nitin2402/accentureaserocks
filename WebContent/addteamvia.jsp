<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='search.js'></script>


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
<script type="text/javascript" src="addteamvia.js"></script> 
</head>
<body>



	<%

HttpSession session1 = request.getSession(false);
if (session1 == null   || (String)session1.getAttribute("user") == null /* || (Boolean)session1.getAttribute("admin") != true  */){
    %><jsp:forward page="home.jsp?msg=Please Login as an Admin" /><%
}
%>
	<div id="templatemo_container" />
	<div id="templatemo_header">
		<div id="site_title_section">
			<div id="site_title">Talent Management Tool</div>
			<div id="slogan">The place to look back</div>
			<div class="cleaner">&nbsp;</div>
		</div>

		<div id="header_section_code">"Overall approach is to maintain
			pyramid form for all designation levels as per Accenture compliance."</div>
	</div>

	<div id="templatemo_menu">
		<ul>
			<li><a href="adminhome.jsp" >Home</a></li>
			<li><a href="admintool.jsp" class="current">Admin Tools</a></li>
			<li><a href="#">Workplan</a></li>
			<li><a href="#">Projects</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="logout.jsp">Logout</a></li>
			<li><a href="#" class="last">Contact Us</a></li>
		</ul>
	</div>

	<div id="templatemo_content">

		<div id="content_left">
			<%@ include file="common_left_team.jsp" %>
			<div class="content_left_section" style="font-size:14px">
				<div class="content_left_section_title">Tasks</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="admintool.jsp" >Add Employee </a></li>
							
						
						<li><a href="addmodulevia.jsp" >Add Module</a></li>
						<li><a href="addteamvia.jsp" style="font-weight: bold; text-decoration: underline" >Add Team </a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>
			<div class="content_left_section" style="font-size:14px">
				<div class="content_left_section_title">View</div>
				<div class="content_left_section_content">
					<%-- <form action="#">
						<input type="text" id="search_field" name="search_field" /> <input
							type="submit" value="Search" id="search_button" />
						<div>
							<span id="msg1">${msg1}</span>
						</div>

					</form> --%>
					<ul>
						<li><a href="viewemployee.jsp" >View Employees</a></li>
					
						<li><a href="viewteam.jsp" >View Teams</a></li>
						<li><a href="viewmodule.jsp" >View Module</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>
			<div class="margin_bottom_20">&nbsp;</div>

		</div>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Team Addition</div>


				<div id="search">


					<div style="font-size: 14px;">
						<form action="TeamSelect"  onsubmit="return validateformteam()">
							<input type="radio" name="select" value="addfromexcel" id= "excel1" />Add
								From Excel <br />
							<br />
							<br /><input type="radio" name="select" value="addmanually" id="manually1" />Add
								Manually<br />
							<br/><input type="submit" value="Select"> </input>
						</form>
					</div>



					<div class="cleaner">&nbsp;</div>
				</div>
				<div id="ajaxResponse"></div>
				<p class="error" style="font-size: 14px; color: red;">${message}</p>
				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<div id="templatemo_content_bottom">&nbsp;</div>
		<div id="templatemo_footer">
			Copyright © 2015 <a href="www.accenture.com">Accenture</a>
		</div>
	</div>
	<%@ include file="footer.jsp" %> 
</body>
</html>