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

 <script src="modulereport.js"></script> 
 
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 <link rel='stylesheet' type='text/css'
	href='http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css' />
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>



<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
 
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type='text/javascript' src='date.js'></script>
<script type="text/javascript" src="js/jquery.ui.datepicker.validation.js"></script>
<link href="calendar.css" rel="stylesheet" />
</head>

<body>
 <jsp:include page="/ModuleListServlet" /> 

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

			<div class="margin_bottom_20">&nbsp;</div>

		</div>

		<div id="content_right">

			<div class="right_col_section_w650" style="height: 300px">

				<div class="header_01">Reports Generated for Module</div>
				

				<div>
				<form  name = "modulereport" action="ModuleReportServlet" method="post" onsubmit ="return validateform()">
				<p>PLEASE SELECT THE MODULE&nbsp;&nbsp;<select name="moduleName">
				<option value=""></option>
												<jstlcore:forEach items="${moduleList}" var="item">
							
								<option	value="${item}" > <jstlcore:out value="${item}" ></jstlcore:out></option>
									
							
							</jstlcore:forEach>
														
												</select></p>
				<p>Start Date: <input type="text" id="calendar" name="startDate"/></p>
				<p>End Date : <input type="text" id="calendar1" name="endDate"/></p>
				<button type="submit" value="Submit">Generate Report</button>
				</form>
				<br />
				<br />
				
				
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
		<%@ include file="footer.jsp" %> 
	</div>
</body>
</html>