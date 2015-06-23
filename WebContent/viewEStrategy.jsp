<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pyramid Optimization</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<title>E-Strategy</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
	function validate() {
		var regExp = /^[a-zA-Z]{1,100}$/;

		var msg1 = document.getElementById("msg1");

		msg1.innerHTML = "";

		if (!regExp.test(form1.search_field.value)) {
			msg1.innerHTML = "Name should be in alpha !";
			return false;
		}

	}
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
<script>
	$(document).ready(function() {

		/* $("#clickk").hide(); */

		$('li.teamclick').on('click', function() {
			var team = $(this).text();
			var module = $(this).attr('id');

			$("#ajaxResponse").show();
			/* $("#piechart").hide(); */

			$.ajax({

				url : "/TMT/FetchTeamEmployees",
				type : "POST",
				data : {
					'teamName' : team,
					'moduleName' : module
				},

				success : function(data) {

					$("empclick").show();
					$("#ajaxResponse").html(data);
					/* 	$("#clickk").show(); */
					$("#teamnam").val(team);

				},
				error : function() {

				}
			});

		});
	});
</script>

<!-- <script>
	function fetch(){
			alert($("#teamname").val());
			
		$.ajax({
			url : "/EmployeeMSAccessDB/FetchTeamEmployees",
			type : "POST",
			data : 'teamName=' + team,
			success : function(data) {
					$("empclick").show();
				$("#ajaxResponse").html(data);
						$("#clickk").show(); 

		 	},
			error : function() {

				} 
			}); 

	}
</script> -->

<!-- <script>
	$(document).ready(function() {
	
		/* $("#clickk").hide(); */

		$('.fetchmembers').on('click', function() {
alert("Hi");
			var team = document.getElementById("teamname");
			/* $("#piechart").hide(); */

			$.ajax({
				url : "/EmployeeMSAccessDB/DisplayEmpList",
				type : "POST",
				data : 'teamName=' + team,

				success : function(data) {

					$("#emplist").html(data);
					/* 	$("#clickk").show(); */

				},
				error : function() {

				}
			});

		});
	});
</script>
 -->

<!-- <script>
	$(document).ready(function()
			{
		
	/* $("#clickk").hide(); */

		
			});

	</script>
 -->
</head>
<body>
	<%
		HttpSession session1 = request.getSession(false);
		if (session1 == null
				|| (String) session1.getAttribute("user") == null) {
	%><jsp:forward page="home.jsp?msg=Please Login" />
	<%
		}
	%>
	<jsp:include page="/ViewReport" />

	<div id="templatemo_container"></div>
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
				/* if ((Boolean) session1.getAttribute("admin") == true) { */
			%>
			<li><a href="adminhome.jsp">Home</a></li>
			<li><a href="addempvia.jsp">Admin Tools</a></li>
			<%
				/* } */
			%>
			<%
				/* if ((Boolean) session1.getAttribute("admin") == false) { */
			%>

			<li><a href="userhome.jsp">Home</a></li>

			<%
				/* } */
			%>

			<li><a href="#">Workplan</a></li>
			<li><a href="#" class="current">Projects</a></li>
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
					<form id="form1" name="form1" action="#">
						<input type="text" id="search_field" name="search_field"
							onchange="validate()" />
						<div>
							<span id="msg1">${param.msg1}</span>
						</div>

					</form>
					<div class="cleaner">&nbsp;</div>
				</div>
				<div class="cleaner">&nbsp;</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div> --%>

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

			<div class="margin_bottom_20">&nbsp;</div>

		</div>
		<!-- <input type="hidden" id="teamname" name="teamname"></input> -->
		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">Top view of E-Strategy</div>

				<div>

					<div id="projchart" style="height: auto; width: 1000px">
						<%-- 	<div class="tree">${html1}</div> --%>
						<table>
							<tr>
								<td class="tree">${html1}</td>
								<td />
								<td />
								<td />
								<td id="ajaxResponse"></td>
							</tr>
						</table>
					</div>

					<div id="ajaxresponse"></div>
					<div id="emplist"></div>


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