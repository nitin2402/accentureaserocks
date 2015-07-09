<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Talent Management Tool</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

</head>
<body>
	
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
				<div class="content_left_section_title">Tasks</div>
				<div class="content_left_section_content">
					<ul>
						<li><a href="admintool.jsp" class="current" style="font-weight: bold; text-decoration: underline">Add Employee </a></li>


						<li><a href="addmodulevia.jsp">Add Module</a></li>
						<li><a href="addteamvia.jsp">Add Team</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>
			
			
				<div class="margin_bottom_20">&nbsp;</div>










		<div class="content_left_section" style="font-size: 14px">

			<div class="content_left_section_title">Projects</div>
			<div class="content_left_section_content">
				<ul>

					<li><a href="viewemployee.jsp">View Employees</a></li>


					<li><a href="viewteam.jsp">View Teams</a></li>

					<li><a href="viewmodule.jsp">View Module</a></li>

				</ul>


			</div>
			<div class="content_left_section_bottom">&nbsp;</div>
		</div>

		<div class="margin_bottom_20">&nbsp;</div>

		</div>
</body>
</html>