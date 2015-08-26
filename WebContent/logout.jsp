<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Talent Management Tool</title>
<meta name="keywords"
	content="Bird Store Online, CSS Template, Free Download" />
<meta name="description"
	content="Bird Store Online - Download Free CSS Template" />
	<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
	<script src="login.js"></script> 
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		
</head>
<body>
<jsp:include page = "/Logout"/>
<div id="templatemo_container">
			<%@ include file="header_login.jsp"%>
		<div id="templatemo_content">

			<div id="content_left">

				<div class="content_left_section">
					<div class="content_left_section_title">Login</div>
					<div class="content_left_section_content">
						<form name="login" 
							action="AdminLogin" method="post">
							User Name*<input type="text" id="USERNAME" name="USERNAME" /> <br />
							<br /> Password*<input type="password" id="PASSWORD"
								name="PASSWORD" /> <input type="submit" value="Login"
								id="search_button" /> <br /> <br /><a href="signup.jsp"
								style="font-size: 14px; text-decoration: underline; font-weight: normal;">Sign
								up</a>
								<br/><br/>
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

                 <p class = "message"><%=request.getParameter("msg") != null ? request
					.getParameter("msg") : ""%>${msg}</p>

					<div class="cleaner">&nbsp;</div>
				</div>

			</div>
			<!-- end of content right -->
			<div class="cleaner">&nbsp;</div>
		</div>
		<!-- end of container -->
		<div id="templatemo_content_bottom">&nbsp;</div>

		<%@ include file="footer.jsp"%>
		<!-- end of footer -->
	</div>
	<!-- end of container -->

</body>
</html>