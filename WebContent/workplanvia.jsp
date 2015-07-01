<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pyramid Optimization</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript" src="workplan.js"></script>

</head>
<body>
	<%-- <jsp:include page="/FetchbudgetDetail" /> --%>
	<input type="hidden" id="backup" name="backup" value="0"></input>

	<%
		HttpSession session1 = request.getSession();
		if (session1 == null
				|| (String) session1.getAttribute("user") == null) {
	%><jsp:forward page="login.jsp?msg=Please Login " />
	<%
		}
	%> 
	<div id="templatemo_container" />
	<div id="templatemo_header">
		<div id="site_title_section">
			<div id="site_title">Pyramid Optimization</div>
			<div id="slogan">The place to look back</div>
			<div class="cleaner">&nbsp;</div>
		</div>
<div id="welcome_msg"
			style="color: yellow; float: right; font-size: 12px;">
			Welcome ${user}&nbsp;<a href="logout.jsp">Logout</a>
		</div>
		<div id="header_section_code">"Overall approach is to maintain
			pyramid form for all designation levels as per Accenture compliance."</div>
	</div>

	<div id="templatemo_menu">
		<ul>
		<li><a href="userhome.jsp" class="current">Home</a></li>
			<li><a href="workplanvia.jsp" class="current">Workplan</a></li>
			<li><a href="#">Projects</a></li>
			<li><a href="#">About Us</a></li>
		<!-- 	<li><a href="logout.jsp">Logout</a></li> -->
			<li><a href="#" class="last">Contact Us</a></li>
		</ul>
	</div>

	<div id="templatemo_content">

		<div id="content_left">

			
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">Projects</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="viewEStrategy.jsp">E-Strategy</a></li>
						<li><a href="viewr3.jsp">R3</a></li>
						<li><a href="viewprimier.jsp">Primier</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>

		</div>
		<div id="content_right">

			<div class="right_col_section_w650" style="height: auto;">

				<div class="header_01">Work Plan</div>


				<div class="header_09"></div>
					<ul>
						<li><a href="workplan.jsp">Raise a new request</a></li>


						<li><a href="requeststatus.jsp">Request Status</a></li>
					
					</ul>
				<div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<div id="templatemo_content_bottom">&nbsp;</div>
		<div id="templatemo_footer">
			Copyright © 2015 <a href="www.accenture.com">Accenture</a>
		</div>
	</div>
</body>
</html>