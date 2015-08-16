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

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://www.google.com/jsapi"></script>
<script src="piechart.js"></script>
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
<body>
	<%
		response.addHeader("Cache-Control",
				"no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0");
		response.addHeader("Pragma", "no-cache");
		response.addDateHeader("Expires", 0);
	%>
	<%
		HttpSession session1 = request.getSession(false);
		if (session1 == null || (String) session1.getAttribute("user") == null
				|| (String) session1.getAttribute("admin") != "user") {
	%><jsp:forward page="login.jsp?msg=Please Login " />
	<%
		}
	%>
	<div id="templatemo_container" />
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

		<div id="header_section_code">"The talent management tool is an
			integrated software tool that addresses the four pillars of talent
			management: plan, organize, budget and schedule talents"</div>
	</div>


	<div id="templatemo_menu">
		<ul>
			<li><a href="userhome.jsp" class="current">Home</a></li>
			<!--  <li><a href="addempvia.jsp">Admin Tools</a></li> -->
			<li><a href="workplanvia.jsp">Workplan</a></li>
			<li><a href="ProjectUser.jsp">Projects</a></li>
			<li><a href="user_initiative.jsp">Initiatives</a></li>
			<li><a href="about_us_users.jsp">About Us</a></li>
			<!-- <li><a href="logout.jsp">Logout</a></li>-->
			<li><a href="#" class="last">Contact Us</a></li>
		</ul>
	</div>

	<div id="templatemo_content">

		<div id="content_left">

			<div class="content_left_section">
				<div class="content_left_section_title">Search Employee</div>
				<div class="content_left_section_content">
					<form action="#">
						Name<input type="text" id="search_field" name="search_field" />
						<!--  <input
							type="submit" value="Search" id="search_button" /> -->
						<div>
							<span id="msg1">${param.msg1}</span>
						</div>

					</form>
					<div class="cleaner">&nbsp;</div>
				</div>
				<div class="cleaner">&nbsp;</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">Projects</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="viewEStrategy.jsp">E-Strategy</a></li>
						<li><a href="viewr3.jsp">R3</a></li>
						<li><a href="viewprimier.jsp">Premier</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="content_left_section" style="font-size: 14px">
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
						<li><a href="viewemployee_user.jsp">View Employee</a></li>
						<li><a href="viewteam_user.jsp">View Team</a></li>
						<li><a href="viewmodule_user.jsp">View Module</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>
			<div class="margin_bottom_20">&nbsp;</div>

		</div>

		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01" align="center">Welcome to user page</div>
				<div class="header_09"></div>

				<div>
					<div id="search">
						<div id="piechart"
							style="background-colour: red; height: 300px; width: 600px"
							onclick="clickToStop()"></div>
						<div class="filter">
							<span style="color: brown; font-size: 16px">Filter by</span><br />
							<a onclick="filter('billability')">Billability</a> / <a
								onclick="filter('proficiency')">Proficiency</a> / <a
								onclick="filter('expertise')">Expertise</a>
						</div>
					</div>
					<div id="ajaxResponse"></div>
					<p class="error message">${message}</p>
					<p class="error" style="font-size: 14px; color: red;">${reqId}</p>

					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>

		<div id="templatemo_footer">
			Copyright © 2015 <a href="www.accenture.com">Accenture</a>
		</div>
	</div>
</body>
</html>