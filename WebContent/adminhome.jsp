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
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$(".header_09").hide();

	});
</script>
<script src="https://www.google.com/jsapi"></script>
<script src="piechart.js"></script>
<script src="search.js"></script>
</head>
<body>
	

	<%@ include file="header_admin.jsp"%>
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

			<div class="right_col_section_w650">

				<div class="header_01">Top View Of The Project</div>
				<div class="header_09"></div>

				<div>
					<div id = "search">
					<div id="piechart"
						style="background-colour: red; height: 300px; width: 600px"
						onclick="clickk()"></div>
						<div class="filter" ><span style="color: brown;font-size: 16px">Filter by</span><br/>
					<a onclick="filter('billability')">Billability</a> /
					<a onclick="filter('proficiency')">Proficiency</a> /
					<a onclick="filter('expertise')">Expertise</a>
					</div>
					</div>
					<div id="ajaxResponse"></div>
					<p class="error message">${message}</p>


					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<%@ include file="footer.jsp"%>

	</div>

</body>
</html>