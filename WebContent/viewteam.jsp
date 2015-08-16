
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />



<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script>
<script type='text/javascript' src='searchAdmin.js'></script>
<script>
	$(document).ready(function() {

		$("#ViewteamCss").css({

			"font-weight" : "bold",
			"text-decoration" : "underline"
		});
	});
</script>

</head>
<body>
	<%@ include file="header_admin.jsp"%>
	<jsp:include page="/FetchTeamDetails" />

	<%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
		/* || (String) session1.getAttribute("user") == null
		|| (Boolean) session1.getAttribute("admin") != true */) {
	%><jsp:forward page="home.jsp?msg=Please Login as an Admin" />
	<%
		}
	%>

	<div id="templatemo_content">
		<%@ include file="common_left_admintool.jsp"%>
		<div id="content_right">

			<div class="right_col_section_w650" style="height: auto">
				<div id="search">
					<div class="header_01">View Team</div>
					<div>${team}</div>

					<div>
						<br />
						<br />
						<div style="color: red; font-size: 12px">${message}</div>

						<div style="font-size: 14px;"></div>
					</div>

					<div class="cleaner">&nbsp;</div>
				</div>
				<div id="ajaxResponse"></div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>






</body>
</html>