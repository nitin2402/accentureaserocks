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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$(".header_09").hide();

	});
</script>
<script src="https://www.google.com/jsapi"></script>
<script src="piechart.js"></script>


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
										$("#piechart").hide();
										$("#ajaxResponse").show();
										$("#ajaxResponse").html(data);
									} else {

										$("#ajaxResponse").hide();

										$("#piechart").show().delay(1000);
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


</head>
<body>
	<jsp:include page="/GetPieChartValues" />

	<%@ include file="header_admin.jsp"%>
	<%
		HttpSession session1 = request.getSession(false);

		if (session1 == null

		|| (String) session1.getAttribute("user") == null

		|| (String) session1.getAttribute("admin") != "admin") {
	%><jsp:forward page="login.jsp?msg=Please Login as an Admin" />

	<%
		}
	%>
	<jstlcore:forEach var="item" items="${pielist}">
		<input type="hidden" id="ASE" value="${item.ASE}" />
		<input type="hidden" id="SE" value="${item.SE}" />
		<input type="hidden" id="SSE" value="${item.SSE}" />
		<input type="hidden" id="TL" value="${item.TL}" />
		<input type="hidden" id="AM" value="${item.AM}" />
		<input type="hidden" id="count" value="${item.count}" />
		<input type="hidden" id="billable" value="${item.billable}" />
		<input type="hidden" id="p0" value="${item.p0}" />
		<input type="hidden" id="p1" value="${item.p1}" />
		<input type="hidden" id="p2" value="${item.p2}" />
		<input type="hidden" id="p3" value="${item.p3}" />
		<input type="hidden" id="p4" value="${item.p4}" />
		<input type="hidden" id="angularJS" value="${item.angularJS}" />
		<input type="hidden" id="AT" value="${item.AT}" />
		<input type="hidden" id="C_UNIX" value="${item.c_UNIX}" />
		<input type="hidden" id="FST" value="${item.FST}" />
		<input type="hidden" id="HTML" value="${item.HTML}" />
		<input type="hidden" id="java" value="${item.java}" />
		<input type="hidden" id="JSP" value="${item.JSP}" />
		<input type="hidden" id="QA" value="${item.QA}" />
		<input type="hidden" id="TBD" value="${item.TBD}" />
		
	</jstlcore:forEach>
	
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
						<li><a href="viewprimier.jsp">Premier</a></li>
					</ul>
				</div>
				<div class="content_left_section_bottom">&nbsp;</div>
			</div>

			<div class="margin_bottom_20">&nbsp;</div>

		</div>

		<div id="content_right">

			<div class="right_col_section_w650">

				<div class="header_01">Top View Of The Project</div>
				<div class="header_09"></div>

				<div>

					<div id="piechart"
						style="background-colour: red; height: 300px; width: 600px"
						onclick="clickk()"></div>
						<div class="filter" ><span style="color: brown;font-size: 16px">Filter by</span><br/>
					<a onclick="filter('billability')">Billability</a> /
					<a onclick="filter('proficiency')">Proficiency</a> /
					<a onclick="filter('expertise')">Expertise</a>
					</div>
					<div id="ajaxResponse"></div>
					<p class="error" style="font-size: 14px; color: red;">${message}</p>


					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="margin_bottom_20">&nbsp;</div>
			</div>

			<div class="cleaner">&nbsp;</div>
		</div>
		<%@ include file="footer.jsp"%>


	</div>

</body>
</html>