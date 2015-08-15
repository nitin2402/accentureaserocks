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



<!--HEADER OF SIGNUP PAGE  -->
	<div id="templatemo_container">
		<%@ include file="header_login.jsp"%>
	
	<!-- CONTENT OF SIGNUP PAGE -->
		<div id="templatemo_content">
             <!-- content left -->
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
			
			<!-- content right -->
			<div id="content_right">

				<div class="right_col_section_w650" style="height: 400px">

					<form name="registration" action="Registration">
						<table style="font-size: 14px;">
							<tr>
							 	<td>Employee ID:*</td>
								<td><input type="text" name="employeeid" /></td>
							</tr>
							<tr>
								<td>User Name:*</td>
								<td><input type="text" name="newuser" /></td>
							</tr>
							<tr>
								<td>Password:*</td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td>Confirm Password:*</td>
								<td><input type="password" name="cpassword" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Register" onclick="return validateform()" /></td>
								<td><a class="back" href="login.jsp">Back</a></td>
							</tr>
						</table>
					</form>


					<p class="message"><%=request.getParameter("msg") != null ? request
					.getParameter("msg") : ""%></p>

					<div class="cleaner">&nbsp;</div>
				</div>

			</div>
			<!-- end of content right -->

		<div class="cleaner">&nbsp;</div>
		</div>
		<!-- FOOTER OF SIGN UP PAGE -->
		<div id="templatemo_content_bottom">&nbsp;</div>

		<%@ include file="footer.jsp"%>
		
	</div>

</body>
</html>