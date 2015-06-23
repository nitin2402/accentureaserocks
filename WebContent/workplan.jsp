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

<script>
	$(document)
			.ready(
					function() {

						$("#add")
								.click(
										function() {

											var bASE = $(
													"#Associate Software Engineer")
													.val();
											var bSE = $("#Software Engineer")
													.val();
											var bSSE = $(
													"#Senior Software Engineer")
													.val();
											var bTL = $("#Team Lead").val();
											var bAM = $("#Associate Manager")
													.val();
											var bM = $("#Manager").val();
											var bSM = $("#Senior Manager")
													.val();

											var filter3 = /^[0-9]{0,10}$/;

											var type = $("#value").val();
											var number = $("#number").val();
											var budget = $("#bud get").val();
											var remain = $("#remaining").val();
											
											alert(budget);
											
											var a = 0, b = 0, c = 0, d = 0;
											if (filter3.test(budget)
													&& filter3.test(number)) {
												if (type == 'Associate Software Engineer') {

													document
															.getElementById("nASE").innerHTML = number;

												}
												if (type == 'Software Engineer') {
													document
															.getElementById("nSE").innerHTML = number;

												}
												if (type == 'Senior Software Engineer') {
													document
															.getElementById("nSSE").innerHTML = number;

												}
												if (type == 'Team Lead') {
													document
															.getElementById("nTL").innerHTML = number;

												}
												if (type == 'Associate Manager') {
													document
															.getElementById("nAM").innerHTML = number;

												}
												if (type == 'Manager') {
													document
															.getElementById("nM").innerHTML = number;

												}
												if (type == 'Senior Manager') {
													document
															.getElementById("nSM").innerHTML = number;

												}
												a = parseInt(document
														.getElementById("nASE").innerHTML);
												b = parseInt(document
														.getElementById("nSE").innerHTML);
												c = parseInt(document
														.getElementById("nSSE").innerHTML);
												d = parseInt(document
														.getElementById("nTL").innerHTML);
												e = parseInt(document
														.getElementById("nAM").innerHTML);
												f = parseInt(document
														.getElementById("nM").innerHTML);
												g = parseInt(document
														.getElementById("nSM").innerHTML);
												var calc = (budget - a * bASE
														- b * bSE - c * bSSE
														- d * bTL - e * bAM - f
														* bM - g * nSM);
												alert(type);
												
												if (calc > 0) {
													$("#remaining").val(calc);
												} 
												else {
													alert("Budget limit reached");
													$("#remaining").val(calc);
												}

											} else {
												alert("Invalid Characters ");
											}

										
										}); 
						$("#budget")
								.change(
										function() {
											var filter3 = /^[0-9]{0,10}$/;
											var budget = $("#budget").val();

											if (filter3.test(budget)) {

											} else {
												alert("Enter only numeric values in budget field");
												$("#budget").val("0");
											}

										});
					});
</script>
</head>
<body>
	<jsp:include page="/FetchbudgetDetail" />
	<input type="hidden" id="backup" name="backup" value="0"></input>


	<jstlcore:forEach items="${budgetList}" var="list">
	
		<input type="hidden" id="${list.designation}"
			name="${list.designation}" value="${list.budgetValue}"></input>

	</jstlcore:forEach>



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
			<li><a href="#" class="current">Workplan</a></li>
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

			<div class="right_col_section_w650" style="height: auto;">

				<div class="header_01">Work Plan</div>


				<div>


					<div style="font-size: 14px;">
						<form action="FormTeam">
							<table>
								<tr>
									<td>

										<table>
											<tr>
												<td>Budget :</td>
												<td><input type="text" name="bud get" id="bud get"></input></td>
											</tr>
											<!-- 	<tr>
									<td><input type="button" value="Submit"></input></td>
								</tr> -->
											<tr style="height: 30px">
												<td></td>
											</tr>
											<tr>
												<td style="font-weight: bold;">Assign Employees</td>
											</tr>
											<tr />
											<tr />
											<tr>
												<td>Designation:</td>
												<td><select name="value" id="value">
														<jstlcore:forEach items="${budgetList}" var="list">
															<option value="${list.designation}">${list.designation}</option>

														</jstlcore:forEach>
												</select></td>
											</tr>
											<tr>
												<td>Total Number:</td>
												<td><input type="text" name="number" id="number"
													value="0"></input></td>
											</tr>
											<tr style="height: 10px">
												<td />
											</tr>
											<tr>
												<td />
												<td><input type="button" value="Add" id="add"
													name="add"></input></td>
											</tr>
										</table>
									</td>
									<td style="width: 60px"></td>
									<td>

										<table class="table1">
											<tr>
												<td>Designation</td>
												<td>Total</td>
											</tr>
											<tr>
												<td>ASE</td>
												<td id="nASE">0</td>
											</tr>
											<tr>
												<td>SE</td>
												<td id="nSE">0</td>
											</tr>
											<tr>
												<td>SSE</td>
												<td id="nSSE">0</td>
											</tr>
											<tr>
												<td>TL</td>
												<td id="nTL">0</td>
											</tr>
											<tr>
												<td>AM</td>
												<td id="nAM">0</td>
											</tr>
											<tr>
												<td>M</td>
												<td id="nM">0</td>
											</tr>
											<tr>
												<td>SM</td>
												<td id="nSM">0</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table align="right">
								<tr>
									<td>Remaining Amount:</td>
									<td><input type="text" name="remaining" id="remaining"
										readonly="readonly"></input></td>
								</tr>
							</table>
							<input type="submit" value="Form Team"></input>
						</form>
					</div>



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