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
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$(".header_09").hide();
	});
</script>

<script>
	$(document).ready(
			function() {

				$('#search_field').keyup(
						function(event) {
							var searchvalue = $("#search_field").val();
							$(".error").hide();
							$.ajax({
								url : "/TMT/SearchEmployee",
								type : "POST",
								data : 'searchName=' + searchvalue,

								success : function(data) {

									$(".header_01").hide();
									$(".header_09").show();
									$(".header_09").text(
											'Search results for \"'
													+ searchvalue + '\"');
							if (data != "") {
										$("#excel").hide();
										 $("#ajaxResponse").show();
										$("#ajaxResponse").html(data); 
									} else {

										 $("#ajaxResponse").hide(); 

										$("#excel").show().delay(1000);
										$(".header_09").hide();
										$(".header_01").show();

									} 

								},
								error : function() {

								}
							});

						});
			});
</script>

<script type='text/javascript' src='addempexcel.js'></script>
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

		<div id="content_left">
<div class="content_left_section">
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

					</form></div>
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
			<div class="content_left_section" style="font-size: 14px">
				<div class="content_left_section_title">View</div>
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
		</div>
		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Select File to upload</div>


				<div>


					<div id="excel" style="font-size: 14px;">
			

						<form action="AddEmployeeExcel" method="post" onsubmit="return Validate(this);">
						
						Choose the Excel File to Upload:-
						<input type="file" name="file1" size="50" /> <br /> <br /> <br />
						<input type="hidden" id="sheetno" name="sheetno" />
						<br /> <input type="submit" value="submit" />
						</form>
						<br />
						
					</div>

<div id="ajaxResponse"></div>
					<p class="error" style="font-size: 14px; color: red;">${message}</p>

					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<%@ include file="footer.jsp" %>     
	</div>


</body>
</html>