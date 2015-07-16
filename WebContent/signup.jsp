<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<meta name="keywords"
	content="Bird Store Online, CSS Template, Free Download" />
<meta name="description"
	content="Bird Store Online - Download Free CSS Template" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="signup.js"></script> 
</head>
<body>
	<div id="templatemo_container">
		<div id="templatemo_header">
			<div id="site_title_section">
				<div id="site_title">Talent Management Tool</div>
				<div id="slogan">The place to look back</div>
				<div class="cleaner">&nbsp;</div>
			</div>

			<div id="header_section_code">"Overall approach is to maintain
				pyramid form for all designation levels as per Accenture
				compliance."</div>
		</div>
		<!-- end of header -->
		<div id="templatemo_menu">
			<ul>
				<!-- 
				<li><a href="#">Workplan</a></li>
				<li><a href="#">Projects</a></li> -->
				<li><a href="about_us_common.jsp">About Us</a></li>
				<li><a href="#" class="last" onclick="myfunction()">Contact
						Us</a></li>
			</ul>
		</div>
		<!-- end of menu -->
		<div id="templatemo_content">

			<div id="content_left">

				<div class="content_left_section">
					<div class="content_left_section_title">User Registration</div>
					<div class="content_left_section_content">

						<div class="cleaner">&nbsp;</div>
					</div>
					<div class="cleaner">&nbsp;</div>
					<div class="content_left_section_bottom">&nbsp;</div>
				</div>

				<div class="margin_bottom_10">&nbsp;</div>

			</div>
			<!-- end of content left -->
			<div id="content_right">

				<div class="right_col_section_w650" style="height: 400px">

					<form name="registration" action="Registration"
						onsubmit="return validateform()">
						<table style="font-size: 14px;">
							<tr>
							 	<td>Employee ID:</td>
								<td><input type="text" name="employeeid" /></td>
							</tr>
							<tr>
								<td>User Name:</td>
								<td><input type="text" name="newuser" /></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td>Confirm Password:</td>
								<td><input type="password" name="cpassword" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Register" /></td>
							</tr>
						</table>
					</form>


					<p style="font-size: 14px; color: red;"><%=request.getParameter("msg") != null ? request
					.getParameter("msg") : ""%></p>

					<div class="cleaner">&nbsp;</div>
				</div>

			</div>
			<!-- end of content right -->

		<div class="cleaner">&nbsp;</div>
		</div>
		<!-- end of container -->
		<div id="templatemo_content_bottom">&nbsp;</div>

		<div id="templatemo_footer">
			Copyright © 2015 <a href="http://www.accenture.com">Accenture</a>
		</div>
		<!-- end of footer -->
	</div>
	<!-- end of container -->
</body>
</html>