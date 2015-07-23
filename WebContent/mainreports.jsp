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
	
<%@ include file="common_left.jsp" %>

		
			<div id="content_right">

			<div class="right_col_section_w650" style="height: auto;">

				<div class="header_01">Reports</div>


                 <div id="search">
				    <div>
					<ul>
						<li><a href="generateempreports.jsp">Reports Generated for Requests</a></li>
						
						<li><a href="#">Reports Generated for Employee</a></li>


						<li><a href="teamreport.jsp">Reports Generated for Team</a></li>
						
						<li><a href="modulereport.jsp">Reports Generated for Module</a></li>
					</ul>
					</div>
				</div>
				
                <div id="ajaxResponse"></div>
                <p class="error" style="font-size: 14px; color: red;">${message1}</p>
				<div class="margin_bottom_20">&nbsp;</div>
				
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
						<%@ include file="footer.jsp" %> 
	</div>
</body>
</html>