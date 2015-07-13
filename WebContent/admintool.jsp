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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type='text/javascript' src='admintool.js'></script>
<script type='text/javascript' src='search.js'></script>
</head>
<body>
	<%@ include file="header_admin.jsp" %>
	<%
		HttpSession session1 = request.getSession(false);

		if (session1 == null

		|| (String) session1.getAttribute("user") == null

		|| (String) session1.getAttribute("admin") != "admin") {
	%><jsp:forward page="login.jsp?msg=Please Login as an Admin" />

	<%
		}
	%>




	<div id="templatemo_content">

	
<%@ include file="common_left_admintool.jsp" %>
		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Employee Addition</div>


				<div id="search">
					<div style="font-size: 14px;">
						<form action="AddEmpChoice" name="radio1"
							onsubmit="return validateform2()">
							<input type="radio" name="select" value="addfromexcel" id="excel">Add
								From Excel<br /> <br /> <br /> <input type="radio"
								name="select" value="addmanually" id="manually">Add
									Manually<br /> <br /> <input type="submit" value="select">
						</form>
					</div>
					<br /> <br /> <br /> <br />
					<div class="notification">${message1}</div>

					<div class="cleaner">&nbsp;</div>
				</div>
				<div id="ajaxResponse"></div>
				<p class="error" style="font-size: 14px; color: red;">${message}</p>

				<div class="cleaner">&nbsp;</div>
			</div>
			<div class="margin_bottom_20">&nbsp;</div>
		</div>
			<%@ include file="footer.jsp" %> 
			</div>
		
			  
			</body>  
</html>