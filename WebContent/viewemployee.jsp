
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
<!--   <script>
	$(document).ready(
			function() {

				$('#s_module').change(
						function(event) {
							var dropDownValue = $("#s_module").children(
									"option").filter(":selected").text();

							$.ajax({
								url : "/EmployeeMSAccessDB/FetchTeam",
								type : "POST",
								data : 'moduleName=' + dropDownValue,

								success : function(data) {

									$("#ajaxResponse").html(data);

								},
								error : function() {

								}
							});

						});
			});
</script> -->

</head>
<body>


	<jsp:include page="/ViewEmployee" />
	<%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
				|| (String) session1.getAttribute("user") == null
						/*||  (Boolean) session1.getAttribute("admin") != true */) {
	%><jsp:forward page="home.jsp?msg=Please Login as an Admin" />
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
			<li><a href="adminhome.jsp">Home</a></li>
			<li><a href="addempvia.jsp">Admin Tools</a></li>
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
				<div class="content_left_section_title">Tasks</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="addempvia.jsp">Add Employee</a></li>


						<li><a href="addmodule.jsp">Add Module</a></li>
						<li><a href="addteam.jsp">Add Team</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>
			
			
			
<div class="content_left_section" style="font-size:14px">
				<div class="content_left_section_title">View</div>
				<div class="content_left_section_content">
					<%-- <form action="#">
						<input type="text" id="search_field" name="search_field" /> <input
							type="submit" value="Search" id="search_button" />
						<div>
							<span id="msg1">${msg1}</span>
						</div>

					</form> --%>
					<ul>
						<li><a href="viewemployee.jsp" style="font-weight: bold; text-decoration: underline">View Employee</a></li>
							
						
						<li><a href="viewteam.jsp" >View Team</a></li>
						<li><a href="viewmodule.jsp" >View Module</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>
			<div class="margin_bottom_20">&nbsp;</div>

		</div>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Employee Details</div>


				<div>


					<div id="scrollable"   style="font-size: 14px;">
						<table class="table1" >
							
							<thead style="font-weight: bold;position: ">
							<tr style="font-weight: bold;">
								<td >Name</td>
								<td>ID</td>
								<td>Level</td>
								<td>Designation</td>
								<td>Expertise</td>
								<td>AttID</td>
								<td>Email</td>
								<td>Team</td>
								<td>Module</td>
								<td>Project</td>
							</tr>
							</thead>
						
							<tbody  >
							<jstlcore:forEach items="${empList}" var="item">
								<tr>
									<td><jstlcore:out value="${item.empName}" /></td>
									<td><jstlcore:out value="${item.empId}" /></td>
									<td><jstlcore:out value="${item.level}" /></td>
									<td><jstlcore:out value="${item.designation}" /></td>
									<td><jstlcore:out value="${item.expertise}" /></td>
									<td><jstlcore:out value="${item.att}" /></td>
									<td><jstlcore:out value="${item.email}" /></td>
									<td><jstlcore:out value="${item.team}" /></td>
									<td><jstlcore:out value="${item.module}" /></td>
									<td><jstlcore:out value="${item.project}" /></td>
								</tr>
							</jstlcore:forEach></tbody></table>
							
						

						<%-- 	<table>
			<tr>
				<td>MODULE:</td>
				<td>[<select name="s_module" id="s_module"><jstlcore:forEach
							var="aff" items="${modu}">

							<option value="${aff}">${aff}</option>
						</jstlcore:forEach></select>]</td>
			</tr><tr>
		<!-- <td>TEAM:</td>	<td id="ajaxResponse"></td> --></tr>
		</table> --%>

					</div>

					<div>${msg1}</div>

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