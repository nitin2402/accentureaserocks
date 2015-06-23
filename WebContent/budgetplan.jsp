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

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

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
	<jsp:include page="/FetchbudgetDetail" />
	<%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
				|| (String) session1.getAttribute("user") == null) {
	%><jsp:forward page="home.jsp?msg=Please Login " />
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

		<div id="header_section_code">"Overall approach is to maintain
			pyramid form for all designation levels as per Accenture compliance."</div>
	</div>

	<div id="templatemo_menu">
		<ul>
			<%
				if ((Boolean) session1.getAttribute("admin") == true) {
			%>
			<li><a href="adminhome.jsp">Home</a></li>
			<li><a href="addempvia.jsp">Admin Tools</a></li>
			<%
				}
			%>
			<%
				if ((Boolean) session1.getAttribute("admin") == false) {
			%>

			<li><a href="userhome.jsp">Home</a></li>

			<%
				}
			%>
			<li><a href="#">Workplan</a></li>
			<li><a href="#">Projects</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="logout.jsp">Logout</a></li>
			<li><a href="#" class="last">Contact Us</a></li>
		</ul>
	</div>

	<div id="templatemo_content">

		<div id="content_left">

			<%-- 	<div class="content_left_section">
				<div class="content_left_section_title">Search</div>
				<div class="content_left_section_content">
					<form action="#">
						<input type="text" id="search_field" name="search_field" /> <input
							type="submit" value="Search" id="search_button" />
						<div>
							<span id="msg1">${msg1}</span>
						</div>

					</form>
					<div class="cleaner">&nbsp;</div>
				</div>
				<div class="cleaner">&nbsp;</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div> --%>
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

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Team Employee Details</div>


				<div>


					<div style="font-size: 14px;">
<form action="AddBudget">

						<table>
						<jstlcore:forEach items="${budgetList}" var="li">
						<tr>
								<td>${li.designation}</td><td><input type="text" name="${li.designation}" value="${li.budgetValue}"></input></td>
							</tr>
							</jstlcore:forEach>
						<!-- <tr>
								<td>Manager</td><td><input type="text" name="M" id="M"></input></td>
							</tr>
						<tr>
								<td>Associate manager</td><td><input type="text" name="AM" id="AM"></input></td>
							</tr>
							<tr>
								<td>Team Lead</td><td><input type="text" name="TL" id="TL"></input></td>
							</tr>
							<tr>
								<td>Senior Software Engineer</td><td><input type="text" name="SSE" id="SSE"></input></td>
							</tr>
							<tr>
								<td>Software Engineer</td><td><input type="text" name="SE" id="SE"></input></td>
							</tr>
							<tr>
								<td>Associate Software engineer</td><td><input type="text" name="ASE" id="ASE"></input></td>
							</tr> -->
							<tr style="height: 20px"><td/></tr>
							<tr><td><input type="submit" value="Assign"></input></td></tr>
						</table> 
</form>
					</div>
<br/>
<div style="color: red;font-size: 14px">${message}</div>

					<div class="cleaner">&nbsp;</div>
				</div>

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