<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pyramid Optimization</title>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="admintool.js"></script> 

<meta charset="utf-8" />
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
</head>
<body>

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
			<li><a href="admintool.jsp" class="current">Admin Tools</a></li>
			<li><a href="#">Workplan</a></li>
			<li><a href="#">Projects</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="logout.jsp">Logout</a></li>
			<li><a href="#" class="last">Contact Us</a></li>
		</ul>
	</div>
	<div id="templatemo_content">

		<div id="content_left">
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">Tasks</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="admintool.jsp">Add Employee</a></li>
						<li><a href="addmodulevia.jsp">Add Module</a></li>
						<li><a href="addteam.jsp">Add Team</a></li>
					</ul>

					<div class="cleaner">&nbsp;</div>
				</div>
				<div class="cleaner">&nbsp;</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">View</div>
				<div class="content_left_section_content">
				
					<ul>
						<li><a href="viewemployee.jsp">View Employee</a></li>


						<li><a href="viewteam.jsp">View Team</a></li>
						<li><a href="viewmodule.jsp">View Module</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>

		</div>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Enter Time</div>
				<script>
 					 $(function() {
 					 $( "#datepicker1" ).datepicker();
 					 });
  				</script>

				<div>
				<form  action="EmployeeReportServlet" method="post">
				<p>Start Date: <input type="text" id="datepicker" name="startdate" /></p>
				<p>End Date : <input type="text" id="datepicker1" name="enddate" /></p>
				<p>Select Status :</p>
				<select name="status">
					<option value=""></option>
 				 	<option value="pending">Pending</option>
  					<option value="onhold">OnHold</option>
 				 	<option value="accepted">Accepted</option>
					<option value="rejected">Rejected</option>
				</select>
				<br />
				<br />
				<button type="submit" value="Submit">Generate Report</button>
				</form>
				<br />
				<br />
				<p><b>Note:</b> Reports Generated for Employee </p>
				
					<br />
					<br />
					<br />
					<br />
					<div class="notification">${message}</div>

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