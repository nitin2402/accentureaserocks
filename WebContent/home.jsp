<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pyramid Optimization</title>
<meta name="keywords"
	content="Bird Store Online, CSS Template, Free Download" />
<meta name="description"
	content="Bird Store Online - Download Free CSS Template" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

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
<script type="text/javascript">
	function validateform() {

		var name = document.forms["login"]["USERNAME"].value;
		var password = document.forms["login"]["PASSWORD"].value;

		if (name == null || name == "") {
			alert("Please provide UserName");
			return false;
		}
		if (password == null || password == "") {
			alert("Please provide Password");
			return false;
		}
	}
</script>


</head>
<body>
	<div id="templatemo_container">
		<div id="templatemo_header">
			<div id="site_title_section">
				<div id="site_title">Pyramid Optimization</div>
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


				<li><a href="#">About Us</a></li>
				<li><a href="#" class="last" onclick="myfunction()">Contact
						Us</a></li>
			</ul>
		</div>
		<!-- end of menu -->

		<div id="templatemo_content">

			<div id="content_left">

				<div class="content_left_section">
					<div class="content_left_section_title">Login</div>
					<div class="content_left_section_content">
						<form name="login" onsubmit="return validateform()"
							action="AdminLogin" method="post">
							User Name<input type="text" id="USERNAME" name="USERNAME" /> <br />
							<br /> Password<input type="password" id="PASSWORD"
								name="PASSWORD" /> <input type="submit" value="Login"
								id="search_button" /> <br /> <br /> <a href="newuser.jsp"
								style="font-size: 14px; text-decoration: underline; font-weight: normal;">Sign
								up</a>
						</form>
						<div class="cleaner">&nbsp;</div>
					</div>
					<div class="cleaner">&nbsp;</div>
					<div class="content_left_section_bottom">&nbsp;</div>
				</div>

				<div class="margin_bottom_10">&nbsp;</div>

			</div>
			<!-- end of content left -->

			<div id="content_right">

				<div class="right_col_section_w650">

					<div class="header_01">The project hierarchy</div>
					<img src="images/templatemo_image_01.jpg" alt="image" />


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
			Copyright � 2015 <a href="http://www.accenture.com">Accenture</a>
		</div>
		<!-- end of footer -->
	</div>
	<!-- end of container -->
</body>
</html>