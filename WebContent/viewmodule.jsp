
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<jsp:include page="/FetchModuleDetails"/>

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

	  <%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
				|| (String) session1.getAttribute("user") == null
				|| (String) session1.getAttribute("admin") != "admin") {
	%>
	  <jsp:forward page="login.jsp?msg=Please Login as an Admin" /> 
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
			<li><a href="adminhome.jsp" >Home</a></li>
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

		<div class="content_left_section" style="font-size:14px">
				<div class="content_left_section_title">Tasks</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="addempvia.jsp" >Add Employee </a></li>
							
						
						<li><a href="addmodulevia.jsp" >Add Module</a></li>
						<li><a href="addteamvia.jsp" >Add Team</a></li>
					</ul>
			
					<div class="cleaner">&nbsp;</div>
				</div>
				<div class="cleaner">&nbsp;</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>
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
						
							
						<li><a href="viewemployee.jsp" >View Employee</a></li>
						<li><a href="viewteam.jsp" >View Team</a></li>
						<li><a href="viewmodule.jsp" style="font-weight:bold;text-decoration:underline">View Module</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>

		</div>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: auto">

			
				<div class="header_01" >Module Details</div>
					<div id="scrollable"   style="font-size: 14px;">
						<table class="table1" >
							
							<thead style="font-weight:bold;position: ">
							<tr style="font-weight:bold;">
								<td></td>
								<td>ModuleId</td>
								<td>ModuleName</td>
								<td>ModuleDescription</td>
								<td>ProjectId</td>
							</tr>
							</thead>
						
							<tbody  >
							<jstlcore:forEach items="${ModuleList}" var="item">
								<tr>
									<td><input type="radio" name="moduleDetails" value=""></input></td>
									<td><jstlcore:out value="${item.moduleId}" /></td>
									<td><jstlcore:out value="${item.moduleName}" /></td>
									<td><jstlcore:out value="${item.moduleDescription}" /></td>
									<td><jstlcore:out value="${item.projectId}" /></td>
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
<br></br>
				<div>
				
				<input type="button" id="" onclick="" value="Edit"></input>
				<input type="button" id="" onclick="" value="Delete"></input>
				</div>
				
				<div>


					<div style="font-size: 14px;">
		<%-- <table>
			<tr>
				<td>PROJECT:</td>
				<td><select name="project" id="project"><jstlcore:forEach
							var="aff" items="${project}">

							<option value="${aff}">${aff}</option>
						</jstlcore:forEach></select>]</td>
			</tr>
		</table>
		 --%>
					</div>
<br/><br/>
<div style="color: red;font-size: 12px">${message}</div>

					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<div id="templatemo_content_bottom">&nbsp;</div>
		<div id="templatemo_footer">
			Copyright � 2015 <a href="www.accenture.com">Accenture</a>
		</div>
	</div>





</body>
</html>