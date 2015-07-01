<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pyramid Optimization</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />


</head>

<body>		
		<jsp:include page="/RequestStatus"/>
		
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
			<div id="site_title">Talent Management Tool</div>
			<div id="slogan">The place to look back</div>
			<div class="cleaner">&nbsp;</div>
		</div>

		<div id="header_section_code">"Overall approach is to maintain
			pyramid form for all designation levels as per Accenture compliance."</div>
	</div>

	<div id="templatemo_menu">
		<ul>
			<li><a href="userhome.jsp" class="current">Home</a></li>
			<li><a href="workplanvia.jsp">Workplan</a></li>
			<li><a href="#">Projects</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="logout.jsp">Logout</a></li>
			<li><a href="#" class="last">Contact Us</a></li>
		</ul>
	</div>

	<div id="templatemo_content">

		<div id="content_left">

			<div class="content_left_section">
				<div class="content_left_section_title">Search Employee</div>
				<div class="content_left_section_content">
					<form action="#">
						Name<input type="text" id="search_field" name="search_field" />
						<!--  <input
							type="submit" value="Search" id="search_button" /> -->
						<div>
							<span id="msg1">${param.msg1}</span>
						</div>

					</form>
					<div class="cleaner">&nbsp;</div>
				</div>
				<div class="cleaner">&nbsp;</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>
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
						<li><a href="viewemployee_user.jsp" >View Employee</a></li>
						<li><a href="viewteam_user.jsp">View Team</a></li>
						<li><a href="viewmodule_user.jsp" >View Module</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>
			<div class="margin_bottom_20">&nbsp;</div>
		</div>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: auto">

			
				<div class="header_01" >Status of requests</div>
					<div id="scrollable"   style="font-size: 14px;">
						<table class="table1" >
							
							<thead style="font-weight:bold;position: ">
							<tr style="font-weight:bold;">
								<td>ReqId</td>
								<td>TeamId</td>
								<td>No_Of_ASE</td>
								<td>No_of_SE</td>
								<td>No_of_SSE</td>
								<td>comment</td>
								<td>Status</td>
							</tr>
							</thead>
						
							<tbody  >
							<jstlcore:forEach items="${StatusList}" var="item">
								<tr>
									
									
									<td><jstlcore:out value="${item.reqId}" /></td>
									<td><jstlcore:out value="${item.teamId}" /></td>
									<td><jstlcore:out value="${item.noOfASE}" /></td>
									<td><jstlcore:out value="${item.noOfSE}" /></td>
									<td><jstlcore:out value="${item.noOfSSE}" /></td>
									<td><jstlcore:out value="${item.comments}" /></td>
									<td><jstlcore:out value="${item.statusName}" /></td> 
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
			Copyright © 2015 <a href="www.accenture.com">Accenture</a>
		</div>
	
</body>
</html>