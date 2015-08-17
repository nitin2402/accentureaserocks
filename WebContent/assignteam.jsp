<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import=" java.util.List, java.util.ArrayList"%>
<%@page
	import=" java.sql.*,com.accenture.tmt.common.DBConnection,java.util.*,com.accenture.tmt.dao.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pyramid Optimization</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	
	  <script type="text/javascript">
    $(function () {
      $('.last').click(function (event) {
        var email = 'chinu.mohanty@accenture.com';
        var subject = 'Feedback';
        var emailBody = 'Hi Chinu,';
        window.location = 'mailto:' + email + '?subject=' + subject + '&body=' + emailBody;
      });
    });
  </script>
  <script>
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
</script>
  
  


<script>
	function validate(form) {
		var regExp = /^[a-zA-Z]{1,100}$/;

		var msg1 = document.getElementById("msg1");

		msg1.innerHTML = "";

		if (!regExp.test(form.search_field.value)) {
			msg1.innerHTML = "Name should be in alpha !";
			return false;
		}

	}
</script>



<script>
	$(document).ready(function() {

		$('#search_field').keyup(function(event) {
			var searchvalue = $("#search_field").val();

			$.ajax({
				url : "/EmployeeMSAccessDB/SearchEmployee",
				type : "POST",
				data : 'searchName=' + searchvalue,

				success : function(data) {
					$("#piechart").hide();
					$("#ajaxResponse").show();
					$("#ajaxResponse").html(data);

				},
				error : function() {

				}
			});

		});
	});
</script>


</head>
<body>
<%
		HttpSession session1 = request.getSession(false);	%>
	<%-- 	if (session1 == null  
				|| (String) session1.getAttribute("user") == null
				|| (Boolean) session1.getAttribute("admin") != true) {
	%><jsp:forward page="home.jsp?msg=Please Login as an Admin" />
	<%
		} --%>

<jsp:include page="/fetchmodule.jsp" />
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
						
			<%if((Boolean)session1.getAttribute("admin") ==true){ %>
		<li><a href="adminhome.jsp">Home</a></li>
			<%
			}
			%>
			
				<%if((Boolean)session1.getAttribute("admin") ==false){ %>
		<li><a href="userhome.jsp">Home</a></li>
			<%
			}
			%>
			
			<%if((Boolean)session1.getAttribute("admin") ==true){ %>
		<li><a href="addempvia.jsp">Admin Tools</a></li>
			<%
			}
			%>
			<li><a href="#">Workplan</a></li>
			<li><a href="#">Projects</a></li>
			<li><a href="aboutus.jsp">About Us</a></li>
			<li><a href="logout.jsp">Logout</a></li>
			<li><a href="#" class="last">Contact Us</a></li>
		</ul>
	</div>

	<div id="templatemo_content">

		<div id="content_left">

			<div class="content_left_section">
				<div class="content_left_section_title">Search</div>
				<div class="content_left_section_content">
					<form action="#">
						<input type="text" id="search_field" name="search_field" /> <input
							type="submit" value="Search" id="search_button" />
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
			<div class="content_left_section">
				<div class="content_left_section_title">Projects</div>
				<div class="content_left_section_content">
					<ul>
						<li>
							<form action="ViewReport">
							<input name="pject" type="hidden" value="eStrategy"></input>
								<input type="submit" value="E - Strategy"
									style="border: none; background-color: transparent; padding-top: 0; top: 0; text-decoration: none; color: white; font-size: 14px;"></input>
							</form>
						</li>
						<li><form action="ViewReport">
							<input name="pject" type="hidden" value="R3"></input>
								<input  type="submit" value="R3"
									style="border: none; background-color: transparent; padding-top: 0; top: 0; text-decoration: none; color: white; font-size: 14px;"></input>
							</form></li>
						<li><form action="ViewReport">
							<input name="pject" type="hidden" value="Primier"></input>
								<input type="submit" value="Primier"
									style="border: none; background-color: transparent; padding-top: 0; top: 0; text-decoration: none; color: white; font-size: 14px;"></input>
							</form></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>

		</div>

		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">Top view of the project</div>

				<div>

					<!-- <div id="piechart"
						style="background-colour: red; height: 300px; width: 600px"
						onclick="clickToStop()"></div> -->
					<div ><form action="AssignTeamFinal">
		<table class="table1" border="1" style="Width: 100%">


			<jstlcore:forEach items="${searchList}" var="list">



				<input type="hidden" name="s_empname" id="s_empname"
					value="${list.empName}" />

				<input type="hidden" name="s_empid" id="s_empid"
					value="${list.empId}" />
				<input type="hidden" name="s_level" id="s_level"
					value="${list.level}" />
				<input type="hidden" name="s_designation" id="s_designation"
					value="${list.designation}" />
				<input type="hidden" name="s_expertise" value="${list.expertise}" />
				<input type="hidden" name="s_experience" value="${list.experience}" />
				<input type="hidden" name="s_teamid" value="${list.teamId}" />
				<tr>
					<td>Employee Name</td>
					<td><jstlcore:out value="${list.empName}"></jstlcore:out></td>

				</tr>

				<tr>
					<td>Employee ID</td>
					<td><jstlcore:out value="${list.empId}"></jstlcore:out></td>
				</tr>
				<tr>
					<td>Employee Level</td>
					<td><jstlcore:out value="${list.level}"></jstlcore:out></td>
				</tr>
				<tr>
					<td>Employee Designation</td>
					<td><jstlcore:out value="${list.designation}"></jstlcore:out></td>
				</tr>
				<tr>
					<td>Employee Expertise</td>
					<td><jstlcore:out value="${list.expertise}"></jstlcore:out></td>
				</tr>
			<%-- 	<tr>
					<td>Employee Experience</td>
					<td><jstlcore:out value="${list.experience}"></jstlcore:out></td>
				</tr> --%>



			</jstlcore:forEach>

		</table>


		<br/>
		<table>
			<tr>
				<td>[MODULE:</td>
				<td>[<select name="s_module" id="s_module"><jstlcore:forEach
							var="aff" items="${modu}">

							<option value="${aff}">${aff}</option>
						</jstlcore:forEach></select></td>
			</tr>
		</table>
		<div id="ajaxResponse"></div>
		
		<br/> <br/> <input type="submit" value="Assign"></input>
	</form></div>


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